# Lab 2 - Using Git and Variable Types

## Introduction

This lab will teach you about setting up your own Git repo, creating and merging branches, and pushing to GitHub.  Additionally, it will introduce you (without going into too much detail yet) to Gradle and Swing.

## What is Git?

Version control is very useful, as it gives you several benefits:

1. Sharing code is very easy
2. You can "time-travel" by making save points in your code.  Just like a save point in a video game, you can go back to an earlier point in development.
3. You can work on a large software project without interfering with others' work or having your own work interfered with.

It is extremely rare to work in a company nowadays which does NOT use version control system (VCS) of some kind.  Git is one VCS, and although far from the only one, it is extremely popular (and by far my personal favorite).  Git is the name of the VCS itself, and GitHub is simply a web-based interface and node in the distributed database that is git.  

Set up Git and GitHub on your machine using the instructions here: https://help.github.com/articles/set-up-git/

## Creating a Repository

Now we are going to create a repository (often referred to as a _repo_) using the instructions here: This repo should be called "Ex1".

1. Go to the GitHub home page: https://github.com/.  If you are not logged in, log in with your username and password (and complete any necessary 2FA if you have that activated)
2. In the upper right-hand corner, click on your user icon and then click on Your Profile.
3. This will take you to your profile page.  The URL should be https://github.com/YOURUSERNAME.
4. Click on the "Repositories" tab.
5. Click on the green "New" button to create a new repository.
6. Give the repository name "Ex1".  The URL for this repo will not be https://github.com/YOURUSERNAME/Ex1
6. For the description, write out " I knew him, Horatio, a fellow of infinite jest, of most excellent fancy." or "As flies to wanton boys, are we to the gods; they kill us for their sport." or whatever description you want.
7. Click on the "Private" radio button.
8. Click on the checkbox "Initialize this repository with a README"
9. In the .gitignore pulldown, select Gradle.
9. For the license, feel free to license it however you want.  The result of your work is your intellectual property.  If you would like more detail on the different licenses, go here: https://opensource.org/licenses  If you don't care, feel free not to select a specific license.
9. Click the green "Create repository"

After following the steps above, you should be taken to your repo's home (https://github.com/YOURUSERNAME/Ex1).  If you scroll to the bottom, you should see the message you typed in the README.md file.

Congratulations, you now have a git repo!  Now let's add collaborators since it's private.

## Adding Collaborators

1. Click on the Settings tab
2. Click on Collaborators on the right-hand side of the page
3. You will need to re-enter your password, as it can be dangerous to have additional collaborators on a repo.  Someone who is a collaborator can not only view but modify your code any way that they see fit!
4. After entering your password, you will be allowed to add usernames.  Add your partner's username and mine (`laboon`).
5. Your partner should receive an email allowing them access to the repo once they agree to do so.

Now your repo is ready to be worked on, but it only exists on GitHub.  We need to make a link to it on our local machine.

## Connecting Up Your Computer to the git Repo

_Note: The following commands will work on most Unix and OS X systems.  If you are using Windows, you can use the git shell (came with the git installation) or Bash Subsystem for Windows.  Do not use Command Prompt.

On your local machine, make a directory where you would like the repo to exist locally, for example, your home directory.

```
cd ~
```

Now let's clone the repository to a subdirectory under this directory.  Replace my git username ("laboon") with your own username.

```
git clone git@github.com:laboon/ex1.git
```

This will create a subdirectory.  Go to it and look around.

```
cd lab2
ls -l
```

There's the README.md file you created!  This is showing you the last "save pointed" (a/k/a "committed") version.

Modify the README.md file using your favorite text editor.

```
vi README.md
```

or

```
emacs -nw README.md
```

or

```
subl README.md
```

or whatever.  At the end of the file, we are going to add some more wisdom.  Add the sentence:

```
Ducks like to quack, but quacks don't like to duck.
```

and save the file.  If you refresh the GitHub site, it's not there - the changes were only made locally.  In fact, since they haven't been committed, the changes are just kind of floating out there.  You can see them, but from git's perspective, they don't really exist.  Take a look at what git is seeing by typing:

