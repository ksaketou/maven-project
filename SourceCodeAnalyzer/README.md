
# Source Code Analyzer Module

This module is the part 4 of the Lab Assignment. The goal of this assignment is to get familiar with
design principles by refactoring code and applying design patterns on a given code base.

## Running the Module

1. Build the executable Java application with:

    `mvn package jacoco:report`

2. Run the executable by executing
java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4 were args translate to:

```
arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
arg2 = “SourceCodeLocationType” [local|web]
arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
arg4 = “OutputFileType” [csv|json]

example: 
java –jar ./target/sourcecodeanalyzer-0.0.3-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv
```

## Structure of the classes

This module has gone through major refactoring following the different Design Patterns. Below you can see the structure that each submodule follows.

### Source File Reader

This module uses the **Strategy** Pattern. This pattern was used here in order to support the double functionality of the file reader and make the code less complex. The functionality can now be easily extended by adding more types of file readers. However, several changes need to be made to the call of the `calculate` method in case of extensibility. Each functionality has now moved to the corresponding class.

The classes participating here are:

* `SourceFileReader` interface contaiing the `readFile` method.

* `ReadFileIntoList` class which uses the `readFile` method in order to read the given file and return it inside a list.

* `ReadFileIntoString` class which uses the `readFile` method in order to read the given file and return it as a string.

### Source Code Analyzer

This module uses the **Strategy** Pattern also. That way, the calculation of each metric is being simplified and the addition of new metrics is easy. The code for this module has become simpler and cleaner, separated based on each available metric. Each functionality has now moved to the corresponding class.

The classes participating here are:

* `SourceCodeAnalyzer` interface which contains the `calculate` method for the calculation of each metric.

* `Loc` class which calculates the loc metric (= lines of code) using the `calculate` method. This method uses the `readFile` method.

* `Noc` class which calculates the noc metric (= number of classes) using the `calculate` method. This method uses the `readFile` method.

* `Nom` class which calculates the nom metric (= number of methods) using the `calculate` method. This method uses the `readFile` method.

### Metrics Exporter

This module uses the **Bridge** Pattern. That way, the different exporter types can vary without affecting each other. Also, the addition of new exporter types is much easier. Each functionality has now moved to the corresponding class.

The classes participating here are:

* `MetricsExporter` interface which contains the `writeFile` method

* `CsvExporter` class  which uses the `writeFile` method to write the calculated output in to a `.csv` file.

* `JsonExporter` class  which uses the `writeFile` method to write the calculated output in to a `.json` file. This functionality is not currently supported.

* `NullExporter` class  which prints out an error message in case the user inserts an unknown exporter type. This class is a result of the **Null object** Pattern. By using this pattern, we eliminate exception handling on `DemoClient` class.

* `GenerateMetrics` class which is the context class for the supported functionality. It contains the `generateFile` method in order to activate the supported functionality. This method uses the `calculate` method.

* `ExecuteMetrics` class which uses the `generateFile` method with the corresponding inputs each time in order to export the output data.
