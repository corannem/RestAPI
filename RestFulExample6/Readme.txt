

To run this example use the following steps

1. Open Project in Eclipse  (this project was created with ver 2021-12)

2. You may have to reset the Java path and build paths to you installed version, this is done in the project properties, build path

3. Make sure the Tomcat server reference is pointing to your installed version, this is set in the project properties, path may need to be reset to yours

4. To test the paths, from the project tab, clean the project and make sure you don't have any build error if so check Java paths again, resolve all errors before proceeding.

5. To run this application example right click on the project and locate the html file 'RestFulExample6.Html' in web contact/static then select "run as", then select "run on server". This will cause Tomcat to load the application, it may restart the Tomcat server and should show that "restfullExample6" is attached to yout Tomcat instance and is started and Synchronized.  At this point a web browser will open with the html. Use the Simple web page to test the Web Service from example 5.




Note:  If you change the Java code for the web service (please feel free to do this), saving the code should update the project on Tomcat but it may not always,  you may have to clean the project triggering a recompile, posibbly republish or at least stop and star the Tomcat instance running under Eclipse for your changes to take affect.

