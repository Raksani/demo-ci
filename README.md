Continuous Integration Demo
===========================

Status of last [Travis CI build](https://travis-ci.com/jbrucker/demo-ci): 
[![Build Status](https://travis-ci.com/jbrucker/demo-ci.svg?branch=master)](https://travis-ci.com/jbrucker/demo-ci)

Demo project using Travis CI to build and test a Java project.

[Travis-CI](https://travis-ci.com) is a continuous integration server for building, testing, and deploying software projects.  It works with many lanaguages and integrates easily with Github.

## Building the Application

To build a Java project on Travis-CI, use Ant, Gradle, or Maven. 
In this demo project we use good-old Apache [Ant](https://ant.apache.org),
a standard Java build tool.

## The Ant Build File

The Ant build file is `build.xml`. Open the file in an editor (not a web browser) to see what it looks like.  The format is XML, of course.

There are several Ant "targets" defined in this file, such as `clean`, `compile`, and `test`.  There is also a `deps` target used by Travis CI to install dependencies needed for Travis to build and test this project.

Here is part of the build file:
```xml
    <property name="base.dir" location="." />
    <property name="src.dir" location="${base.dir}/src"/>
    <property name="build.dir" location="${base.dir}/bin"/>

    <!-- compile the source code -->
    <target name="compile" depends="init" description="Compile source code" >
        <javac srcdir="${src.dir}" destdir="${build.dir}" includeantruntime="false" />
    </target>
```
the `property` elements define named constants, the `target` elements define tasks to perform.
The "compile" target requires that the "init" target be done first. Ant will take care of executing
dependencies.  The commands for a target (task) to perform are given inside the XML scope
for that target. `javac` is an Ant pre-defined task that will compile everything in the `srcdir`.

## Build and Test Locally

Ant requires the JUnit libraries be on the classpath. You can a) copy them to the `lib` directory, b) use ant -Dlib.dir=/your/junit/directory test, or c) run `ant deps` to download the Junit jars.  That is:
```
ant deps
ant test
```

If you type `ant test` a second time, the "init", "compile", and "test-compile" tasks are run but don't do anything, because their outputs are already up-to-date.

### Managing Dependencies

This project needs JUnit JARs to run tests. These are (suprisingly) not on the CLASSPATH of the Travis virtual machine, so they need to be installed before compiling the code.   The Ant `deps` task includes a command to download JUnit JARs into a `./lib` directory.  The Travis config file `.travis.yml` runs `ant deps` as part of the VM initialization.

I do this because JUnit is already installed on my computer in an external directory, so I don't need to download it each time.  In the `.travis.yml` file you'll see that the `lib.dir` property is set to `./lib` (directory relative to the project dir), whereas when I run Ant locally, `lib.dir` points to my JUnit lib directory.

## Enable Travis on Github

See links below for how to add Travis as an "Application" to your Github account.  You do this from the Travis-ci.com web site. Don't use the older travis-ci.org site.  

The Travis-CI site lets you configure project-specific settings, such as what branch it should build, and what triggers a build.  You can add pull requests as a trigger.

Then configure your Github project for Travis, such as adding a `.travis.yml` file.

------
## More Info

[Building a Java Project](https://docs.travis-ci.com/user/languages/java/) with Travis CI. Info on Ant builds is a bit sketchy.

[Travis Getting Started Guide](https://docs.travis-ci.com/user/getting-started/)

