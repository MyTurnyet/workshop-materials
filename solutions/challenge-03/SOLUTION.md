# Challenge 3 Solution: Java Service Generator Skill

## Overview

This solution demonstrates how to create a custom Claude Code skill for generating Java service boilerplate.

## Step 1: Understand Skills Location (1 minute)

**Prompt to Claude:**
```
What is the path to the Claude Code skills directory?
```

**Claude Code will respond:**
Skills are located at: `~/.claude/skills/`

Each skill is a subdirectory containing a `skill.md` file.

## Step 2: Create Skill Directory (1 minute)

**Prompt to Claude:**
```
Create a directory for a new skill called java-service-generator in the skills directory.
```

**Claude Code will:**
1. Use Bash tool: `mkdir -p ~/.claude/skills/java-service-generator`

## Step 3: Create skill.md File (5 minutes)

**Prompt to Claude:**
```
Create a skill.md file in ~/.claude/skills/java-service-generator/ that:
1. Accepts a serviceName parameter
2. Generates a service interface with CRUD methods
3. Generates a service implementation with constructor injection
4. Generates a unit test skeleton with mocks
5. Follows Java coding best practices
```

**Claude Code will:**
1. Use Write tool to create `~/.claude/skills/java-service-generator/skill.md`

**Complete skill.md Content:**

```markdown
---
name: java-service-generator
description: Generate Java service interface, implementation class, and unit tests
arguments:
  - name: serviceName
    description: Name of the service entity (e.g., Product, Order, User)
    required: true
---

# Java Service Generator

Generate a complete Java service structure for: **${serviceName}**

## Context

This skill creates a standard service layer pattern with:
- Service interface defining the contract
- Service implementation with constructor injection
- Unit test skeleton with Mockito mocks

## Task

Create the following three files:

### 1. Service Interface

Create `${serviceName}Service.java` with:
- Package: `com.workshop.service`
- CRUD method signatures: findAll(), findById(), create(), update(), delete()
- Javadoc for all methods
- Use appropriate Java generics and collections

**Implementation requirements:**
- All methods must have Javadoc
- Use Optional<T> for findById return type
- Use Long for ID type
- Return List<T> for findAll

### 2. Service Implementation

Create `${serviceName}ServiceImpl.java` with:
- Package: `com.workshop.service.impl`
- Implements ${serviceName}Service interface
- Constructor injection for repository dependency
- All CRUD methods implemented with:
  - Input validation (throw IllegalArgumentException for null)
  - Logging using java.util.logging.Logger
  - Repository method calls
- Logger instance: `private static final Logger LOGGER`

**Implementation requirements:**
- Constructor injection (no field injection)
- Validate all inputs in public methods
- Log INFO level for operations
- Keep methods under 20 lines each

### 3. Unit Test Skeleton

Create `${serviceName}ServiceTest.java` with:
- Package: `com.workshop.service`
- JUnit 5 (@Test, @BeforeEach)
- Mockito for mocking repository (@Mock)
- Test methods for each CRUD operation
- Test methods for validation (null checks)
- MockitoAnnotations.openMocks(this) in setUp()

**Implementation requirements:**
- Use JUnit 5 (jupiter)
- Mock the repository
- Test both happy path and error cases
- Include TODO comments for incomplete tests

## File Generation Instructions

1. Determine the appropriate source directory structure
2. Create directories if they don't exist
3. Generate all three files with the ${serviceName} parameter substituted
4. Ensure proper Java package structure
5. Follow Google Java Style Guide
6. Confirm all files created successfully

## Example

If serviceName is "Product", generate:
- `ProductService.java` (interface)
- `ProductServiceImpl.java` (implementation)
- `ProductServiceTest.java` (tests)

## Success Criteria

- All three files created in correct package structure
- Code follows Java best practices
- All public methods have Javadoc
- Constructor injection used (not field injection)
- Unit tests include both success and failure cases
- Code compiles without errors
```

## Step 4: Test the Skill (3 minutes)

**Prompt to Claude:**
```
/java-service-generator Product
```

**Claude Code will:**
1. Read the skill.md file
2. Execute the skill with serviceName="Product"
3. Create ProductService.java (interface)
4. Create ProductServiceImpl.java (implementation)
5. Create ProductServiceTest.java (unit tests)
6. Confirm all files created successfully

**Expected Files Created:**

```
src/main/java/com/workshop/service/
├── ProductService.java
└── impl/
    └── ProductServiceImpl.java

src/test/java/com/workshop/service/
└── ProductServiceTest.java
```

## Step 5: Verify Generated Code (1 minute)

**Prompt to Claude:**
```
Read the generated ProductService.java and verify it has all CRUD methods with Javadoc.
```

**Claude Code will:**
1. Use Read tool on generated files
2. Verify structure and content
3. Confirm it matches requirements

## Alternative: Test with Different Service

**Prompt to Claude:**
```
/java-service-generator Order
```

This should generate OrderService, OrderServiceImpl, and OrderServiceTest with the same structure.

## Key Learning Points

### 1. Skills are Reusable
Once created, you can invoke the skill anytime with different parameters:
```
/java-service-generator Product
/java-service-generator Order
/java-service-generator User
/java-service-generator Payment
```

### 2. Skills Accept Parameters
The `${serviceName}` parameter is replaced with the actual argument:
- `/java-service-generator Product` → serviceName = "Product"
- All instances of `${serviceName}` in the skill.md are replaced

### 3. Skills are Just Markdown
Skills are plain markdown files with:
- YAML front matter (metadata)
- Prompt instructions for Claude
- No coding required - just clear instructions

### 4. Skills Follow Project Rules
If `.claude/rules.md` exists, skills will generate code following those rules.

## Common Issues & Troubleshooting

### Issue 1: "Skill not found"
**Solution:** Verify the skill directory path is exactly: `~/.claude/skills/java-service-generator/skill.md`

### Issue 2: "Parameter not replaced"
**Solution:** Ensure front matter lists the argument:
```yaml
arguments:
  - name: serviceName
    description: The service name
    required: true
```
Then use `${serviceName}` in the prompt.

### Issue 3: "Generated code doesn't compile"
**Solution:** Test the skill with a simple example first, then refine the skill.md instructions.

### Issue 4: "Files created in wrong location"
**Solution:** Specify the exact package structure in skill.md instructions.

## Extending the Skill

You can enhance the skill by:
1. Adding more parameters (e.g., `${packageName}`)
2. Adding more file types (e.g., controller, DTO)
3. Adding Spring annotations
4. Adding more validation logic
5. Customizing logging frameworks

**Example with multiple parameters:**
```yaml
arguments:
  - name: serviceName
    required: true
  - name: packageName
    required: false
    default: com.workshop
```

## Time Breakdown

- **1 min:** Understand skills directory location
- **1 min:** Create skill directory
- **5 min:** Write skill.md with complete instructions
- **3 min:** Test skill by generating ProductService
- **1 min:** Verify generated code

**Total: 10 minutes** (may vary slightly)

## Next Challenge

Proceed to Challenge 4: Sub-agents and Task Delegation where you'll learn to use Task tool with different agent types to explore large codebases.

## Additional Resources

- Look at existing skills in ~/.claude/skills/ for more examples
- Skills can be shared across projects and teams
- Skills can invoke other tools (Read, Edit, Bash, etc.)
- Skills are version-controlled just like code
