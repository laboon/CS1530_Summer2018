# CS/COE 1530 - Software Engineering
Summer Semester 2018

### ASSIGNED 5 JULY 2018, D4 DUE 19 JULY, D5 DUE 2 AUG

## Deliverables 4 and 5

For the fourth sprint, each group will need to:

1. Add the "Timer" option (see below)
2. Add one additional feature from the Optional Features list (see below)
3. Clean up code from previous sprints (see below)
4. Write a Sprint Report including a clean-up report
5. Properly use the GitHub projects interface to keep track of user story status

For the fifth sprint, each group will need to:
1. Add two more features from the Optional Features list
2. Clean up code from previous sprints and prepare project for final presentation
3. Write a Sprint Report including a clean-up report
4. Properly use the GitHub projects interface to keep track of user story status
5. Present their program to the class (5 - 10 minutes)

The team should determine the Scrum Master for each sprint.  The Scrum Master must be a different person than the one whow as chosen for the last sprint.

## Format

For the final two sprints, your team will turn in:

1. A cover page, in the format described below
2. A description of the sprint (a Sprint Report), including who worked on which user story and a clean-up report.
3. A completely "working" game including the "Timer" option.  Details are below.

Format for cover page:
* The title "*your team name* - SPRINT {4,5} DELIVERABLE"
* The names of the people in the group, and their GitHub usernames.  Mark down who the Scrum Master is this sprint, e.g. "Jane Doe (Scrum Master)"
* Link to the project repository on GitHub
* The date that it is due (19 JULY 2018 / 2 AUG 2016)

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

This should be an approximately one- to two-page report which contains the following information:

1. Who did which stories?
2. What issues or problems did you encounter?
3. What went more easily than you expected, or was more difficult?
4. What design/coding/architectural decisions did you make?
5. Was there any disagreement on those decisions?  How was it resolved?
6. Any other significant information about the work done this sprint

Most importantly, you must include what you did to improve quality (clean up report).  This can include:

1. Adding unit tests
2. Refactoring code
3. Modifying architecture
4. Other testing
5. Analysis of edge cases
6. Fixing known defects

## The Timer Option

When starting a game, players should be given the option to have a time limit indicated (in seconds).  If this is selected, players will have an on-screen counter count down, once per second, from the time limit down to 0.  After the timer reaches 0, the text of the timer will change to FOLD and the player will automatically fold.  This only counts for the human player.  There is an additional design constraint, this must be done in a separate thread.

## Optional Features List

Implement one of these (your group's choice) this sprint, and two for the next sprint.  Remember that it is up to you to split these into user stories.

1. "Real" AI - AI players will respond in reasonable and differing ways.  If you implement this, AI players should generally have a two-axis "personality" - tight vs loose and passive vs aggressive ( http://www.pokerology.com/lessons/poker-playing-styles/ ).  Levels may be selected by the player or be random.
2. Training mode - When starting a game, players can select to be in "training mode".  In training mode, two things will hapen: (a) before the flop, will show the relative value of their hand and (b) a value is shown to the player every time they have a chance to bet - the pot odds ( https://en.wikipedia.org/wiki/Pot_odds ).
3. Training mode (advanced) - I recommend you only implement this after implementing "Training Mode".  This would be an addition on to Training Mode which would also show Expected Value AND after the player makes a move, whether or not it was a good one according to EV ( http://www.pokerology.com/lessons/expected-value/ ).
3. Check / Call AND Show Winning Hand - The "call" button should show "Check" when there is no bet to the user (same as calling $0).  Also, the winning five cards should be indicated graphically.
3. (SUPER FEATURE - COUNTS AS TWO FEATURES) Create a way for human players to play against each other on different systems (e.g. via direct network connection, via email, via a centralized server, etc.)
4. "Heckling" mode - At the beginning of the game, players will have the option of selecting "heckling mode".  If this mode is selected, players will be "heckled" at random intervals by a text box with various insults to their poker-playing abilities (be creative).  This should NOT be a modal dialog ("pop-up box").  Design constraint: this must be done using a separate thread.
5. Chips - Instead of showing stacks (money) as just an integer, show an appropriate number of chips in front of each player using standard US (not California) chip colors ( http://poker.wikia.com/wiki/Chip_colors ).  You may assume that players trade in their chips to the dealer for the fewest number of chips possible at each turn (i.e., always display chips using the fewest number of chips possible).
6. Player graphics - Every player is indicated by an individual graphic for their avatar.  The human player can select a graphic to be used, loaded from an external image file.

You may implement a separate feature of your own choosing (in fact, this would be great!) but it needs to be approved by the instructor first.  This feature will generally count as one feature unless otherwise indicated.

You may implement more features for bonus points.

## Grading (D4)
* Sprint report: 15% of grade
* Project set up and used correctly on GitHub: 10% of grade
* Project: 75% of grade

## Grading (D5)
* Sprint report: 15% of grade
* Project set up and used correctly on GitHub: 10% of grade
* Project: 65% of grade
* Presentation: 10% of grade

Remember that your grade may be adjusted based on group assessment and analysis.

The system __must__ compile and have the basic functionality outlined below.  You can have more functionality if you like, but it is essential that your program compiles, runs and displays the GUI without error!

The system __must__ be able to run on __everybody's__ computer!  Everybody should have access to the repository on GitHub and able to make commits by the end of this sprint.

You must "tag" the particular commit you want to have graded with the tag "D4" (for D4) or "D5" (for D5).  Make sure you make an annotated and not a lightweight tag.  Also be sure you push the tag up to GitHub specifically!  Pushing up the branch to origin will NOT automatically push up the tag as well, you must do so separately.  If you want to tag the current commit, you may do so with the following commands:

```
git tag -a D4 -m "D4"
git push origin D4
```

Converting the above commands to tag for D5 is left as an exercise for the reader.

Further details on tagging are here: https://git-scm.com/book/en/v2/Git-Basics-Tagging

The needs of the customer will be determined in class by interviewing the product owner (i.e., Bill Laboon).


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
