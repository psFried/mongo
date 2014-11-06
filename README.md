mongo
=====

examples of working with grails and mongodb

This is a super basic Grails application that uses MongoDB as a database backend. 
The examples are laughably simple, but should serve to show how things can be done with MongoDB. 


### Build
This app uses grails 2.4.4 and has the grails wrapper included. Run the app with: `./grailsw run-app`. 
The only external dependencies are JDK 1.7+ and MongoDB. The datasource in `conf/Datasource.groovy` is setup
for the default MongoDB connnection parameters if you have MongoDB running on your local machine.

### MongoDB 
This app depends on MongoDB 2.6.0 or greater. Check out the [MongoDB installation instructions](http://docs.mongodb.org/manual/installation/) 
for information on how to install MongoDB. The Linux packages will automatically put the init scripts in the right places so that you
can run mongodb simply by starting the 'mongod' service. For other platforms, you'll need to start it manually and supply the `--dbpath` 
option to specify a directory to use for storing the database files: `mongod --dbpath <path-to-dir>`. The db directory must already exist. 


# Where to look for the good stuff

- There's a few domain classes and associated controllers. These should look pretty familiar to anyone who's worked with grails before.
- conf/Bootstrap.groovy Some instances are created and inserted into the database here.
- conf/BuildConfig.groovy shows the plugin dependencies and has comments that will probably save you future headaches.

