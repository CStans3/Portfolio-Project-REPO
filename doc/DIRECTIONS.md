# Portfolio Project Directions

Welcome to the portfolio project directions. Historically, this assignment
was completed in parts. But due to the excessive grading load that the
assignment created, the portfolio project was converted to a single submission.
The individual steps were maintained in this repo for your reference, but the
assignment must be completed as outlined in this document. In other words,
**ignore** any submission instructions you see in the individual docs.

## Assignment Description

In this assignment, you are tasked with creating a software component from
scratch using OSU's discipline as follows:

- Create the kernel and enhanced interfaces as described in the
   [component interfaces docs](03-component-interfaces\03-component-interfaces.md)
- Create the secondary abstract class as described in the
   [component abstract class docs](04-component-abstract-class\04-component-abstract-class.md)
- Create one kernel implementation as described in the
   [component kernel implementation docs](05-component-kernel-implementation\05-component-kernel-implementation.md)

In addition, you must complete the following tasks:

- Write a systematic test suite for all methods in each interface as well as the
  common methods as described in the
  [finishing touches doc](06-component-finishing-touches\06-component-finishing-touches.md)
- Write two qualitatively different use cases for your component as described in the
  [finishing touches doc](06-component-finishing-touches\06-component-finishing-touches.md)

Finally, you may take your component above and beyond expectations by
completing the following tasks:

- Create a CI pipeline that automates your testing on GitHub
- Generate documentation for you component using JavaDoc
- Version your component using your preferred versioning style

## Assignment Rubric

The assignment is graded broadly on the following categories. See Carmen for
the official rubric:

- **Discipline** (30%): how well does the component follow the discipline?
- **Testing** (25%): how systematic are the test cases?
- **Best Practices** (20%): how well-written is the code?
- **Use Cases** (15%): how well do the use cases show off the component?
- **Reflection** (10%): how thoughtful is the writing?

## Assignment Instructions

To complete the assignment, you must do the following **in order**:

1. Review this entire document from top-to-bottom
   - Make sure you have read the rubric and know how you're being assessed
2. Use this repo as a template, as described in the main [README](../README.md)
3. Clone this repo to your machine
4. Create a new branch from `main` and complete all of your work on it
   - `main` must only contain the template files at the time of submission
   - The new branch may be called whatever you like, but `portfolio-project` is
     fine
5. Create your component on your new branch
   - Commit early and often
   - Use descriptive commit messages (e.g., "Add enhanced interfaces")
6. Test your component and include two use cases showing it off
7. Complete the reflection in the next section
8. Create a pull request from your branch to `main`
9. Submit a link of the pull request to Carmen

## Assignment Reflection

Following the completion of the portfolio project, please take some time to
fill out the following reflection prompts. There is no word count, but at least
a few sentences per question would be ideal.

> A common gripe that students express is how much they feel the work they do
> in class fails to map to the real world. Now that you've had a chance to
> complete the portfolio project, how much better (or worse) do you think you
> understand software development and why?

I'm not entirely sure whether I understand software development better or not. I feel like having the resources and time available to me made a big difference in my ability to create something that actually worked. Unlike in an exam environment, where I tend to p anic and feel like countless hours of preparation go down the drain, working on this project at home made me feel more in my element. I was able to take my time, reference previous labs and project, and apply things that I've learned throughout the semester. I think this project helped me realize that I'm more capable of aplying what I've learned when I'm not under the pressure of an exam.

> Also, did the portfolio project surface any gaps in your own knowledge of
> software development. If so, what are those gaps and how did you address them?

One of the biggest gaps in my knowledge was understanding how the JUnit testing interface worked in VS Code. Throughout the semester, I had been mostly hoping my test cases were working correctly without fully understanding how to run or interpret them. I was more familiar with Eclipse's JUnit testing environment from last semester so adjusting to VS Code was frustrating.

When I initially tried organizing my tests into two separate files, like the example directory structure showed, I ran into several issues where the tests wouldn't run at all. After struggling with that setup, I decided to simplify evereything into a single test file, which finally allowed my tests to run properly. I also learend how to interpret the test results, including that the message `The test run did not record any output` simply means the tests didn't produce console output. Instead I needed to look at the JUnit test results to confirm whether each test passed or failed. Although this was one of the more stressful parts of the project, I feel like I have a much better understanding of how to use JUnit in VS Code now.

> Finally, as a part of completing the portfolio project, to what extent has
> your perspective of software development changed, if at all? In other words,
> is software development something you still enjoy? If not, why not?

I Still enjoy software development. I just don't enjoy exams. I understand that exams come with taking classes, but I've always struggled with test-taking, and this semester has been no different. After seeing how poorly I was doing on my exams, I knew I needed to complete this project regardless of how little time I had left, to try to salvage my grade.

I think this project would have been more enjoyable if I hadn't procrastinated as much as I did. The JUnit testing issues especially stressed me out because I was already running short on time. Had I started earlier, I think this could have been a much more relaxing and interesting way to reinforce the fundamanetals I've learned throughout the semester. Despite the frustration, I still enjoyed being able to work on something I chose myself and seeing it come together.

> One of the challenges of completing the portfolio project is picking up a lot
> of skills on your own. Some of these skills are, of course, software skills.
> However, there are plenty of other skills you may have picked up through
> this process. Therefore, the first question is what skills did you pick up
> through this process?

One surprisingly useful skill I picked up was learning how to work more efficiently by reusing similar code. A lot of the methods in my component had nearly identical structures, with the main difference being their names and the statistics they worked with. For example my `health()` and `attack()` getter methods followed the same basic pattern, so I could copy one method and then carefuylly update the names, comments, and implementation to match the other. Small things like this helped speed up development and made it easier to stay on schedule.

