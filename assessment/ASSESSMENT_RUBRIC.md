# Claude Code CLI Workshop - Assessment Rubric

## Overview

This rubric helps facilitators and participants assess workshop completion and learning outcomes.

## Assessment Types

### 1. Self-Assessment (Participant)
Use during and after workshop to track your own progress.

### 2. Facilitator Assessment (Instructor)
Use to evaluate participant understanding and workshop effectiveness.

### 3. Completion Assessment (Both)
Objective criteria for challenge completion.

---

## Challenge Completion Rubric

### Challenge 1: Fix Calculator (20 points)

| Criteria | Points | Description |
|----------|--------|-------------|
| **Bug Fixed** | 5 | percentage() method fixed (multiplies before dividing by 100.0) |
| **Tests Pass** | 5 | All 8 tests pass (`mvn test`) |
| **Logging Added** | 5 | All 5 CalculatorService methods have logging |
| **Proper Logger** | 3 | Uses java.util.logging.Logger (not System.out) |
| **PROGRESS.md** | 2 | Challenge marked complete with notes |

**Total: 20 points**

**Minimum for completion:** 15/20 points

---

### Challenge 2: Add Project Rules (15 points)

| Criteria | Points | Description |
|----------|--------|-------------|
| **Rules File Exists** | 3 | .claude/rules.md created |
| **Rules Complete** | 4 | Includes: method length, Javadoc, naming, logging |
| **Calculator Refactored** | 4 | All public methods have Javadoc |
| **Code Compiles** | 2 | `mvn compile` succeeds |
| **PROGRESS.md** | 2 | Challenge marked complete |

**Total: 15 points**

**Minimum for completion:** 11/15 points

---

### Challenge 3: Generate UserService (15 points)

| Criteria | Points | Description |
|----------|--------|-------------|
| **Skill Created** | 5 | skill.md exists in ~/.claude/skills/java-service-generator/ |
| **Skill Works** | 5 | Successfully generates service files |
| **Files Generated** | 3 | UserService, UserServiceImpl, UserServiceTest created |
| **Follows Rules** | 2 | Generated code follows project rules |

**Total: 15 points**

**Minimum for completion:** 10/15 points

---

### Challenge 4: Security Audit (15 points)

| Criteria | Points | Description |
|----------|--------|-------------|
| **Sub-agent Used** | 5 | Successfully used Explore sub-agent |
| **Vulnerabilities Found** | 5 | Identified at least 4 security issues |
| **Documentation** | 3 | Created SECURITY_AUDIT.md or similar |
| **Understanding** | 2 | Can explain findings |

**Total: 15 points**

**Minimum for completion:** 10/15 points

---

### Challenge 5: Refactor OrderService (20 points)

| Criteria | Points | Description |
|----------|--------|-------------|
| **Methods Extracted** | 5 | Long methods broken into smaller ones (<20 lines) |
| **Methods Renamed** | 3 | calc → calculateCustomerTotal, etc. |
| **Javadoc Added** | 4 | All public methods have Javadoc |
| **/remember Used** | 3 | Used at least 2 times |
| **Session Resumed** | 3 | Closed and resumed Claude Code |
| **PROGRESS.md** | 2 | Documented progress and completion |

**Total: 20 points**

**Minimum for completion:** 14/20 points

---

### Challenge 6: Build BookService (Capstone) (30 points)

| Criteria | Points | Description |
|----------|--------|-------------|
| **Entity Created** | 4 | Book.java with all properties |
| **Repository** | 4 | BookRepository interface with all methods |
| **Service Interface** | 3 | BookService interface defined |
| **Service Implementation** | 6 | BookServiceImpl with validation & logging |
| **Business Rules** | 5 | Stock >= 0, price > 0, valid year, etc. |
| **Tests Created** | 6 | Comprehensive tests with mocks |
| **All Tests Pass** | 6 | `mvn test` shows all passing |
| **Code Quality** | 4 | Follows rules, clean code |
| **Methods <20 lines** | 3 | All methods follow rule |
| **Javadoc Complete** | 2 | All public methods documented |

