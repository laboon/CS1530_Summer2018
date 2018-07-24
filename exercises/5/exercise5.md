## Exercise 5 - Refactoring and Defect Resolution

In this exercise, you will fix two defects (described below) in a Sieve of Eratosthenes program and then refactor the code (according to the `checkstyle` guidelines).  I recommend you fix the defects first and then run `checkstyle`.

The Sieve of Eratosthenes is an ancient way of finding all prime numbers below a specific value.  For details on the algorithm itself, please see https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes.

This program accepts one integer value and will tell you all prime numbers up to and including the passed-in value.  However, there are two (known) defects hidden in the code.  You will fix these two defects.

Please either show me your corrected code in class _or_ send me an email with a link to a repository containing the fixed code before the next class for two extra credit points on D5.

The developer of this code decided to test the program with two inputs, 100, and 101.  They wanted to test that the program worked when the final value was both a composite value and a prime value.  It worked in both cases, so they said "ship it!"

```
[laboon@ekaterina ~/pitt/bug-fodder]
(22036) $ java Sieve 100
Sieve of Eratosthenes
> 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
[laboon@ekaterina ~/pitt/bug-fodder]
(22037) $ java Sieve 101
Sieve of Eratosthenes
> 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101
```

## Defects

### DEFECT 1

```
SUMMARY:
Missing argument on command line shows NegativeArraySizeException

DESCRIPTION:
If an invalid value (e.g. negative number or string unable to be parsed
as an integer) is entered as an argument on the command line, the program
should assume the user meant 100.  This works correctly if a string which
cannot be parsed as an integer is passed in (e.g., "java Sieve fdsfds")
but if no argument is passed in, the program crashes with a
NegativeArraySizeException.

REPRODUCTION STEPS:
Enter "java Sieve".  Note no argument is passed in.

EXPECTED BEHAVIOR:
Program assumes value is 100 and notifies user of the default value.

OBSERVED BEHAVIOR:
Program crashes with a NegativeArraySizeException.

NOTES:
Output:

[laboon@ekaterina ~/pitt/bug-fodder]
(22062) $ java Sieve
Sieve of Eratosthenes
Exception in thread "main" java.lang.NegativeArraySizeException
	at Sieve.generateSieve(Sieve.java:169)
	at Sieve.main(Sieve.java:232)

```

### DEFECT 2

```
SUMMARY:
If final number is composite, sometimes it is shown

DESCRIPTION:
For some composite values entered as an argument, the program will display the
correct prime values but will also show the initial entered value as a prime
number as well.

REPRODUCTION STEPS:
Enter "java Sieve 4"

EXPECTED BEHAVIOR:
Output consists of values 2 and 3, all prime numbers n < 4.

OBSERVED BEHAVIOR:
Output includes 2, 3, and 4.  4 is composite and thus should not be displayed.

NOTES: This behavior was seen on a variety of different inputs where the
final value is composite.  See below:

[laboon@ekaterina ~/pitt/bug-fodder]
(22048) $ java Sieve 102
Sieve of Eratosthenes
> 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101 102
[laboon@ekaterina ~/pitt/bug-fodder]
(22049) $ java Sieve 4
Sieve of Eratosthenes
> 2 3 4
[laboon@ekaterina ~/pitt/bug-fodder]
(22050) $ java Sieve 6
Sieve of Eratosthenes
> 2 3 5 6

HOWEVER, this was not universal for all composite numbers.  For example,
the following output is correct despite 112 being composite:

(22061) $ java Sieve 112
Sieve of Eratosthenes
> 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101 103 107 109

```


## Clone and Compile bug-fodder


## Run Checkstyle

`checkstyle` is a kind of program called a _linter_ which will verify that your program meets the style guidelines - such as variable naming, proper capitalization and indentation, etc. - specified in a given file.  The file you will use is included in the GitHub `bug-fodder` repository and is a slightly modified version of the official Google Java style guidelines.

You can run checkstyle on Sieve using the following command, assuming you have cloned down the bug-fodder repository.

```
java -jar checkstyle-7.0-all.jar -c google_checks_modified.xml Sieve.java
```

This will give you a list of style violations which you should fix.

## Instructions

1. Clone the bug-fodder repository (https://github.com/laboon/bug-fodder)
2. Go to the directory
3. Compile the Sieve.java file
4. Verify that the defects occur
5. Fix both of the defects described above.
6. Ensure that the Sieve program still works by sending in a few different values (there is no need for pinning tests for this assignment, although it would be a good idea to do so in industry!)
7. Refactor code until `checkstyle` shows no errors.  Verify that your refactoring did not cause any additional failures.  Note that refactoring modifies code without modifying functional behavior.

## Grading

If you show me your completed exercise before the beginning of the next class, you will get two bonus points on the final deliverable.

Note that you will need to put this in your own GitHub repository if you would like me to review it after class.  If you finish in-class, you may show me in-person or put it up on GitHub.
