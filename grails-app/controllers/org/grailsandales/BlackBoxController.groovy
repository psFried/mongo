package org.grailsandales

import com.mongodb.DB
import grails.converters.JSON
import grails.mongodb.geo.Point
import org.bson.types.ObjectId

class BlackBoxController {

	// provides direct access to the mongodb driver
	def mongo

	def save(){

		def json = request.JSON

		// _id can be left off if we want
		json._id = new ObjectId().toString()

		BlackBox.collection.insert(json)

		render json
	}

	def saveBox(){
		BlackBox bb = new BlackBox()
		def json = request.JSON
		bb.metadata = json

		if (json.lat && json.lng){
			// if these properties have been specified, then make them into a Point so we can search them
			bb.location = Point.valueOf(json.lng, json.lat)
			bb.metadata.remove('lat')
			bb.metadata.remove('lng')
		}
		bb.save(flush: true)
		render bb as JSON
	}

	def show(){

		render BlackBox.get(params.id) as JSON
	}

	def findNear(){
		Point point = Point.valueOf(Double.parseDouble(params.lng), Double.parseDouble(params.lat))
		render BlackBox.findByLocationNearSphere(point) as JSON
	}
}