**Total: 30 points**

**Minimum for completion:** 21/30 points

---

## Overall Workshop Completion

### Total Points: 115

**Completion Levels:**

| Level | Points | Description |
|-------|--------|-------------|
| **Mastery** | 100-115 | Excellent understanding, all challenges complete |
| **Proficient** | 85-99 | Strong understanding, most challenges complete |
| **Competent** | 70-84 | Good understanding, core challenges complete |
| **Developing** | 50-69 | Basic understanding, some challenges complete |
| **Incomplete** | <50 | Needs more practice |

**Minimum to pass workshop:** 70/115 points (Competent level)

---

## Skills Assessment

### Basic Skills (Must achieve for workshop completion)

| Skill | Evidence |
|-------|----------|
| **Read files** | Can use Claude to read and understand code |
| **Edit files** | Can use Claude to modify existing code |
| **Run commands** | Can use Claude to execute Bash commands |
| **Understand workflow** | Knows Read → Edit → Test cycle |

**All 4 required for completion**

---

### Intermediate Skills (Should achieve)

| Skill | Evidence | Weight |
|-------|----------|--------|
| **Create project rules** | .claude/rules.md exists and is used | Important |
| **Create custom skills** | Has working java-service-generator | Important |
| **Use sub-agents** | Successfully used Explore agent | Important |
| **Context management** | Used /remember, resumed sessions | Moderate |

**At least 3 of 4 for proficiency**

---

### Advanced Skills (Nice to have)

| Skill | Evidence |
|-------|----------|
| **Integration** | Combined multiple concepts (Challenge 6) |
| **Problem solving** | Fixed issues independently |
| **Best practices** | Followed coding standards consistently |
| **Testing** | Created comprehensive test coverage |

**2+ for mastery level**

---

## Learning Objectives Assessment

### Knowledge (Can explain)

- [ ] When to use Claude Code vs traditional tools
- [ ] How project rules work and why they're useful
- [ ] What skills are and how to create them
- [ ] When to delegate to sub-agents
- [ ] How to manage context across sessions

**Score: ___/5**

### Skills (Can demonstrate)

- [ ] Read files with Claude Code
- [ ] Edit code using Claude Code
- [ ] Run tests and verify changes
- [ ] Create and apply project rules
- [ ] Create custom skills
- [ ] Use sub-agents for complex tasks
- [ ] Manage context with /remember

**Score: ___/7**

### Application (Can apply to real work)

- [ ] Identify appropriate use cases for Claude Code
- [ ] Set up project rules for team consistency
- [ ] Create skills for repetitive workflows
- [ ] Use for code review and refactoring
- [ ] Apply best practices (verify AI suggestions)

**Score: ___/5**

---

## Participant Self-Assessment

### At End of Workshop

**Rate your confidence (1-5 scale):**

| Area | Rating | Notes |
|------|--------|-------|
| Using Claude Code CLI | __/5 | |
| Creating project rules | __/5 | |
| Creating custom skills | __/5 | |
| Using sub-agents | __/5 | |
| Managing context | __/5 | |
| Applying to real work | __/5 | |

**Total Confidence Score: __/30**

**Reflection Questions:**

1. What was most valuable? ____________________
2. What was most challenging? _________________
3. What will you use at work? _________________
4. What would improve the workshop? ___________

---

## Facilitator Assessment

### Individual Participant

**Name:** _______________ **Date:** ___________

**Challenge Completion:**
- Challenge 1: ___/20
- Challenge 2: ___/15
- Challenge 3: ___/15
- Challenge 4: ___/15
- Challenge 5: ___/20
- Challenge 6: ___/30
**Total: ___/115**

**Engagement:**
- [ ] Actively participated
- [ ] Asked questions
- [ ] Helped others
- [ ] Completed on time

**Understanding:**
- [ ] Grasped basic concepts
- [ ] Applied concepts correctly
- [ ] Could troubleshoot issues
- [ ] Ready for independent use

