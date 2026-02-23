# Challenge 1 Solution: Calculator Service

## Overview

This solution guide provides step-by-step instructions for completing Challenge 1 using Claude Code CLI.

## Step 1: Read the Failing Test (2 minutes)

**Prompt to Claude:**
```
Read the test file to show me which tests are failing and why.
```

**Claude Code will:**
1. Use Read tool on `src/test/java/com/workshop/CalculatorTest.java`
2. Identify the failing tests: `testPercentageCalculation` and `testPercentageWithLargeNumbers`
3. Explain what's expected vs. what's actually happening

**Expected Output:**
Claude will explain that the tests expect:
- 20% of 150 = 30.0 (not 0.0)
- 10% of 20000 = 2000.0 (not 0.0)

## Step 2: Identify the Bug (3 minutes)

**Prompt to Claude:**
```
Read Calculator.java and identify the bug in the percentage method.
```

**Claude Code will:**
1. Use Read tool on `src/main/java/com/workshop/Calculator.java`
2. Locate the `percentage()` method
3. Identify the bug: `(value / 100) * percent`

**Bug Explanation:**
The issue is **integer division before multiplication**:
```java
public double percentage(int value, int percent) {
    return (value / 100) * percent;  // BUG: value/100 does integer division first
}
```

When `value / 100` is evaluated with integers:
- `150 / 100` = 1 (integer division, not 1.5)
- `1 * 20` = 20 (wrong!)

Should be:
- `150 * 20 / 100.0` = 30.0 (correct)

## Step 3: Fix the Percentage Bug (3 minutes)

**Prompt to Claude:**
```
Fix the percentage calculation bug. The issue is that integer division happens before multiplication, losing precision. Change the calculation to multiply first, then divide by 100.0.
```

**Claude Code will:**
1. Use Edit tool to fix Calculator.java:52-54

**Correct Implementation:**
```java
public double percentage(int value, int percent) {
    // Fixed: Multiply first, then divide by 100.0 to preserve precision
    return (value * percent) / 100.0;
}
```

**Alternative Fix (also acceptable):**
```java
public double percentage(int value, int percent) {
    return (value * percent) / 100.0;
}
```

## Step 4: Add Logging to CalculatorService (7 minutes)

**Prompt to Claude:**
```
Add logging to all methods in CalculatorService.java. Use java.util.logging.Logger. Log the operation being performed and the result for each method.
```

**Claude Code will:**
1. Use Read tool on `src/main/java/com/workshop/CalculatorService.java`
2. Use Edit tool to add logging import and logger field
3. Use Edit tool to add logging statements to each method

**Expected Changes:**

Add import and logger:
```java
import java.util.logging.Logger;

public class CalculatorService {
    private static final Logger LOGGER = Logger.getLogger(CalculatorService.class.getName());
    private final Calculator calculator;
```

Add logging to performAddition:
```java
public int performAddition(int a, int b) {
    LOGGER.info(String.format("Performing addition: %d + %d", a, b));
    int result = calculator.add(a, b);
    LOGGER.info(String.format("Addition result: %d", result));
    return result;
}
```

Similar changes for all other methods (performSubtraction, performMultiplication, performDivision, performPercentageCalculation).

For performDivision, also add error logging:
```java
public int performDivision(int a, int b) {
    LOGGER.info(String.format("Performing division: %d / %d", a, b));
    try {
        int result = calculator.divide(a, b);
        LOGGER.info(String.format("Division result: %d", result));
        return result;
    } catch (IllegalArgumentException e) {
        LOGGER.severe(String.format("Division error: %s", e.getMessage()));
        throw e;
    }
}
```

## Step 5: Run Tests to Verify (5 minutes)

**Prompt to Claude:**
```
Run the tests using Maven to verify all fixes work correctly.
```

**Claude Code will:**
1. Use Bash tool to run: `mvn test`

**Expected Output:**
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.workshop.CalculatorTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

All tests should now pass!

## Alternative: Run Main to See Logging

**Prompt to Claude:**
```
Run the Main class to see the logging output in action.
```

**Claude Code will:**
1. Use Bash tool to run: `mvn compile exec:java`

**Expected Output:**
```
INFO: Performing addition: 10 + 5
INFO: Addition result: 15
Calculator Service Demo
=======================
10 + 5 = 15
INFO: Performing subtraction: 10 - 5
INFO: Subtraction result: 5
10 - 5 = 5
... (more output with logging)
```

## Common Issues & Troubleshooting

### Issue 1: "Edit failed - string not unique"
**Solution:** Provide more context in the old_string to make it unique. Include surrounding lines.

### Issue 2: Tests still failing after fix
**Solution:** Make sure you're multiplying before dividing, and dividing by 100.0 (not 100).

### Issue 3: Maven command not found
**Solution:** Use `./mvnw test` instead of `mvn test` if mvnw wrapper is present.

## Learning Outcomes

After completing this challenge, you should understand:

1. **Read Tool:** How to use Read to view file contents and understand code
2. **Edit Tool:** How to use Edit with exact string matching to modify code
3. **Bash Tool:** How to run commands like `mvn test` to verify changes
4. **Basic Workflow:** The pattern of Read → Understand → Edit → Verify

## Time Breakdown

- **2 min:** Read failing tests
- **3 min:** Identify bug in Calculator.java
- **3 min:** Fix percentage calculation bug
- **7 min:** Add logging to all CalculatorService methods
- **5 min:** Run tests and verify fixes

**Total: 20 minutes**

## Next Challenge

Proceed to Challenge 2: Rules and Project Configuration where you'll learn how to configure Claude Code to follow team coding standards.
