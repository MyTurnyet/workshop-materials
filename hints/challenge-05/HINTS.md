# Challenge 5: Refactor OrderService - Hints

## Three-Level Hint System

Use these hints progressively if you get stuck. Try Level 1 first, then Level 2 if still stuck, and Level 3 as a last resort.

---

## Level 1: Gentle Nudges (Use after 5 minutes if stuck)

### Hint 1.1: Starting with Task-Based Design
If you're unsure how to begin:
- Start by asking Claude to analyze OrderService.java
- Then ask Claude to create a refactoring checklist in REFACTOR-TASKS.md
- The checklist should have phases: Analysis, Method Extraction, Renaming, Logging, Documentation, Verification
- Don't start coding until you have the checklist

**Example prompt:**
```
"Based on your analysis of OrderService, create a refactoring checklist in REFACTOR-TASKS.md with phases for: method extraction, renaming, logging, documentation, and verification."
```

### Hint 1.2: Following the Checklist
If you created the checklist but aren't sure how to use it:
- Work through the checklist section by section
- Reference the checklist in your prompts: "Following the Method Extraction section of our checklist..."
- Mark tasks complete as you go (change `- [ ]` to `- [x]`)
- Use /remember to save progress on the checklist

### Hint 1.3: Method Extraction
If you're stuck on breaking down methods:
- Look for natural "chunks" of logic in long methods
- Validation logic → separate validateXXX() method
- Calculation logic → separate calculateXXX() method
- Creation logic → separate createXXX() method
- Each extracted method should have a single, clear purpose

### Hint 1.4: Using /remember
If you're not sure what to save with /remember:
- Save that you created the checklist
- Save the overall refactoring strategy
- Save what sections of the checklist you've completed
- Don't save implementation details, save decisions and progress

---

## Level 2: Stronger Hints (Use after 10 minutes if still stuck)

### Hint 2.1: Complete Checklist Example
Your REFACTOR-TASKS.md should look something like this:

```markdown
# OrderService Refactoring Checklist

## Analysis
- [x] Read and analyze OrderService.java
- [x] Identify code smells
- [x] Create this checklist

## Method Extraction
- [ ] Break down createOrder (extract validateOrderInputs, calculateOrderTotal, createNewOrder)
- [ ] Break down updateOrderStatus (extract validateStatusUpdate)
- [ ] Ensure all methods under 20 lines

## Renaming
- [ ] calc() → calculateCustomerTotal()
- [ ] getHistory() → getCustomerHistory()

## Logging
- [ ] Add Logger import and instance
- [ ] Replace System.out.println with LOGGER.info()

## Documentation
- [ ] Add Javadoc to all public methods with @param and @return

## Verification
- [ ] All methods under 20 lines
- [ ] Run mvn compile
- [ ] Update PROGRESS.md
```

### Hint 2.2: createOrder Method Breakdown
The createOrder method (50+ lines) should be broken into:

1. **validateOrderInputs()** - Check all parameters are valid
   - Customer ID, name, email validation
   - Items list validation
   - Each should throw IllegalArgumentException with clear message

2. **calculateOrderTotal()** - Calculate total from items
   - Loop through items
   - Validate each item (quantity > 0, price >= 0)
   - Sum up total

3. **createNewOrder()** - Construct and store the Order object
   - Create Order instance
   - Set all fields
   - Add to orders map
   - Return order

4. **Main createOrder()** - Orchestrate (under 10 lines)
   ```java
   validateOrderInputs(customerId, customerName, customerEmail, items);
   double total = calculateOrderTotal(items);
   Order order = createNewOrder(customerId, customerName, customerEmail, items, total);
   updateOrderHistory(customerId, "Order " + order.getOrderId() + " created");
   totalOrdersCreated++;
   return order;
   ```

### Hint 2.3: Logging Implementation
To add proper logging:

1. Add import:
   ```java
   import java.util.logging.Logger;
   ```

2. Add logger instance (class level):
   ```java
   private static final Logger LOGGER = Logger.getLogger(OrderService.class.getName());
   ```

