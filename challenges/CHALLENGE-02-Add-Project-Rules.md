# Challenge 2: Add Project Rules

**Duration:** 10 minutes
**Difficulty:** Intermediate
**Project:** claude-code-workshop (same directory)

## Learning Objectives
- Create and configure .claude directory
- Write project-specific rules in rules.md
- Understand how rules influence Claude Code behavior
- Apply rules to refactor existing code

## Scenario

Now that Calculator works, let's establish coding standards for the entire platform. You'll create project rules and refactor Calculator to follow them.

## Your Mission

1. **Create .claude/rules.md** - Define team coding standards
2. **Define standards** - Methods under 20 lines, Javadoc, etc.
3. **Refactor Calculator** - Apply rules to existing code
4. **Verify compliance** - Check that code follows rules

## Starting Point

You're in `claude-code-workshop/` with:
- Fixed Calculator (from Challenge 1)
- No `.claude` directory yet
- Other services (OrderService, auth) that will benefit from rules

## Tasks

### Task 1: Create .claude Directory (1 min)

**Prompt to Claude:**
```
Create a .claude directory in the project root.
```

### Task 2: Create rules.md (3 min)

**Prompt to Claude:**
```
Create .claude/rules.md with the following team coding standards:
- All methods must be under 20 lines
- All public methods must have Javadoc with @param and @return tags
- No public fields - use private with getters/setters
- Follow Google Java Style Guide naming conventions
- Use java.util.logging.Logger - no System.out.println
- Validate all inputs in public methods
- Use constructor injection for dependencies
```

### Task 3: Refactor Calculator (4 min)

**Prompt to Claude:**
```
Read Calculator.java and refactor it to follow the rules in .claude/rules.md. Specifically:
1. Add Javadoc to all public methods
2. Ensure all methods are under 20 lines
3. Follow naming conventions
```

Expected changes:
- Javadoc added to all public methods
- Proper @param and @return tags
- Clean, well-documented code

### Task 4: Verify Rules Followed (2 min)

**Prompt to Claude:**
```
Read the refactored Calculator.java and verify that all methods are under 20 lines and all public methods have Javadoc.
```

## Success Criteria

- [ ] `.claude/rules.md` exists with complete standards
- [ ] Calculator.java has Javadoc on all public methods
- [ ] All methods under 20 lines
- [ ] Code still compiles: `mvn compile`
- [ ] Tests still pass: `mvn test`
- [ ] PROGRESS.md updated

## Example rules.md Content

```markdown
# Project Coding Standards

## Method Length
- All methods must be under 20 lines of code
- Extract helper methods if needed

## Documentation
- All public methods must have Javadoc
- Include @param and @return tags
- Describe what, not how

## Encapsulation
- No public fields
- Use private with getters/setters
- Validate inputs

## Naming
- Follow Google Java Style Guide
- No abbreviations
- Clear, descriptive names

## Dependency Injection
- Use constructor injection
- Make dependencies final

## Logging
- Use java.util.logging.Logger
- Never use System.out.println
```

## Strategy Cards

- **Card #4 - Project Rules:** Create .claude/rules.md for coding standards
- **Card #5 - Rule Specificity:** Be specific in rules
- **Card #6 - Testing Rules:** Verify Claude follows rules

## Hints

### Hint 1
Rules apply automatically to ALL Claude Code interactions in this project once .claude/rules.md exists.

### Hint 2
Be specific: "methods under 20 lines" is better than "keep methods small".

### Hint 3
Test your rules by asking Claude to create something new - it should follow the rules automatically.

## What's Next

After completing this challenge:
1. Update PROGRESS.md
2. Verify rules file exists and is complete
3. Move to Challenge 3

**Challenge 3** will create a custom skill that automatically follows these rules when generating new services.

## Benefits

Now that rules exist:
- **All future code** will follow standards automatically
- OrderService refactoring (Challenge 5) will use these rules
- UserService generation (Challenge 3) will follow rules
- BookService creation (Challenge 6) will follow rules
- Consistent quality across entire platform
