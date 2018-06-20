# CS/COE 1530 - Software Engineering
Summer Semester 2018

### ASSIGNED 21 JUNE 2018, DUE 5 JULY 2018

## Deliverable 3

For the third sprint, each group will need to:

1. Add betting and blinds features to the game
2. Test the program (using either manual or unit tests) and write a test report
2. Properly use the GitHub projects interface to keep track of user story status
3. Write a Sprint Report

The team should determine the Scrum Master for this sprint.  The Scrum Master must be a different person than the one for the first sprint.

## Format

For the third sprint, your team will turn in:

1. A cover page, in the format described below
2. A description of the sprint (a Sprint Report), including who worked on which user story
3. A description of the testing you did for this sprint, including unit tests and any defects found
3. A completely "working" game including bets and simple AI.  Details are below.

Format for cover page:
* The title "*your team name* - SPRINT 3 DELIVERABLE"
* The names of the people in the group, and their GitHub usernames.  Mark down who the Scrum Master is this sprint, e.g. "Jane Doe (Scrum Master)"
* Link to the project repository on GitHub
* The date that it is due (5 JULY 2018)

ADDITIONALLY, every user will hand in a SEPARATE paper with their name on it ranking their fellow group members, on a scale of 1-5, on their contribution.  This is necessarily a subjective measure, and so nothing in your grade will be DIRECTLY negatively impacted by the scores of your teammmates with additional scrutiny by me (although there can be a positive adjustment if everybody agrees you did a good job).

No other member of the group will see this ranking - it is confidential.

You will receive a group grade for this project but based on the reports of your teammmates and my analysis of the codebase (remember that I can see who committed what lines, when, etc. in your repository), your individual grade may be adjusted upwards or downwards.

### Ranking

I recommend you review these rankings, as they will also allow you to know what makes a good team member!

This is necessarily a subjective process, and you may find that a member does not fit directly in one category or another (say, the member was a very good developer and developed high quality code, but was not very good at communicating).  The descriptions are meant as broad generalizations for the various rankings.  You should use your best judgment in terms of where a particular person fits.  _You may provide fractional grades (e.g. 3.5) if you like._

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
* Sprint report: 10% of grade
* Project set up and used correctly on GitHub: 10% of grade
* Testing and test report: 10% of grade
* Project: 70% of grade

Remember that your grade may be adjusted based on group assessment and analysis.

The system __must__ compile and have the basic functionality outlined below.  You can have more functionality if you like, but it is essential that your program compiles, runs and displays the GUI without error!

The system __must__ be able to run on __everybody's__ computer!  Everybody should have access to the repository on GitHub and able to make commits by the end of this sprint.

You must "tag" the particular commit you want to have graded with the tag "D3".  Make sure you make an annotated and not a lightweight tag.  Also be sure you push the tag up to GitHub specifically!  Pushing up the branch to origin will NOT automatically push up the tag as well, you must do so separately.  If you want to tag the current commit, you may do so with the following commands:

```
git tag -a D3 -m "D3"
git push origin D3
```

Further details on tagging are here: https://git-scm.com/book/en/v2/Git-Basics-Tagging

The needs of the customer will be determined in class by interviewing the product owner (i.e., Bill Laboon).

## Third Sprint

It is incumbent upon you to make user stories using the Connextra template for this sprint.  I will give a description of what I want, but you will turn it into individual user stories.

Blinds should be set to 10/20 (small blind/big blind).  The nominal dealer, small blind, and big blind should be indicated visually.  The dealer should be selected at random and each hand, whoever is the dealer will rotate clockwise.

The granularity of betting shall be a dollar (i.e., there is no betting of cents - $10.50 or $10.01 are not valid bets, but $15 and $11 are).

The minimum bet shall be $10.  Players should be able to bet any amount from the minimum bet up to the limit of their stack (holdings).  If a player wants to call but does not have enough money, side pots should be implemented (see below).

Example scenario: Assume three players, A, B and C.  Player A raises $100.  Player B only has $50 but would like to call.  Player C folds.  Player B puts all of their money in, Player A is returned $50 and the game continues.

Example scenario 2: Assume three players, A, B, and C.  Player A raises $100.  Player B only has $50 but would like to call.  Player C has $1000 and would like to call.  There is now a "regular" pot with $50 from each player, and a "side" pot (which should be indicated visually somehow) with $100 ($50 from Player A, $50 from Player C).  Player B can no longer make any bets - they are committed and must wait until the end of the hand.  Players A and C can continue to raise and bet but all additional money ends up in the side pot.  At the end of the hand, if either Player A or C wins the hand, all of the money in the regular and side pots goes to them.  If Player B wins the hand, they win all of the money in the regular pot only.  Whoever has the best hand of Players A and C wins the side pot.

If a player runs out of money, they are out of the game and will make no more moves.  No cards should be dealt to them.  A player who is out of the game should have some sort of visual indication.

Ties should be handled by giving the tied players P1..Pn 1/nth of the pot.  For example, if three people end up tying (n=3), each player gets 1/3 of the pot.

AI players should have at _least_ a valid random response.  They should never fold if no money is bet to them, however (e.g., if everybody before them just called, they should either raise or call themselves).  You may work on an "official" AI if you like but it is not necessary for this sprint.

If any functionality from previous sprints has not been completed, you should complete it this sprint.

The game shall end once only one player has money.  At this point, a message shall appear indicating who the winner is and asking if the user would like to play again.  If the user answers yes, the game starts from the beginning.

In the case of any confusion or ambiguity, the rules of the game shall follow Hoyle's Rules of Texas Hold'em, available here: https://www.hoylegaming.com/rules/showrule.aspx?RuleID=222

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
