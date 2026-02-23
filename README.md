# Claude Code CLI Workshop - Challenge-Based with Progressive Difficulty

**Duration:** 2 hours (Mastery version)
**Target Audience:** Intermediate Java developers
**Format:** Challenge-based learning with one progressive project

## Overview

This workshop teaches Claude Code CLI through 6 progressive challenges that build on a single `claude-code-workshop` codebase. Participants start with a project that has bugs and messy code, then progressively fix, enhance, and expand it using Claude Code.

### Why Single Project Approach?

- ✅ **Set up once**, use throughout
- ✅ **See realistic project evolution** - how code grows over time
- ✅ **Build on own work** - each challenge uses previous results
- ✅ **No context switching** - stay in same directory
- ✅ **Clear progress** - watch the platform improve
- ✅ **Complete working system at end** - take home reference project

## Workshop Structure

### Time Allocation (2 hours total)

| Time | Duration | Activity |
|------|----------|----------|
| 0:00-0:10 | 10 min | Introduction + Setup Verification |
| 0:10-0:30 | 20 min | Challenge 1: Fix Calculator |
| 0:30-0:45 | 15 min | Discussion: Claude Code Philosophy |
| 0:45-0:55 | 10 min | Challenge 2: Add Project Rules |
| 0:55-1:05 | 10 min | Challenge 3: Generate UserService |
| 1:05-1:15 | 10 min | Challenge 4: Security Audit |
| 1:15-1:30 | 15 min | Challenge 5: Refactor OrderService |
| 1:30-1:50 | 20 min | Challenge 6: Build BookService (Capstone) |
| 1:50-2:00 | 10 min | Wrap-up + Reflection |

## The Project: claude-code-workshop

A Java microservices platform that grows from simple calculator to full API system.

### Starting State
```
claude-code-workshop/
├── calculator/          # Has bugs → Challenge 1
├── order/               # Messy code → Challenge 5
├── auth/                # Security issues → Challenge 4
├── user/                # Empty → Challenge 3
├── book/                # Empty → Challenge 6
└── .claude/             # Doesn't exist → Challenge 2
```

### Final State (After All Challenges)
```
claude-code-workshop/
├── calculator/          # ✅ Fixed, logged, documented
├── order/               # ✅ Refactored, clean code
├── auth/                # ✅ Issues documented
├── user/                # ✅ UserService generated
├── book/                # ✅ Complete REST API
├── .claude/rules.md     # ✅ Team standards
└── Custom skill created # ✅ ~/.claude/skills/java-service-generator/
```

## Challenge Progression

### Challenge 1: Fix Calculator (20 min) - BEGINNER
**Focus:** Basic commands - Read, Edit, Bash
**What they do:** Fix percentage bug, add logging
**Outcome:** Working calculator, understand basic workflow

### Challenge 2: Add Project Rules (10 min) - INTERMEDIATE
**Focus:** Project configuration
**What they do:** Create .claude/rules.md, refactor Calculator
**Outcome:** Standards established for entire project

### Challenge 3: Generate UserService (10 min) - INTERMEDIATE
**Focus:** Skills and automation
**What they do:** Create custom skill, generate UserService
**Outcome:** Reusable skill + new service in platform

### Challenge 4: Security Audit (10 min) - ADVANCED
**Focus:** Sub-agents
**What they do:** Use Explore agent to find vulnerabilities
**Outcome:** Security issues documented

### Challenge 5: Refactor OrderService (15 min) - ADVANCED
**Focus:** Context management
**What they do:** Multi-session refactoring with /remember
**Outcome:** Clean OrderService, understand session management

### Challenge 6: Build BookService (20 min) - CAPSTONE
**Focus:** Integration of all skills
**What they do:** Build complete REST API from scratch
**Outcome:** Production-ready BookService

## Pre-Workshop Setup (Participants)

**IMPORTANT:** Participants should clone the **separate starter repository**, NOT this workshop-materials repository.

### 1. Install Claude Code CLI
```bash
# Follow installation instructions at:
# https://github.com/anthropics/claude-code
```

### 2. Configure API Key
```bash
claude code configure
# Enter your Anthropic API key
```

### 3. Clone Starter Project
```bash
# Participants clone the starter repository
git clone https://github.com/MyTurnyet/claude-code-workshop-starter.git
cd claude-code-workshop-starter
```

**Note:** This is a separate repository from the workshop materials. Participants should NOT clone the `workshop-materials` repository, which contains solutions and facilitator guides.

### 4. Verify Setup
```bash
mvn clean compile
```

Should compile successfully (with warnings OK, but no errors).

### 5. Run Tests
```bash
mvn test
```

Some tests should fail - that's expected! They'll fix them in Challenge 1.

### Repository Structure

There are **TWO separate repositories**:

1. **claude-code-workshop-starter** (for participants)
   - Contains starter code with intentional bugs
   - Clean README for participants
   - No solutions or hints visible
   - Clone command: `git clone https://github.com/MyTurnyet/claude-code-workshop-starter.git`

2. **workshop-materials** (for facilitators)
   - Contains challenge guides, solutions, hints
   - Facilitator documentation
   - Assessment materials
   - This repository

## Materials Included

### 📁 starter-project/
Contains `claude-code-workshop/` - the single project used throughout

