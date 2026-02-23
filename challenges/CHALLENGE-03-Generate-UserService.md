# Challenge 3: Generate UserService with Custom Skill

**Duration:** 10 minutes
**Difficulty:** Intermediate
**Project:** claude-code-workshop (same directory)

## Learning Objectives
- Create custom Claude Code skills
- Understand skill structure and parameters
- Use skills to automate repetitive workflows
- Generate code that follows project rules

## Scenario

The platform needs a UserService. Instead of manually creating all the boilerplate (interface, implementation, tests), you'll create a reusable skill that automates this workflow.

## Your Mission

1. **Navigate to skills directory** - Find ~/.claude/skills/
2. **Create java-service-generator skill** - Build custom skill
3. **Test the skill** - Generate UserService for the platform
4. **Verify generated code** - Ensure it follows project rules

## Starting Point

You're in `claude-code-workshop/` with:
- Fixed Calculator with rules (from Challenges 1-2)
- `.claude/rules.md` established
- Empty `src/main/java/com/workshop/user/` directory
- Need to add UserService

## Tasks

### Task 1: Navigate to Skills Directory (1 min)

**Prompt to Claude:**
```
Show me the path to the Claude Code skills directory and create a new skill directory called java-service-generator.
```

Expected: `~/.claude/skills/java-service-generator/` created

### Task 2: Create Skill File (5 min)

**Prompt to Claude:**
```
Create a skill.md file in ~/.claude/skills/java-service-generator/ that:
1. Accepts a serviceName parameter
2. Generates a service interface with CRUD methods
3. Generates a service implementation with constructor injection
4. Generates a unit test skeleton with Mockito mocks
5. Places files in the correct package structure
6. Follows the project rules in .claude/rules.md
```

The skill should generate files in:
- `src/main/java/com/workshop/{serviceName.toLowerCase()}/`

### Task 3: Test the Skill (3 min)

Return to `claude-code-workshop/` directory.

**Prompt to Claude:**
```
/java-service-generator User
```

Expected generated files:
- `src/main/java/com/workshop/user/UserService.java` (interface)
- `src/main/java/com/workshop/user/UserServiceImpl.java` (implementation)
- `src/test/java/com/workshop/user/UserServiceTest.java` (tests)

### Task 4: Verify Generated Code (1 min)

**Prompt to Claude:**
```
Read the generated UserService.java and verify it follows the project rules from .claude/rules.md.
```

Check:
- Methods have Javadoc
- Methods under 20 lines
- Constructor injection used
- Proper naming conventions

## Success Criteria

- [ ] skill.md created in `~/.claude/skills/java-service-generator/`
- [ ] Skill accepts serviceName parameter
- [ ] UserService, UserServiceImpl, and UserServiceTest generated
- [ ] Generated code follows project rules
- [ ] Files in correct package structure
- [ ] Code compiles: `mvn compile`
- [ ] PROGRESS.md updated

## Skill Template Hints

### Front Matter
```yaml
---
name: java-service-generator
description: Generate Java service interface, implementation, and tests
arguments:
  - name: serviceName
    description: Name of the service (e.g., User, Product, Order)
    required: true
---
```

### Prompt Structure
```markdown
# Java Service Generator

Generate a complete Java service for: **${serviceName}**

Create these files:
1. ${serviceName}Service.java (interface)
2. ${serviceName}ServiceImpl.java (implementation)
3. ${serviceName}ServiceTest.java (unit tests)

Place in: src/main/java/com/workshop/${serviceName.toLowerCase()}/

Follow all rules in .claude/rules.md
```

## Strategy Cards

- **Card #7 - Skill Location:** Skills live in ~/.claude/skills/
- **Card #8 - Skill Structure:** Each skill needs skill.md
- **Card #9 - Skill Parameters:** Use ${paramName} syntax

## Hints

### Hint 1
Look at the skill template example in `/workshop-materials/challenges/skill-template-example.md`

### Hint 2
Skills are just markdown files with YAML front matter - no coding required!

### Hint 3
The skill will automatically follow project rules since .claude/rules.md exists.

## What's Next

After completing this challenge:
1. Update PROGRESS.md
2. Verify UserService files exist and compile
3. Move to Challenge 4

**Challenge 4** will use sub-agents to find security issues in the auth code that's already in the platform.

## Bonus

If time permits, test the skill again:
```
/java-service-generator Product
```

This should generate ProductService in `src/main/java/com/workshop/product/`

## Real-World Value

This skill is now available for:
- Any service you need to add to this platform
- Future projects (skill is global, not project-specific)
- Team members (share the skill file)
- Consistent code generation across projects