3. Replace all `System.out.println("message")` with:
   ```java
   LOGGER.info("message");
   ```

### Hint 2.4: Context Management During Session Resume
When you resume Claude Code after closing:

1. First prompt should summarize what's done:
   ```
   "I'm continuing OrderService refactoring from Challenge 5. Completed: method extraction, renaming, and logging. Now need to verify all methods are under 20 lines and have Javadoc."
   ```

2. Reference your checklist:
   ```
   "Read REFACTOR-TASKS.md to see what's been completed. We're now on the Verification section."
   ```

---

## Level 3: Near-Solution (Use after 15 minutes or as last resort)

### Hint 3.1: Complete Workflow with Checklist

**Phase 1: Create Checklist (2 min)**
```
"Read order/OrderService.java and identify all problems."

"Create a refactoring checklist in REFACTOR-TASKS.md with sections: Analysis (done), Method Extraction, Renaming, Logging, Documentation, Verification. Include specific tasks for each section."

"/remember Created REFACTOR-TASKS.md with refactoring plan"
"/remember OrderService problems: 300+ lines, methods >50 lines, poor naming"
"/remember Strategy: extract methods, rename, add logging, add Javadoc"
```

**Phase 2: Execute Refactoring (5 min)**
```
"Following our REFACTOR-TASKS.md 'Method Extraction' section: Break down createOrder method into validateOrderInputs(), calculateOrderTotal(), and createNewOrder(). Keep main createOrder under 20 lines."

"Mark the createOrder extraction tasks complete in REFACTOR-TASKS.md."

"Following the 'Renaming' section: Rename calc() to calculateCustomerTotal() and getHistory() to getCustomerHistory(). Mark these tasks complete."

"Following the 'Logging' section: Add Logger and replace all System.out.println. Mark logging tasks complete."
```

**Phase 3: Close and Resume (1 min)**
```
[Exit Claude Code with Ctrl+C]
[Restart: claude code]

"Continuing OrderService refactoring. Read REFACTOR-TASKS.md. We completed Method Extraction, Renaming, and Logging sections. Now working on Documentation section - need to add Javadoc to all public methods."
```

**Phase 4: Verify (3 min)**
```
"Following our REFACTOR-TASKS.md 'Documentation' section: Add Javadoc to all public methods with @param and @return tags."

"Read OrderService.java and verify all methods are under 20 lines. Report any that aren't."

"Run mvn compile to verify no errors."

"Mark all Verification tasks complete in REFACTOR-TASKS.md."

"Update PROGRESS.md: Challenge 5 complete. OrderService reduced from 300+ to ~220 lines, all methods under 20 lines, proper logging and Javadoc added."
```

### Hint 3.2: Exact Method Extraction for createOrder

**Before:**
```java
public Order createOrder(Long customerId, String customerName, String customerEmail,
                        List<OrderItem> items) throws Exception {
    // 50+ lines of validation, calculation, creation
}
```

**After:**
```java
public Order createOrder(Long customerId, String customerName, String customerEmail,
                        List<OrderItem> items) throws Exception {
    validateOrderInputs(customerId, customerName, customerEmail, items);
    double total = calculateOrderTotal(items);
    Order order = createNewOrder(customerId, customerName, customerEmail, items, total);
    updateOrderHistory(customerId, "Order " + order.getOrderId() + " created");
    totalOrdersCreated++;
    return order;
}

private void validateOrderInputs(Long customerId, String customerName, String customerEmail, List<OrderItem> items) {
    if (customerId == null || customerId <= 0) {
        throw new IllegalArgumentException("Customer ID must be positive");
    }
    if (customerName == null || customerName.trim().isEmpty()) {
        throw new IllegalArgumentException("Customer name required");
    }
    if (customerEmail == null || !customerEmail.contains("@")) {
        throw new IllegalArgumentException("Valid email required");
    }
    if (items == null || items.isEmpty()) {
        throw new IllegalArgumentException("Order must have items");
    }
}

private double calculateOrderTotal(List<OrderItem> items) {
    double total = 0.0;
    for (OrderItem item : items) {
        if (item.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (item.getPrice() < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        total += item.getQuantity() * item.getPrice();
    }
    if (total < 0.01) {
        throw new IllegalArgumentException("Total must be at least 0.01");
    }
    return total;
}

private Order createNewOrder(Long customerId, String customerName, String customerEmail,
                            List<OrderItem> items, double total) {
    Order order = new Order();
    order.setOrderId(nextOrderId++);
    order.setCustomerId(customerId);
    order.setCustomerName(customerName);
    order.setCustomerEmail(customerEmail);
    order.setItems(new ArrayList<>(items));
    order.setTotal(total);
    order.setStatus("PENDING");
    order.setCreatedAt(new Date());
    orders.put(order.getOrderId(), order);
    return order;
}
```