### 📁 challenges/
- `CHALLENGE-01-Fix-Calculator.md`
- `CHALLENGE-02-Add-Project-Rules.md`
- `CHALLENGE-03-Generate-UserService.md`
- `CHALLENGE-04-Security-Audit.md`
- `CHALLENGE-05-Refactor-OrderService.md`
- `CHALLENGE-06-Build-BookService-Capstone.md`

### 📁 solutions/
Complete solutions for each challenge (participants should try first!)

### 📁 strategy-cards/
Quick-reference cards for key concepts:
- Reading Files, Making Edits, Running Commands
- Project Rules, Sub-agents, Session Memory
- And more...

### 📁 facilitator/
- `FACILITATOR_GUIDE.md` - Detailed facilitation instructions
- `SETUP_VERIFICATION.md` - How to verify participant setups
- `COMMON_ISSUES.md` - Troubleshooting guide

### 📁 hints/
Progressive hints (3 levels) for each challenge

## Facilitator Quick Start

1. **Pre-Workshop** (1 week before)
   - Send setup instructions to participants
   - Ask them to verify: `mvn compile` works
   - Collect any setup issues

2. **Workshop Day**
   - Verify everyone is in `claude-code-workshop/` directory
   - Quick demo of Claude Code basics (5 min)
   - Launch into Challenge 1

3. **During Challenges**
   - Circulate and help participants
   - Provide hints as needed (3-level system)
   - Encourage experimentation

4. **Between Challenges**
   - Brief discussion of concepts
   - Show different approaches if time permits
   - Ensure everyone completes before moving on

## Key Design Decisions

### Why This Format?
- **Progressive difficulty** - Builds confidence
- **Real-world simulation** - How actual projects evolve
- **Hands-on learning** - Not lecture-based
- **Immediate feedback** - Test changes instantly
- **Cumulative progress** - See improvement over time

### Why Java?
- Target audience is Java developers
- Familiar syntax reduces cognitive load
- Focus on learning Claude Code, not new language
- Many enterprise developers use Java

### Why Challenge-Based?
- More engaging than follow-along
- Participants solve real problems
- Builds problem-solving skills
- Mimics real development work

### Why Single Project?
- Reduces setup time
- Eliminates context switching
- Realistic project evolution
- Clear sense of accomplishment

## Success Metrics

Participants successfully complete the workshop when:
- ✅ All 6 challenges completed
- ✅ claude-code-workshop compiles and tests pass
- ✅ PROGRESS.md fully filled out
- ✅ Custom skill created
- ✅ Can explain when to use each Claude Code feature

## Post-Workshop

Participants leave with:
1. **Working project** - Complete claude-code-workshop
2. **Custom skill** - java-service-generator for future use
3. **Reference material** - Strategy cards, solutions
4. **Confidence** - Ready to use Claude Code at work

## Common Questions

### Q: What if participants finish at different speeds?
**A:** Faster participants can:
- Help others (peer teaching)
- Try bonus challenges
- Experiment with advanced features
- Start on next challenge

### Q: What if someone falls behind?
**A:**
- Provide hints (3-level system)
- Pair them with someone ahead
- They can catch up using solution guides
- Focus on completing at least Challenges 1-4

### Q: What if setup fails during workshop?
**A:**
- Have backup plans (pair programming)
- Pre-built solution branches
- See `COMMON_ISSUES.md`

### Q: Can this be self-paced?
**A:** Yes! Challenges are self-contained. Can be:
- Self-study at home
- Company training
- University course material

## Customization

### For Shorter Workshops (1 hour)
Focus on Challenges 1-4 only:
- Challenge 1: Fix Calculator (20 min)
- Challenge 2: Add Rules (10 min)
- Challenge 3: Generate Service (10 min)
- Challenge 4: Security Audit (10 min)
- Wrap-up (10 min)

### For Different Languages
The structure works for any language:
- Python: Flask/FastAPI service platform
- JavaScript: Express/Node.js service platform
- Go: HTTP service platform
- C#: .NET service platform

Just replace the Java files with equivalent in target language.

### For Different Skill Levels

**Beginners** - Focus on:
- Challenges 1-2 only
- More time on basic commands
- More hints and guidance

**Advanced** - Add:
- More complex refactorings
- Performance optimization challenges
- Integration with CI/CD
- Custom hooks and integrations

## License & Usage

This workshop material is designed for teaching Claude Code CLI. Feel free to:
- Use in company training
- Adapt for your needs
- Share with colleagues
- Customize for your environment

## Feedback & Improvements

After running the workshop:
- Collect participant feedback
- Note timing accuracy
- Track common issues
- Suggest improvements

## Contact

For questions, issues, or feedback about this workshop:
- GitHub issues: [repository link]
- Workshop facilitator: [contact info]

---

## Quick Links

- [Starter Project](starter-project/claude-code-workshop/)
- [Challenge 1](challenges/CHALLENGE-01-Fix-Calculator.md)
- [Facilitator Guide](facilitator/FACILITATOR_GUIDE.md)
- [Setup Verification](facilitator/SETUP_VERIFICATION.md)

**Ready to start? Begin with [Challenge 1: Fix Calculator](challenges/CHALLENGE-01-Fix-Calculator.md)**
