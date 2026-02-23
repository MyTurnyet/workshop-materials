# Claude Code CLI - Command Reference

Quick reference for Claude Code CLI commands and workflows.

## Basic Commands

### Starting Claude Code
```bash
claude code
```
Starts Claude Code CLI in current directory.

### Exiting Claude Code
```bash
> exit
```
Or press: `Ctrl+C`

### Getting Help
```bash
claude --help
claude code --help
```

---

## Claude Code Tools

### Read Tool
**Purpose:** View file contents

**Usage:**
```
Read [filename]
Read Calculator.java
Read src/main/java/com/workshop/Calculator.java
```

**Tips:**
- Claude uses this automatically when you ask about files
- Can read any file in the project
- Shows line numbers for reference

### Edit Tool
**Purpose:** Modify existing files

**Usage:**
```
Fix the percentage bug by changing line 32 to multiply before dividing
```

**How it works:**
- Claude identifies exact string to replace
- Shows you the change before applying
- Requires exact string matching

**Tips:**
- Include enough context for unique matching
- Verify changes with Read after editing
- Can undo by editing back

### Write Tool
**Purpose:** Create new files

**Usage:**
```
Create a new Book.java entity with fields: id, title, author
```

**Tips:**
- Used for creating new files
- Prefer Edit for modifying existing files
- Always verify created files compile

### Bash Tool
**Purpose:** Run terminal commands

**Usage:**
```
Run tests: mvn test
Compile the project: mvn compile
Check Git status: git status
```

**Common Commands:**
- `mvn compile` - Compile Java code
- `mvn test` - Run tests
- `mvn clean` - Clean build artifacts
- `git status` - Check Git status
- `git diff` - See changes

---

## Project Configuration

### .claude/rules.md
**Purpose:** Define project-specific coding standards

**Location:** `.claude/rules.md` in project root

**Example:**
```markdown
# Project Coding Standards

## Method Length
- All methods must be under 20 lines

## Documentation
- All public methods must have Javadoc

## Naming
- Follow Google Java Style Guide
```

**Impact:** Claude automatically follows these rules for ALL interactions in the project

---

## Skills

### What are Skills?
Reusable automation workflows stored in `~/.claude/skills/`

### Skill Structure
```
~/.claude/skills/
└── skill-name/
    └── skill.md
```

### Creating a Skill
1. Create directory: `~/.claude/skills/my-skill/`
2. Create `skill.md` with:
```markdown
---
name: my-skill
description: What the skill does
arguments:
  - name: param1
    required: true
---

# Skill Content

Instructions for Claude using ${param1}
```

### Using a Skill
```
/skill-name parameter
/java-service-generator User
```

---

## Sub-agents

### When to Use
- Large codebase searches
- Complex multi-step tasks
- Parallel work
- Research and analysis

### Types of Sub-agents

**Explore Agent**
- Purpose: Search codebases, find patterns
- Usage: `Use Task tool with Explore sub-agent to find all authentication code`

**Plan Agent**
- Purpose: Design implementation approaches
- Usage: `Use Plan agent to design a new feature`

**Bash Agent**
- Purpose: Complex terminal operations
- Usage: `Use Bash agent to run security scans`

### Example Prompt
```
Use Task tool with Explore sub-agent to find all files related to authentication. Look for JWT, token, and security-related code.
```

---

## Context Management

### /remember Command
**Purpose:** Save information for future sessions

**Usage:**
```
/remember UserService uses repository pattern with constructor injection

/remember We decided to use bcrypt for password hashing

/remember API follows RESTful conventions: GET /api/books, POST /api/books
```

**When to Use:**
- Architectural decisions
- Design choices
- Important conventions
- Long-running projects

### Session Management

**Closing Session:**
- Save important info with /remember
- Document progress in PROGRESS.md
- Exit: `Ctrl+C` or `exit`

**Resuming Session:**
1. Start Claude Code: `claude code`
2. Provide brief context:
```
I'm continuing the refactoring of OrderService. I've completed method extraction and now need to verify all methods are under 20 lines.
```

---

## Common Workflows

### Fixing a Bug
1. Read the test to understand expected behavior
2. Read the buggy code
3. Ask Claude to fix specific issue
4. Run tests to verify
5. Commit changes

```
Read CalculatorTest.java
Read Calculator.java
Fix the percentage calculation bug
Run tests: mvn test
```

### Adding a Feature
1. Plan the approach
2. Create/modify files
3. Add tests
4. Verify everything works

```
Create a Book entity with properties: id, title, author, isbn
Create BookRepository interface with CRUD methods
Create BookService interface and implementation
Create tests for BookService
Run tests: mvn test
```

### Refactoring Code
1. Analyze current code
2. Use /remember for plan
3. Refactor incrementally
4. Verify after each change
5. Document progress

```
Read OrderService.java and identify problems
/remember Refactoring plan: extract validation, rename methods, split responsibilities
Refactor createOrder method to be under 20 lines
Run tests: mvn test
Update PROGRESS.md
```

---

## Best Practices

### Do's
✅ Read files before editing them
✅ Verify changes with tests
✅ Use project rules for consistency
✅ Break large tasks into phases
✅ Document progress
✅ Use /remember for important decisions
✅ Review AI suggestions before accepting

### Don'ts
❌ Don't blindly accept AI suggestions
❌ Don't skip testing changes
❌ Don't work without rules configured
❌ Don't forget to document progress
❌ Don't use for learning fundamentals
❌ Don't use with proprietary code without approval

---

## Troubleshooting

### "Edit failed: string not unique"
**Solution:** Include more surrounding context in your edit request

### "File not found"
**Solution:** Check file path is correct, use absolute or relative paths

### "Command failed"
**Solution:** Check command syntax, ensure dependencies installed

### "API rate limit"
**Solution:** Wait a moment, or check API quota

### "Context too large"
**Solution:** Summarize and use /remember, start new session

---

## Quick Tips

**Prompt Engineering:**
- Be specific: "Fix percentage bug" not "fix bug"
- Give context: "The bug is in line 32"
- Explain intent: "I want to add logging for debugging"

**Efficiency:**
- Read multiple files at once when related
- Combine related edits
- Use skills for repetitive tasks
- Leverage sub-agents for research

**Quality:**
- Always test after changes
- Review generated code
- Follow project rules
- Document decisions

---

## Additional Resources

**Official Documentation:**
- Claude Code: https://github.com/anthropics/claude-code
- Anthropic API: https://docs.anthropic.com

**Community:**
- Discord: [link]
- GitHub Issues: [link]

**Learning:**
- Workshop materials: [this repository]
- Example projects: [link]
- Video tutorials: [link]

---

## Keyboard Shortcuts

- `Ctrl+C` - Exit Claude Code
- `Ctrl+L` - Clear screen (in some terminals)
- `↑/↓` - Navigate command history
- `Tab` - Autocomplete (context-dependent)

---

## Version Information

```bash
claude --version        # Check Claude Code CLI version
java -version          # Check Java version
mvn -version           # Check Maven version
```

---

This reference card covers the essential Claude Code commands and workflows. Keep it handy during development!

For detailed examples, see the workshop challenges and solution guides.
