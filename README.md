Demo
====

Demo project for JUnit testing and Travis CI to build project and run tests.

We use [Travis-CI](https://travis-ci.com) for automated build and test.

### Building the Application

Travis has several choices for build tools it can use to build and test your project. For Java projects, they are: Ant, Gradle, and Maven.
In this demo we will use good-old [Ant](https://ant.apache.org),
a standard tool for building software, widely used for Java apps.

### The Ant Build File

The default name for the Ant build file is `build.xml`. Open the file in an editor to see what it looks like.  The format is XML (of course).  

### Testing with JUnit

We use JUnit 4 for testing. An Ant *task* is defined for running the JUnit tests after compiling your application.
Travis CI will run the project's JUnit tests each time a new commit is pushed to Github, and report the results.

### Enable Travis on Github

Add Travis as an "Application" to your Github account.  You do this from the Travis-ci.com web site. Don't use the older travis-ci.org site.

Some Github project configuration may also be required. 


Build Status
============
[![Build Status](https://travis-ci.org/travis-examples/travis-java-ant-example.png?branch=master)](https://travis-ci.org/travis-examples/travis-java-ant-example) shows status of last Travis CI build. Gratuitous eye-candy.

More Info
=========
[Building a Java Project](https://docs.travis-ci.com/user/languages/java/) how to build Java projects using Travis.

[Travis Getting Started Guide](https://docs.travis-ci.com/user/getting-started/)
