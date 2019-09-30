# Planetakino test automation
#### Pet-project created for ["Планета Кіно" website](https://planetakino.ua/)

[Java](https://java.com/en/) and [Maven](https://maven.apache.org/download.cgi) are required for running the project. The framework uses [Selenium](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java), [Webdriver Manager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager) and [TestNG](https://mvnrepository.com/artifact/org.testng/testng).

To run the whole project use the following command:
```
mvn clean test
```
You can run only one test class:
```
mvn clean test -Dtest=LocationTests
```
You can find all documents related to the project in 'test artifacts' folder. Bugs and issues are in 'issues' folder.
