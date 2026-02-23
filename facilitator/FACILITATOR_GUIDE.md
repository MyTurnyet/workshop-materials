# Facilitator Guide - Claude Code CLI Workshop

**Workshop Duration:** 2 hours
**Target Audience:** Intermediate Java developers
**Max Participants:** 20-25 (for interactive workshop)

## Overview

This guide helps you successfully facilitate the Claude Code CLI workshop. The workshop uses a challenge-based approach with a single progressive project that participants build throughout.

## Pre-Workshop Preparation (1 Week Before)

### 1. Send Setup Instructions
- Email participants the `PRE_WORKSHOP_SETUP.md` guide
- Request confirmation that setup is complete
- Offer office hours for setup help (optional)

### 2. Prepare Your Environment
- Complete all 6 challenges yourself to understand timing
- Test the workshop flow
- Identify potential stumbling blocks
- Prepare backup solutions for common issues

### 3. Prepare Materials
- Print strategy cards (or prepare digital versions)
- Have solution guides ready
- Load hint files for quick reference
- Prepare presentation slides (introduction section)

### 4. Technical Prep
- Test screen sharing setup
- Ensure projector/display works
- Test audio if presenting remotely
- Have backup laptop ready

### 5. Logistics
- Room setup (tables for pair programming if needed)
- Power outlets for all participants
- WiFi credentials ready
- Name tags/seating (optional)

## Workshop Day Setup (30 minutes before)

### Room Setup
- Arrange seating to see all participants
- Test projector and screen sharing
- Write WiFi credentials on board
- Display "Setup Verification" checklist

### Materials Distribution
- Strategy cards (printed or digital links)
- Challenge guides (digital or printed)
- Emergency contact info on board

### Pre-Workshop Check (As participants arrive)
Quick verification for each participant:
```bash
cd claude-code-workshop
mvn compile    # Should succeed
mvn test       # Should have 2 failures
claude code    # Should start
```

## Workshop Timeline (2 Hours)

### 0:00-0:10 | Introduction (10 min)

**Welcome & Overview (3 min)**
- Welcome participants
- Introduce yourself
- Workshop objectives
- Schedule overview

**Claude Code Introduction (5 min)**
- What is Claude Code CLI?
- When to use it (and when not to)
- Basic workflow: Read → Think → Edit → Verify
- Key features: Rules, Skills, Sub-agents

**Logistics (2 min)**
- Bathroom location
- Break schedule (none in 2hr, but mention)
- Questions: raise hand or ask anytime
- Pairs vs solo (participant choice)

**Setup Verification**
Quick show of hands:
- "Who has the project compiled?" (should be everyone)
- "Who has Claude Code working?" (should be everyone)
- Help stragglers quickly or pair them

---

### 0:10-0:30 | Challenge 1: Fix Calculator (20 min)

**Introduction (2 min)**
- Explain Challenge 1 objectives
- Show them CHALLENGE-01-Fix-Calculator.md
- Emphasize: everyone stays in same directory
- Update PROGRESS.md as you go

**Working Time (15 min)**
- Participants work independently or in pairs
- Circulate and observe
- Provide hints as needed (3-level system)
- Note common issues

**Hints to Provide:**
- **Early on (5 min in):** "Read the test file first to understand what's expected"
- **Mid-way (10 min in):** "The bug is in the percentage method - integer division issue"
- **Late (15 min in):** Provide Level 2 or 3 hints from hints file

**Common Issues:**
- Forgetting to multiply before dividing
- Using 100 instead of 100.0
- Edit tool string matching issues

**Wrap-up (3 min)**
- Quick show of hands: "Who got all tests passing?"
- Briefly show the solution
- Key takeaway: Read, Edit, Bash workflow
- "Mark Challenge 1 complete in PROGRESS.md"

---

### 0:30-0:45 | Discussion: Claude Code Philosophy (15 min)

**Group Discussion Format**

**When to Use Claude Code (5 min)**
Facilitate discussion:
- "When have you struggled with coding tasks?"
- Examples: refactoring, boilerplate, understanding unfamiliar code
- Claude Code excels at: repetitive tasks, code exploration, pattern application

**When NOT to Use Claude Code (3 min)**
Be honest about limitations:
- Not for learning fundamentals (use to accelerate, not replace learning)
- Not for critical security decisions (AI can make mistakes)
- Not when you need to deeply understand every line
- Not as a crutch - understand what it generates

**Best Practices (5 min)**
- Start with clear intent: "I want to..."
- Verify AI suggestions before applying
- Use project rules for consistency
- Combine with traditional tools (debuggers, profilers)
- Human is always in control

**Q&A (2 min)**
Open floor for questions

---

### 0:45-0:55 | Challenge 2: Add Project Rules (10 min)

