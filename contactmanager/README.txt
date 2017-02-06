Aquent Contact Manager CRUD Interview Application
Forrest Samuels
4/28/2014

Platform versions developed and deployed on:
* java-1.7.0
* apache-tomcat-7.0.53
* PostgreSQL 9.3.4
* apache-maven-2.2.1 (The platform and framework requirements said to use Maven 2 however I developed on Maven 3.2.1. I went back and tested on Maven 2.2.1 and after changing the target compiler setting, it works as well.)

Steps to Deploy and Run
* Create a new PostgreSQL database. I recommend naming it 'contactmanager'.
* Use 'contactmanager.sql' to create the database schema.
* Update 'src\main\webapp\WEB-INFcontactmanager-dispatcher-servlet.xml' to specify your database, user and password that you just created.
* If there isn't already a Tomcat user with the 'manager-script' role, create one in 'conf/tomcat-users.xml'
* Specify the Tomcat server url in 'pom.xml' 
* From the 'contactmanager' directory, run 'mvn tomcat7:deploy -Dtomcat.username=admin -Dtomcat.password=password' to build and deploy the webapplication, replacing 'admin' and 'password' with the login credentials for the Tomcat user with the 'manager-script' role
* Once deployed, go to http://<HOST>:<PORT>/contactmanager/

Notes
* I did not use CSS in this project. I had some trouble configuring the path to CSS so I focused on more important funtionality.
* I did not use JS or jQuery either for the same reasons as above.
* My create and update queries need to be done in a Transaction but I didn't get to do that. I added a TODO to the code.
* I wanted to make creating the database an automated part of the Maven deployment but ran out of time to do so.