I also reinforced my understanding of how to organize a component into separate interfaces, abstract classes, and concrete implementations. My orginal proof-of-concept stored the character's stats directly as individual field, but I later changed the implementation to use a `Sequence<Integer>`. Making that change helped me better understand the difference between a component's mathematical model and how its data is actaully stored. I also gained more experience with JUnit testing, troubleshooting errors in VS Code, and managing a project through GitHub.

> The follow-up question is: could you rephrase these skills you picked up
> as bullet points that you could put on a resume? Try it below.

- Designed and implemented a reusable Java component using interfaces, abstract classes, and object-oriented programming principles.
- Used Java data structures to manage and update character statistics while maintaining representation invariants.
- Developed JUnit 4 tests to verify component functionality and boundary conditions.
- Used Git and GitHub for version control and organizing project development.
- Troubleshot Java compilation, dependency, and testing configuration issues in Visual Studio Code.
- Created technical documentation describing component design, implementation, and practical use cases.

> Next, how has working on this project affected your career trajectory?
> In other words, do you now hate the topic you picked? Or, are you even more
> interested in it? Both outcomes are valuable to your personal development.

This project hasn't really shifted my career goals, but it has helped me better understand which parts of programming interest me the most. I still like the idea of working in software development, particularly on projects involving applications that people can interact with. At the same time, I've realized that I need a lot more practice with the fundamentals before I feel confident pursuing software development professionally.

I think I would enjoy working on projects where I can actually see and interact with what I'm creating, rather than focusing entirely on the underlying code. This project reinforced that interest, even though I spent most of my time working on the component's internal implementation. I still want to explore different areas of software development before deciding exactly what direction I want to take.

> Finally, consider the skills you've picked up and your current career
> trajectory. What are some things you could do to continue on your
> career trajectory? Also, who are some mentors you could contact to help
> you stay on your path?

To continue improving, I want to work on more small personal proejcts, especially ones involving games or front-end development. I also want to become more comfortable with Java, learn more about web development, and practice using GitHub so I can start building a portfolio for future internships. I think working on projects outside of class would help me build confidence without the pressure of exams or strict deadlines.

Some people I could reach out to for guidance would include Professor Griski and other students who have already landed internships. I should also attend more career events on campus to learn about different career paths and opportunities. I've also received emails about the Software Enginerring club and their hackathons, and I've considered reaching out to see how I could get involved, even with my limited experience. I think participating in something like that could be a good opportunity to learn from other students and gain more practical experience.

## Assignment Advice

Broadly, this assignment may take anywhere from a few hours to over a full work
week (i.e., 40 hours) to complete depending on the complexity of your design.
Historically, the first part of this assignment was meant to help you scope down
your design, so it is still recommended to complete it even though it is not
graded. You may want to share your ideas with your instructor before you start
coding. In any case, it is your job to budget your time effectively.

With that said, it may not be a good idea to start early. Much of the
discipline will not be exposed to you until the end of week 3. Perhaps a good
starting time would be after your first midterm when you'll know if you need
an exam replacement.

In addition, you will have to learn some of the concepts (e.g., the common
methods) on your own, even though the course will cover them near the end of
the course. So, once you understand how to layer a component (i.e., after week
3), you can begin your work. Do not wait until the end of the course to start.

Also, you may submit the entire component **early** for a chance to get
feedback. There will be an early submission window, about a week before the
second midterm, where you can submit your completed component for an initial
grade. Any submissions after this point will not have a chance to resubmit.

Finally, if you have no idea where to start, consider checking out the
[part 1 docs](01-component-brainstorming\01-component-brainstorming.md).
There, you'll find a link to an article that includes project ideas. It is
recommended to follow the instructions in parts 1 through 6 anyway (even the
proof of concept for your own sanity), but you can continue to ignore the
individual submission instructions since you'll just be submitting everything at
once.

## Artificial Intelligence (AI) Policy

The purpose of this assignment is to help you develop your own skill and style
as a future software developer. You cannot do that if you shortcut your growth
by leveraging the available generative AI tools that exist today (e.g., ChatGPT,
Claude, Gemini, Codex, Copilot, etc.). In fact, even if you plan to entirely
write code in the future by burning tokens, you still need to fundamentally
understand software to step in when things go wrong. Therefore, use of these
tools on this assignment are strictly prohibited.

With that said, it is impossible to prevent you from using "AI" to develop
your component. Copilot is currently embedded in VS Code, and even disabling AI
integration in VS Code using the `chat.disableAIFeatures` is not enough. First,
it's very easy for you to flip the boolean to false or to delete the line
altogether, despite this being an obvious sign of ignoring this disclaimer in
your pull request. Second, there are probably hundreds of chat bot extensions
that bypass this setting. Third, there is really nothing stopping you from
using a third-party tool and dumping the resulting code here. Ultimately,
there is just no way to prove that you used AI.

However, in the same way that educators have no control over the usage of AI,
beyond coding with pen and paper, you have no control over the assessment
process. Therefore, it is in your best interest to do your own work because
only you can trust the work that you produce. If you do not develop the
expertise to do good work, you won't be able to evaluate the output of a chat
bot or agent. You will be putting your grade in the hands of an LLM. Use it at
your own risk.

With that said, since the type of student who will use "AI" on their component
is unlikely to even read this section, a series of prompts are provided in the
AGENTS.md file at the root of the repo. While the most desperate will
certainly find workarounds, hopefully it gives everyone else a good laugh.
