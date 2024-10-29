# Project: *se1-play*, branch *b2-streams*

Branch *b2-streams* contains code and tasks for the assignment.

Code and JUnit-tests must work in the IDE and in the terminal.

Steps:

1. [Introduction to the Java *Streams API*](#1-introduction-to-the-java-streams-api)

1. [*Setup* and *Build* Project](#2-setup-and-build-project)

1. [Implement *Stream* - Methods](#3-implement-stream-methods)

1. [*JUnit*-Tests](#4-junit---tests)

1. [Final Result](#final-result)


&nbsp;

## 1. Introduction to the Java *Streams API*

The
[*Java Streams API*](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/stream/Stream.html)
has been introduced with Java version 8 (2014) to support *data-streams* and *stream-based programming*.

A `Stream` consists of three parts:

1. a `Source` from where data originates,

    - can be a *Collection* (List, Array, ...), a *Range* or a *Supplier* (*Generator*),

1. a concatenated sequence of `Functions` applied to data objects,

    - any *none-terminal* method of the *Java Streams API*, e.g.
        *map()*, *filter()*, *findAny()*,

1. a `Sink` that *pulls data* from the stream producing a *result*

    - any *terminal* method of the *Java Streams API*, e.g.
        *reduce()*, *sum()*, *collect()*, *forEach()*.

<img src="https://s1.o7planning.com/web-rs/web-image/en/arf-1189995-vi.webp" width="600"/>


Create in project `se1-play` a new package `streams` and in it a file
`StreamPlay.java` with:

```java
/*
 * Numbers with negative numbers and duplicates.
 */
final List<Integer> numbers = List.of(-2, 14, 9, 4, -3, 4, 9, 5);

/**
 * Return even numbers from input in ascending order with duplicates
 * removed.
 * @param input numbers
 * @return even numbers in ascending order with no duplicates
 */
List<Integer> sortedEvenNumbersNoDuplicates(List<Integer> input) {
    return input.stream()           // Source: input list as stream source
        .filter(n -> n % 2 == 0)    // only even numbers pass
        .distinct()                 // remove duplicates from stream
        .sorted()                   // sort stream
        .toList();                  // Sink: collect results as List<Integer>
}

public void run() {
    var result = sortedEvenNumbersNoDuplicates(numbers);
    var report = String.format("sortedEvenNumbers: %s", result);
    System.out.println(report);
}
```

Run `StreamPlay.java`:

```
sortedEvenNumbers: [-2, 4, 14]
```

Add method:


```java
/**
 * Return ten random numbers in an interval of a lower and an upper
 * bound: {@code lower <= number <= upper} in ascending order.
 * @param lower lower bound
 * @param upper upper bound
 * @return ten random numbers in ascending order
 */
List<Integer> tenSortedRandomNumbers(int lower, int upper) {
    Random rand = new Random();
    return Stream.generate(     // Source: generator
        () -> Integer.valueOf(rand.nextInt(upper)))
        // ...
        .limit(10)
        // ...
        .toList();
}
```

Run `tenSortedRandomNumbers(100, 999)` to return ten three-digit
random numbers:

```
sortedEvenNumbers: [-2, 4, 14]
tenSortedRandomNumbers: [108, 554, 602, 675, 693, 813, 889, 923, 965, 987]
```

Add argument: `boolean ascending` to control order and run function
with:

- `tenSortedRandomNumbers(100, 999, true)`

- `tenSortedRandomNumbers(100, 999, false)`

producing output:

```
# with: ascending=true
tenSortedRandomNumbers: [132, 274, 456, 527, 665, 700, 750, 859, 915, 980]

# with: ascending=false
tenSortedRandomNumbers: [940, 916, 718, 685, 561, 504, 493, 364, 213, 128]
```


&nbsp;

## 2. *Setup* and *Build* Project

Add branch
[b2-streams](https://github.com/sgra64/se1-play/tree/b2-streams)
to the project `se1-play`.

```sh
cd se1-play                 # change into the project directory

# update the 'main'-branch in the project directory (pull the latest
# changes from the remote directory giving incoming changes ("theirs")
# priority in case of conflicts)
# 
git pull origin main --strategy-option theirs

# pull content from branch 'b2-streams'
# 
git pull origin b2-streams --strategy-option theirs
```


New source files appear in package:
[*streams*](src/streams) with an interface:
[*Streams.java*](src/streams/Streams.java)
and implementation class:
[*StreamsImpl.java*](src/streams/StreamsImpl.java)
and driver code
[*StreamsDriver.java*](src/streams/StreamsDriver.java).


```sh
<se1-play>              # project directory
 |
 +--.gitignore                  # files for git to ignore
 +-- README.md                  # this markup file
```
