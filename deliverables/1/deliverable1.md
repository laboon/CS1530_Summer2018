# CS/COE 1530 - Software Engineering
Summer Semester 2018

### ASSIGNED 24 MAY 2018, DUE 7 JUNE 2018

## Deliverable 1

For the first sprint, each group will need to:

1. Write a walking skeleton and prototype UI of the application using swing and gradle
2. Write unit tests
2. Properly use the GitHub projects interface to keep track of user story status
3. Write a Sprint Report

The team should determine the Scrum Master for this first sprint.  The Scrum Master will change each sprint.

## Format

For the first sprint, your team will turn in:

1. A cover page, in the format described below
2. A description of the sprint (a Sprint Report), including who worked on which user story
3. A "walking skeleton" application available on GitHub in a PRIVATE repository (ADD ME AND THE TA AS COLLABORATORS!  Usernames are `laboon` and `mraoufi`).  Note that running this program should display a basic UI for the program - note that only minimal functionality is required here for the first deliverable.


Format for cover page:
* The title "*your team name* - SPRINT 1 DELIVERABLE"
* The names of the people in the group, and their GitHub usernames.  Mark down who the Scrum Master is this sprint, e.g. "Jane Doe (Scrum Master)"
* Link to the project repository on GitHub
* The date that it is due (7 JUNE 2018)

ADDITIONALLY, every user will hand in a SEPARATE paper with their name on it ranking their fellow group members, on a scale of 1-5, on their contribution.  This is necessarily a subjective measure, and so nothing in your grade will be DIRECTLY negatively impacted by the scores of your teammmates with additional scrutiny by me (although there can be a positive adjustment if everybody agrees you did a good job).

No other member of the group will see this ranking - it is confidential.

You will receive a group grade for this project but based on the reports of your teammmates and my analysis of the codebase (remember that I can see who committed what lines, when, etc. in your repository), your individual grade may be adjusted upwards or downwards.

### Ranking

I recommend you review these rankings, as they will also allow you to know what makes a good team member!

This is necessarily a subjective process, and you may find that a member does not fit directly in one category or another (say, the member was a very good developer and developed high quality code, but was not very good at communicating).  The descriptions are meant as broad generalizations for the various rankings.  You should use your best judgment in terms of where a particular person fits.

You may also add your own comments for your rationale for the ranking, but this is not necessary.

1. Member did nothing, or very little, during the sprint.  Member did not respond in a timely manner to others' requests.  Member did not communicate or communicated rarely with other members.

2. Member did less than an expected amount of work this sprint and/or produced work of lesser quality than expected.  Member responded to others in the group, but did so poorly, required multiple prompting, took a long time to respond, or responded right before the due date.  Member did not communicate with other teammates very often.

3. Member did an expected amount of work this sprint, and with an acceptable level of quality.  Member responded to others in a timely fashion when asked to do so.  Member communicated with other teammates regularly and well.

4. Member did more than expected this sprint and/or did so with a high level of quality.  Member went above and beyond in responding to teammates.  Member went out of their way to communicate and did so quickly and well.

5. Member did a heroic amount of work this sprint and/or did work of exceptional quality.  Member is seen as a mentor and role model to others.  Member went above and beyond to communicate quickly and effectively.

## Sprint Report

This should be an approximately one-page report which contains the following information:

1. Who did which stories?
2. What issues or problems did you encounter?
3. What went more easily than you expected, or was more difficult?
4. What design/coding/architectural decisions did you make?
5. Was there any disagreement on those decisions?  How was it resolved?
6. Any other significant information about the work done this sprint

## Grading
* Sprint report: 20% of grade
* Project set up and used correctly on GitHub: 10% of grade
* Initial GUI: 70% of grade

Remember that your grade may be adjusted based on group assessment and analysis.

The initial GUI __must__ compile and show a basic UI for the application.  You can have more functionality if you like, but it is essential that your program compiles, runs and displays a basic UI without error!

This basic UI should display:

1. Your cards (face up)
2. Other players' cards (face down)
3. The amount of money in your "stack" (i.e. how much money you have)
4. The amount of money in other players' stacks
5. Names for your player and other players
6. Space for five shared cards in the middle (can be empty squares for first deliverable)

Public-domain card images are available here: https://github.com/notpeter/Vector-Playing-Cards or you can use some other publicly-available images (or if you are feeling really ambitious, you can make your own).

The basic UI may change over the course of the project.

The walking skeleton __must__ be able to run on __everybody's__ computer!  Everybody should have access to the repository on GitHub and able to make commits by the end of this sprint.

