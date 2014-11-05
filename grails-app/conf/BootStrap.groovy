import com.mongodb.BasicDBObject
import grails.mongodb.geo.Point
import org.codehaus.groovy.grails.web.json.JSONObject
import org.grailsandales.BlackBox
import org.grailsandales.Child
import org.grailsandales.Parent

class BootStrap {

    def init = { servletContext ->

		BlackBox.collection.remove(new BasicDBObject()) //drops the collection

	    /*
	    MongoDB doesn't have transactions, per se, but grails will sort of mimic some pseudo-transactional behavior.
	    None of the Domain instances in the withTransaction closure will actually be saved until after the closure returns.
	    MongoDB GORM will just wait until the end and insert all the documents in a batch operation.
	     */
	    BlackBox.withTransaction {
		    new BlackBox(location: new Point(-82.789, 40.213), metadata: new JSONObject(name: 'thing1')).save()
		    //throw new RuntimeException("Oh no, what about those documents I was saving?")
		    new BlackBox(location: new Point(-82.111, 40.555), metadata: new JSONObject(name: 'Phil', interests: ['rainbows', 'butterflies', 'long walks on the beach'])).save()

	    }

	    /////////// parent and child example ///////////

	    Child.collection.remove(new BasicDBObject())
	    Parent.collection.remove(new BasicDBObject())

	    Child kid1 = new Child(name: 'Jill', age: 7).save()

	    Parent mommy = new Parent(name: 'Jane', age: 35)
	    mommy.addToChildren(kid1)
	    mommy.save()

	    Parent daddy = new Parent(name: 'Jack', age: 32)
	    daddy.setSpouse(mommy)
	    daddy.addToChildren(kid1)
	    daddy.save()

	    mommy.setSpouse(daddy)
	    mommy.save(flush: true)

    }

    def destroy = {
    }

}
