package org.grailsandales

class Parent {

	String id

	String name

	int age

	Parent spouse

	static hasMany = ['children': Child]

	static mapping = {
		index(name: 'text') //Text index is only supported on MongoDB 2.6+
		children(reference: true)
	}

	static constraints = {
		spouse(nullable: true)
	}

}