```
git status
```

It will tell you something along these lines:

```
On branch master
Your branch is up-to-date with 'origin/master'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

	modified:   README.md
```

This means that you have a file which you made changes to, but is not committed.

If you type:

```
git diff
```

It will show you which lines were edited, added, or deleted.

Let's now commit all of our changes with the following command:

```
git commit -a -m "Added duck info"
```

This commits all of our changes (that is what the -a flag means) with the message "Added duck info".  We can look back into the past of this repo with the command:

```
git log
```

So let's try that now.  You should see output similar to the following:

```
commit fe813a4d1fd912958520a838318b462402718167
Author: laboon <laboon@gmail.com>
Date:   Fri Sep 11 15:43:08 2015 -0400

    Added duck info

commit 30c53ecdc89e5c3f808549865a4e33922454b44a
Author: Bill Laboon <laboon@users.noreply.github.com>
Date:   Fri Sep 11 14:51:36 2015 -0400

    Initial commit

```

That long string of letters and numbers is actually a hexadecimal (base 16) number which uniquely identifies that commit.  It's called a SHA (rhymes with "baa"), after the hashing algorithm used to create it.  It is (for all practical purposes) unique for each commit - think of it as a PeopleSoft number or SSN for your commit.  If you want to look at what a commit consists of, you can `show` it by using the show command with the SHA.  Try the following command, but use one of the SHAs that your computer shows - this particular one won't work.

```
git show 30c53ecdc89e5c3f808549865a4e33922454b44a
```

Make a new file using your text editor, called Test.java.  Copy and paste the following text to it:

```
public class Test {

    public static void main(String[] args) {
        System.out.println("Test!");
    }

}
```

Now type:

```
git status
```

You will see a message like:

```
Untracked files:
  (use "git add <file>..." to include in what will be committed)

	Test.java
```

We need to tell git which files we want it to track.  So type:

```
git add Test.java
```

Later, if you decide you don't want git to track a file anymore, you can use `rm` instead of `add` to remove it.

Now let us see the status again:

```
git status
```

You should see:

```
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

	new file:   Test.java
```

After adding (it is _staged_ for commit), we will need to commit again.  We have made a change (_staged_ it) but not committed it.

```
git commit -a -m "added Test.java"
```

If you go back to the GitHub repo, you will notice that Test.java is not there, nor are our changes to README.md.  All changes were made locally.  We need to "push" our changes up to the GitHub server:

```
git push origin master
```

Git will inform you that it has succeeded:

```
Counting objects: 8, done.
Delta compression using up to 2 threads.
Compressing objects: 100% (3/3), done.
Writing objects: 100% (6/6), 501 bytes | 0 bytes/s, done.
Total 6 (delta 0), reused 0 (delta 0)
To git@github.com:laboon/lab2.git
   30c53ec..5bc5379  master -> master
```

Now if you look at the repo page on GitHub, you will see Test.java.  Your local machine's copy and the copy on GitHub are in sync.

You may want to make a few more changes and commits to Test.java, and push up to GitHub, to make sure you understand this before we move on.  


## Installing Gradle

Gradle is a build system.  That is, it provides a centralized way to manage libraries, organize code, test the code, package it, etc.  We will go more into depth on Gradle and build systems shortly, but for now just make sure that you have installed it.

