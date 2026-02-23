# Claude Code CLI - Quick Start Guide

Get started with Claude Code CLI in 5 minutes.

## What is Claude Code?

Claude Code is an AI-powered CLI tool that helps you write, debug, and refactor code through natural language conversation.

**Use it for:**
- Fixing bugs
- Adding features
- Refactoring code
- Understanding codebases
- Writing tests
- Generating boilerplate

**Don't use it for:**
- Learning fundamentals (supplement, don't replace learning)
- Production-critical decisions without review
- Proprietary code without authorization

---

## Installation

### macOS/Linux
```bash
curl -fsSL https://raw.githubusercontent.com/anthropics/claude-code/main/install.sh | sh
```

### Windows
```powershell
irm https://raw.githubusercontent.com/anthropics/claude-code/main/install.ps1 | iex
```

### Verify
```bash
claude --version
```

---

## Configuration

### Get API Key
1. Visit: https://console.anthropic.com/
2. Sign up or log in
3. Create API key
4. Copy the key

### Configure Claude Code
```bash
claude code configure
```

Enter your API key when prompted.

---

## Your First Session

### 1. Navigate to Project
```bash
cd your-project-directory
```

### 2. Start Claude Code
```bash
claude code
```

### 3. Try Basic Commands

**Read a file:**
```
> Read README.md
```

**Fix a bug:**
```
> Read Calculator.java and fix the percentage calculation bug
```

**Run tests:**
```
> Run the tests using mvn test
```

**Exit:**
```
> exit
```

---

## Essential Concepts

### 1. Tools
Claude uses tools to interact with your code:
- **Read** - View files
- **Edit** - Modify files
- **Write** - Create files
- **Bash** - Run commands

You don't call tools directly - just ask Claude in natural language.

### 2. Project Rules
Create `.claude/rules.md` to define coding standards:

```markdown
# Coding Standards

- All methods under 20 lines
- Javadoc on all public methods
- Use constructor injection
```

Claude automatically follows these rules.

### 3. Skills
Create reusable workflows in `~/.claude/skills/`:

```
~/.claude/skills/my-skill/skill.md
```

Invoke with: `/my-skill`

### 4. Context
Claude remembers conversation context. For long tasks:
- Use `/remember` to save key info
- Document progress
- Provide summary when resuming

---

## Common Tasks

### Fix a Bug
```
Read the test to understand what's failing
Read the source code
Fix the bug in [filename]
Run tests to verify
```

### Add a Feature
```
I need to add a Book entity with fields: id, title, author, isbn
Create Book.java in src/main/java/com/workshop/book/
Add getters and setters
```

### Refactor Code
```
Read OrderService.java
This class is too long. Break down the createOrder method into smaller methods under 20 lines each
```

### Write Tests
```
Create unit tests for BookService using JUnit 5 and Mockito
Test all CRUD operations and edge cases
```

---

## Best Practices

### 1. Be Specific
❌ "Fix the bug"
✅ "Fix the percentage calculation bug in Calculator.java line 32"

### 2. Verify Everything
Always test after changes:
```
Run mvn test
Run mvn compile
```

### 3. Use Project Rules
Define standards once, apply everywhere:
```
Create .claude/rules.md with our team coding standards
```

### 4. Break Down Complex Tasks
Instead of:
```
Build a complete REST API
```

Do:
```
Step 1: Create entity
Step 2: Create repository interface
Step 3: Create service layer
Step 4: Add tests
```

### 5. Review AI Suggestions
Claude is powerful but not perfect:
- Review generated code
- Understand what changed
- Test thoroughly
- Use version control

---

## Workflow Example

Complete workflow for adding a feature:

```bash
# Start Claude Code
cd my-project
claude code

# Set up rules (first time only)
> Create .claude/rules.md with: methods under 20 lines, Javadoc on public methods, constructor injection

# Read existing code to understand patterns
> Read src/main/java/com/workshop/user/UserService.java

# Create new feature
> Create a Book entity in src/main/java/com/workshop/book/ with fields: id, title, author, isbn, price

# Add business logic
> Create BookService interface and BookServiceImpl with CRUD operations, validation, and logging

# Add tests
> Create BookServiceTest with unit tests using Mockito

# Verify
> Compile: mvn compile
> Run tests: mvn test

# Document
> Update PROGRESS.md with what was added

# Exit
> exit
```

---

## Troubleshooting

### Claude doesn't understand my request
- Be more specific
- Provide file names
- Give context about what you're trying to achieve

### Edit failed
- Error: "String not unique"
- Solution: Include more surrounding context

### Tests fail after changes
- Review what Claude changed
- Check if logic is correct
- May need to fix manually

### Out of context
- Use `/remember` for key info
- Start new session
- Provide summary when resuming

---

## Next Steps

### Learn More
- Complete the workshop challenges
- Read command reference
- Explore example projects

### Try Advanced Features
- Create custom skills
- Use sub-agents for research
- Configure project-specific rules

### Join Community
- Discord: [link]
- GitHub: [link]
- Share tips and tricks

---

## Resources

**Documentation:**
- Command Reference: `resources/COMMAND_REFERENCE.md`
- Workshop Challenges: `challenges/`
- Examples: `starter-project/`

**Help:**
- `/help` in Claude Code
- `claude --help` in terminal
- Community support

---

## Remember

**Claude Code is a tool, you're the developer:**
- ✅ Review all suggestions
- ✅ Test all changes
- ✅ Understand what's happening
- ✅ Use version control
- ✅ Keep learning

**Happy coding with Claude! 🚀**
