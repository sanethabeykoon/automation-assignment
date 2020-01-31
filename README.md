**Technologies Used**

Programming language: Java (v 1.8.0)
Build and dependency management: Maven (v 3.5.3)
API testing: REST Assured (v 3.0.3)
JSONPath: json-path (v 2.4.0)
Unit testing: TestNG (v 6.14.3)
IDE: Eclipse (v Oxygen.2)

**Technical Approach**

1.	Categories class is used as the middle layer between the test case and the API. The middle layer allows to manage the communication to the API as a separate entity.
2.	The API is assured using a test case in TestNG.

**For Eclipse Users**

To import the project:

1.	Go to File > Import…
2.	Maven > Existing Maven Projects 
3.	Browse the checked out codebase and select the directory where the pom.xml is available
4.	Finish

To execute the test:

1.	Go to src/test/java > com.assurity.testcases
2.	Right click on AssureGetCategoryDetails.java
3.	Run As > TestNG Test

OR

1.	Right click on testng.xml file
2.	Run As > TestNG Suite
