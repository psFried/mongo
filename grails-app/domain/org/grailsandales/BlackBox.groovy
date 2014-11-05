package org.grailsandales

import grails.mongodb.geo.Point
import org.bson.types.ObjectId

class BlackBox {

	// id automatically gets mapped to mongodb '_id'
	String id
	// ObjectId id // can also be used
	// long id // this is the default, will use an incrementing id

	Point location
	Map metadata

	static embedded = ['metadata']

	static mapping = {
		index(['location': '2dsphere'], [sparse: true])
	}

}
