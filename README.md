C.I. Demo
=========

Build Status: 
[![Build Status](https://travis-ci.com/jbrucker/demo-ci.svg?branch=master)](https://travis-ci.com/jbrucker/demo-ci)
of last [Travis CI build](https://travis-ci.com/jbrucker/demo-ci).  

Demo project using Travis CI to build project and run unit tests.

We use [Travis-CI](https://travis-ci.com) for automated build and test.

### Building the Application

Travis has several choices for build tools it can use to build and test your project. For Java projects, they are: Ant, Gradle, and Maven.
In this demo we will use good-old [Ant](https://ant.apache.org),
a standard tool for building software, widely used for Java apps.

### The Ant Build File

The default name for the Ant build file is `build.xml`. Open the file in an editor to see what it looks like.  The format is XML (of course).  

There are several Ant "tasks" defined in this file, such as `clean`, `compile`, and `test`.  There is also a `deps` task that is used by Travis CI to install dependencies needed by this project.

### Managing Dependencies

This project needs JUnit JARs to run tests.  The Ant "deps" task includes a command to download them into a `lib` directory.  The `deps` task is run by Travis (its in the `.travis.yml` file), but it isn't automatically run locally.

I do this because JUnit is already installed on my computer, so I don't need to download it each time.  In the `.travis.yml` file you'll see that the `lib` directory is set to `lib` (directory relative to the project dir), whereas when I run Ant locally, `lib` points to my JUnit lib directory.

### Testing with JUnit

We use JUnit 4 for testing. An Ant *task* is defined for running the JUnit tests after compiling your application.
Travis CI will run the project's JUnit tests each time a new commit is pushed to Github, and report the results.

### Enable Travis on Github

Add Travis as an "Application" to your Github account.  You do this from the Travis-ci.com web site. Don't use the older travis-ci.org site.

Some Github project configuration may also be required. 


More Info
=========
[Building a Java Project](https://docs.travis-ci.com/user/languages/java/) how to build Java projects using Travis.

[Travis Getting Started Guide](https://docs.travis-ci.com/user/getting-started/)
