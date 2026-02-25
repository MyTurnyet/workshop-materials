# Challenge 5: Refactor OrderService - Context Management

**Duration:** 15 minutes
**Difficulty:** Advanced
**Project:** claude-code-workshop (same directory)

## Learning Objectives
- **Use task-based design** to plan refactoring work
- Manage Claude Code's context window effectively
- Use /remember command to save decisions
- Practice closing and resuming sessions
- Handle large refactoring tasks across sessions
- Document progress with task checklists

## Scenario

The platform has a messy OrderService (300+ lines) that violates many best practices. This refactoring is too large for one uninterrupted session, so you'll practice context management: breaking work into phases, using /remember, and resuming sessions.

## Your Mission

1. **Phase 1: Analysis** - Understand the code and plan refactoring
2. **Use /remember** - Save architectural decisions
3. **Phase 2: Extract Methods** - Break down long methods
4. **Close and Resume** - Practice session management
5. **Phase 3: Refactor** - Apply project rules
6. **Document** - Track progress

## Starting Point

You're in `claude-code-workshop/` with:
- `src/main/java/com/workshop/order/OrderService.java` (300+ lines, messy)
- Project rules in `.claude/rules.md`
- PROGRESS.md to track work

## Tasks

### Phase 1: Analysis and Planning (4 min)

**Step 1: Analyze the code (1 min)**

**Prompt to Claude:**
```
Read order/OrderService.java and identify all the problems. What responsibilities does this class have that should be separate?
```

Expected findings:
- 300+ lines (too long)
- Methods over 50 lines
- Multiple responsibilities
- Poor naming (calc, getHistory)
- Duplicate logic
- Missing proper validation

**Step 2: Create a task checklist (2 min)**

**Prompt to Claude:**
```
Based on your analysis, please create a refactoring task checklist in REFACTOR-TASKS.md. Include tasks for:
1. Analyzing current issues
2. Breaking down long methods
3. Renaming unclear methods
4. Adding documentation
5. Verification steps

Organize the checklist by phases.
```

Claude will generate a checklist similar to:
```markdown
# OrderService Refactoring Checklist

## Analysis
- [x] Identify all code smells and issues
- [x] Document current responsibilities

## Method Extraction
- [ ] Break down createOrder method (currently 60+ lines)
- [ ] Break down updateOrderStatus method
- [ ] Extract validation into separate methods

## Renaming
- [ ] Rename calc() to calculateCustomerTotal()
- [ ] Rename getHistory() to getCustomerOrderHistory()

## Documentation
- [ ] Add Javadoc to all public methods
- [ ] Ensure Javadoc includes @param and @return tags

## Verification
- [ ] Verify all methods under 20 lines
- [ ] Run mvn compile
- [ ] Check project rules compliance
```

Review the checklist and refine if needed.

**Step 3: Use /remember to save the plan (1 min)**

```
/remember Created REFACTOR-TASKS.md with refactoring checklist for OrderService

/remember OrderService has these problems: too long, methods >50 lines, multiple responsibilities (CRUD + validation + history tracking), poor naming

/remember Refactoring strategy from checklist: 1) Extract validation methods, 2) Rename unclear methods (calc → calculateCustomerTotal), 3) Break down createOrder and updateOrderStatus methods, 4) Follow project rules (methods <20 lines, add Javadoc)

/remember Keep OrderService focused on order management only. Validation should be inline but in separate methods.
```

### Phase 2: Extract and Refactor Methods (5 min)

**Following your checklist, prompt Claude:**
```
Let's work through our REFACTOR-TASKS.md checklist. Starting with the "Method Extraction" section:

1. Break the createOrder method into smaller methods (under 20 lines each)
2. Break the updateOrderStatus method into smaller methods
3. Extract validation into separate helper methods

Then handle "Renaming":
4. Rename calc() to calculateCustomerTotal()

Finally, complete "Documentation":
5. Add Javadoc to all public methods

Follow the rules in .claude/rules.md throughout.
```

**As you work, mark tasks complete:**
```
Claude, please mark the "Break down createOrder method" task as complete in REFACTOR-TASKS.md
```

