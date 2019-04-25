# Selenium demo project

My sample WWW automation project - [Test Page](http://parabank.parasoft.com)


## Introduction

This is just sample test automation project on testing WWW. For this puropse Selenium framework has been used and some other tools described in "Build With" section. Project contains some sample Test Cases such us user registration, login into user account  and some basic operations. 
Test users created on this Test page are automatically deleted after some time when they are not being used (it might be even few minutes).


### Prerequisites

- JAVA (I use jdk-11.0.1) - [LINK](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- Intellij or other similar tool- [LINK](https://www.jetbrains.com/idea/)
- Maven (I use apache-maven-3.6.0) - [LINK](https://maven.apache.org/)
- Chrome browser - [LINK](https://www.google.com/chrome/) or other like IE/Firefox


### Installing

- Open Intellij or other similar tool. 
- Select: New > Project from Version Control > GIT
- Set:
	URL: https://github.com/tfdemo1/demo2.git
	Directory: create new folder on the disk and copy here his path
- Press Clone button to finish configuration.


## Running the tests

- 1 option: run tests in Paclage:TestCases one by one with TestNG using IntelliJ tool

- 2 option: run "mvn clean test -PTCS" command inside project folder using CMD 
	then run "mvn test -Dtest=FindTransaction#findTran" because test data were created in xls during first run


## Built With

* [Selenium](https://www.seleniumhq.org/) - Framework for test automation
* [Maven](https://maven.apache.org/) - Dependency Management
* [Maven surfire plugin](https://maven.apache.org/surefire/maven-surefire-plugin/index.html) - plugin for tests execution
* [TestNG](https://testng.org/doc/index.html) - automation testing framework supporting tests execution
* [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) - solution for using WebDriver binaries easier
* [Jexcelapi](http://jexcelapi.sourceforge.net/) - solution for using test data as input xls file
* [Apache POI](https://poi.apache.org/) - solution for saving test data as output in xls file



## Author

* **Tomasz Frynia** - *concept and code*

