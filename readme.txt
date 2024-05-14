Project comprises of :
1. POM - Page Object Model Design Pattern
2. Factory design pattern
3. Use of TestNG as a unit testing
4. Apache POI libary for test data
4. Maven as a build tool
5. Dockerirized Selenium Grid


Components of the framework:
1. Constants - It is mostly used to store all the constants used across framework and it follows
               encapsulation principle

2. Enum - Used for WaitStrategy and fetching properties from config file

3. Exceptions - Custom exception are used which gives custom message why the exception has occured

4. Driver - It has three sub sections:
            a. DriverManager - ThreadLocal based webdriver instance
            b. DriverFactory - Returing the brower instance based on its type using factory design
                               pattern
            c. Driver - To launch and quit the driver

5. factory - Factory method for explicit wait

6. listeners - It has three sub components:
            a. Retry listner for re running failed cases
            b. MethodInterceptor that fetch the tc to be executed from the excel sheet
            c. ListnerClass - that will recieve events at testStart, testSuccess, testFailure and
                              in this class we will have methods for logging tc info in the extent
                              report, sending logs to ELK (Elastic search, log stash, kibana)

7. pages - Follow page object model design pattern which page actions and locators for each page
           of the application are on respective java classes

8. reporting - It has three sub sections:
               a. ExtentReport - base code for initializing extent report, flusing the extent report
                                 and creating extent test
               b. ExtentManager - ThreadLocal instance for extent test
               c. ExtentLogger - to log test case results, with their screenshots if applicable to
                                 extent report

9. Utils - It has different utlity classes for logging results in elk, fetching data from excel
           file, taking screenshots, fetching the properties from config file

10. TestData.xls - It has two sheets i.e. "RunManager - which controls the which tests to run
                    and what not to run", and other sheet i.e. "Data - which is the test data
                    to be fed in the test cases

11. tests - Usual tests based on each page of the application based on testNG

12. config properties - It has all the properties which are consumed in the framework

13. docker-compose file - It has the configuration to run the test cases in the selenium grid
                          env. hosted on Docker


How to build the framework
--------------------------
mvn clean install

How to run the test cases without docker set up
-----------------------------------------------
mvn tests

How to run the test cases on dockerized env.
--------------------------------------------
docker-compose -f docker-compose-v3.yml up (to start the execution)
docker-compose -f docker-compose-v3.yml down (to stop the execution)