### Hint 3.3: /remember Commands to Use

Copy and paste these /remember commands:

```
/remember Created REFACTOR-TASKS.md checklist with 6 phases: Analysis, Method Extraction, Renaming, Logging, Documentation, Verification

/remember OrderService has 300+ lines, methods over 50 lines, poor naming (calc, getHistory), missing Javadoc

/remember Refactoring strategy: Extract methods to get under 20 lines, rename for clarity, add proper logging, add Javadoc to all public methods

/remember Completed Method Extraction phase - createOrder and updateOrderStatus broken down. Now working on Renaming phase.

/remember Completed Renaming and Logging phases. Moving to Documentation phase - adding Javadoc.

/remember All phases complete per REFACTOR-TASKS.md. OrderService now ~220 lines, all methods under 20 lines, proper logging and Javadoc.
```

---

## Common Issues & Solutions

### Issue: "I created the checklist but Claude isn't following it"
**Solution:** Explicitly reference the checklist in your prompts:
```
"Following the [section name] of our REFACTOR-TASKS.md checklist, [specific task]"
```

### Issue: "I forgot to mark tasks complete"
**Solution:** Ask Claude to do it:
```
"Please mark all tasks in the 'Method Extraction' section as complete in REFACTOR-TASKS.md"
```

Or edit manually: change `- [ ]` to `- [x]`

### Issue: "Methods are still over 20 lines"
**Solution:** Extract more helpers. Look for any logical chunk that can be named and extracted.

### Issue: "Lost context after resuming session"
**Solution:**
1. Read REFACTOR-TASKS.md first
2. Provide clear summary of what's done
3. Tell Claude what section you're working on now

### Issue: "Not sure if I'm done"
**Solution:** Check your REFACTOR-TASKS.md. All tasks should be marked `[x]`. Then verify:
- Run `mvn compile` (should succeed)
- All methods under 20 lines
- All public methods have Javadoc
- PROGRESS.md updated

---

## Quick Reference: Task-Based Design Commands

**Create checklist:**
```
"Create a refactoring checklist in REFACTOR-TASKS.md for OrderService"
```

**Reference checklist:**
```
"Following our REFACTOR-TASKS.md, let's work on [section name]"
```

**Mark tasks complete:**
```
"Mark the [task name] as complete in REFACTOR-TASKS.md"
```

**Check progress:**
```
"Read REFACTOR-TASKS.md and tell me what's left to do"
```

**Use with /remember:**
```
"/remember Created REFACTOR-TASKS.md with refactoring plan"
"/remember Completed [section name] per checklist"
```

---

## Success Checklist

Before moving to Challenge 6, verify:
- [x] Created REFACTOR-TASKS.md checklist
- [x] Followed checklist systematically
- [x] Marked tasks complete as finished
- [x] Used /remember at least 3 times
- [x] Closed and resumed Claude Code session
- [x] OrderService reduced to ~220 lines
- [x] All methods under 20 lines
- [x] All public methods have Javadoc
- [x] Proper logging with Logger
- [x] Code compiles (mvn compile)
- [x] PROGRESS.md updated

If all checked, you're ready for Challenge 6!
