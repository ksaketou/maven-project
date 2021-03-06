# Lab Assignment 3

This is a Maven child Module about JUnit and Continuous Integration. Also tools like JaCoCo and
Mockito are being used for the proper testing of the code. This project is part of the Lab 
Assignment of the Software Engineering course.

## Build the Project
In order to build the project and generate the JaCoCo reports firstly download the source code in a zip form. 
Unzip the folder, open it and execute
```
mvn package jacoco:report
```
This command builds all the modules of the project and automatically runs all the tests.
With the execution of the tests two directories related to the test reports are being created in the `unittesting/target` directory.
The first one is `surefire-reports` that contains the results of the tests according to the surefire plugin which is being used here.
The second one is `site`, which contains the reports generated by JaCoCo while the tests where running.

## Test the Project
If you want to only run the unit tests simply execute
```
mvn test
```