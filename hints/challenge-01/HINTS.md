# Challenge 1 Hints: Calculator Service

## Progressive Hint System

Use these hints if you get stuck. Try to solve as much as possible before requesting hints!

---

## Part 1: Finding the Bug

### Hint Level 1 (Gentle Nudge)
The failing tests are related to percentage calculations. Look at what the test expects vs. what the method is currently returning. Pay attention to the order of operations in the calculation.

### Hint Level 2 (Stronger Hint)
The bug is in the `percentage()` method in Calculator.java. When you divide integers, Java performs integer division which truncates the decimal. The expression `(value / 100)` loses precision before the multiplication happens.

### Hint Level 3 (Near-Solution)
Change the calculation from `(value / 100) * percent` to `(value * percent) / 100.0`. By multiplying first, you preserve the precision, and dividing by 100.0 (not 100) ensures floating-point division.

**Exact fix needed:**
```java
public double percentage(int value, int percent) {
    return (value * percent) / 100.0;
}
```

---

## Part 2: Adding Logging

### Hint Level 1 (Gentle Nudge)
You need to import `java.util.logging.Logger` and create a logger instance for the CalculatorService class. Then add logging before and after each calculation.

### Hint Level 2 (Stronger Hint)
Add these at the top of the CalculatorService class:
```java
import java.util.logging.Logger;

private static final Logger LOGGER = Logger.getLogger(CalculatorService.class.getName());
```

Then in each method, log the operation being performed and the result. Use `LOGGER.info()` for normal operations and `LOGGER.severe()` for errors.

### Hint Level 3 (Near-Solution)
Here's the pattern for each method:

```java
public int performAddition(int a, int b) {
    LOGGER.info(String.format("Performing addition: %d + %d", a, b));
    int result = calculator.add(a, b);
    LOGGER.info(String.format("Addition result: %d", result));
    return result;
}
```

Apply this same pattern to all five methods in CalculatorService.

---

## Part 3: Running Tests

### Hint Level 1 (Gentle Nudge)
Use the Bash tool to run Maven tests. The command is `mvn test`.

### Hint Level 2 (Stronger Hint)
Ask Claude Code: "Run the tests using Maven to verify all fixes work."
Claude will use the Bash tool to execute: `mvn test`

### Hint Level 3 (Near-Solution)
Exact command to run:
```bash
mvn test
```

If `mvn` is not found, you may need to use the Maven wrapper:
```bash
./mvnw test
```

All 8 tests should pass after your fixes are complete.

---

## Common Mistakes to Avoid

1. **Dividing by 100 instead of 100.0**: This still causes integer division! Use 100.0
2. **Not including enough context in Edit tool**: If Edit fails saying "string not unique", include more surrounding lines
3. **Forgetting to import Logger**: Make sure to add `import java.util.logging.Logger;`
4. **Not using String.format**: While you can use string concatenation, String.format is cleaner

---

## Verification Checklist

- [ ] percentage() method multiplies before dividing
- [ ] Division is by 100.0 (not 100)
- [ ] Logger is imported and initialized
- [ ] All 5 methods in CalculatorService have logging
- [ ] Tests run and all 8 pass
- [ ] You understand why the bug occurred (integer division)

---

## Still Stuck?

Ask your facilitator for a live demonstration or refer to the complete solution guide in `/workshop-materials/solutions/challenge-01/`.

Remember: The goal is to learn the Claude Code workflow (Read → Edit → Bash), not just to get the right answer!
