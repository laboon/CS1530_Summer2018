# CS/COE 1530 - Software Engineering
Summer Semester 2018

### ASSIGNED 7 JUNE 2018, DUE 21 JUNE 2018

## Deliverable 2

For the second sprint, each group will need to:

1. Add features to make this a playable game (details below)
2. Test the program (using either manual or unit tests)
2. Properly use the GitHub projects interface to keep track of user story status
3. Write a Sprint Report

The team should determine the Scrum Master for this sprint.  The Scrum Master must be a different person than the one for the first sprint.

## Format

For the second sprint, your team will turn in:

1. A cover page, in the format described below
2. A description of the sprint (a Sprint Report), including who worked on which user story
3. A completely "working" game - note that this will not include all features.  Details are below.

Format for cover page:
* The title "*your team name* - SPRINT 2 DELIVERABLE"
* The names of the people in the group, and their GitHub usernames.  Mark down who the Scrum Master is this sprint, e.g. "Jane Doe (Scrum Master)"
* Link to the project repository on GitHub
* The date that it is due (21 JUNE 2018)

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
* GUI: 70% of grade

Remember that your grade may be adjusted based on group assessment and analysis.

The system __must__ compile and have the basic functionality outlined below.  You can have more functionality if you like, but it is essential that your program compiles, runs and displays the GUI without error!

The system __must__ be able to run on __everybody's__ computer!  Everybody should have access to the repository on GitHub and able to make commits by the end of this sprint.

You must "tag" the particular commit you want to have graded with the tag "D2".  Make sure you make an annotated and not a lightweight tag.  Also be sure you push the tag up to GitHub specifically!  Pushing up the branch to origin will NOT automatically push up the tag as well, you must do so separately.  If you want to tag the current commit, you may do so with the following commands:

```
git tag -a D2 -m "D2"
git push origin D2
```

Further details on tagging are here: https://git-scm.com/book/en/v2/Git-Basics-Tagging

The needs of the customer will be determined in class by interviewing the product owner (i.e., Bill Laboon).

## Second Sprint

It is incumbent upon you to make user stories using the Connextra template for this sprint.  I will give a description of what I want, but you will turn it into individual user stories.

At the end of this sprint, the system should be able to "play" the game.  That is, players should be able to start the game, transition to the flop/turn/river (i.e., the first three cards in the center, then the fourth, then the fifth), then all players' cards displayed and shown who has won.  At each transition, players should be able to fold, bet a certain amount of money, or call.  Whoever wins the hand gets all of the money in the pot added to their stack.

There is no need to implement AI, antes, etc.  AI players at this point should always fold if there is a bet by the player.  Otherwise, the AI players will call.  Note this means that no player will ever "win" the game - for this sprint, any money added to the pot will be from the player, and all of the players will automatically fold.

If not done already, cards should be displayed as images.

The rules of the game shall follow Hoyle's Rules of Texas Hold'em, available here: https://www.hoylegaming.com/rules/showrule.aspx?RuleID=222

Additionally, the game administrator has decided that there should be logging of all events in the game.  This is information written to a text file which includes:

1. A game starting and details about that game
2. A game ending
3. Which hands were dealt
4. The actions of each player
5. The result of each hand

The format does not have to be exactly what is in the example but should be similar.

Example:

```
Game started - 7 June 2017 at 3:43 PM
Player name: Bob
AI Players: Jane, Jan, Janet
Hand 1:
Cards dealt:
Bob: Ac Ah
Jane: Kh 8d
Jan: Qh 3h
Janet: 2h 7c
Bob calls.
Jane calls.
Jan calls.
Janet calls.
Flop: Ad Kd Ks
Bob calls.
Jane calls.
Jan folds.
Janet folds.
Turn: 2s
Bob calls.
Jane calls.
River: 3d
Bob calls.
Jan calls.
Bob wins with three-of-a-kind (Ac Ah Ad).
Bob wins $0.00.
Hand 2:
```

It is a good idea to "batch" related user stories together and have the same person work on them.

These stories should be filed as GitHub issues and added to the Product Backlog (using GitHub projects).   They should also be assigned to users.

As part of Sprint Planning, you should also add the number of story points.  These should be part of the issue description along with a brief summary.  The full user story should be included as the main comment.

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

Please feel free to email me or come to office hours to discuss any problems you have.