I highly recommend you use a package manager (not just for Gradle, but this will come in handy for installing lots of other tools).  Linux systems tend to have `yum` or `apt` built-in (depending on which distribution you are using).  For OS X, I recommend homebrew ( https://brew.sh/ ).  For Windows, people have been happy with Chocolatey ( https://chocolatey.org/ ) or Scoop ( https://scoop.sh/ ).  I personally have used Scoop but Chocolatey seems be more popular (at least it has more packages).

Install Gradle using your package manager:

```
apt:
See https://www.vultr.com/docs/how-to-install-gradle-on-ubuntu-16-10

homebrew:

brew install gradle

Chocolatey:

choco install gradle

Scoop:

scoop install gradle

```

If you are using a different OS, package manager, etc., let me know and I will see if I can help you get Gradle installed.

## Gradle Basics

Gradle is a "convention over configuration" system.  There is a specified, default location for where our source files will be, configuration files will be, test files, etc.  Remember that there are pluses and minuses to this approach (as discussed a few lectures back).

Let's start by creating a new Gradle project.  For now, just accept that these commands do what they do and that there is a reason the files are in certain places - we will discuss further later.

Run the following command:

```
gradle init
```

You should see something similar to this output:

```
BUILD SUCCESSFUL in 1s
2 actionable tasks: 2 executed
```

This created an initial Gradle project.  Looking at the files will show a few new files and directories:

```
(1684) $ ls -l
total 48
-rw-r--r--  1 laboon  staff    35 May 27 12:37 README.md
-rw-r--r--  1 laboon  staff   201 May 27 12:37 build.gradle
drwxr-xr-x  3 laboon  staff   102 May 27 12:37 gradle
-rwxr-xr-x  1 laboon  staff  5296 May 27 12:37 gradlew
-rw-r--r--  1 laboon  staff  2260 May 27 12:37 gradlew.bat
-rw-r--r--  1 laboon  staff   357 May 27 12:37 settings.gradle
```

Edit the `build.gradle` file and add the following lines to the very top of the file:

```
apply plugin: 'java'
apply plugin: 'application'

mainClassName = "TicTacToe"
```

These specify that we are creating a Java application and that the main class name (where to look for the `public static void main` method) is TicTacToe.

Now we are going to create a location for our Java files.  Gradle expects that our Java files will live in the subdirectory `./src/main/java`, so let's create that subdirectory and go to it.

```
[laboon@penelope ~/pitt/ex1]
(1701) $ mkdir src

[laboon@penelope ~/pitt/ex1]
(1702) $ cd src

[laboon@penelope ~/pitt/ex1/src]
(1703) $ mkdir main

[laboon@penelope ~/pitt/ex1/src]
(1704) $ cd main

[laboon@penelope ~/pitt/ex1/src/main]
(1705) $ mkdir java

[laboon@penelope ~/pitt/ex1/src/main]
(1706) $ cd java

[laboon@penelope ~/pitt/ex1/src/main/java]
(1707) $ 
```

Now let's open a `TicTacToe.java` file in this directory and just have it print out "Tic Tac Toe" when it is run.

```
public class TicTacToe {
    
    public static void main(String[] args) {
	System.out.println("Tic Tac Toe");
    }
    
}
```

You may think that we would compile and run this from here.  But this is where the build system will come in handy (it may seem like extra work now, but it will save us work later when we have to worry about dependencies, JVM options, etc.)  Go back to the root directory of the Gradle project, and build the project using `gradle build`.

```
[laboon@penelope ~/pitt/ex1/src/main/java]
(1719) $ cd ../../..

[laboon@penelope ~/pitt/ex1]
(1720) $ gradle build

BUILD SUCCESSFUL in 3s
5 actionable tasks: 5 executed
```

We have now successfully built our Java program (if you see an error, double-check your syntax and location of your `TicTacToe.java` file.  The compiled `.class` files as well as other necessary files to run are located in the `./build` subdirectory, but you don't need to deal with that.  If you have ever gotten annoyed at .class files cluttering up your directory, build systems are a life-saver.

Now we are going to actually run the program.  Do this by typing `gradle run` and you should see the following output:

```
[laboon@penelope ~/pitt/ex1]
(1725) $ gradle run

> Task :run
Tic Tac Toe

BUILD SUCCESSFUL in 2s
2 actionable tasks: 1 executed, 1 up-to-date
```

There's our code executing!  If you don't want the extra Gradle status on your screen, you can run it in quiet mode with `-q`:

```
[laboon@penelope ~/pitt/ex1]
(1726) $ gradle -q run
Tic Tac Toe
```

## Adding Multiple Files To Git

We now have MANY files we want to add to our repository: build.gradle, our Java file, the `gradlew` and `gradlew.bat` files, etc.  But we also have EVEN MORE files that we don't want to add - the `.class` files in .build, perhaps backup files from our text editor, temporary scripts generated by Gradle, etc.  It's going to be annoying to go through and add individual files and avoid ones we don't want.

Fear not, gentle exercise-doer.  Remember when we created the repository that we generated a `.gitignore` file.  This will tell git to ignore many kinds of files that we don't want, even without specifying them!

```
[laboon@penelope ~/pitt/ex1]
(1751) $ more .gitignore 
.gradle
/build/

# Ignore Gradle GUI config
gradle-app.setting

# Avoid ignoring Gradle wrapper jar file (.jar files are usually ignored)
!gradle-wrapper.jar

# Cache of project
.gradletasknamecache

# # Work around https://youtrack.jetbrains.com/issue/IDEA-116898
# gradle/wrapper/gradle-wrapper.properties
```

Now, starting at the root directory of the Gradle project, add everything, using `git .`

```
[laboon@penelope ~/pitt/ex1]
(1752) $ git add .
```

Now let's see what was actually staged for commit:

```
[laboon@penelope ~/pitt/ex1]
(1753) $ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

	new file:   build.gradle
	new file:   build.gradle~
	new file:   gradle/wrapper/gradle-wrapper.jar
	new file:   gradle/wrapper/gradle-wrapper.properties
	new file:   gradlew
	new file:   gradlew.bat
	new file:   settings.gradle
	new file:   src/main/java/TicTacToe.java
```

It ignored everything in `/build` and lots of other files we wanted it to ignore.  But I do notice that it added in a backup file (`build.gradle~`) that I did not want.  Let's try this again.  Let's start over, then add in `*~` to `.gitignore` to ignore Emacs backup files (note - your text editor may use a different backup configuration, feel free to modify based on what you use).

```
[laboon@penelope ~/pitt/ex1]
(1754) $ git reset HEAD

[laboon@penelope ~/pitt/ex1]
(1755) $ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Untracked files:
  (use "git add <file>..." to include in what will be committed)

	.gitignore
	build.gradle
	build.gradle~
	gradle/
	gradlew
	gradlew.bat
	settings.gradle
	src/

nothing added to commit but untracked files present (use "git add" to track)
```

We un-staged everything for commit.  Now let's edit `.gitignore`.  At the bottom of the file I add `*~` ("ignore any file that ends in ~").  Then I add it and commit it.

```
# Ignore Emacs backup files
*~
```

```
[laboon@penelope ~/pitt/ex1]
(1758) $ git add .gitignore

[laboon@penelope ~/pitt/ex1]
(1759) $ git commit -m "ignore emacs backups"
[master cf5b423] ignore emacs backups
 1 file changed, 4 insertions(+), 1 deletion(-)
 ```

Now let's try adding everything again.

```
[laboon@penelope ~/pitt/ex1]
(1760) $ git add .

[laboon@penelope ~/pitt/ex1]
(1761) $ git status
On branch master
Your branch is ahead of 'origin/master' by 2 commits.
  (use "git push" to publish your local commits)
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

	new file:   build.gradle
	new file:   gradle/wrapper/gradle-wrapper.jar
	new file:   gradle/wrapper/gradle-wrapper.properties
	new file:   gradlew
	new file:   gradlew.bat
	new file:   settings.gradle
	new file:   src/main/java/TicTacToe.java
```

This time it ignored any file that ended with ~.  Let's finish up by pushing our changes up to GitHub.

```
[laboon@penelope ~/pitt/ex1]
(1762) $ git commit -am "add files"
[master 330588c] ds
 7 files changed, 289 insertions(+)
 create mode 100644 build.gradle
 create mode 100644 gradle/wrapper/gradle-wrapper.jar
 create mode 100644 gradle/wrapper/gradle-wrapper.properties
 create mode 100755 gradlew
 create mode 100644 gradlew.bat
 create mode 100644 settings.gradle
 create mode 100644 src/main/java/TicTacToe.java

laboon@penelope ~/pitt/ex1]
(1763) $ git push origin master
Counting objects: 6, done.
Delta compression using up to 2 threads.
Compressing objects: 100% (6/6), done.
Writing objects: 100% (6/6), 745 bytes | 0 bytes/s, done.
Total 6 (delta 1), reused 0 (delta 0)
remote: Resolving deltas: 100% (1/1), done.
To https://github.com/laboon/GradlePlay.git
   e083ca0..cf5b423  master -> master
```

You can now view your work at `https://github.com/YOURUSERNAME/Ex1`

## Branches and Pull Requests

It turns out that what we have been doing works fine when working with a single person on a project, but not when multiple people are working on it.  This is where _branches_ come in handy.  A branch is like a parallel universe that "branches" off from the "master" branch, and can later be "merged" back in.  It allows different people to work on the same project - or even file - without interfering with each other.

Let's say we want to add the ability to have our Tic-Tac-Toe game say "Tic Tac Toe: The Game of Kings!" instead of just "Tic Tac Toe".  Let's create a new branch.  I like to put my initials in front of branches just so people know who created it at a glance.

```
[laboon@penelope ~/pitt/ex1]
(1770) $ git checkout -b bl_game_of_kings
Switched to a new branch 'bl_game_of_kings'
```

I am now on the `bl_game_of_kings` branch, NOT the `master` branch that we have been working on.  Any change I make here will NOT be visible to any user looking at the `master` branch (at least not yet).

I edit the `TicTacToe.java` file and check my status.

```
[laboon@penelope ~/pitt/ex1]
(1771) $ git status
On branch bl_game_of_kings
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

	modified:   src/main/java/TicTacToe.java

no changes added to commit (use "git add" and/or "git commit -a")

[laboon@penelope ~/pitt/ex1]
(1772) $ gradle run

> Task :run
Tic Tac Toe: The Game of Kings!

BUILD SUCCESSFUL in 4s
2 actionable tasks: 2 executed
```

Everything looks good, so let's commit and push.  Note that I do NOT push to master - I am pushing to a new branch, `bl_game_of_kings`.

```
[laboon@penelope ~/pitt/ex1]
(1774) $ git add src/main/java/TicTacToe.java

[laboon@penelope ~/pitt/ex1]
(1775) $ git commit -m "game of kings"
[bl_game_of_kings 52a5d7e] game of kings
 1 file changed, 1 insertion(+), 1 deletion(-)

[laboon@penelope ~/pitt/ex1]
(1776) $ git push
fatal: The current branch bl_game_of_kings has no upstream branch.
To push the current branch and set the remote as upstream, use

    git push --set-upstream origin bl_game_of_kings
```

What does this mean?  Simply that it doesn't know exactly where to push this.  We need to set it to say to push it to GitHub.  Luckily, this is simple as copying and pasting the command it gave us.

```
[laboon@penelope ~/pitt/ex1]
(1777) $ git push --set-upstream origin bl_game_of_kings
```

This will also set our upstream permanently for this branch, so we can always just do a `git push` from now.  For example, I add a few more exclamation points because I am so excited by Tic Tac Toe.

```
[laboon@penelope ~/pitt/ex1]
(1778) $ git status
On branch bl_game_of_kings
Your branch is up-to-date with 'origin/bl_game_of_kings'.
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

	modified:   src/main/java/TicTacToe.java

no changes added to commit (use "git add" and/or "git commit -a")

[laboon@penelope ~/pitt/ex1]
(1780) $ more src/main/java/TicTacToe.java
public class TicTacToe {
    
    public static void main(String[] args) {
        System.out.println("Tic Tac Toe: The Game of Kings!!!");
    }
    
}

[laboon@penelope ~/pitt/ex1]
(1781) $ git add src/main/java/TicTacToe.java

[laboon@penelope ~/pitt/ex1]
(1782) $ git commit -m "MORE EXCLAIMING"
[bl_game_of_kings 5cd1c2e] MORE EXCLAIMING
 1 file changed, 1 insertion(+), 1 deletion(-)

[laboon@penelope ~/pitt/ex1]
(1783) $ git push
Counting objects: 6, done.
Delta compression using up to 2 threads.
Compressing objects: 100% (3/3), done.
Writing objects: 100% (6/6), 434 bytes | 0 bytes/s, done.
Total 6 (delta 2), reused 0 (delta 0)
remote: Resolving deltas: 100% (2/2), completed with 2 local objects.
To https://github.com/laboon/GradlePlay.git
   52a5d7e..5cd1c2e  bl_game_of_kings -> bl_game_of_kings
```

Note I could just do `git push` here.

## Pull Requests and Merging

Let's go look at our repository on GitHub.  Hmm, my `TicTacToe.java` file only show "Tic Tac Toe" and no "The Game of Kings!!!".  This is because I am viewing the master branch.  Let's hop on over to our `bl_game_of_kings` branch.

At https://github.com/YOURUSERNAME/ex1, right above the code, you will notice a pulldown saying "Branch: master".  Change it to "Branch: bl_game_of_kings" (or whatever you named your new branch).  Now when you view `TicTacToe.java`, you will see your changes.

We want to add these to the master branch, though, as this is the "main" branch.  There should be a green button, "Compare & Pull Request".  Click on it.

Now give a good description and click "Create Pull Request".  You will note that a Pull Request looks an awful lot like an Issue except it comes with code that can be merged in.  For the project, somebody will review your code here before it gets merged in.  Let's add a comment here to see how this is done.

Click on the "Files changed" tab, and go to the left edge of the updated file.  A "+" sign should appear at the left edge of the line (you may need to move the mouse around a little at first to find this).  Click on the "+".

Write in the textbox "Perhaps too excited?" and click "Start review".  Then click "Review changes" and "Submit review".  Congratulations, you have done a very simple code review.

Go back to the "Conversation" tab.  Here the developer, reviewer, and others can discuss the code review.  Type in "No such thing when it comes to Tic Tac Toe" as a response and assume the code review is now passed.

Click on the green "Merge pull request" button, then "Confirm merge".  If you like, you can also delete the branch now via the web interface.  Personally, I like to keep branches around for a while and delete them later, just in case I messed something up.

Now go back to https://github.com/YOURUSERNAME/ex1 and ensure that you are on the master branch.  If you view TicTacToe.java, you will see that your code has been merged in!

## Swing Basics

Your mission, should you choose to accept it, is to create a GUI Tic-Tac-Toe game!

As you are going along, please compile (`gradle build`) and check that your program functions correctly (`gradle run`) regularly.  Do not just type, type, type.  Studies have shown that more senior software engineers tend to make smaller steps, whereas junior engineers like to type in hundreds of lines then see if they compile.  Become a senior engineer as soon as you can!

### Instructions

The first thing to do is import all of the libraries that we need.  Specifically, we will want the java.awt.*, java.awt.event.*, and javax.swing.* classes.  We will see why later.  We want to put these at the top of our TicTacToe.java file.

```java
import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
```

After that, it's time to create a new frame.  A frame is what most people think of as a window (this is actually an old term - Emacs, for example, calls a window a "frame").  Creating a JFrame will create a new window.  You can set its size, default closing behavior, etc.  Frames are constructed like so:

```java
    JFrame _frame = new JFrame("Tic-Tac-Toe");
```

You should create this as an instance variable, not in a method.  Example:

```java
public class TicTacToe {
    JFrame _frame = new JFrame("Tic-Tac-Toe");

    public static void main(String[] args) {
       
    }

}
```

You will note that our class is a JFrame, and not a Frame.  Frames are AWT (Abstract Window Toolkit) classes; JFrames are Swing classes.  Swing is a GUI framework built on top of AWT (which is much nicer, trust me).  You will find that most classes that start with J have an equivalent J-less class in AWT.

We will do most of the work in the constructor; our main method should just make a new instance of the TicTacToe class.

```java
    public static void main(String[] args) {
	new TicTacToe();
    }
```

The last line of the constructor should let the frame be visible.  We can generate all of the data/elements/etc. "behind the scenes" without displaying them to the user, and then show them the finished version.  If you find that a window is not updating, it may be that you need to "force" a refresh by setting the frame to visible again.  It won't hurt anything if you do it more times than necessary (except when it comes to performance).

```java
	// Refresh window - otherwise we will not be able to see it
	// THIS IS A COMMON SOURCE OF BUGS!
	_frame.setVisible(true);
```

You can set the size of the frame by using the `setSize(width, height)` method on the frame.  `width` and `height` are specified in pixels.  The size of the frame is up to you.  Figure out what works best on your screen.  This can be done in the constructor.

```java
    	   _frame.setSize(400, 400);
	   _frame.setVisible(true);

```

You can set what should happen the user closes the window.  In many cases, we will want the program to exit; in others, we would want other events to occur.  For example, if you have multiple Firefox windows open, and you close one, you would not want the whole program to exit!  In our case, though, since we will have only one window and we will not need it to run in the background.  You can also do this in the constructor.

```java
	_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```

Feel free to look at the JFrame API (https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html) to see what else you can do!

Now, we want to have two sections of the frame.  Each of these sections is called a panel, and like good Swing classes, are called JPanels.  Create them

```java
	JPanel _ttt = new JPanel();
	JPanel _newPanel = new JPanel();
```

The top panel is going to be a grid layout (that is, it will have all of its elements in a two-dimensional grid, just like a Tic-Tac-Toe board).  Each spot in the grid will be a button.  The bottom panel is only going to have one button in it, so it doesn't really matter what layout we use.

In the constructor, set their respective layouts:

```java
	_ttt.setLayout(new GridLayout(3, 3));
	_newPanel.setLayout(new FlowLayout());
```

The Grid layout will position any elements (e.g. textboxes, buttons, labels, etc.) in a 3x3 layout.  The FlowLayout will just position the elements one after another, like letters in a line of text.  Also like a line of text, when no more elements fit, it will go "down" to the next line.

Now in the constructor, position them like so:

```java

	// This will place the tic-tac-toe panel at the top of
	// the frame and the newPanel panel at the bottom
	_frame.add(_ttt, BorderLayout.NORTH);
	_frame.add(_newPanel, BorderLayout.SOUTH);

```


Create nine buttons to put in the 3x3 layout and add them.  You can do this with a simple for loop:

```java
public class TicTacToe {
    JButton[] _buttons = new JButton[9];
...
```

In the constructor:

```java
	for (int j=0; j<9; j++) {
	    // Make a new button in the array location with text "_"
	    _buttons[j] = new JButton("_");
	    // Associate a new ButtonListener to the button (see below)
	    ActionListener buttonListener = new ButtonListener();
	    _buttons[j].addActionListener(buttonListener);
	    // Set the font on the button
	    _buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));
	    // Add this button to the _ttt panel
	    _ttt.add(_buttons[j]);
	}
```

This will create nine buttons along with their _listeners_ - that is, objects that "listen" for an event to take place, and then execute code when it happens.  We will fill in the listeners now so that they actually do something when the button is pressed.

Note that this style of programming - where code is executed when certain events occur, such as a button being pressed or a timer going off - is known as _event-driven programming_.

Before you can compile, add a ButtonListener.  This can be an internal (non-public) class.  In our case, we will start with a button which just changes to X when it is pressed.

```java
    class ButtonListener implements ActionListener {

	// Every time we click the button, it will perform
	// the following action.

	public void actionPerformed(ActionEvent e) {

	    JButton source = (JButton) e.getSource();
	    String currentText = source.getText();
	    if (currentText.equals("_")) {
		source.setText("X");
	    } else {
		source.setText("_");
	    }
	}
    
    }

```

Their default text on the button is `"_"` (the String argument to the JButton constructor).  When a user presses a button, the associated ActionListener for the clicked button will have its actionPerformed(ActionEvent e) method called.  We associated the listener with our button when we did the `_buttons[j].addActionListener(buttonListener);` statement.  Now when a button is pressed, the actionPerformed event actions take place.  If the text was a `"_"`, it will be changed to an `"X"`; otherwise, it will be set back to `"_"`.

Using the above code as a base, create one button and listener for the other panel in the layout (`newPanel`).

Using the previous steps as a base, create the listener for the "new game" button.  It should "erase" all of the buttons, putting them back to their default text when pressed, and the X player should .be the player again.

Using the previous steps as a base, create a boolean variable which flip-flops every time somebody presses a (valid) button.  The first time a button is pressed, the player should be an X, the second time an O, the third time an X, etc.  You can determine whether to make the spot an X or O based on this flip-flop variable.

Finally, modify the code to ensure that users cannot press a button which is already an X or an O.

## Adding Graphics

X's and O's are fine, but kids today demand graphics in their high-end video games like Tic-Tac-Toe.  They also demand philosophical references.  Thus we will modify our Tic-Tac-Toe game to use pictures of Plato (X) and Aristotle (O).  (_Pictures taken from the painting "Scuola di Atene" by Raphael - In the public domain and available here: https://en.wikipedia.org/wiki/The_School_of_Athens#/media/File:%22The_School_of_Athens%22_by_Raffaello_Sanzio_da_Urbino.jpg)

First, make a subdirectory in your project under `src/main` called `resources`.  Download the `plato.png` and `aristotle.png` from this directory and place them there.  The `resources` subdirectory will contain any art, sound, or other resources that you may want to use in your codebase.

Now we want to create an Image object from this particular resource.  Import the `javax.imageio` and `java.io.*` classes from the Java standard library, create two instance variables along with the other instance variables in TicTacToe class, and load the images in the TicTacToe constructor.

Note that those images may not exist (or may not be accessible!), so we will need to catch any IO exception.  This really shouldn't happen, so we will just exit with exit code 1 ( = error) if it does.

```
import javax.ImageIO.*;
import java.io.*;

...

// Images

Image _platoImage;
Image _aristotleImage;

...


	try {
	    _platoImage = ImageIO.read(getClass().getResource("/plato.png"));
	    _aristotleImage = ImageIO.read(getClass().getResource("/aristotle.png"));
	} catch (IOException ioex) {
	    System.exit(1);
	}
```

Now we need the button to display an IMAGE instead of TEXT when it is pressed.  We will need to create a new `ImageIcon` object with our image, and set the icon for that button to be our new ImageIcon.

Wherever you are setting text to X, replace it with the following code.

```
source.setIcon(new ImageIcon(_platoImage));
source.setText("");
```

Wherever you set text to O, you will need to do something similar with _aristotleImage.

You may need to go back and modify the original size of the buttons/frames/etc. to prevent automatic resizing.


### Additional Information

Feel free to take a look at the sample code for these classes to help put the system together:

1. Frames - https://github.com/laboon/cs0401/blob/master/sample_code/FrameDemo.java
1. Panels - https://github.com/laboon/cs0401/blob/master/sample_code/PanelDemo.java and https://github.com/laboon/cs0401/blob/master/sample_code/PanelDemo2.java
2. Extending Panels - https://github.com/laboon/cs0401/tree/master/sample_code/extended_jpanel
3. Creating and Interacting with Buttons - https://github.com/laboon/cs0401/blob/master/sample_code/ButtonDemo.java
4. Creating a Grid Layout - https://github.com/laboon/cs0401/blob/master/sample_code/GridDemo.java
5. Dynamically Changing A Button - https://github.com/laboon/cs0401/blob/master/sample_code/NameChangeButtonDemo.java

Remember that part of being a software engineer is knowing how to look things up on your own!  If you don't understand how something works, feel free to look at the Java API pages (http://docs.oracle.com/javase/8/docs/api/).  

For fun, you can add code to detect when a player has won or lost.  For even more fun, add some artificial intelligence and have the computer play the user! 

## Grading

This is an exercise and thus not graded.
