package org.grailsandales

import grails.converters.JSON

class PersonController {


	def index(){
		render Parent.list() as JSON
	}

	def getChildren(){

		/*
		Uses MongoDB 'text' index to provide full text search.
		searchTop will limit the list of results to the top 5 by default.
		The normal `search` method will give control over pagination of results.
		 */
		List<Parent> matching = Parent.searchTop(params.parentName)

		Parent parent = (matching.isEmpty())? null : matching.first()

		/*
		parent.getChildren() would result in a query similar to:
		db.child.find({_id: {$in: [<child_id_1>, <child_id_2>, ...<child_id_n>] }})
		MongoDB doesn't have joins, so getting the children will always involve
		a separate query, regardless of whether they're fetched eagerly or lazily.
	    */
		render parent?.children as JSON

	}
}
