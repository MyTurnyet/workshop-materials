# Challenge 2 Hints: Add Project Rules

---

## Part 1: Creating .claude Directory

### Level 1 (Gentle Nudge)
You need to create a hidden directory called `.claude` in your project root. Ask Claude to do this for you.

### Level 2 (Stronger Hint)
Prompt: "Create a .claude directory in the project root"
Claude will use: `mkdir -p .claude`

### Level 3 (Near-Solution)
```
Create a .claude directory using mkdir -p .claude
```

---

## Part 2: Writing rules.md

### Level 1 (Gentle Nudge)
The rules.md file should contain team coding standards in markdown format. Think about what makes good, maintainable code: method length, documentation, naming, etc.

### Level 2 (Stronger Hint)
Your rules should include:
- Method length limits (e.g., "All methods under 20 lines")
- Documentation requirements (e.g., "Javadoc on all public methods")
- Naming conventions (e.g., "Follow Google Java Style Guide")
- Logging standards (e.g., "Use Logger, not System.out.println")
- Dependency injection preferences
- Validation requirements

### Level 3 (Near-Solution)
Prompt to Claude:
```
Create .claude/rules.md with these coding standards:
- All methods must be under 20 lines
- All public methods must have Javadoc with @param and @return tags
- No public fields - use private with getters/setters
- Follow Google Java Style Guide naming
- Use java.util.logging.Logger, never System.out.println
- Validate all inputs in public methods
- Use constructor injection for dependencies
```

---

## Part 3: Refactoring Calculator

### Level 1 (Gentle Nudge)
Once rules.md exists, ask Claude to refactor Calculator.java to follow those rules. Claude will automatically read the rules and apply them.

### Level 2 (Stronger Hint)
Prompt:
```
Read Calculator.java and refactor it to follow all rules in .claude/rules.md.
Specifically:
1. Add Javadoc to all public methods
2. Ensure all methods are under 20 lines
3. Follow naming conventions
```

### Level 3 (Near-Solution)
Exact prompt:
```
Refactor Calculator.java to follow .claude/rules.md:
1. Add Javadoc comments to add(), subtract(), multiply(), divide(), and percentage() methods
2. Include @param tags for parameters and @return tags for return values
3. Verify all methods are under 20 lines
4. Ensure code compiles after changes
```

---

## Part 4: Verification

### Level 1 (Gentle Nudge)
After refactoring, ask Claude to verify that the code follows all the rules. Check method lengths and Javadoc presence.

### Level 2 (Stronger Hint)
Prompt:
```
Read the refactored Calculator.java and verify:
1. All methods are under 20 lines
2. All public methods have Javadoc
3. Code still compiles
```

### Level 3 (Near-Solution)
```
Verify Calculator.java follows rules:
1. Count lines in each method - report any over 20
2. Check each public method has Javadoc with @param and @return
3. Run: mvn compile
```

---

## Common Mistakes

### Mistake 1: Rules too vague
**Symptom:** Claude doesn't know how to apply rules
**Example:** "Keep methods small" vs "Methods under 20 lines"
**Fix:** Be specific with numbers and exact requirements

### Mistake 2: Forgot to create .claude directory first
**Symptom:** Error creating rules.md
**Fix:** Run `mkdir -p .claude` before creating rules.md

### Mistake 3: Not testing that rules work
**Symptom:** Rules file exists but not being followed
**Fix:** Ask Claude to read the rules and confirm they're being applied

### Mistake 4: Too many rules
**Symptom:** Overwhelming, hard to follow
**Fix:** Start with 5-7 essential rules, can add more later

---

## Example Rules Section

```markdown
# Project Coding Standards

## Method Length
- All methods must be under 20 lines of code
- If a method exceeds 20 lines, extract helper methods

## Documentation
- All public methods must have Javadoc comments
- Include @param tags for all parameters
- Include @return tag for non-void methods
- Describe what the method does, not how

## Encapsulation
- No public fields (except public static final constants)
- All instance fields must be private
- Provide getters/setters only when needed

## Naming Conventions (Google Java Style Guide)
- Class names: PascalCase
- Method names: camelCase starting with verb
- Variable names: camelCase
- Constants: UPPER_SNAKE_CASE
- No abbreviations
```

---

## Quick Verification Checklist

Before moving to Challenge 3:
- [ ] `.claude/rules.md` exists
- [ ] Rules include method length limit
- [ ] Rules include documentation requirements
- [ ] Rules include naming conventions
- [ ] Calculator.java refactored
- [ ] All public methods have Javadoc
- [ ] All methods under 20 lines
- [ ] Code compiles: `mvn compile`
- [ ] Tests still pass: `mvn test`

---

## Understanding Rules Impact

Once .claude/rules.md exists:
- **Automatic application:** Claude follows these rules for ALL interactions
- **Consistency:** All code generated will follow standards
- **Future challenges:** UserService, BookService will automatically follow rules
- **Team alignment:** Share rules.md with team for consistency

---

## Still Stuck?

1. Check example rules in `solutions/challenge-02/rules.md.example`
2. Ask facilitator to show their rules file
3. Look at other projects' .claude/rules.md for inspiration
