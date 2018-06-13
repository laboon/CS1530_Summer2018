# Git 911 Answers

Note that there are multiple ways to solve most of these!  I just wrote down one for each.

## BadRepo0

```
git checkout -b new_branch_name
*make changes*
git commit -am "change message"
git checkout master
git merge new_branch_name
git push origin master
```

## BadRepo1

```
git revert _SHA of last commit_
```

## BadRepo2

A _merge conflict_ is when two branches change the same line of code.  When merging, they are indicated as follows:

```
<<<<<<< HEAD
			toReturn = '_';
=======
			toReturn = ' ';
>>>>>>> wjl_display
```

When you see these, it means git could not figure out which one to use.  You need to delete all of the garbage (<<<<<< HEAD, ======, >>>>>> wjl_display), and determine yourself which line to use.  The lines _above_ the ====== signs are what is in the branch you are merging into; the lines _below_ are the ones from the branch you are merging from.  The final product should be equal to the code you want in master (or whatever branch you are merging _into_).  This can be either one of the chunks, both of them, or something entirely new (e.g., `toReturn = '?'`).  However, you will definitely need to ensure that you remove the <<<<<, =====, and >>>>> lines.

Merge conflicts were accidentally committed "as actual code".  Two solutions:

1. Revert back a commit (as in BadRepo1).  Then re-merge (`git merge wjl_display`).  Fix merge conflicts along the way as per normal.
2. Resolve the merge conflicts in master, and then commit that as an additional change.

In general, small issues like this would be solved the second way; larger errors in the first way.

## BadRepo3

```
git checkout wjl_commits
git rebase -i master
Squash (s) all of the commits into the first one (change "pick" to "squash" or just "s")
git push --force origin wjl_commits
```

Note that you won't be able to push this back up without forcing, since you "rewrote history" on the branch!  This behavior can be overriden  with `git push -f _branchname_`, or `git push --force _branchname_` or you can make a new branch from that point `git checkout -b _new_branch_`.

After rebasing, you can merge to master just like before:

```
git checkout master
git merge wjl_commits
git push origin master
```

You should NOT have to force push the _master_ branch!  Rebasing will add it to the end of the list of deltas (i.e., all the code in the branch will become a new commit "on top of" the master branch).  This does not modify history.

## BadRepo4

```
git checkout master
git merge wjl_derp
```

Fix all of the merge conflicts using your favorite text editor, then commit changes like so:

```
git add com/laboon/Cell.java com/laboon/JavaLife.java
git commit -am "fix merge conflicts"
git push origin master
```