**Overall Assessment:**
- [ ] Mastery (100-115)
- [ ] Proficient (85-99)
- [ ] Competent (70-84)
- [ ] Developing (50-69)
- [ ] Incomplete (<50)

**Notes:** _________________________________

---

## Workshop Effectiveness Assessment

### For Facilitator (After Workshop)

**Timing:**
- Challenge 1: On time / Over / Under (by ___ min)
- Challenge 2: On time / Over / Under (by ___ min)
- Challenge 3: On time / Over / Under (by ___ min)
- Challenge 4: On time / Over / Under (by ___ min)
- Challenge 5: On time / Over / Under (by ___ min)
- Challenge 6: On time / Over / Under (by ___ min)

**Completion Rates:**
- Challenge 1: ___% completed
- Challenge 2: ___% completed
- Challenge 3: ___% completed
- Challenge 4: ___% completed
- Challenge 5: ___% completed
- Challenge 6: ___% completed

**Common Issues:**
1. ______________________________
2. ______________________________
3. ______________________________

**What Worked Well:**
1. ______________________________
2. ______________________________
3. ______________________________

**Improvements for Next Time:**
1. ______________________________
2. ______________________________
3. ______________________________

**Overall Workshop Success Rate:** ___%

---

## Quick Pass/Fail Criteria

### Minimum Requirements for Workshop Completion

**Must Complete:**
- [ ] Challenge 1 (Fix Calculator) - 15/20 minimum
- [ ] Challenge 2 (Project Rules) - 11/15 minimum
- [ ] At least 2 of Challenges 3-5
- [ ] Challenge 6 (Capstone) - 21/30 minimum OR demonstrated understanding

**Must Demonstrate:**
- [ ] Can read files with Claude Code
- [ ] Can edit code with Claude Code
- [ ] Can run tests
- [ ] Understands project rules concept
- [ ] Knows when to use Claude Code

**If all boxes checked:** ✅ **PASS**

**Overall Score Required:** 70/115 minimum

---

## Certificate of Completion Template

```
┌─────────────────────────────────────────────────┐
│                                                 │
│        CLAUDE CODE CLI WORKSHOP                 │
│         Certificate of Completion               │
│                                                 │
│              [Participant Name]                 │
│                                                 │
│    Has successfully completed the Claude Code   │
│    CLI Challenge-Based Workshop and demonstrated│
│    proficiency in:                             │
│                                                 │
│    • Claude Code CLI fundamentals              │
│    • Project rules configuration               │
│    • Custom skills creation                    │
│    • Sub-agent delegation                      │
│    • Context management                        │
│    • Building production-quality code          │
│                                                 │
│    Score: [___/115]  Level: [_________]       │
│                                                 │
│    [Date]              [Facilitator Signature] │
│                                                 │
└─────────────────────────────────────────────────┘
```

---

## Usage Guidelines

### For Participants:
1. Track your progress through challenges
2. Self-assess at end of each challenge
3. Complete reflection questions
4. Identify areas for further learning

### For Facilitators:
1. Use during workshop to gauge progress
2. Identify participants needing help
3. Assess overall workshop effectiveness
4. Adjust future workshops based on data

### For Organizations:
1. Verify employee training completion
2. Identify skill gaps
3. Measure training ROI
4. Plan follow-up training

---

## Success Stories

**Competent Level (70-84 points):**
"Ready to use Claude Code for daily tasks with supervision"

**Proficient Level (85-99 points):**
"Confident using Claude Code independently for most tasks"

**Mastery Level (100-115 points):**
"Can teach others and handle complex scenarios with Claude Code"

---

## Additional Resources for Improvement

**If scored < 70:**
- Review workshop materials
- Practice challenges again
- Schedule 1-on-1 with facilitator
- Try Quick Start Guide exercises

**If scored 70-84:**
- Practice advanced challenges
- Create more custom skills
- Apply to real projects
- Join community for tips

**If scored 85+:**
- Help train others
- Contribute to community
- Create advanced skills
- Share best practices

---

This rubric ensures consistent, fair assessment while providing clear goals for participants and facilitators.