You must "tag" the particular commit you want to have graded with the tag "D1".  Make sure you make an annotated and not a lightweight tag.  Also be sure you push the tag up to GitHub specifically!  Pushing up the branch to origin will NOT automatically push up the tag as well, you must do so separately.  If you want to tag the current commit, you may do so with the following commands:

```
git tag -a D1 -m "D1"
git push origin D1
```

Further details on tagging are here: https://git-scm.com/book/en/v2/Git-Basics-Tagging

The needs of the customer will be determined in class by interviewing the product owner (i.e., Bill Laboon).

## The Game

The rules of the game shall follow Hoyle's Rules of Texas Hold'em, available here: https://www.hoylegaming.com/rules/showrule.aspx?RuleID=222

## Initial User Stories for First Sprint

1. As a game administrator,
I want the cards to be shuffled pseudorandomly and dealt,
So that players cannot unfairly know which cards others have.

1. As a player,
I want to see my own cards, but not others',
So that I can know what to play.

1. As a player,
I want to see my and others' stacks (amount of money available for betting),
So that I can bet legal amounts and adjust my strategy.

1. As a player,
I want to see the amount of money in the pot,
So that I can know how much money I can win in this round.

1. As a game administrator,
I want players to be able to input their name,
So that they can identify with the player on-screen.

1. As a game administrator,
I want all AI players to have a unique name,
So that human players can refer to AI players by a unique name.

1. As a player,
I want the game to allow me to choose the number of opponents from 1 to 7,
So that I can play with a variable number of opponents.

1. As a game administrator,
I want all players, human and AI, to start with $1,000.00,
So that the game is fair for all players.

For the first sprint, only these stories must be implemented.  In other words, the game will ask the player for their name and the number of opponents, and display a board with pseudorandomly-dealt cards.  The pot will start with $0.00 as nobody has anted or put up blinds yet (we will deal with this in the next sprint).  Players will start with $1,000.00 each and this should be displayed near their names.  The actual "playing" of the game does not need to occur yet.

Remember that stories must meet the "definition of done" - functionality been tested, code has been reviewed and approved by another member of the team, and any necessary documentation is included.

It is a good idea to "batch" related user stories together and have the same person work on them.

These stories should be filed as GitHub issues and added to the Product Backlog (using GitHub projects).   They should also be assigned to users.  For the first sprint, all of these stories should start in the Sprint Backlog.  You may start adding additional user stories or other tasks to the Product Backlog, but this is not necessary.

As part of Sprint Planning, you should also add the number of story points.  These should be part of the issue description along with a brief summary.  The full user story should be included as the main comment.

We will go over adding issues and user stories in class.

## Code Review

You should never work directly on the master branch.  Generally, each story should be done on a separate branch (if there are exceptions, you should note them in the deliverable paperwork).  Stories should never be merged directly into master, but rather submitted as pull requests.

You may not merge your own pull request.  Some other member of the team must review and approve your code - verifying that it compiles, is tested, does not break other aspects of the software, etc.  When performing code review, look to see:

1. Is the code and feature properly tested?
1. Is it well-commented?
1. Are there any issues with formatting (e.g. bad or inconsistent indents)?
1. Does the code compile?
1. Are variables well-named?
1. Are good algorithms used?
1. Is it easy to understand?
1. Is it well-segmented (i.e., good methods that are self-contained)?
1. Does it actually do what it says it does?
1. Does it accomplish what is specified in the user story?

This is not an exhaustive list - feel free to think of other user story-specific issues which may occur.

## Other

Each team member must indicate in the paperwork which user stories they worked on during the sprint.  Every sprint, team members must implement at least one user story.  Developers can collaborate on user stories, but one person should be "in charge" of each user story.

You must use the Java Swing framework for the graphical user interface.  You can use the following repository to either brush up on your Swing or learn it on your own: https://github.com/laboon/GameOfLife This contains a graphical version of Conway's Game of Life.

The following files from my CS0401 class may also be helpful as examples:

1. Frames - https://github.com/laboon/cs0401/blob/master/sample_code/FrameDemo.java
1. Panels - https://github.com/laboon/cs0401/blob/master/sample_code/PanelDemo.java and https://github.com/laboon/cs0401/blob/master/sample_code/PanelDemo2.java
2. Extending Panels - https://github.com/laboon/cs0401/tree/master/sample_code/extended_jpanel
3. Creating and Interacting with Buttons - https://github.com/laboon/cs0401/blob/master/sample_code/ButtonDemo.java
4. Creating a Grid Layout - https://github.com/laboon/cs0401/blob/master/sample_code/GridDemo.java
5. Dynamically Changing A Button - https://github.com/laboon/cs0401/blob/master/sample_code/NameChangeButtonDemo.java

We will also have an in-class exercise for a Swing refresher.

Please feel free to email me or come to office hours to discuss any problems you have.