Or manually edit REFACTOR-TASKS.md: change `- [ ]` to `- [x]` for completed items.

Expected changes:
- `createOrder()` split into: `validateOrder()`, `calculateTotal()`, `createNewOrder()`
- `updateOrderStatus()` simplified
- `calc()` renamed to `calculateCustomerTotal()`
- Javadoc added throughout
- All methods under 20 lines
- Checklist items marked as complete

### Phase 3: Close and Resume Session (1 min)

**Exit Claude Code:**
```
Ctrl+C or type: exit
```

**Update PROGRESS.md manually** with what you've accomplished.

**Restart Claude Code:**
```bash
claude code
```

**Provide context:**
```
I'm continuing the refactoring of OrderService. I've completed extracting methods and renaming. Now I need to verify all methods are under 20 lines and all public methods have Javadoc.
```

### Phase 4: Verify and Complete (4 min)

**Prompt to Claude:**
```
Read the refactored OrderService.java and verify:
1. All methods are under 20 lines
2. All public methods have Javadoc with @param and @return tags
3. No methods have duplicate logic
4. All naming is clear and follows conventions
```

**If issues found, ask Claude to fix them.**

### Phase 5: Final Documentation (1 min)

**Prompt to Claude:**
```
Update PROGRESS.md with a summary of the OrderService refactoring: what was done, how many lines reduced, what problems were fixed.
```

## Success Criteria

- [ ] **Created REFACTOR-TASKS.md checklist** with Claude's help
- [ ] Used /remember at least 3 times to save decisions
- [ ] **Followed checklist systematically** during refactoring
- [ ] **Marked completed tasks** in the checklist
- [ ] OrderService reduced from 300+ to ~200 lines
- [ ] All methods under 20 lines
- [ ] All public methods have Javadoc
- [ ] Closed and resumed session successfully
- [ ] Code compiles: `mvn compile`
- [ ] PROGRESS.md updated with refactoring summary
- [ ] Understand task-based design and context management workflow

## Strategy Cards

- **Card #15 - Task-Based Design:** Create and follow task checklists
- **Card #13 - Context Awareness:** Watch token usage
- **Card #14 - Session Memory:** Use /remember for decisions

## /remember Command Examples

```
/remember Created REFACTOR-TASKS.md with refactoring checklist - use this to track progress

/remember OrderService needs methods under 20 lines per project rules

/remember createOrder() should be split into: validateOrder, calculateTotal, createNewOrder

/remember Following checklist: completed method extraction tasks, now working on renaming

/remember Validation should throw IllegalArgumentException with clear messages

/remember All public methods need Javadoc with @param tags
```

## Hints

### Hint 1
Break large refactorings into clear phases: 1) Analyze, 2) Plan, 3) Execute, 4) Verify

### Hint 2
Use /remember for design decisions, not implementation details

### Hint 3
When resuming, read PROGRESS.md first, then provide a brief summary to Claude

## What's Next

After completing this challenge:
1. Verify OrderService compiles and follows rules
2. Update PROGRESS.md
3. Move to Challenge 6 (Capstone)

**Challenge 6** will build a complete BookService API from scratch, integrating all learned skills.

## Benefits of Context Management

### Real-World Application
- Large features take multiple days
- Work gets interrupted
- Need to context-switch between tasks
- /remember helps maintain consistency
- Documentation preserves decisions

### Skills Practiced
- **Creating and following task checklists**
- **Task-based design for complex refactoring**
- Breaking work into phases
- Documenting progress
- Using /remember effectively
- Resuming work smoothly
- Managing complex refactorings

## Refactoring Checklist

Use this to track your refactoring:

**Before:**
- [ ] 300+ lines
- [ ] Methods over 50 lines
- [ ] Poor naming (calc, getHistory)
- [ ] Missing Javadoc
- [ ] Duplicate logic

**After:**
- [ ] ~200 lines
- [ ] All methods under 20 lines
- [ ] Clear naming (calculateCustomerTotal)
- [ ] Complete Javadoc
- [ ] No duplication
- [ ] Follows project rules
