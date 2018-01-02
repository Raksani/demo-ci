Demo
====

Demo project using JUnit for testing and Travis CI to build project and run tests.

[Travis-CI](https://travis-ci.org)
==================================
[Travis-CI](https://travis-ci.org) is a *continuous integration* system that builds and tests your project.  It has many hooks for integration with Github.

How can a program build and test your application?  Obviously it needs to know *how* to build it and *how* to test it.

### Building the Application

You have a choice of build tools including Ant, Gradle, and Maven.
For this demo (and OOP) we'll start with good-old [Ant](https://ant.apache.org),
a standard tool for automatically building software, widely used for Java apps.
Netbeans creates Ant Build files (`build.xml`) for projects and
Eclipse can use them, too, if you configure your project to use Ant.

For most projects in OOP, we'll give you an Ant build file.

### Testing with JUnit

We use JUnit 4 for testing.  Circle-CI will run the project's JUnit tests
and repor the results.



Build Status
============
[![Build Status](https://travis-ci.org/travis-examples/travis-java-ant-example.png?branch=master)](https://travis-ci.org/travis-examples/travis-java-ant-example) shows status of last Travis CI build. Gratuitous eye-candy.
