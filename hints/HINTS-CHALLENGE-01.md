# Challenge 1 Hints: Fix Calculator

Progressive 3-level hint system. Provide Level 1 first, then Level 2 if still stuck, then Level 3 as last resort.

---

## Part 1: Finding the Bug

### Level 1 (Gentle Nudge)
The failing tests are both related to percentage calculations. Look at what the test expects versus what the method returns. Pay attention to the order of mathematical operations.

### Level 2 (Stronger Hint)
The bug is in line 32 of Calculator.java. When you do `(value / 100)` with integers, Java performs integer division which loses the decimal. For example: `150 / 100 = 1` (not 1.5), then `1 * 20 = 20` (not 30).

### Level 3 (Near-Solution)
Change line 32 from:
```java
return (value / 100) * percent;
```
To:
```java
return (value * percent) / 100.0;
```
The `.0` forces floating-point division instead of integer division.

---

## Part 2: Adding Logging

### Level 1 (Gentle Nudge)
You need to import `java.util.logging.Logger` and create a logger instance. Then add logging statements before and after each calculation.

### Level 2 (Stronger Hint)
At the top of CalculatorService.java, add:
```java
import java.util.logging.Logger;

private static final Logger LOGGER = Logger.getLogger(CalculatorService.class.getName());
```

Then in each method, log the operation and result like:
```java
LOGGER.info("Performing addition: " + a + " + " + b);
int result = calculator.add(a, b);
LOGGER.info("Addition result: " + result);
```

### Level 3 (Near-Solution)
Ask Claude with this exact prompt:
```
Add logging to CalculatorService.java:
1. Import java.util.logging.Logger
2. Create a logger: private static final Logger LOGGER = Logger.getLogger(CalculatorService.class.getName());
3. In performAddition, log: "Performing addition: a + b" before calculation, and "Addition result: result" after
4. Add similar logging to all 5 methods
5. In performDivision, add error logging in the catch block
```

---

## Part 3: Running Tests

### Level 1 (Gentle Nudge)
Ask Claude to run the tests using Maven. The command is `mvn test`.

### Level 2 (Stronger Hint)
Prompt: "Run the tests using Maven to verify all fixes work"
Claude will execute: `mvn test`

### Level 3 (Near-Solution)
Type in Claude Code:
```
Run the tests: mvn test
```

All 8 tests should pass.

---

## Common Mistakes

### Mistake 1: Still dividing by 100 instead of 100.0
**Symptom:** Tests still fail
**Fix:** Make sure you use `100.0` not `100` to force floating-point division

### Mistake 2: Edit tool fails with "string not unique"
**Symptom:** Error: "The string to replace is not unique in the file"
**Fix:** Include more surrounding context in your old_string to make it unique

### Mistake 3: Forgot to import Logger
**Symptom:** Compilation error: "Cannot resolve symbol Logger"
**Fix:** Add `import java.util.logging.Logger;` at top of CalculatorService.java

### Mistake 4: Using System.out.println instead of Logger
**Symptom:** Works but doesn't follow best practices
**Fix:** Use `LOGGER.info()` not `System.out.println()`

---

## Quick Verification Checklist

Before moving to Challenge 2, verify:
- [ ] Calculator.percentage() multiplies before dividing
- [ ] Division is by 100.0 (not 100)
- [ ] Logger imported and instantiated
- [ ] All 5 methods in CalculatorService have logging
- [ ] Tests pass: `mvn test` shows "BUILD SUCCESS"
- [ ] PROGRESS.md updated with Challenge 1 complete

---

## Still Stuck?

If none of these hints help:
1. Check the full solution at `solutions/challenge-01/SOLUTION.md`
2. Ask facilitator for assistance
3. Pair with another participant

Remember: The goal is learning the Claude Code workflow, not just getting the right answer!
