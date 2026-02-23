# Claude Code Workshop Project - Workshop Starter Project

## Overview

This is the starter codebase for the Claude Code CLI Workshop. You'll work in this single project throughout all 6 challenges, progressively building and improving it.

## Current Status

This is a **work-in-progress platform** with:
- ✅ Calculator service (has bugs to fix)
- ✅ Order service (legacy code, needs refactoring)
- ✅ Authentication utilities (has security issues)
- ⚠️ User service (doesn't exist yet - you'll create it)
- ⚠️ Book service (doesn't exist yet - you'll create it)
- ⚠️ Project rules (not configured yet)

## Setup

1. **Prerequisites**
   - Java 11 or higher
   - Maven 3.6 or higher
   - Claude Code CLI installed
   - Claude API key configured

2. **Verify Setup**
   ```bash
   cd claude-code-workshop
   mvn clean compile
   ```

   Should compile with warnings but no errors.

3. **Run Tests**
   ```bash
   mvn test
   ```

   Some tests will fail - that's expected! You'll fix them in Challenge 1.

## Workshop Progression

### Challenge 1: Fix Calculator Bugs
- Fix failing tests in Calculator
- Add logging to CalculatorService
- Learn Read, Edit, Bash tools

### Challenge 2: Add Project Rules
- Create .claude/rules.md
- Refactor Calculator to follow rules
- Learn about project configuration

### Challenge 3: Generate UserService
- Create custom skill
- Generate UserService using skill
- Learn skills and automation

### Challenge 4: Security Audit
- Use sub-agents to find security issues
- Audit auth code
- Learn sub-agent delegation

### Challenge 5: Refactor OrderService
- Multi-session refactoring
- Practice context management
- Learn /remember command

### Challenge 6: Build BookService
- Create complete REST API
- Integration of all learned skills
- Demonstrate mastery

## Project Structure

```
claude-code-workshop/
├── src/main/java/com/workshop/
│   ├── calculator/          # Challenge 1
│   ├── order/               # Challenge 5
│   ├── auth/                # Challenge 4
│   ├── user/                # Challenge 3 (empty)
│   ├── book/                # Challenge 6 (empty)
│   └── config/
├── src/test/java/com/workshop/
├── .claude/                 # Challenge 2 (empty)
├── pom.xml
├── README.md (this file)
└── PROGRESS.md              # Track your progress
```

## Getting Started

1. Open this directory in your terminal
2. Start Claude Code CLI:
   ```bash
   claude code
   ```
3. Begin with Challenge 1 instructions

## Need Help?

- Check the hints files in `/workshop-materials/hints/`
- Consult strategy cards
- Ask your facilitator
- Refer to solution guides (try on your own first!)

## After the Workshop

This project will be a complete working system with:
- Fixed bugs
- Clean, refactored code
- Project standards configured
- Custom automation tools
- Security issues identified
- New features implemented
- Comprehensive tests

Keep this as a reference for using Claude Code CLI in your own projects!

## Notes

- Stay in this directory for all challenges
- Each challenge builds on the previous
- Track progress in PROGRESS.md
- Have fun and experiment!
