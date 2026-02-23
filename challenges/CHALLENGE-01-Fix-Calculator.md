# Challenge 1: Fix Calculator Bugs

**Duration:** 20 minutes
**Difficulty:** Beginner
**Project:** claude-code-workshop (stay in this directory)

## Learning Objectives
- Navigate files with Read tool
- Make code changes with Edit tool
- Execute commands with Bash tool
- Understand Claude Code's file-based workflow

## Scenario

The claude-code-workshop project has a Calculator service with bugs causing test failures. Use Claude Code CLI to investigate and fix these issues.

## Your Mission

1. **Read the failing test** - Understand what's expected
2. **Identify the bug** - Find the percentage calculation issue
3. **Fix the bug** - Correct the calculation
4. **Add logging** - Add logging to CalculatorService methods
5. **Verify fixes** - Run tests to confirm everything works

## Starting Point

You're in `claude-code-workshop/` directory with:
- `src/main/java/com/workshop/calculator/Calculator.java` - has percentage bug
- `src/main/java/com/workshop/calculator/CalculatorService.java` - needs logging
- `src/test/java/com/workshop/calculator/CalculatorTest.java` - has failing tests

## Tasks

### Task 1: Read Failing Tests (2 min)

**Prompt to Claude:**
```
Read the CalculatorTest.java file and show me which tests are failing and why.
```

Expected: Two failing tests related to percentage calculations.

### Task 2: Identify the Bug (3 min)

**Prompt to Claude:**
```
Read Calculator.java and explain the bug in the percentage method.
```

The bug: Integer division `(value / 100)` loses precision before multiplication.

### Task 3: Fix the Bug (3 min)

**Prompt to Claude:**
```
Fix the percentage calculation bug. Change it to multiply first, then divide by 100.0 to preserve precision.
```

Expected fix: `(value * percent) / 100.0`

### Task 4: Add Logging (7 min)

**Prompt to Claude:**
```
Add logging to all methods in CalculatorService.java. Use java.util.logging.Logger. Log the operation being performed and the result.
```

Expected:
- Logger import and field added
- Logging in all 5 methods
- Log operations and results

### Task 5: Verify (5 min)

**Prompt to Claude:**
```
Run the tests using Maven to verify all fixes work correctly.
```

Expected: All 8 tests pass.

## Success Criteria

- [ ] All tests in CalculatorTest pass (`mvn test`)
- [ ] Logging added to all CalculatorService methods
- [ ] You understand Read, Edit, and Bash tools
- [ ] PROGRESS.md updated with completion

## Strategy Cards

- **Card #1 - Reading Files:** Use Read tool to view file contents
- **Card #2 - Making Edits:** Use Edit tool with exact string matching
- **Card #3 - Running Commands:** Use Bash tool to run `mvn test`

## Hints

### Hint 1 (Gentle)
The percentage bug happens because integer division truncates before multiplication. Try calculating 150/100 with integers - you get 1, not 1.5!

### Hint 2 (Stronger)
Change `(value / 100) * percent` to `(value * percent) / 100.0`. The `.0` forces floating-point division.

### Hint 3 (Solution)
Ask Claude: "Fix the percentage method by changing line to: `return (value * percent) / 100.0;`"

## What's Next

After completing this challenge:
1. Update PROGRESS.md - mark Challenge 1 complete
2. Verify all tests pass: `mvn test`
3. Move to Challenge 2 (stay in same directory!)

**Challenge 2** will add project rules and refactor this same Calculator to follow them.
