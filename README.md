**Technical Approach**

1.	Categories class is used as the middle layer between the test case and the API. The middle layer allows to manage the communication to the API as a separate entity.
2.	The API is assured using a test case in TestNG.

**For Eclipse users**

To import the project:

1.	Go to File > Import…
2.	Maven > Existing Maven Projects 
3.	Browse the codebase and select the directory where the pom.xml is available
4.	Finish

To execute the test:

1.	Go to src/test/java > com.assurity.testcases
2.	Right click on AssureGetCategoryDetails.java
3.	Run As > TestNG Test

OR

1.	Right click on testng.xml file
2.	Run As > TestNG Suite
