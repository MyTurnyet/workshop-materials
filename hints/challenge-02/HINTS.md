# Challenge 2 Hints: Inventory System Rules

## Progressive Hint System

---

## Part 1: Creating Rules File

### Hint Level 1 (Gentle Nudge)
You need to create a `.claude` directory first, then add a `rules.md` file inside it. This file will contain your team's coding standards in markdown format.

### Hint Level 2 (Stronger Hint)
Ask Claude Code: "Create a .claude directory and then create a rules.md file with coding standards including: methods under 20 lines, Javadoc on public methods, private fields, Google Java naming, and no System.out.println."

### Hint Level 3 (Near-Solution)
Exact commands to run:
```bash
mkdir -p .claude
```

Then create `.claude/rules.md` with content like:
```markdown
# Project Coding Standards

## Method Length
- All methods must be under 20 lines

## Documentation
- All public methods must have Javadoc with @param and @return tags

## Encapsulation
- No public fields
- Use private with getters/setters

## Naming
- Follow Google Java Style Guide
- No abbreviations

## Logging
- Use java.util.logging.Logger
- No System.out.println
```

---

## Part 2: Applying Rules to Refactor

### Hint Level 1 (Gentle Nudge)
Once rules.md exists, Claude Code will automatically follow those rules. Ask it to read InventoryManager.java and refactor it according to the rules. Focus on the longest methods first (like addItem and removeItem).

### Hint Level 2 (Stronger Hint)
The key refactorings needed:
1. Break long methods (addItem, removeItem, printInventoryReport) into smaller helpers
2. Add Javadoc to all public methods
3. Change public fields to private
4. Rename unclear methods (calc → calculateTotalValue)
5. Replace System.out.println with Logger statements

### Hint Level 3 (Near-Solution)
Ask Claude Code with this prompt:

```
Read InventoryManager.java and refactor it following the rules in .claude/rules.md.

Specifically:
1. Break the addItem method into smaller methods (validateItemInputs, updateExistingItem, addNewItem)
2. Break the removeItem method into smaller methods
3. Add Javadoc to all public methods
4. Change public fields to private
5. Rename calc() to calculateTotalValue()
6. Rename getAll() to getAllItems()
7. Replace all System.out.println with Logger statements
8. Add a Logger field: private static final Logger LOGGER = Logger.getLogger(InventoryManager.class.getName());
```

---

## Part 3: Common Refactoring Patterns

### Breaking Down Long Methods

**Pattern: Extract Validation**
```java
// Instead of validation inside the main method:
public void addItem(String itemName, int qty, double price) {
    if (itemName == null || itemName.trim().isEmpty()) { ... }
    if (qty < 0) { ... }
    // ... rest of logic
}

// Extract to helper:
public void addItem(String itemName, int qty, double price) {
    validateItemInputs(itemName, qty, price);
    // ... rest of logic
}

private void validateItemInputs(String name, int qty, double price) {
    // All validation here
}
```

**Pattern: Extract Conditional Branches**
```java
// Instead of big if-else in one method:
if (itemExists(itemName)) {
    // 15 lines of update logic
} else {
    // 10 lines of add logic
}

// Extract to separate methods:
if (itemExists(itemName)) {
    updateExistingItem(itemName, quantity, price);
} else {
    addNewItem(itemName, quantity, price);
}
```

---

## Part 4: Verification

### Hint Level 1 (Gentle Nudge)
After refactoring, ask Claude to verify that all methods are under 20 lines and all public methods have Javadoc. You can also compile the code to check for errors.

### Hint Level 2 (Stronger Hint)
Verification prompts:
```
1. "Read the refactored InventoryManager and count lines in each method. Report any over 20 lines."
2. "Check that all public methods have Javadoc comments."
3. "Compile the project: mvn compile"
```

### Hint Level 3 (Near-Solution)
Complete verification checklist:

```
Ask Claude to verify:
1. All methods < 20 lines
2. All public methods have Javadoc with @param and @return
3. All fields are private
4. No System.out.println remains
5. Logger is used instead
6. No public fields (except constants)
7. All methods have clear names
8. Code compiles: mvn compile
```

---

## Common Mistakes to Avoid

1. **Rules too vague:** "Keep methods small" vs "Methods under 20 lines"
2. **Forgetting to create .claude directory first:** Must exist before rules.md
3. **Not being specific enough in refactoring request:** Tell Claude exactly what to do
4. **Not verifying after refactoring:** Always check that rules are followed
5. **Breaking functionality:** Run tests if available to ensure behavior unchanged

---

## Example: Method Breakdown

**Before (40 lines):**
```java
public void addItem(String itemName, int quantity, double price) {
    // Validation (10 lines)
    // Check if exists (5 lines)
    // Update existing (10 lines)
    // Add new (10 lines)
    // Logging (5 lines)
}
```

**After (multiple methods, each < 20 lines):**
```java
public void addItem(String itemName, int quantity, double price) {
    validateItemInputs(itemName, quantity, price);
    if (itemExists(itemName)) {
        updateExistingItem(itemName, quantity, price);
    } else {
        addNewItem(itemName, quantity, price);
    }
    logTransaction("ADD", itemName, quantity, price);
} // 8 lines

private void validateItemInputs(...) { ... } // 10 lines
private boolean itemExists(...) { ... } // 3 lines
private void updateExistingItem(...) { ... } // 12 lines
private void addNewItem(...) { ... } // 8 lines
```

---

## Verification Checklist

After refactoring, ensure:
- [ ] `.claude/rules.md` exists with complete standards
- [ ] All methods in InventoryManager < 20 lines
- [ ] All public methods have Javadoc
- [ ] All fields are private
- [ ] Logger replaces System.out.println
- [ ] Clear method names (no abbreviations)
- [ ] Code compiles: `mvn compile`

---

## Still Stuck?

Refer to the complete solution guide at `/workshop-materials/solutions/challenge-02/` or ask your facilitator for a demonstration.
