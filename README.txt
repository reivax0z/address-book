The Java coding challenge has been answered by developing a web-app, as it is easy to test for the end-users. 
The app is based on Java EE 6 and is hosted on Heroku.

Links:
- The app is directly accessible at: http://xavier-address-book.herokuapp.com/
- The source code is hosted on Github, available at: https://github.com/reivax0z/address-book

The source code includes minimum comments to each class and most of the methods to be understood by others.

To start the application locally:
- mvn package
- java -jar target/dependency/jetty-runner.jar target/*.war
This will package the project using maven (if the tests pass) and then run the application locally via Jetty, on localhost:8080.
Note that the database is still the remote one from AWS.

The web-app uses the following technologies:
- Bootstrap framework for a responsive display on all devices.
- Jetty server.
- PostgreSQL database.
- Hibernate for DB management (mapping of DB content with Java objects).
- Maven for dependencies management, compilation and automatic tests before deployment.
- JUnit for test of classes.

Some assumption have been made for the development simplification:
- A friend only has one number per record (duple of name + phone).
- A phone number must be a valid 10 digits string.
- The search process uses 2 search engines: 
	--> 1 based on exact name matching (case insensitive) and 
	--> 1 providing similar matching (i.e., Boby similar to Bob).
- The compare address book uses exact match for names.

Design choices:
- Java for the back-end, with Hibernate for the DB management.
- JSP for the front-end, with Javascript to validate the forms before any submission (displaying warning message if invalid input is provided).
- Error handling is provided in the Servlets, displaying error if any, or success.
- The comparison of address books is using a JSON file upload system and compares the 2 books entry by entry, based on names exactitude.

The architecture of the web-app is as follow:
- src/main/java
	* package controller --> the Servlet classes
	* package model --> the DB classes
	* package util --> the Utility classes (conversions, comparators, ...)
- src/main/resources
	--> contains the hibernate.cfg.xml, used for DB connection and object mapping
- src/test/java
	* package tests --> contains the Test suite (JUnit)
- webapp
	--> contains the .jsp files and web.xml description file (Servlet / URL mappings)
