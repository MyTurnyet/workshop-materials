# Challenge 2 Solution: Inventory System Rules

## Overview

This solution demonstrates how to create project-specific rules and use them to refactor code systematically.

## Step 1: Create .claude Directory (1 minute)

**Prompt to Claude:**
```
Create a .claude directory in the project root.
```

**Claude Code will:**
1. Use Bash tool: `mkdir -p .claude`

## Step 2: Create rules.md with Team Standards (2 minutes)

**Prompt to Claude:**
```
Create .claude/rules.md with the following team coding standards:
- All methods must be under 20 lines
- All public methods must have Javadoc with @param and @return tags
- No public fields - use private with getters/setters
- Follow Google Java Style Guide naming conventions
- Use constructor injection for dependencies
- No System.out.println - use proper logging
- Validate all inputs in public methods
```

**Claude Code will:**
1. Use Write tool to create `.claude/rules.md`

**Expected Content:**
```markdown
# Project Coding Standards

## Method Length
- All methods must be under 20 lines of code
- If a method exceeds 20 lines, extract helper methods
- Break complex logic into smaller, focused methods

## Documentation
- All public methods must have Javadoc comments
- Include @param tags for all parameters
- Include @return tag for non-void methods
- Describe what the method does, not how it does it

## Encapsulation
- No public fields
- All fields must be private
- Provide public getters/setters only when needed
- Validate inputs in setters

## Naming Conventions
- Follow Google Java Style Guide
- Use clear, descriptive method names
- No abbreviations (calc → calculateTotalValue, getAll → getAllItems)
- Boolean methods should start with is/has/can
- Getters start with get, setters start with set

## Dependency Injection
- Use constructor injection for required dependencies
- Avoid field injection
- Make dependencies final where possible

## Logging
- Never use System.out.println
- Use java.util.logging.Logger or SLF4J
- Log at appropriate levels (INFO, WARNING, SEVERE)

## Validation
- Validate all inputs in public methods
- Throw IllegalArgumentException for invalid inputs
- Provide meaningful error messages

## Single Responsibility
- Each method should do one thing well
- Extract helper methods for complex operations
- Keep classes focused on a single concern
```

## Step 3: Refactor InventoryManager Using Rules (5 minutes)

**Prompt to Claude:**
```
Read InventoryManager.java and refactor it to follow all the rules in .claude/rules.md. Pay special attention to:
1. Breaking long methods into smaller ones (under 20 lines each)
2. Adding Javadoc to all public methods
3. Making fields private with proper accessors
4. Renaming unclear methods (calc, getAll)
5. Replacing System.out.println with proper logging
```

**Claude Code will:**
1. Read `src/main/java/com/workshop/InventoryManager.java`
2. Read `.claude/rules.md` to understand constraints
3. Use Edit tool multiple times to refactor the class

**Key Refactorings:**

### A. Add Logger and Make Fields Private

```java
import java.util.logging.Logger;

public class InventoryManager {
    private static final Logger LOGGER = Logger.getLogger(InventoryManager.class.getName());

    private List<String> items = new ArrayList<>();
    private Map<String, Integer> quantities = new HashMap<>();
    private Map<String, Double> prices = new HashMap<>();
    private String warehouseLocation;
    private boolean isInitialized = false;
```

### B. Break Down Long Methods

**Before (40+ lines):**
```java
public void addItem(String itemName, int quantity, double price) {
    // 40+ lines of validation, updates, and logging
}
```