**Introduction (1 min)**
- Explain .claude/rules.md concept
- Show example rules file
- "These rules will apply to ALL future work"

**Working Time (7 min)**
- Participants create rules and refactor Calculator
- Circulate and help
- Check rules.md files for completeness

**Common Issues:**
- Forgetting to create .claude directory first
- Rules too vague ("keep methods small" vs "methods under 20 lines")
- Not testing that rules work

**Wrap-up (2 min)**
- "Who has .claude/rules.md created?"
- Show example rules file
- Key takeaway: Rules ensure consistency
- Impact: All future challenges benefit from these rules

---

### 0:55-1:05 | Challenge 3: Generate UserService (10 min)

**Introduction (1 min)**
- Explain skills concept
- Show skill location: ~/.claude/skills/
- "Create reusable automation"

**Working Time (7 min)**
- Participants create java-service-generator skill
- Test it by generating UserService
- Check that files are created in correct location

**Common Issues:**
- Skill file in wrong location
- YAML front matter syntax errors
- Parameter syntax (${serviceName} vs $serviceName)
- Files generated in wrong package

**Wrap-up (2 min)**
- "Who successfully generated UserService?"
- Demonstrate skill invocation: `/java-service-generator Product`
- Key takeaway: Skills automate repetitive workflows
- Bonus: "This skill now works in ANY project!"

---

### 1:05-1:15 | Challenge 4: Security Audit (10 min)

**Introduction (1 min)**
- Explain sub-agents concept
- When to delegate: large searches, complex analysis
- Types: Explore, Plan, Bash

**Working Time (7 min)**
- Participants use Explore sub-agent
- Find security vulnerabilities in auth code
- Document findings

**Common Issues:**
- Not giving sub-agent clear enough instructions
- Waiting for sub-agent (explain it takes time - thorough search)
- Not understanding how to use findings

**Wrap-up (2 min)**
- "How many security issues did you find?" (should be 5-6)
- Briefly list main issues: hardcoded credentials, MD5, etc.
- Key takeaway: Sub-agents for complex analysis
- Real-world: security audits, finding deprecated APIs

---

### 1:15-1:30 | Challenge 5: Refactor OrderService (15 min)

**Introduction (2 min)**
- Explain context management importance
- Introduce /remember command
- "This simulates multi-day refactoring"

**Working Time (11 min)**
- Phase 1: Analysis (3 min)
- Phase 2: Refactor (5 min)
- Phase 3: Close/Resume session (1 min)
- Phase 4: Verify (2 min)

**Facilitation Notes:**
- At 5 min mark: "Have you used /remember at least once?"
- At 8 min mark: "Time to close and resume Claude Code"
- Help participants with context when resuming

**Common Issues:**
- Not using /remember (remind them)
- Forgetting to close/resume (enforce this step)
- Not providing context when resuming
- Refactoring too aggressive or not enough

**Wrap-up (2 min)**
- "How many lines did you reduce OrderService by?"
- Key takeaway: Context management for long tasks
- Real-world: features spanning multiple days

---

### 1:30-1:50 | Challenge 6: Build BookService (Capstone) (20 min)

**Introduction (2 min)**
- "This is your capstone - integrate everything"
- Requirements review
- "Use ALL skills learned: rules, skills, sub-agents"
- Emphasize quality over speed

**Working Time (16 min)**
- Participants build complete BookService
- Entity, repository, service, tests
- Full CRUD + validation + tests

**Facilitation:**
- Circulate actively
- Check progress at 8-min mark
- Provide hints for those stuck
- Encourage using their custom skill
- Remind about project rules

**Common Issues:**
- Trying to do too much (bonus features)
- Skipping tests
- Not following project rules
- Forgetting validation

**Wrap-up (2 min)**
- "Who got BookService working with tests?"
- "Run `mvn test` to verify"
- Key takeaway: Integration of all concepts
- Congratulate completion!

---

### 1:50-2:00 | Wrap-up & Reflection (10 min)

**Group Reflection (5 min)**
Discussion questions:
- "What was most surprising about Claude Code?"
- "What feature will you use most at work?"
- "What was most challenging?"
- "How does this change your development workflow?"

**Resources & Next Steps (3 min)**
- Workshop materials available: [location/URL]
- Keep claude-code-workshop as reference
- Claude Code documentation: [link]
- Community: [Discord/Slack if applicable]
- Office hours for questions: [if offered]

**Feedback (2 min)**
- Distribute feedback form (or send email link)
- "Your feedback helps us improve"
- Thank participants for their time and engagement

---

## Facilitation Tips

### General

**Pacing**
- Watch the clock - challenges can overrun
- Have "minimum viable completion" for each challenge
- Skip bonus content if running behind
- Can compress discussion sections if needed

