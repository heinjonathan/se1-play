# Project: *se1-play*, branch *b1-numbers*

<<<<<<< HEAD
Branch *b1-numbers* contains code and tasks for the *b1-numbers* assignment.

Goals are:

- rebuild the project with branches
    [*b1-numbers*](../../tree/b1-numbers) and
    [*b1-numbers-tests*](../../tree/b1-numbers-tests) added,

- implement functions of the [*Numbers.java*](src/numbers/Numbers.java) interface and

- verify correctness through *JUnit-tests*.

Code and JUnit-tests must work in the IDE and in the terminal.

Steps:

1. [Project Structure](#1-project-structure)

1. [*Setup* and *Build* Project](#2-setup-and-build-project)

1. [Implement *sum()*](#3-implement-sum)

1. [*JUnit*-Tests](#4-junit---tests)

1. [Implement *Numbers*-Functions](#5-implement-numbers-functions)

1. [Final Result](#final-result)

Goal of this exercise is to demonstate a professionally engineered
Java project.

&nbsp;

## 1. Project Structure

The *Numbers*-project is assembled from three parts:

- regular content from the [*main*](../../tree/main) branch,

- branch: [*b1-numbers*](../../tree/b1-numbers) adds source code
    with package [*src/numbers*](src/numbers),

- branch: [*b1-numbers-tests*](../../tree/b1-numbers-tests) adds
    *JUnit-tests* with package [*tests/numbers*](tests/numbers)

The project content assembled from the three branches is:
=======
Goal of this exercise is to demonstate a professionally engineered
Java project.

You will learn about project *"Setup"* and *"Build"* processes,
what *"Sourcing"* is and about the structure (*"scaffold"*) of a
Java project.

- Only basic tools are used: `git`, `java`, `javac`, `jar`, `javadoc`
(more advanced build tools are introduced later).

- Basic skills are trained such as the use of `git` and the `terminal shell`.

- *VSCode* is the preferred IDE for development, other IDE can be used
    as well, e.g. *eclipse*, *IntelliJ*.


Project *se1-play* was created in steps that are recorded as tagged commits
in the remote Git repository ([*"se1-play"*](https://github.com/sgra64/se1-play)).
Reviewing steps provides a first understanding:

<!-- relative paths work for tags and branches -->
<!-- - Step 1 (tag: [*t0*](https://github.com/sgra64/se1-play/tree/t0)) - -->
- Step 1 (tag: [*t0*](../../tree/t0)) -
    initial commit with [*.gitignore*](.gitignore) `README.md` files.

- Step 2 (tag: [*t1*](../../tree/t1)) -
    commit with the [*.vscode*](.vscode) settings folder for the *VSCode* IDE.

- Step 3 (tag: [*t2*](../../tree/t2)) -
    commit with `.env.sh`, the script to *source* the project
    (see: setup the project environment).

- Step 4 (tag: [*root*](../../tree/root)) -
    commit with `src`, `tests` and `resources` folders added.

- Step 5: a separate branch: [*libs*](../../tree/libs)
    containing *.jar* - libraries are added that are required by the project.


The following steps must be performed by a developer on a laptop
for *onboarding* the project.

- Step 6, section [*Getting the Project*](#getting-the-project-se1-play).

- Step 7, section [*Project Setup*](#project-setup).

- Step 8, section [*Project Build*](#project-build).

- Step 9, section [*Running the Application*](#running-the-application).

- Summary: [*Complete Project Content*](#complete-project-content)


&nbsp;

## Getting the Project: *se1-play*

Cloning the project from the Git repository yields the project
folder *`se1-play`* in the current directory (workspace).

A *workspace* is a directory where projects directories reside
as sub-folders.

You need to select a *workspace* directory on your laptop for
this and following projects.

```sh
cd <workspace>      # change to folder where the project should be located

# Cloning the entire repository (with all branches) is often not adviced
# in a real git-repository due to repository size:
#  - git clone git@github.com:sgra64/se1-play.git
# Smarter is to fetch only needed branches, here the 'main'-branch of
# the repository
# 
# Hint: if the ssh-link: git@github... does not work, use the https-link:
# https://github.com/sgra64/se1-play.git
# 
git clone -b main --single-branch git@github.com:sgra64/se1-play.git se1-play

ls -la              # show the new project folder: 'se1-play'
cd se1-play         # change into the project folder
ls -la              # list inital project content
```

The initial project content is:

```
drwxr-xr-x 1     0 Oct  4 14:26 ./
drwxr-xr-x 1     0 Oct  4 14:26 ../
-rw-r--r-- 1 25037 Oct  4 14:26 .env.sh
drwxr-xr-x 1     0 Oct  4 14:26 .git/
-rw-r--r-- 1  1214 Oct  4 14:26 .gitignore
drwxr-xr-x 1     0 Oct  4 14:26 .vscode/
-rw-r--r-- 1  1123 Oct  4 14:26 README.md
drwxr-xr-x 1     0 Oct  3 19:29 resources/
drwxr-xr-x 1     0 Oct  3 19:45 src/
drwxr-xr-x 1     0 Oct  3 19:29 tests/
```

The project structure (*"scaffold"*) with files and folders is:

```sh
<workspaces>        # workspace folder, select and know the location of
  |                 # this directory on your laptop
  +-<se1-play>          # project directory "se1-play" with files and
     |                  # folders for the project such as:
     +--.env.sh             # file to set/source the project entvironment
     +-<.git>               # the local git repository
     +--.gitignore          # file that tells git which files to ignore
     +-<.vscode>            # VSCode project files
     +--README.md           # this markup file
     +-<src>                # Java source code folder
     +-<resources>          # folder with none-Java sources, config files
     +-<tests>              # folder with source code for tests
 ```

The complete project content can be listed with:

```sh
find . | grep -v '.git'     # list project (omitting the .git folder)
```

Output shows folders and files that are included in the project:

```
./.env.sh
./.vscode
./.vscode/launch.json
./.vscode/launch_terminal.sh
./.vscode/settings.json
./README.md
./resources
./resources/application.properties
./resources/log4j2.properties
./resources/META-INF
./resources/META-INF/MANIFEST.MF
./src
./src/application
./src/application/Application.java
./src/application/package-info.java
./src/application/Runtime.java
./src/module-info.java
./tests
./tests/application
./tests/application/Application_0_always_pass_Tests.java
```


&nbsp;

## Project Setup

*Project Setup* describes steps to the stage that a project can be *"built"*,
which means, the IDE finds proper configurations and works, tools such as the
Java compiler *javac*, the Java VM *java*, the *javadoc* compiler work.

*Project Setup* includes these steps:

- step 1 - adding libraries that did not come with the git-checkout.

- step 2 - *"sourcing"* the project to set up the project environment with:

    - environment variables, e.g.
        `CLASSPATH`, `MODULEPATH`, `JDK_JAVAC_OPTIONS`, `JUNIT_OPTIONS` ... ,

    - configuration files created for the IDE and Java tools, e.g.
        `.classpath`, `.project`, `libs`-link ... and

    - functions defined to facilitate *build* commands, e.g.
        `show`, `mk`, `clean`, `wipe` ... .

*Libraries* required by a project are typically not stored inside the
project. In our case, a new sub-folder `branches` will hold the
[*libs*](https://github.com/sgra64/se1-play/tree/libs) - branch
from the project repository. The branch will be separately checked out.

Create folder `branches` in the project directory and *cd* into it:

```sh
mkdir branches          # create folder 'branches' (must be in 'se1-play')
cd branches             # cd into the new folder

# Fetch branch 'libs' from the repository (use the http-link, if the
# git@-link does not work)
# 
git clone -b libs --single-branch git@github.com:sgra64/se1-play.git libs
```
```
Cloning into 'libs'...
remote: Enumerating objects: 38, done.
remote: Counting objects: 100% (38/38), done.
remote: Compressing objects: 100% (32/32), done.
remote: Total 38 (delta 5), reused 38 (delta 5), pack-reused 0 (from 0)
Receiving objects: 100% (38/38), 6.91 MiB | 7.28 MiB/s, done.
Resolving deltas: 100% (5/5), done.
```

A new folder `libs` has been created in `branches`.

```sh
ls -la                      # show the new 'libs' folder
find libs | grep -v .git    # list content of 'libs' (omitting .git folder)
```

Output shows `.jar` files of various libraries:

```
libs
libs/jackson
libs/jackson/jackson-annotations-2.13.0.jar
libs/jackson/jackson-core-2.13.0.jar
libs/jackson/jackson-databind-2.13.0.jar
libs/jacoco
libs/jacoco/jacocoagent.jar
libs/jacoco/jacococli.jar
libs/junit
libs/junit/apiguardian-api-1.1.2.jar
libs/junit/junit-jupiter-api-5.9.3.jar
libs/junit/junit-platform-commons-1.9.3.jar
libs/junit/opentest4j-1.2.0.jar
libs/junit-platform-console-standalone-1.9.2.jar
libs/logging
libs/logging/log4j-api-2.23.1.jar
libs/logging/log4j-core-2.23.1.jar
libs/logging/log4j-slf4j2-impl-2.23.1.jar
libs/logging/slf4j-api-2.0.16.jar
libs/README.md
```

Learn about the libraries
[here](https://github.com/sgra64/se1-play/tree/libs):

- `jackson`: processing JSON data in Java

- `jacoco`: code coverage library for Java

- `junit`: libraries for JUnit tests

- `logging`: *log4j2* logging library for Java

- `junit-platform-console-standalone-1.9.2.jar`: JUnit test runner

The term *"sourcing"* comes from the *Shell* command `source` that
executes a script in context of the *Shell* process (not as a sub-process).

In this project, script [.env.sh](.env.sh) will:

- set environment variables, e.g.
    `CLASSPATH`, `MODULEPATH`, `JDK_JAVAC_OPTIONS`, `JUNIT_OPTIONS` ... ,

- create configuration files for the IDE and Java tools, e.g.
    e.g. `.classpath`, `.project`, `libs`-link ... and

- create functions to facilitate the *build* process, e.g.
    `show`, `mk`, `clean`, `wipe` ... .

This environment will be set for the *executing shell* and only
last for the existence of the *shell* process (terminal).

When the *shell* process ends, e.g. when the terminal is closed,
*environment variables* and *functions* will be lost (created
configuration files remain).

The *project must be sourced* with every new *shell* processes
and terminal.

*"Source"* the project in the project directory with:

```sh
source .env.sh          # source the project (execute script '.env.sh')
```

Output shows what was created for the environment:

```
setting the project environment with:
 - environment variables:
    - PROJECT_PATH
    - CLASSPATH
    - MODULEPATH
    - JDK_JAVAC_OPTIONS
    - JDK_JAVADOC_OPTIONS
    - JUNIT_CLASSPATH
    - JUNIT_OPTIONS
    - JACOCO_AGENT
 - files created:
    -  ln -s ./branches/libs libs
    - .classpath
    - .project
    - .vscode/.classpath
 - functions and aliases:
    - aliases: mk, build, wipe, clean
    - functions: make, show, cmd, copy, javac_version, coverage_report
\\
project environment is set (use 'wipe' to reset)
```

A new function: `show` shows the commands that are now available
for *building* the project.

```sh
show                    # show commands for build process
show --all              # show complete command list
```
```
source | project:
  source .env.sh

classpath | cp:
  echo $CLASSPATH | tr "[;:]" "\n"

compile:
  javac $(find src -name '*.java') -d bin/classes; \
  copy resources bin/resources

compile-tests:
  javac $(find tests -name '*.java') -d bin/test-classes; \
  copy resources bin/resources

resources:
  copy resources bin/resources

run:
  java application.Runtime

run-tests:
  java $(eval echo $JUNIT_CLASSPATH) org.junit.platform.console.ConsoleLauncher\
    $(eval echo $JUNIT_OPTIONS) \
    --scan-class-path

javadoc:
  javadoc -d docs $(eval echo $JDK_JAVADOC_OPTIONS) \
    $(builtin cd src; find . -type d | sed -e 's/\//./g' -e 's/^\.*//')

clean:
  rm -rf bin logs docs coverage

build:
  mk compile compile-tests run-tests package

wipe:
```

New content was added during *project setup* in the project directory is:
>>>>>>> upstream/main

```sh
<se1-play>              # project directory
 |
<<<<<<< HEAD
 # regular content of the project from the 'main'-branch
 +--.gitignore                  # files for git to ignore
 +-- README.md                  # this markup file
 | ...
 |
 # content from branch: 'b1-numbers' with package 'numbers'
 +-<src>                        # source code for 'numbers'
 |  +-<numbers>                 # package 'numbers'
 |    +--Numbers.java           # interface of methods to implement
 |    +--NumbersImpl.java       # implementation class with implemented methods
 |    +--NumbersDriver.java     # driver code to perform calculations from command line
 |    +--package-info.java      # package documentation
 |
 # content from branch: 'b1-numbers-tests' adding JUnit tests
 +-<tests>                      # source code for 'numbers' JUnit tests
 |  +-<numbers>
      +--Matchers.java
      +--Numbers_1_sum_Tests.java
      +--Numbers_2_sum_positive_even_Tests.java
      +--Numbers_3_sum_recursion_Tests.java
      +--Numbers_4_find_first_Tests.java
      +--Numbers_5_find_last_Tests.java
      +--Numbers_6_find_all_Tests.java
      +--Numbers_7a_find_sums_Tests.java
      +--Numbers_7b_find_sums_duplicates_Tests.java
      +--Numbers_8a_find_all_sums_Tests.java
      +--Numbers_8b_find_all_sums_XL_Tests.java
```


&nbsp;

## 2. *Setup* and *Build* Project

*Setup* of the project is assembling content from branches:

```sh
cd se1-play                 # change into the project directory

# update the 'main'-branch in the project directory (pull the latest
# changes from the remote directory giving incoming changes ("theirs")
# priority in case of conflicts)
# 
git pull origin main --strategy-option theirs

# pull content from branch 'b1-numbers'
# 
git pull origin b1-numbers --strategy-option theirs
```
```
From https://github.com/sgra64/se1-play
 * branch            b1-numbers -> FETCH_HEAD
Auto-merging README.md
Auto-merging src/module-info.java
Merge made by the 'ort' strategy.
README.md                      | 769 ++----
src/module-info.java           |   1 +
src/numbers/Numbers.java       | 106 ++++++
src/numbers/NumbersDriver.java | 202 +++++++++++
src/numbers/NumbersImpl.java   | 174 ++++++++++
src/numbers/package-info.java  |   7 +
6 files changed, 517 insertions(+), 742 deletions(-)
create mode 100644 src/numbers/Numbers.java
create mode 100644 src/numbers/NumbersDriver.java
create mode 100644 src/numbers/NumbersImpl.java
create mode 100644 src/numbers/package-info.java
```

The *src* directory should now contain the new package: *numbers*.

```sh
find src                    # show content of 'src' directory
```
```
src
src/application
src/application/Application.java
src/application/package-info.java
src/application/Runtime.java
src/module-info.java
src/numbers
src/numbers/Numbers.java            <-- interface
src/numbers/NumbersDriver.java
src/numbers/NumbersImpl.java        <-- implementation class
src/numbers/package-info.java
```

New source files appear in package:
[*numbers*](src/numbers) with an interface:
[*Numbers.java*](src/numbers/Numbers.java)
and implementation class:
[*NumbersImpl.java*](src/numbers/NumbersImpl.java).

The driver code
[*NumbersDriver.java*](src/numbers/NumbersDriver.java)
interprets instructions from the command line and controls
the program execution.


*Build* and *Run* the project:

```sh
mk compile                  # compile sources
mk run sum                  # run program with sum() function
```
```
java application.Runtime sum
NumbersDriver:
 - sum(numbers) -> 0        # sum() is not implemented, yet
done.
```


&nbsp;

## 3. Implement *Sum()*

Interface: [*Numbers.java*](src/numbers/Numbers.java) defines function
`sum(int[] numbers)`:

```java
/**
 * Interface defining functions for the <i>"b1-numbers"</i> assignment.
 */
public interface Numbers {

    /**
     * Aufgabe 1.) Calculate sum of numbers[].
     * @param numbers input
     * @return sum of numbers[]
     */
    int sum(int[] numbers);
}
```

&nbsp;

Class [*NumbersImpl.java*](src/numbers/NumbersImpl.java) includes some
*numbers[]* data and function implementations:

```java
    /*
     * Numbers with negative numbers and duplicates.
     */
    static final int[] numbers = {-2, 4, 9, 4, -3, 4, 9, 5};

    /*
     * Numbers with no negative numbers and no duplicates.
     */
    static final int[] numb_1 = {8, 10, 7, 2, 14, 5, 4};

    /*
     * Larger set of 24 numbers, no negatives, no duplicates.
     */
    static final int[] numb_2 = {   // 24 numbers
        371,  682,  446,  754,  205,  972,  600,  163,  541,  672,
         27,  170,  226,    7,  190,  639,   87,  773,  651,  370,
        125,  774,  903,  636//,225,  463,  286,  569,  384,    9,
    }; // add more numbers to find more solutions

    /*
     * Even larger set of 63 numbers, no negatives, no duplicates.
     */
    static final int numb_3[] = {
        799, 2377,  936, 3498, 1342,  493, 1635, 4676, 1613, 3851,
       1445, 4506, 3346,    7, 2141, 2064, 1491,  908,   78, 3325,
       1756, 3691,   23, 1995, 1800,   15, 2784, 4305,   36, 2532,
       4292, 4802, 2522, 4183, 3261, 2610,  803, 2656,  498, 1668,
       2038, 2194,  440,  463, 4047, 4235, 3931,  756,  521, 4042,
       3302,  485, 1002,  408, 4691, 3387, 3104, 3658, 2241, 4382,
       1220, 3656,  500,
    };

    /**
     * Aufgabe 1.) Calculate sum of numbers[].
     * @param numbers input
     * @return sum of numbers[]
     */
    @Override
    public int sum(int[] numbers) {
        return 0;
    }
```

Method `sum(int[] numbers)` currently returns `0`, which is also the
output when running the code:

```sh
mk run sum                  # run program invoking method sum() on 'numbers[]' array
```
```
java application.Runtime sum
NumbersDriver:
 - sum(numbers) -> 0        # result from un-implemented sum() is 0
done.
```

Implement `sum(int[] numbers)` such that it returns the correct result.

```
java application.Runtime sum
NumbersDriver:
 - sum(numbers) -> 30       # correct result (sum of: {-2, 4, 9, 4, -3, 4, 9, 5})
done.
```

Run program with other numbers arrays. The driver code interprets
arguments as function name followed by the name of a numbers array.

```sh
mk run sum numbers \
    sum numb_1 \
    sum numb_2 \
    sum numb_3
```

Output shows the correct results:

```
java application.Runtime sum numbers sum numb_1 sum numb_2 sum numb_3
NumbersDriver executing NumbersImpl
 - sum(numbers) -> 30
 - sum(numb_1) -> 50
 - sum(numb_2) -> 10984
 - sum(numb_3) -> 141466
done.
```


&nbsp;

## 4. *JUnit* - Tests

After `sum(int[] numbers)` has been implemented, *JUnit*-tests can verify
its correct function.

Read about *JUnit-tests:*

- Carsten Gips, [*Testen mit JUnit5*](https://www.hsbi.de/elearning/data/FH-Bielefeld/lm_data/lm_1359639/testing/junit-basics.html).

- Tobias Trelle, [*JUnit 5*](https://www.codecentric.de/wissens-hub/blog/junit5-junit-5).


&nbsp;

Install from branch
[*b1-numbers-tests*](../../tree/b1-numbers-tests/tests/numbers)
files (only these two):

- [*Matchers.java*](../../tree/b1-numbers-tests/tests/numbers/Matchers.java)

- [*Numbers_1_sum_Tests.java*](../../tree/b1-numbers-tests/tests/numbers/Numbers_1_sum_Tests.java)

into the proper place in the project (under: *tests/numbers* ).

Compile tests and run:

```sh
mk compile-tests                # compile JUnit tests
mk run-tests                    # run JUnit-tests (all tests found)

# or run specific tests specified by the '-c' flag
java $(eval echo $JUNIT_CLASSPATH) org.junit.platform.console.ConsoleLauncher\
  $(eval echo $JUNIT_OPTIONS) \
  -c application.Application_0_always_pass_Tests \
  -c numbers.Numbers_1_sum_Tests
```

Output:

```
java $(eval echo $JUNIT_CLASSPATH) org.junit.platform.console.ConsoleLauncher\
  $(eval echo $JUNIT_OPTIONS) \
  --scan-class-path
╷
├─ JUnit Jupiter ✔
|  |
│  ├─ Application_0_always_pass_Tests ✔
│  │  ├─ test_001_always_pass() ✔
│  │  └─ test_002_always_pass() ✔
|  |
│  +─ Numbers_1_sum_Tests ✔
│     ├─ test100_sum_regular() ✔
│     ├─ test101_sum_regular() ✔
│     ├─ test102_sum_regular() ✔
│     └─ test103_sum_regular() ✔
|   
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔

Test run finished after 1093 ms
[         6 tests found           ]
[         6 tests successful      ]
[         0 tests failed          ]
done.
```


&nbsp;

## 5. Implement *Numbers*-Functions

Goal of this part is to implement all functions, one after another:

1. `sum(int[] numbers)` (done).

1. `sum_positive_even_numbers(numbers[])`, [link](#2-sum_positive_even_numbers).

1. `sum_recursive(numbers[], int i)`, [link](#3-sum_recursive).

1. `findFirst(numbers[], int x)`, [link](#4-findfirst).

1. `findLast(numbers[], int x)`, [link](#5-findlast).

1. `findAll(numbers[], int x)`, [link](#6-findall).

1. `findSums(numbers[], int sum)`, [link](#7-findsums).

1. `findAllSums(numbers[], int sum)`, [link](#8-findallsums).

1. `findAllSums(), XXL`, [link](#9-findallsums-xxl).


Interface: [*Numbers.java*](src/numbers/Numbers.java) defines
eight functions:

```java
/**
 * Interface defining functions for the <i>"b1-numbers"</i> assignment.
 */
public interface Numbers {

    /**
     * Aufgabe 1.) Calculate sum of numbers[].
     * @param numbers input
     * @return sum of numbers[]
     */
    int sum(int[] numbers);

    /**
     * Aufgabe 2.) Calculate sum of positive even numbers[].
     * ...
     */
    int sum_positive_even_numbers(int[] numbers);

    /**
     * Aufgabe 3.) Calculate sum of numbers[] recursively without using loops
     * (for, while, do/while). ...
     */
    int sum_recursive(int[] numbers, int i);

    /**
     * Aufgabe 4.) Return index of first occurrence of x in numbers[]
     * or return -1 if x was not found. ...
     */
    int findFirst(int[] numbers, int x);

    /**
     * Aufgabe 5.) Return index of last occurrence of x in numbers[]
     * or return -1 if x was not found. ...
     */
    int findLast(int[] numbers, int x);

    /**
     * Aufgabe 6.) Return list of all indices of number x in numbers[].
     * Return empty list, if x was not found. ...
     */
    List<Integer> findAll(int[] numbers, int x);

    /**
     * Aufgabe 7.) Return all pairs (a, b) in numbers[] with a + b = sum with
     * consolidating mirror copies such as (a, b) and (b, a) by returning
     * either (a, b) or (b, a), not both. ...
     */
    Set<Pair> findSums(int[] numbers, int sum);

    /**
     * Aufgabe 8.) Find all combinations of numbers in numbers[] that add to sum.
     * ...
     */
    Set<Set<Integer>> findAllSums(int[] numbers, int sum);

    /**
     * Immutable pair of integer values a and b.
     */
    record Pair(int a, int b) {
        public String toString() { return String.format("(%d,%d)", a, b); }
    };
}
```


&nbsp;

### 2. *sum_positive_even_numbers()*

Function: `sum_positive_even_numbers(numbers[], int i)` returns the sum of
only positive and even numbers from `numbers[]`.

Implement the function and demonstrate:

```sh
mk run sum_positive_even_numbers numbers \
    sum_positive_even_numbers numb_1 \
    sum_positive_even_numbers numb_2 \
    sum_positive_even_numbers numb_3
```

Output shows the correct results:

```
java application.Runtime sum numbers sum numb_1 sum numb_2 sum numb_3
NumbersDriver executing NumbersImpl
 - sum_positive_even_numbers(numbers) -> 12
 - sum_positive_even_numbers(numb_1) -> 38
 - sum_positive_even_numbers(numb_2) -> 6492
 - sum_positive_even_numbers(numb_3) -> 80012
done.
```

Install the *JUnit*-test for the function
[*Numbers_2_sum_positive_even_Tests.java*](../../tree/b1-numbers-tests/tests/numbers/Numbers_2_sum_positive_even_Tests.java)
and run the test:

```sh
java $(eval echo $JUNIT_CLASSPATH) org.junit.platform.console.ConsoleLauncher\
  $(eval echo $JUNIT_OPTIONS) \
  -c numbers.Numbers_2_sum_positive_even_Tests
```

Output shows all 200's tests passing:

```
├─ JUnit Jupiter ✔
|  |
│  └─ Numbers_2_sum_positive_even_Tests ✔
│     ├─ test200_sum_positive_even_numbers_regular() ✔
│     ├─ test201_sum_positive_even_numbers_regular() ✔
│     ├─ test202_sum_positive_even_numbers_regular() ✔
│     └─ test203_sum_positive_even_numbers_regular() ✔
|
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔
```


&nbsp;

### 3. *sum_recursive()*

Function: `sum_recursive(numbers[], int i)` returns the sum of `numbers[]`,
but uses recursion instead of loops (`for`, `while`, `do-while`).

Implement the function (no loops!) and demonstrate:

```sh
mk run sum_recursive numbers \
    sum_recursive numb_1 \
    sum_recursive numb_2 \
    sum_recursive numb_3
```

Output shows the correct results:

```
java application.Runtime sum numbers sum numb_1 sum numb_2 sum numb_3
NumbersDriver executing NumbersImpl
 - sum_recursive(numbers) -> 30
 - sum_recursive(numb_1) -> 50
 - sum_recursive(numb_2) -> 10984
 - sum_recursive(numb_3) -> 141466
done.
```

Install the *JUnit*-test class
[*Numbers_3_sum_recursion_Tests.java*](../../tree/b1-numbers-tests/tests/numbers/Numbers_3_sum_recursion_Tests.java)
and run the test:

```sh
java $(eval echo $JUNIT_CLASSPATH) org.junit.platform.console.ConsoleLauncher\
  $(eval echo $JUNIT_OPTIONS) \
  -c numbers.Numbers_3_sum_recursion_Tests
```

Output shows 300's tests passing:

```
├─ JUnit Jupiter ✔
│  └─ Numbers_3_sum_recursion_Tests ✔
│     ├─ test300_sum_recursion_regular() ✔
│     ├─ test301_sum_recursion_regular() ✔
│     ├─ test302_sum_recursion_regular() ✔
│     └─ test303_sum_recursion_regular() ✔
|
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔
```

&nbsp;

### 4. *findFirst()*

Function: `findFirst(numbers[], int x)` returns index of the first occurence
of `x` in `numbers[]` or `-1` if `x` is not found.

For example, number `4` occurs 3x in `numbers: [-2, 4, 9, 4, -3, 4, 9, 5]`.
Index `1` is the first occurence.

Implement and run the function:

```sh
mk run findFirst numbers x=4 \
    findFirst numbers x=-3 \
    findFirst numbers x=1
```
```
 - findFirst(numbers, x=4) -> 1
 - findFirst(numbers, x=-3) -> 4
 - findFirst(numbers, x=1) -> -1
```

Add and run tests
[*Numbers_4_find_first_Tests.java*](../../tree/b1-numbers-tests/tests/numbers/Numbers_4_find_first_Tests.java):

```sh
java $(eval echo $JUNIT_CLASSPATH) org.junit.platform.console.ConsoleLauncher\
  $(eval echo $JUNIT_OPTIONS) \
  -c numbers.Numbers_4_find_first_Tests
```

Output shows 400's tests passing:

```
├─ JUnit Jupiter ✔
│  └─ Numbers_4_find_first_Tests ✔
│     ├─ test400_find_first_regular() ✔
│     ├─ test401_find_first_regular() ✔
│     ├─ test402_find_first_regular() ✔
│     └─ test403_find_first_regular() ✔
|
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔
```


&nbsp;

### 5. *findLast()*

Function: `findLast(numbers[], int x)` returns index of the last occurence
of `x` in `numbers[]` or `-1` if `x` is not found.

For example, number `4` occurs 3x in `numbers[]: [-2, 4, 9, 4, -3, 4, 9, 5]`.
Index `5` is the last occurence.

- *findFirst()* is an efficient function. It can immediately return
    when *x* is found - giving it a *"speed"* of *n/2* on average
    with *n* as the length of the array.

    - What is the efficiency of *findLast()*? Can it also return *"early"* or has
    it to visit the entire array - giving it a *"speed"* of *n*.

    - Can you find an implementation that runs at *"speed"* *n/2*?


Implement and run the function:

```sh
mk run findLast numbers x=4 \
    findLast numbers x=-3 \
    findLast numbers x=1
```
```
 - findLast(numbers, x=4) -> 5
 - findLast(numbers, x=-3) -> 4
 - findLast(numbers, x=1) -> -1
```

Add and run tests
[*Numbers_5_find_last_Tests.java*](../../tree/b1-numbers-tests/tests/numbers/Numbers_5_find_last_Tests.java):

```sh
java $(eval echo $JUNIT_CLASSPATH) org.junit.platform.console.ConsoleLauncher\
  $(eval echo $JUNIT_OPTIONS) \
  -c numbers.Numbers_5_find_last_Tests
```

Output shows 500's tests passing:

```
├─ JUnit Jupiter ✔
│  └─ Numbers_5_find_last_Tests ✔
│     ├─ test500_find_last_regular() ✔
│     ├─ test501_find_last_regular() ✔
│     ├─ test502_find_last_regular() ✔
│     └─ test503_find_last_regular() ✔
|
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔
```


&nbsp;

### 6. *findAll()*

Function: `List<Integer> findAll(int[] numbers, int x)` returns indices of all
occurences of `x` in `numbers[]` as a `List<Integer>`.

Implement and run the function:

```sh
mk run findAll numbers x=4 \
    findAll numbers x=-3 \
    findAll numbers x=1
```

Output shows that `x=4` was found 3x in `numbers[]: [-2, 4, 9, 4, -3, 4, 9, 5]`
at indices: `[1, 3, 5]`, `x=-3` was found once at index `[4]` and `x=1` was
not found returning an empty result `[]`.

```
 - findAll(numbers, x=4) -> [1, 3, 5]
 - findAll(numbers, x=-3) -> [4]
 - findAll(numbers, x=1) -> []
```

Add and run tests
[*Numbers_6_find_all_Tests.java*](../../tree/b1-numbers-tests/tests/numbers/Numbers_6_find_all_Tests.java):

```sh
java $(eval echo $JUNIT_CLASSPATH) org.junit.platform.console.ConsoleLauncher\
  $(eval echo $JUNIT_OPTIONS) \
  -c numbers.Numbers_6_find_all_Tests
```

Output shows 600's tests passing:

```
├─ JUnit Jupiter ✔
│  └─ Numbers_6_find_all_Tests ✔
│     ├─ test600_find_all_regular() ✔
│     ├─ test601_find_all_regular() ✔
│     ├─ test602_find_all_regular() ✔
│     └─ test603_find_all_regular() ✔
|
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔
```


&nbsp;

### 7. *findSums()*

Function: `Set<Pair> findSums(int[] numbers, int sum)` returns a set of
pairs: `(x, y)` from `numbers[]` with `x + y = sum`.

For example: `sum=12` can be created from `numb_1[]: [8, 10, 7, 2, 14, 5, 4]`
with pairs: `[ (5,7), (4,8), (2,10) ]`.

Duplicates should be avoided and included only once, which means either
`(5,7)` or `(7,5)` and not both.

Interface `Numbers.java` defines `Pair` as Java-Record:

```java
/**
 * Immutable pair of integer values a and b.
 * @param a first element of pair
 * @param b second element of pair
 */
record Pair(int a, int b) {
    public String toString() { return String.format("(%d,%d)", a, b); }
};
```

Implementing the functions yields results using array `numb_1[]`:

```sh
mk run findSums numb_1 sum=10 \
    findSums numb_1 sum=12 \
    findSums numb_1 sum=15 \
    findSums numb_3 sum=500
```

Output shows that `sum=10` can be added by `2+8` from array
`numb_1[]: [8, 10, 7, 2, 14, 5, 4]`. There is only one solution.

There are three pairs of numbers from `numb_1[]` that add to `sum=12`:
`[ (5,7), (4,8), (2,10) ]` and two pairs that add to `sum=15`.

Sum `500` can be added from pairs: `[ (7,493), (485,15) ]` from array `numb_3[]`.

```
 - findSums(numb_1, sum=10) -> [(2,8)], solutions: 1
 - findSums(numb_1, sum=12) -> [(5,7), (4,8), (2,10)], solutions: 3
 - findSums(numb_1, sum=15) -> [(7,8), (5,10)], solutions: 2
 - findSums(numb_3, sum=500) -> [(7,493), (485,15)], solutions: 2
```

Add and run tests
[*Numbers_7a_find_sums_Tests.java*](../../tree/b1-numbers-tests/tests/numbers/Numbers_7a_find_sums_Tests.java)
and
[*Numbers_7b_find_sums_duplicates_Tests.java*](../../tree/b1-numbers-tests/tests/numbers/Numbers_7b_find_sums_duplicates_Tests.java):

Leave out tests `7b` if duplicate tests are not passing.

```sh
java $(eval echo $JUNIT_CLASSPATH) org.junit.platform.console.ConsoleLauncher\
  $(eval echo $JUNIT_OPTIONS) \
  -c numbers.Numbers_7a_find_sums_Tests \
  -c numbers.Numbers_7b_find_sums_duplicates_Tests
```

Output shows 700's tests passing:

```
├─ JUnit Jupiter ✔
│  ├─ Numbers_7a_find_sums_Tests ✔
│  │  ├─ test700_find_sums_regular() ✔
│  │  ├─ test701_find_sums_regular() ✔
│  │  ├─ test702_find_sums_regular() ✔
│  │  ├─ test703_find_sums_regular() ✔
│  │  ├─ test704_find_sums_regular() ✔
│  │  ├─ test705_find_sums_regular() ✔
│  │  └─ test706_find_sums_regular() ✔
|  |
│  └─ Numbers_7b_find_sums_duplicates_Tests ✔
│     ├─ test710_find_sums_duplicates() ✔
│     ├─ test711_find_sums_same_duplicates() ✔
│     ├─ test712_find_sums_mirror_duplicates() ✔
│     └─ test713_find_sums_regular_duplicates() ✔
|
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔
```


&nbsp;

### 8. *findAllSums()*

Function: `Set<Set<Integer>> findAllSums(int[] numbers, int sum)` returns all
combinations of numbers from the array that add to `sum`.

For example: `sum=10` can be created from `numb_1[]: [8, 10, 7, 2, 14, 5, 4]`
with: `[10]` and `[2, 8]`,
`sum=14` can be created with: `[14], [4, 10], [2, 4, 8], [2, 5, 7]`.

Duplicates such as `[4,10]` or `[10,4]`should be avoided and included only once.

```sh
mk run \
    findAllSums numb_1 sum=10 \
    findAllSums numb_1 sum=12 \
    findAllSums numb_1 sum=14 \
    findAllSums numb_1 sum=15 \
    findAllSums numb_1 sum=20
```

```
 - findAllSums(numb_1, sum=10) -> {[10], [2, 8]}, solutions: 2
 - findAllSums(numb_1, sum=12) -> {[4, 8], [2, 10], [5, 7]}, solutions: 3
 - findAllSums(numb_1, sum=14) -> {[14], [4, 10], [2, 4, 8], [2, 5, 7]}, solutions: 4
 - findAllSums(numb_1, sum=15) -> {[7, 8], [5, 10], [2, 5, 8]}, solutions: 3
 - findAllSums(numb_1, sum=20) -> {[2, 8, 10], [5, 7, 8], [2, 4, 14]}, solutions: 3
```

Explore more combinations from the (larger) `numb_2[]` array:

```sh
mk run \
    findAllSums numb_2 sum=1000 \
    findAllSums numb_2 sum=999
```

```
 - findAllSums(numb_2, sum=1000) -> [
    - [226, 774],
    - [754, 87, 7, 27, 125],
    - [7, 27, 636, 125, 205],
    - [7, 651, 27, 125, 190],
    - [7, 27, 125, 205, 190, 446]
   ], solutions: 5

 - findAllSums(numb_2, sum=999) -> [
    - [226, 773],
    - [27, 972],
    - [371, 87, 541],
    - [170, 190, 639],
    - [226, 27, 541, 205],
    - [163, 170, 125, 541],
    - [163, 170, 27, 639],
    - [163, 7, 190, 639],
    - [226, 371, 170, 27, 205],
    - [226, 371, 7, 205, 190],
    - [226, 371, 87, 125, 190],
    - [226, 163, 371, 7, 27, 205],
    - [226, 163, 371, 87, 27, 125]
   ], solutions: 13
```

Add and run tests
[*Numbers_8a_find_all_sums_Tests.java*](../../tree/b1-numbers-tests/tests/numbers/Numbers_8a_find_all_sums_Tests.java):

```sh
java $(eval echo $JUNIT_CLASSPATH) org.junit.platform.console.ConsoleLauncher\
  $(eval echo $JUNIT_OPTIONS) \
  -c numbers.Numbers_8a_find_all_sums_Tests
```

Output shows 800(a)'s tests passing:

```
├─ JUnit Jupiter ✔
│  ├─ Numbers_8a_find_all_sums_Tests ✔
│  │  ├─ test800_find_all_sums_regular() ✔
│  │  └─ test821_find_all_sums_regular_nbrs_2_sum999() ✔
|
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔
```


&nbsp;

### 9. *findAllSums(), XXL*

Array `numb_2[]` with `24` numbers is still small.

```java
/*
 * Larger set of 24 numbers, no negatives, no duplicates.
 */
static final int[] numb_2 = {   // 24 numbers
    371,  682,  446,  754,  205,  972,  600,  163,  541,  672,
     27,  170,  226,    7,  190,  639,   87,  773,  651,  370,
    125,  774,  903,  636//,225,  463,  286,  569,  384,    9,
}; // add more numbers to find more solutions
```

Run the function for `sum=999` with 24 numbers from `numb_2[]`:

```sh
mk run findAllSums numb_2 sum=999
```

Output:

```
 - findAllSums(numb_2, sum=999) -> [
    - [27, 972],
    - [226, 773],
    - [371, 87, 541],
    - [170, 190, 639],
    - [226, 27, 541, 205],
    - [163, 170, 125, 541],
    - [163, 170, 27, 639],
    - [163, 7, 190, 639],
    - [226, 371, 170, 27, 205],
    - [226, 371, 7, 205, 190],
    - [226, 371, 87, 125, 190],
    - [226, 163, 371, 7, 27, 205],
    - [226, 163, 371, 87, 27, 125]
   ], solutions: 13
```

Add numbers `225` und `463` to `numb_2[]` (remove comments) and repeat:

```sh
mk run findAllSums numb_2 sum=999
```

More solutions are found with the new numbers `225` und `463`:

```
 - findAllSums(numb_2, sum=999) -> [
    - [226, 773],
    - [225, 774],
    - [27, 972],
    - [371, 87, 541],
    - [170, 190, 639],
    - [163, 7, 190, 639],
    - [226, 27, 541, 205],
    - [163, 170, 125, 541],
    - [163, 170, 27, 639],
    - [225, 226, 7, 541],
    - [226, 371, 170, 27, 205],
    - [226, 371, 7, 205, 190],
    - [225, 226, 371, 7, 170],
    - [226, 371, 87, 125, 190],
    - [226, 163, 371, 7, 27, 205],
    - [226, 163, 371, 87, 27, 125],
    - [225, 87, 7, 27, 190, 463]
   ], solutions: 17
```

Incrementally add more numbers to `numb_2[]` and repeat:

- add number `286` --> 19 solutions,

- add number `569` --> 21 solutions,

- add number `384` --> 24 solutions,

- add number `9` --> 44 solutions:

```
-> findAllSums(sum=999, numb_2) -> [
    - [226, 773],                   - [371, 27, 125, 286, 190],
    - [27, 972],                    - [225, 226, 371, 7, 170],
    - [225, 774],                   - [226, 7, 569, 170, 27],
    - [170, 190, 639],              - [225, 370, 9, 205, 190],
    - [371, 87, 541],               - [226, 163, 371, 7, 27, 205],
    - [225, 569, 205],              - [226, 163, 371, 87, 27, 125],
    - [903, 87, 9],                 - [226, 163, 9, 125, 286, 190],
    - [226, 9, 125, 639],           - [225, 7, 9, 170, 125, 463],
    - [163, 9, 541, 286],           - [384, 7, 170, 27, 125, 286],
    - [163, 170, 27, 639],          - [384, 226, 163, 9, 27, 190],
    - [225, 226, 7, 541],           - [225, 7, 9, 27, 541, 190],
    - [163, 170, 125, 541],         - [225, 87, 7, 27, 190, 463],
    - [163, 7, 190, 639],           - [384, 226, 87, 7, 9, 286],
    - [773, 9, 27, 190],            - [7, 9, 125, 205, 190, 463],
    - [226, 27, 541, 205],          - [9, 170, 27, 125, 205, 463],
    - [163, 87, 286, 463],          - [225, 87, 9, 27, 205, 446],
    - [384, 27, 125, 463],          - [384, 226, 87, 7, 170, 125],
    - [226, 371, 87, 125, 190],     - [225, 370, 163, 9, 27, 205],
    - [226, 371, 170, 27, 205],     - [225, 371, 7, 9, 170, 27, 190],
    - [226, 371, 7, 205, 190],      - [163, 7, 9, 27, 125, 205, 463],
    - [163, 371, 9, 170, 286],      - [370, 226, 7, 9, 170, 27, 190],
    - [225, 87, 9, 651, 27],        - [384, 87, 7, 9, 170, 27, 125, 190]
   ], solutions: 44
```

A *"bruteforce"* algorithm will take increasing time from the 24th number
and not end if numbers continue to be added.

Alterative algorithms need to be used that can cope with larger number
arrays such as `numb_3`:

```java
/*
* Even larger set of 63 numbers, no negatives, no duplicates (n=3).
*/
static final int numb_3[] = {
     799, 2377,  936, 3498, 1342,  493, 1635, 4676, 1613, 3851,
    1445, 4506, 3346,    7, 2141, 2064, 1491,  908,   78, 3325,
    1756, 3691,   23, 1995, 1800,   15, 2784, 4305,   36, 2532,
    4292, 4802, 2522, 4183, 3261, 2610,  803, 2656,  498, 1668,
    2038, 2194,  440,  463, 4047, 4235, 3931,  756,  521, 4042,
    3302,  485, 1002,  408, 4691, 3387, 3104, 3658, 2241, 4382,
    1220, 3656,  500,
};
```

Try to find such algorithms (e.g. *"branch-and-bound"*) and implement
function `findAllSums(int sum)` such that it works with numbers from
`numb_3`, e.g. for `sum=999`:

```sh
mk run findAllSums numb_3 sum=999
```

Although there are only 10 solutions for `sum=999`, the number space
to explore is large: *2^63*.

```
 - findAllSums(numb_3, sum=999) -> [
    - [521, 463, 15],
    - [500, 36, 463],
    - [36, 7, 493, 463],
    - [498, 408, 78, 15],
    - [498, 23, 463, 15],
    - [23, 440, 521, 15],
    - [500, 36, 23, 440],
    - [36, 485, 463, 15],
    - [36, 23, 7, 440, 493],
    - [36, 485, 23, 440, 15]
   ], solutions: 10
```

There are only 5 solutions for `sum=1000`:

```sh
mk run findAllSums numb_3 sum=1000
```
```
 - findAllSums(numb_3, sum=1000) -> [
    - [500, 7, 493],
    - [500, 485, 15],
    - [485, 7, 493, 15],
    - [36, 408, 78, 463, 15],
    - [36, 23, 408, 440, 78, 15]
   ], solutions: 5
```

If you found an implementation that works with the `numb_3[]` array,
add and run tests
[*Numbers_8b_find_all_sums_XL_Tests.java*](../../tree/b1-numbers-tests/tests/numbers/Numbers_8b_find_all_sums_XL_Tests.java):

```sh
java $(eval echo $JUNIT_CLASSPATH) org.junit.platform.console.ConsoleLauncher\
  $(eval echo $JUNIT_OPTIONS) \
  -c numbers.Numbers_8b_find_all_sums_XL_Tests
```

Output:

```
├─ JUnit Jupiter ✔
|  |
│  └─ Numbers_8b_find_all_sums_XL_Tests ✔
│     ├─ test824_find_all_sums_XL_24_numbers() ✔
│     ├─ test825_find_all_sums_XL_25_numbers() ✔
│     ├─ test826_find_all_sums_XL_26_numbers() ✔
│     ├─ test827_find_all_sums_XL_27_numbers() ✔
│     ├─ test828_find_all_sums_XL_28_numbers() ✔
│     ├─ test829_find_all_sums_XL_29_numbers() ✔
│     ├─ test830_find_all_sums_XL_30_numbers() ✔
│     ├─ test840_find_all_sums_XL_numb_3_999() ✔
│     └─ test841_find_all_sums_XL_numb_3_1000() ✔
|
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔
```


&nbsp;

## Final Result

The final result will show all tests passing. Leave out tests that are
not passing:

<img src="https://gitlab.bht-berlin.de/sgraupner/playground/-/raw/main/markup/img/numbers_junit_vscode_3.png" width="800"/>

```sh
mk run-tests                    # run all tests
```

Or run tests selectively (remove tests that are failing):

```sh
# or run tests selectively (remove tests that are failing)
java $(eval echo $JUNIT_CLASSPATH) org.junit.platform.console.ConsoleLauncher\
  $(eval echo $JUNIT_OPTIONS) \
  -c application.Application_0_always_pass_Tests \
  -c numbers.Numbers_1_sum_Tests \
  -c numbers.Numbers_2_sum_positive_even_Tests \
  -c numbers.Numbers_3_sum_recursion_Tests \
  -c numbers.Numbers_4_find_first_Tests \
  -c numbers.Numbers_5_find_last_Tests \
  -c numbers.Numbers_6_find_all_Tests \
  -c numbers.Numbers_7a_find_sums_Tests \
  -c numbers.Numbers_7b_find_sums_duplicates_Tests \
  -c numbers.Numbers_8a_find_all_sums_Tests \
  -c numbers.Numbers_8b_find_all_sums_XL_Tests
```

Output with all tests passing:

```
├─ JUnit Jupiter ✔
│  ├─ Application_0_always_pass_Tests ✔
│  │  ├─ test_001_always_pass() ✔
│  │  └─ test_002_always_pass() ✔
│  ├─ Numbers_1_sum_Tests ✔
│  │  ├─ test100_sum_regular() ✔
│  │  ├─ test101_sum_regular() ✔
│  │  ├─ test102_sum_regular() ✔
│  │  └─ test103_sum_regular() ✔
│  ├─ Numbers_2_sum_positive_even_Tests ✔
│  │  ├─ test200_sum_positive_even_numbers_regular() ✔
│  │  ├─ test201_sum_positive_even_numbers_regular() ✔
│  │  ├─ test202_sum_positive_even_numbers_regular() ✔
│  │  └─ test203_sum_positive_even_numbers_regular() ✔
│  ├─ Numbers_3_sum_recursion_Tests ✔
│  │  ├─ test300_sum_recursion_regular() ✔
│  │  ├─ test301_sum_recursion_regular() ✔
│  │  ├─ test302_sum_recursion_regular() ✔
│  │  └─ test303_sum_recursion_regular() ✔
│  ├─ Numbers_4_find_first_Tests ✔
│  │  ├─ test400_find_first_regular() ✔
│  │  ├─ test401_find_first_regular() ✔
│  │  ├─ test402_find_first_regular() ✔
│  │  └─ test403_find_first_regular() ✔
│  ├─ Numbers_5_find_last_Tests ✔
│  │  ├─ test500_find_last_regular() ✔
│  │  ├─ test501_find_last_regular() ✔
│  │  ├─ test502_find_last_regular() ✔
│  │  └─ test503_find_last_regular() ✔
│  ├─ Numbers_6_find_all_Tests ✔
│  │  ├─ test600_find_all_regular() ✔
│  │  ├─ test601_find_all_regular() ✔
│  │  ├─ test602_find_all_regular() ✔
│  │  └─ test603_find_all_regular() ✔
│  ├─ Numbers_7a_find_sums_Tests ✔
│  │  ├─ test700_find_sums_regular() ✔
│  │  ├─ test701_find_sums_regular() ✔
│  │  ├─ test702_find_sums_regular() ✔
│  │  ├─ test703_find_sums_regular() ✔
│  │  ├─ test704_find_sums_regular() ✔
│  │  ├─ test705_find_sums_regular() ✔
│  │  └─ test706_find_sums_regular() ✔
│  ├─ Numbers_7b_find_sums_duplicates_Tests ✔
│  │  ├─ test710_find_sums_duplicates() ✔
│  │  ├─ test711_find_sums_same_duplicates() ✔
│  │  ├─ test712_find_sums_mirror_duplicates() ✔
│  │  └─ test713_find_sums_regular_duplicates() ✔
│  ├─ Numbers_8a_find_all_sums_Tests ✔
│  │  ├─ test800_find_all_sums_regular() ✔
│  │  └─ test821_find_all_sums_regular_nbrs_2_sum999() ✔
│  └─ Numbers_8b_find_all_sums_XL_Tests ✔
│     ├─ test824_find_all_sums_XL_24_numbers() ✔
│     ├─ test825_find_all_sums_XL_25_numbers() ✔
│     ├─ test826_find_all_sums_XL_26_numbers() ✔
│     ├─ test827_find_all_sums_XL_27_numbers() ✔
│     ├─ test828_find_all_sums_XL_28_numbers() ✔
│     ├─ test829_find_all_sums_XL_29_numbers() ✔
│     ├─ test830_find_all_sums_XL_30_numbers() ✔
│     ├─ test840_find_all_sums_XL_numb_3_999() ✔
│     └─ test841_find_all_sums_XL_numb_3_1000() ✔
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔

Test run finished after 4911 ms
[        14 containers found      ]
[         0 containers skipped    ]
[        14 containers started    ]
[         0 containers aborted    ]
[        14 containers successful ]
[         0 containers failed     ]
[        48 tests found           ]
[         0 tests skipped         ]
[        48 tests started         ]
[         0 tests aborted         ]
[        48 tests successful      ]
[         0 tests failed          ]
=======
 +--.env.sh             # file to set/source the project entvironment
 +-<.vscode>            # VSCode project files
 |  +--.classpath           # (generated) file used by VSCoderunner
 |
 +--.classpath          # VSCode, eclipse IDE configuration files,
 +--.project            # generated during "sourcing" the project
 |
 +-<libs> -> ./branches/libs    # link to 'libs'-branch (separately checked out)
 |
 +-<branches>           # home of separately checkout project branches
 |  +-<libs>            # 'libs'-branch containing project libraries
 |     +-<jackson>          # JSON library for Java
 |     +-<jacoco>           # code coverage library
 |     +-<logging>          # logging library
 |     +-<junit>            # library for JUnit5 tests
 |     +--junit-platform-console-standalone-1.9.2.jar   # JUnit5 test runner
```

Test the presence of environment variables:

```sh
echo $CLASSPATH
echo $MODULEPATH
echo $JDK_JAVAC_OPTIONS
```

Command `mk` (make) performs the shown commands.

```sh
mk classpath            # show $CLASSPATH with line-separated output
```

Content created during *project setup* can be removed and re-created
any time.

```sh
wipe                    # remove all content generated during setup
source .env.sh          # re-create setup
```


&nbsp;

## Project Build

*Project Build* is the process to create a final, executable artefact
from sources, typically a '.jar'-file for Java.

Steps include:

1. Compile sources from the `src` folder:
    ```sh
    mk compile
    ```

1. Run the program:
    ```sh
    mk run
    ```

1. Compile test sources from the `tests` folder:
    ```sh
    mk compile-tests
    ```

1. Run tests and perform code coverage analysis:
    ```sh
    mk run-tests
    mk coverage
    ```

1. Package classes to the final artefact, which is for this project
    `bin/application-1.0.0-SNAPSHOT.jar`:
    ```sh
    mk package
    ```

1. Run the final artefact:
    ```sh
    mk run-jar
    ```

1. Create *Javadoc*:
    ```sh
    mk javadoc
    ```

New content created during *project build* in the project directory is:

```sh
 |  # folders generated during project build by java, javac, javadoc
 |
 +-<bin>                        # compiled code (.class files, generated)
 |  +--application-1.0.0-SNAPSHOT.jar   # packaged application
 |  +-<classes>                 # folder with compiled files from 'src'
 |  |  +-<application>                  # package 'application' from 'src'
 |  |  |  +--Application.class
 |  |  |  +--Runtime.class
 |  |  |  +--Runtime$Run.class
 |  |  |  +--Runtime$Runnable.class
 |  |  |  +--Runtime$StartUpStatus.class
 |  |  |  +--Runtime$SupplierWithExceptions.class
 |  |  |  +--package-info.class
 |  |  |  +--package_info.class
 |  |  +--module-info.class
 |  |
 |  +-<resources>               # copy of 'resources' folder with files that
 |  |  +--application.properties    # are accessed at runtime and therefore
 |  |  +--log4j2.properties         # need to be on the CLASSPATH (bin)
 |  |
 |  +-<test-classes>            # folder with compiled tests from 'tests'
 |     +-<application>              # package 'application' from 'tests'
 |        +--Application_0_always_pass_Tests.class  # compiled test class
 |
 +-<docs>                       # folder with javadoc documentation (generated)
 |  +--index.html                   # javadoc landing page
 |  +-- ...                         # more .html and .css files
 |
 +-<coverage>                   # folder with code coverage files (generated)
 |  +--jacoco.exec                  # coverage recording
 |  +--index.html                   # coverage report
```

Content created during *project build* can always be removed and
re-created (re-built).

```sh
mk clean                        # remove 'bin', 'docs', 'coverage'

# re-buil project by performing all build steps
mk compile compile-tests run-tests coverage jar javadoc

# alternatively
mk clean build
```


&nbsp;

## Running the Application

Running the application means that a *configured entry point* is invoked
to start the application. Usually, this is a class with a `main(String[] args)`
function in Java. Multiple such classes may exist.

A more advanced project allows configuration of which class to launch.
In this project, this is achieved by a special class
[Runtime.java](src/application/Runtime.java)
that is included in the `application` package.

In general, a *Runtime* is a system that supports the execution of an application.
*Runtime* systems can be complex frameworks, such as powerful frameworks for
developing professional Java applications
[*Spring*](https://spring.io/),
[*Spring Boot*](https://spring.io/projects/spring-boot) or
[*Jakarta*](https://jakarta.ee/).

In this project, class [Runtime.java](src/application/Runtime.java) introduces to
the concept, which we will see again in *Spring Boot* development later.
*Runtime* here performs simple steps supporting the program execution:

- load [Properties](https://www.baeldung.com/java-properties) from file:
    [resources/application.properties](resources/application.properties),

- load [Logger](https://www.digitalocean.com/community/tutorials/log4j2-example-tutorial-configuration-levels-appenders)
    configuration from file:
    [resources/log4j2.properties](resources/log4j2.properties).

- Select a class for execution by

    - scanning all classes for implementing the `Runtime.Runnable` interface

    - select from those the class of the highest (run-)priority, create an
        instance of this class and invoke the interface method:
        ```java
        @Override
        void run(Properties properties, String[] args);
        ```

    - Run priorities are defined by

        - a `@Run(priority=n)` annotation on a *runnable* class and by

        - the order defined by the `runtime.run.priority` property
            in the `application.properties` file in the
            [*resources*](resources) folder.

        Property order supersedes the annotation priority for priorities:
        `1..999`. Annotation priority `>= 1000` supersedes order priority.

After build, the program can be launched in various ways.

In order to perform its tasks, class `Runtime.java` must be invoked before
the actual application can run:

```sh
java application.Runtime            # start Runtime directly
java application.Application        # start Runtime indirectly in Application.main()

mk run                              # also launches: application.Runtime
```

Starting the application directly will invoke the `main()` function in
[Application.java](src/application/Application.java),
which calls `Runtime` as the first step:

```java
public static void main(String[] args) {
    Runtime.getInstance().start(args);
}
```

The packaged application also has `application.Runtime` defined as
entry point in a file called: [*MANIFEST.MF*](resources/META-INF/MANIFEST.MF)
that defines the program launch for a `.jar` file.

*VSCode* also launches `application.Runtime`, see configuration files:
[*launch.json*](.vscode/launch.json) for *VSCode Run & Debug* or:
[*settings.json*](.vscode/settings.json) for the *Java Code Runner*.

After `Runtime` is finished performing its tasks, it will call the `run()` method
of the selected class passing references to `properties` and `args[]`:

```java
/**
 * Method of the {@link Runtime.Runnable} interface called on an instance
 * created by the {@link Runtime}. Program execution starts here.
 * @param properties from the {@code application.properties} file
 * @param args arguments passed from the command line
 */
@Override
public void run(Properties properties, String[] args) {
    /*
     * 1.) print application name fetched from 'application.name' property
     *     from the 'resources/application.properties' file:
     */
    String key = "application.name";
    String name = (String)properties.get(key);
    if(name==null) {
        name = "???";
        log.warn(String.format("property: \"%s\" not found, used \"%s\" instead", key, name));
    }
    System.out.println(String.format("Hello, \"%s\" (%s)", name, this.getClass().getName()));

    /*
     * 2.) print args[] from command line when called with:
     *     java application.Application AB BC CD
     */
    for(String arg : args) {
        String fmt = String.format("- arg: %s", arg);
        System.out.println(fmt);    // print formatted line
    }
}
```

The application prints the name obtained from the `application.name`
property in the `application.properties` file and then prints command
line arguments.

```sh
mk run 1 23 456                     # run application
java application.Runtime 1 23 456
java application.Application 1 23 456

mk run-jar 1 23 456                 # run packaged application
java -jar bin/application-1.0.0-SNAPSHOT.jar 1 23 456
```

Output is:

```
Hello, "SE-1 Play" (application.Application)
- arg: 1
- arg: 23
- arg: 456
done.
```

The *Logging* system has been configured by `Runtime` such that logfiles
are created in a directory called `logs`. File `runtime.log` contains logs
written by the logger for class `Runtime`.

Content created during *program execution* is:

```sh
 |
 +-<logs>               # log files generated during program execution
   +--runtime.log                  # log file for Runtime.java logger
   +--application.log              # log file for Application.java logger
```


&nbsp;

## Complete Project Content

The complete content of the project is shown below. All generated content
can be removed at any time and re-created by the *Build Process*.

The *Build Process* must always work in a software project.

Only *"source"* content belongs in the code repository, not generated
artefacts. Only *"working"* content must be checked-in, never broken files.

```sh
<se1-play>              # project directory
 |
 +--.env.sh             # file to set/source the project entvironment
 +-<.git>               # local git repository
 |  +--config               # git project settings
 +--.gitignore          # files for git to ignore
 +-- README.md          # this markup file
 |
 +--.classpath          # VSCode, eclipse IDE configuration files,
 +--.project            # generated during "sourcing" the project
 |
 +-<.vscode>                    # VSCode project files
 |  +--settings.json                # project-specific VSCode configuration
 |  +--launch.json                  # launch and debug configurations
 |  +--launch_terminal.sh           # script to launch terminals in VSCode
 |  +--.classpath                   # (generated) file used by VSCoderunner
 |
 +-<src>                        # Java source code
 |  +-<application>                 # package 'application'
 |  |  +--Application.java              # main application file
 |  |  +--Runtime.java                  # basic runtime
 |  |  +--package-info.java             # package documentation
 |  +--module-info.java             # module description (exports, requires)
 |
 +-<resources>                  # none-Java sources, configuration files
 |  +--application.properties       # application configuration file
 |  +--log4j2.properties            # logging configuration file
 |  +-<META-INF>                    # required to package executabe .jar
 |     +--<MANIFEST.MF>             # define main class and CLASSPATH for .jar
 |
 +-<tests>                      # source code for tests
 |  +-<application>                 # package 'application'
 |     +--Application_0_always_pass_Tests.java      # test class
 |
 +-<libs> -> ./branches/libs    # link to 'libs'-branch in folder 'branches'
 |
 +-<branches>                   # home of separately checkout project branches
 |  |
 |  +-<libs>                    # 'libs'-branch containing project libraries
 |     +-<jackson>                  # JSON library for Java
 |     |  +--jackson-annotations-2.13.0.jar
 |     |  +--jackson-core-2.13.0.jar
 |     |  +--jackson-databind-2.13.0.jar
 |     |
 |     +-<jacoco>                   # code coverage library
 |     |  +--jacocoagent.jar
 |     |  +--jacococli.jar
 |     |
 |     +-<logging>                  # logging library
 |     |  +--log4j-api-2.23.1.jar
 |     |  +--log4j-core-2.23.1.jar
 |     |  +--log4j-slf4j2-impl-2.23.1.jar
 |     |  +--slf4j-api-2.0.16.jar
 |     |
 |     +-<junit>                    # library for JUnit5 tests
 |     |  +--apiguardian-api-1.1.2.jar
 |     |  +--junit-jupiter-api-5.9.3.jar
 |     |  +--junit-platform-commons-1.9.3.jar
 |     |  +--opentest4j-1.2.0.jar
 |     |
 |     +--junit-platform-console-standalone-1.9.2.jar   # JUnit5 test runner
 |
 +-<bin>                        # compiled code (.class files, generated)
 |  +--application-1.0.0-SNAPSHOT.jar   # packaged application
 |  |
 |  +-<classes>                 # compiled files from 'src'
 |  |  +-<application>                  # package 'application' from 'src'
 |  |  |  +--Application.class
 |  |  |  +--Runtime.class
 |  |  |  +--Runtime$Run.class
 |  |  |  +--Runtime$Runnable.class
 |  |  |  +--Runtime$StartUpStatus.class
 |  |  |  +--Runtime$SupplierWithExceptions.class
 |  |  |  +--package-info.class
 |  |  |  +--package_info.class
 |  |  +--module-info.class
 |  |
 |  +-<resources>               # files copied from 'resources' folder that
 |  |  +--application.properties    # are accessed at runtime and therefore
 |  |  +--log4j2.properties         # need to be on the CLASSPATH (bin)
 |  |
 |  +-<test-classes>            # compiled tests from 'tests'
 |     +-<application>              # package 'application' in 'tests'
 |     +--Application_0_always_pass_Tests.class     # compiled test class
 |
 +-<docs>                       # javadoc documentation (generated)
 |  +--index.html                   # javadoc landing page
 |  +-- ...                         # more .html and .css files
 |
 +-<coverage>                   # code coverage files (generated)
 |  +--jacoco.exec                  # coverage recording
 |  +--index.html                   # coverage report
 |
 +-<logs>                       # log files (generated during program execution)
    +--runtime.log                  # log file for Runtime.java logger
    +--application.log              # log file for Application.java logger
>>>>>>> upstream/main
```
