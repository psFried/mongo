
// environment specific settings
environments {
	development {
		// MongoDB connection information
		grails {
			mongo {
				host = 'localhost'
				port = 27017
				databaseName = "bb"
				//username =
				//password =
			}
		}
	}
	test {
		// MongoDB connection information
		grails {
			mongo {
				host = 'localhost'
				port = 27017
				databaseName = "test-bb"
				//username =
				//password =
			}
		}
	}
	production {
		// MongoDB connection information
		grails {
			mongo {
				host = 'localhost'
				port = 27017
				databaseName = "bb"
				//username =
				//password =
			}
		}
	}
}