**Engagement**
- Circulate constantly during challenges
- Make eye contact, encourage questions
- Call on quiet participants occasionally
- Celebrate successes ("Great job finding that bug!")

**Troubleshooting**
- Fix issues quickly - don't let anyone fall too far behind
- Have solution code ready to copy/paste if needed
- Pair struggling participants with those ahead
- Know when to move on (don't wait for 100% completion)

### Hint System

**3 Levels:**
1. **Gentle Nudge** (5 min into challenge) - Direction without answer
2. **Stronger Hint** (10 min in) - More specific guidance
3. **Near-Solution** (15 min in) - Almost the exact answer

**When to Provide:**
- Participant asks for help
- Clearly stuck (staring at screen, frustrated)
- Falling significantly behind others
- Misunderstanding core concept

**How to Provide:**
- Ask "Where are you stuck?" first
- Start with Level 1, escalate if needed
- Use Socratic method when possible
- Show don't tell (demonstrate in their environment)

### Managing Different Skill Levels

**Fast Finishers:**
- Encourage helping others (peer teaching)
- Suggest bonus challenges
- Ask them to explore advanced features
- Move to next challenge (but stay available)

**Slow Starters:**
- Extra attention early
- Pair with faster participant
- Provide hints proactively
- Focus on completing 4/6 challenges minimum

**Mixed Pairs:**
- Encourage pair programming
- Rotate pairs between challenges
- Use fast finishers as "consultants"

### Common Questions & Answers

**Q: "Can I use my own project instead of claude-code-workshop?"**
A: For the workshop, please stick with the provided project - it's designed for learning. After the workshop, absolutely use it on your projects!

**Q: "Will this work with Python/JavaScript/etc?"**
A: Yes! Claude Code works with any programming language. This workshop uses Java, but the concepts apply universally.

**Q: "How much does the API cost?"**
A: This workshop typically uses $2-5 of API credits per participant. Claude Code pricing: [link to current pricing]

**Q: "Is my code sent to Anthropic?"**
A: Yes, when you use Claude Code, your prompts and code are sent to Anthropic's API. See privacy policy: [link]. Don't use with proprietary/sensitive code without approval.

**Q: "Can Claude Code write code without me reviewing it?"**
A: Claude Code always shows you what it will do before making changes. You're always in control and should review all changes.

**Q: "What if Claude makes a mistake?"**
A: AI can make mistakes! Always test generated code, verify logic, and use version control. You're the developer - Claude is a tool.

## Emergency Protocols

### Technical Failure

**Projector fails:**
- Have printed handouts ready
- Share challenge links digitally
- Participants can work independently

**WiFi fails:**
- Claude Code needs internet for API calls
- Can work offline on analysis/planning
- Reschedule if prolonged outage

**Mass setup failures:**
- Have solution branches ready in git
- Participants can pull working code
- Pivot to demonstration format

### Time Overruns

**Running 15+ minutes behind:**
- Skip or shorten discussion sections
- Provide solutions instead of waiting
- Combine challenges 2&3 or 4&5
- Focus on completing challenges 1,2,6

**One challenge taking too long:**
- Call time at 80% completion rate
- Show solution quickly
- Move on to keep pace

### Low Engagement

**Participants disengaged:**
- More active demonstrations
- Switch to pair programming
- Take a 5-minute break
- Ask for feedback midway

## Post-Workshop

### Immediately After

- Collect feedback forms
- Note what worked/didn't
- Update timing notes
- Save chat logs (if virtual)

### Follow-up (Within 1 week)

- Email thank you with resources
- Share solution code repository
- Provide additional learning resources
- Office hours for questions (optional)

### Improvement

- Review feedback
- Update materials based on issues
- Adjust timing for next session
- Document lessons learned

## Success Metrics

Workshop is successful if:
- ✅ 80%+ complete at least 4/6 challenges
- ✅ 90%+ understand basic workflow (Read, Edit, Bash)
- ✅ 60%+ complete capstone challenge
- ✅ Positive feedback on usefulness
- ✅ Participants leave confident to use Claude Code

## Resources for Facilitators

### Before Workshop
- [ ] Complete all challenges yourself
- [ ] Test timing
- [ ] Prepare environment
- [ ] Print/distribute materials
- [ ] Send pre-workshop setup email

### During Workshop
- [ ] Strategy cards accessible
- [ ] Hints files ready
- [ ] Solution code ready
- [ ] Troubleshooting guide handy
- [ ] Feedback forms prepared

### After Workshop
- [ ] Collect feedback
- [ ] Send follow-up email
- [ ] Update materials
- [ ] Schedule retrospective

## Contact & Support

For questions about facilitating this workshop:
- [Contact information]
- [Slack/Discord community]
- [Email support]

Good luck, and enjoy facilitating this workshop!