**After (under 20 lines each):**
```java
/**
 * Adds an item to the inventory or updates existing item quantity.
 * @param itemName the name of the item
 * @param quantity the quantity to add
 * @param price the price per unit
 * @throws IllegalArgumentException if inputs are invalid
 */
public void addItem(String itemName, int quantity, double price) {
    validateItemInputs(itemName, quantity, price);

    if (itemExists(itemName)) {
        updateExistingItem(itemName, quantity, price);
    } else {
        addNewItem(itemName, quantity, price);
    }

    logTransaction("ADD", itemName, quantity, price);
}

private void validateItemInputs(String itemName, int quantity, double price) {
    if (itemName == null || itemName.trim().isEmpty()) {
        throw new IllegalArgumentException("Item name cannot be empty");
    }
    if (quantity < 0) {
        throw new IllegalArgumentException("Quantity cannot be negative");
    }
    if (price < 0) {
        throw new IllegalArgumentException("Price cannot be negative");
    }
}

private boolean itemExists(String itemName) {
    return items.contains(itemName);
}

private void updateExistingItem(String itemName, int quantity, double price) {
    int currentQty = quantities.get(itemName);
    int newQty = currentQty + quantity;
    quantities.put(itemName, newQty);

    LOGGER.info(String.format("Updated %s: %d → %d units", itemName, currentQty, newQty));

    updatePriceIfChanged(itemName, price);
}

private void updatePriceIfChanged(String itemName, double newPrice) {
    double currentPrice = prices.get(itemName);
    if (Math.abs(currentPrice - newPrice) > 0.01) {
        prices.put(itemName, newPrice);
        LOGGER.info(String.format("Price updated for %s: $%.2f → $%.2f",
            itemName, currentPrice, newPrice));
    }
}

private void addNewItem(String itemName, int quantity, double price) {
    items.add(itemName);
    quantities.put(itemName, quantity);
    prices.put(itemName, price);
    LOGGER.info(String.format("Added new item: %s (Qty: %d, Price: $%.2f)",
        itemName, quantity, price));
}
```

### C. Rename Unclear Methods

```java
// Before
public double calc(String itemName) { ... }
public List<String> getAll() { ... }

// After with Javadoc
/**
 * Calculates the total value of a specific item in inventory.
 * @param itemName the name of the item
 * @return the total value (quantity × price), or 0.0 if item not found
 */
public double calculateTotalValue(String itemName) {
    if (!itemExists(itemName)) {
        return 0.0;
    }
    return quantities.get(itemName) * prices.get(itemName);
}

/**
 * Retrieves all item names in the inventory.
 * @return a list of all item names
 */
public List<String> getAllItems() {
    return new ArrayList<>(items);
}
```

### D. Add Proper Getters/Setters with Validation

```java
/**
 * Gets the warehouse location.
 * @return the warehouse location
 */
public String getWarehouseLocation() {
    return warehouseLocation;
}

/**
 * Sets the warehouse location.
 * @param location the new warehouse location
 * @throws IllegalArgumentException if location is null or empty
 */
public void setWarehouseLocation(String location) {
    if (location == null || location.trim().isEmpty()) {
        throw new IllegalArgumentException("Warehouse location cannot be empty");
    }
    this.warehouseLocation = location;
    LOGGER.info("Warehouse location updated to: " + location);
}
```

## Step 4: Verify Refactoring (2 minutes)

**Prompt to Claude:**
```
Read the refactored InventoryManager.java and verify that all methods are under 20 lines and all public methods have Javadoc.
```

**Claude Code will:**
1. Read the refactored file
2. Count lines in each method
3. Check for Javadoc on public methods
4. Report compliance with rules

**Verification Checklist:**
- ✅ All methods under 20 lines
- ✅ All public methods have Javadoc
- ✅ All fields are private
- ✅ Clear method names (no abbreviations)
- ✅ Logger used instead of System.out.println
- ✅ Input validation in public methods
- ✅ Code still compiles

## Step 5: Compile to Ensure No Errors (Optional)

**Prompt to Claude:**
```
Compile the project to ensure the refactored code has no syntax errors.
```

**Claude Code will:**
1. Use Bash tool: `mvn compile`

**Expected Output:**
```
[INFO] BUILD SUCCESS
```

## Key Learning Points

### 1. Rules Apply Automatically
Once `.claude/rules.md` exists, Claude Code will follow those rules in ALL interactions for this project.

### 2. Rules Make Refactoring Consistent
Instead of manually specifying standards each time, rules ensure consistency across all changes.

### 3. Rules Can Be Updated
You can modify `.claude/rules.md` anytime to adjust standards.

### 4. Rules Work with All Tools
Whether using Edit, Write, or any other tool, Claude respects project rules.

## Common Issues & Troubleshooting

### Issue 1: "Refactoring too aggressive"
**Solution:** Add more specific constraints in rules.md about what NOT to change.

### Issue 2: "Methods still over 20 lines"
**Solution:** Ask Claude to recount and extract more helper methods.

### Issue 3: "Compilation errors after refactoring"
**Solution:** Ask Claude to read error output and fix issues.

## Time Breakdown

- **1 min:** Create .claude directory
- **2 min:** Write rules.md with team standards
- **5 min:** Refactor InventoryManager following rules
- **2 min:** Verify and compile

**Total: 10 minutes**

## Next Challenge

Proceed to Challenge 3: Skills and Custom Commands where you'll create reusable skill templates.
