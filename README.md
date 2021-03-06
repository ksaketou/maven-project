# Lab Assignment - Software Engineering
[![Build Status](https://travis-ci.com/ksaketou/maven-project.svg?token=SAbjwsyqTgTceG3agqdc&branch=development)](https://travis-ci.com/ksaketou/maven-project) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This repository was created in terms of the Software Engineering in Practice class and contains a Maven project written in Java.

## Histogram Generator Module

This module generates a histogram of grades which are given as an input through a file. The input file is provided
to the program as a command line argument. Java's JFreeChart library is being used for the generation of the histogram.

### Jar file Creation and Execution

First of all, download the source code in a zip form. Then, unzip the folder, open it and execute

```
mvn package
```

The target folder has now been created automatically with all the generated files. For the creation of the diagram, execute

```
java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar [input file absolut path]
```

If you want to execute the jar file with the `grades.txt` file as an input simply run

```
java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar gradeshistogram\src\main\resources\grades.txt
```
## Unit Testing Module
Details regarding the Unit Testing and Continuous Integration module are available [here](https://github.com/ksaketou/maven-project/tree/development/unittesting/README.md).

## Source Code Analyzer Module
Details and information related to this module and the Design Patterns can be found [here](https://github.com/ksaketou/maven-project/blob/development/SourceCodeAnalyzer/README.md).