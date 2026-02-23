# Challenge 3 Hints: Java Service Generator Skill

## Progressive Hint System

---

## Part 1: Finding Skills Directory

### Hint Level 1 (Gentle Nudge)
Skills live in a special directory in your home folder. Ask Claude Code where skills are stored.

### Hint Level 2 (Stronger Hint)
Ask Claude: "What is the path to the Claude Code skills directory?"
The path is: `~/.claude/skills/`

### Hint Level 3 (Near-Solution)
Skills directory: `~/.claude/skills/`
Each skill is a subdirectory with a `skill.md` file inside.

For this challenge, you'll create:
`~/.claude/skills/java-service-generator/skill.md`

---

## Part 2: Creating Skill Structure

### Hint Level 1 (Gentle Nudge)
A skill consists of:
1. A directory: `~/.claude/skills/[skill-name]/`
2. A file: `skill.md` inside that directory
3. YAML front matter defining metadata
4. Markdown content with instructions

### Hint Level 2 (Stronger Hint)
First create the directory:
```bash
mkdir -p ~/.claude/skills/java-service-generator
```

Then create `skill.md` with this structure:
```markdown
---
name: java-service-generator
description: Brief description
arguments:
  - name: serviceName
    description: The service name
    required: true
---

# Skill Title

Instructions for Claude Code...
```

### Hint Level 3 (Near-Solution)
Ask Claude Code:
```
Create a directory at ~/.claude/skills/java-service-generator and create a skill.md file with YAML front matter that accepts a serviceName parameter.
```

The front matter should be:
```yaml
---
name: java-service-generator
description: Generate Java service interface, implementation, and tests
arguments:
  - name: serviceName
    description: Name of the service (e.g., Product, Order)
    required: true
---
```

---

## Part 3: Writing Skill Instructions

### Hint Level 1 (Gentle Nudge)
The skill instructions should tell Claude Code exactly what files to generate and what they should contain. Think about:
- What package structure to use
- What methods each interface/class needs
- What coding standards to follow

### Hint Level 2 (Stronger Hint)
Your skill prompt should instruct Claude to create three files:

1. **Interface**: `${serviceName}Service.java`
   - CRUD method signatures
   - Javadoc comments

2. **Implementation**: `${serviceName}ServiceImpl.java`
   - Implements the interface
   - Constructor injection for repository
   - Logging and validation

3. **Tests**: `${serviceName}ServiceTest.java`
   - JUnit 5 test class
   - Mockito mocks
   - Test stubs

Use `${serviceName}` wherever you want the parameter substituted.

### Hint Level 3 (Near-Solution)
Refer to the template file at:
`workshop-materials/challenges/03-skill-template/skill-template-example.md`

Copy this structure and customize as needed. Key sections:
- Front matter with arguments
- Clear file generation instructions
- Code templates with ${serviceName} placeholders
- Success criteria

---

## Part 4: Using Parameters

### Hint Level 1 (Gentle Nudge)
Parameters defined in the front matter can be used in the skill body with `${parameterName}` syntax.

### Hint Level 2 (Stronger Hint)
If your front matter has:
```yaml
arguments:
  - name: serviceName
```

Then in your skill body, use: `${serviceName}`

When invoked with `/java-service-generator Product`, Claude will replace all `${serviceName}` with "Product".

### Hint Level 3 (Near-Solution)
Example usage in skill.md:
```markdown
Generate a service interface named ${serviceName}Service.java

The class should be:
```java
public interface ${serviceName}Service {
    List<${serviceName}> findAll();
}
```
```

When invoked with "Product", generates:
```java
public interface ProductService {
    List<Product> findAll();
}
```

---

## Part 5: Testing the Skill

### Hint Level 1 (Gentle Nudge)
After creating the skill, test it by invoking with `/java-service-generator Product` in Claude Code CLI.

### Hint Level 2 (Stronger Hint)
In Claude Code CLI:
```
> /java-service-generator Product
```

Claude will:
1. Read your skill.md
2. Replace ${serviceName} with "Product"
3. Generate the three files
4. Confirm creation

### Hint Level 3 (Near-Solution)
Complete testing sequence:

```bash
# Start Claude Code
claude code

# Invoke your skill
> /java-service-generator Product

# Verify files created
> Read ProductService.java to verify it was created correctly

# Test with another service
> /java-service-generator Order
```

---

## Common Mistakes to Avoid

1. **Wrong file location**: Must be exactly `~/.claude/skills/java-service-generator/skill.md`
2. **Missing front matter**: YAML front matter must be at the top between `---` markers
3. **Wrong parameter syntax**: Use `${serviceName}`, not `$serviceName` or `{serviceName}`
4. **Vague instructions**: Be specific about what files to create and their content
5. **Not testing**: Always test the skill after creating it

---

## Verification Checklist

Before testing, verify:
- [ ] Directory created at `~/.claude/skills/java-service-generator/`
- [ ] File `skill.md` exists in that directory
- [ ] Front matter has `arguments` with `serviceName`
- [ ] Skill body uses `${serviceName}` for parameter substitution
- [ ] Instructions are clear and specific
- [ ] Success criteria defined

---

## Example: Minimal Working Skill

Simplest possible skill.md:
```markdown
---
name: java-service-generator
description: Generate Java service files
arguments:
  - name: serviceName
    required: true
---

# Generate Java Service

Create a file named ${serviceName}Service.java with:

```java
package com.workshop.service;

public interface ${serviceName}Service {
    // TODO: Add methods
}
```

Create in: src/main/java/com/workshop/service/
```

This is minimal but functional. Enhance it by adding more files and detail.

---

## Debugging Skills

If skill doesn't work:

1. **Check file location**:
   ```bash
   ls -la ~/.claude/skills/java-service-generator/
   ```
   Should show `skill.md`

2. **Check front matter**:
   - Must start with `---`
   - Must end with `---`
   - Must have valid YAML

3. **Check parameter names**:
   - Front matter: `name: serviceName`
   - Body: `${serviceName}`
   - Must match exactly

4. **Read error messages**:
   Claude will tell you if skill syntax is wrong

---

## Still Stuck?

Refer to:
- Template: `/workshop-materials/challenges/03-skill-template/skill-template-example.md`
- Solution: `/workshop-materials/solutions/challenge-03/SOLUTION.md`
- Ask facilitator for live demonstration
