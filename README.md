Continuous Integration Demo
===========================

Status of last [Travis CI build](https://travis-ci.com/jbrucker/demo-ci): 
[![Build Status](https://travis-ci.com/jbrucker/demo-ci.svg?branch=master)](https://travis-ci.com/jbrucker/demo-ci)

Demo project using Travis CI to build and test a Java project.

> If you want to test this project using Travis CI,
> then you need to create your **own Github repo** for it.
>
> Therefore, **do not clone** this repo from Github.
> Download it as a **ZIP file**, create your own repo, then
> add Github as remote origin and push. 

> After that, give Travis access to your Github repo and trigger a build on Travis.

[Travis-CI](https://travis-ci.com) is a continuous integration server for building, testing, and deploying software projects.  It works with many lanaguages and integrates easily with Github.

## Building the Application

To build a Java project on Travis-CI, use Ant, Gradle, or Maven. 
In this demo project we use good-old Apache [Ant](https://ant.apache.org),
a standard Java build tool.

## The Ant Build File

The Ant build file is `build.xml`. Open the file in an editor (not a web browser) to see what it looks like.

There are several Ant "targets" defined in the build file, such as `clean`, `compile`, and `test`.  There is also a `deps` target used by Travis CI to install dependencies needed for Travis to build and test this project.  Type `ant -p` to print all targets.

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
The target is named "compile", which requires another target ("init") be done first.  The "compile" target contains one task to perform: `javac`.
`javac` is an Ant pre-defined task that will compile everything in the `srcdir` and subdirs, and put the compiler output in corresponding directory in `destdir`.

If there are any errors, the task will print error messages and ant will stop.

## Build and Test Locally

Ant requires the JUnit libraries on the classpath.  In the build.xml, it uses `lib.dir` for the directory containing Jars.
Do one of these:
  * copy JUnit Jars to a `lib` dir inside this project 
  * use a command line argument to set `lib.dir` to refer to your JUnit directory (of course you have JUnit installed, right?):
  ```shell
  ant -Dlib.dir=/your/junit/lib  test
  ```
  * Install them using an Ant task:
  ```shell
  ant deps
  ```

Then run the tests using:
```shell
ant test
```
You'll see Ant run the `init`, `compile`, and `test-compile` tasks before running `test`.

If you type `ant test` a second time, the "init", "compile", and "test-compile" tasks are run but don't do anything, because their outputs are already up-to-date.

### Managing Dependencies

This project needs JUnit JARs to run tests. These are (suprisingly) not on the CLASSPATH of the Travis Virtual Machine, so they need to be installed before compiling the code.   Travis automatically runs an "ant deps" task to setup dependencies.  So in `build.xml` there is a `deps` target that download JUnit JARs into a `./lib` directory.

## Enable Travis on Github

See links below for how to add Travis as an "Application" to your Github account.  You do this from the Travis-ci.com web site. Don't use the older travis-ci.org site.  

The Travis-CI site lets you configure project-specific settings, such as what branch it should build, and what triggers a build.  You can add pull requests as a trigger.

You may need to force Travis to do an initial build of your project.  Use the "More Options" menu on the right-side of Travis screen for your project.

------
## More Info

[Building a Java Project](https://docs.travis-ci.com/user/languages/java/) with Travis CI. Info on Ant builds is a bit sketchy.

[Travis Getting Started Guide](https://docs.travis-ci.com/user/getting-started/)

