# Lab Assignment 2
This repository was created in terms of the Software Engineering in Practice class and contains a Maven project written in Java. 

The assignment aims to the better understanding of Build Automation Tools and to the familiarization with Maven.

## Histogram Generator

This module generates a histogram of grades which are given as an input through a file. The input file is provided
to the program as a command line argument. Java's JFreeChart library is being used for the generation of the histogram.

### Jar file Creation and Execution

First of all, download the source code in a zip form. Then, unzip the folder, open it and execute

```mvn package```

The target folder has now been created automatically with all the generated files. For the creation of the diagram, execute

```java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependecies.jar [input file absolut path]```

If you want to execute the jar file with the `grades.txt` file as an input simply run

```java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependecies.jar gradeshistogram\src\main\resources\grades.txt```