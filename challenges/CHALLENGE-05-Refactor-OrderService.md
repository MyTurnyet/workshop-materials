# Challenge 5: Refactor OrderService - Context Management

**Duration:** 15 minutes
**Difficulty:** Advanced
**Project:** claude-code-workshop (same directory)

## Learning Objectives
- Manage Claude Code's context window effectively
- Use /remember command to save decisions
- Practice closing and resuming sessions
- Handle large refactoring tasks across sessions
- Document progress

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

**Use /remember to save the plan:**
```
/remember OrderService has these problems: too long, methods >50 lines, multiple responsibilities (CRUD + validation + history tracking), poor naming

/remember Refactoring strategy: 1) Extract validation methods, 2) Rename unclear methods (calc → calculateCustomerTotal), 3) Break down createOrder and updateOrderStatus methods, 4) Follow project rules (methods <20 lines, add Javadoc)

/remember Keep OrderService focused on order management only. Validation should be inline but in separate methods.
```

### Phase 2: Extract and Refactor Methods (5 min)

**Prompt to Claude:**
```
Refactor OrderService.java to follow the rules in .claude/rules.md:
1. Break the createOrder method into smaller methods (under 20 lines each)
2. Break the updateOrderStatus method into smaller methods
3. Rename calc() to calculateCustomerTotal()
4. Add Javadoc to all public methods
5. Extract validation into separate helper methods
```

Expected changes:
- `createOrder()` split into: `validateOrder()`, `calculateTotal()`, `createNewOrder()`
- `updateOrderStatus()` simplified
- `calc()` renamed to `calculateCustomerTotal()`
- Javadoc added throughout
- All methods under 20 lines

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

- [ ] Used /remember at least 3 times to save decisions
- [ ] OrderService reduced from 300+ to ~200 lines
- [ ] All methods under 20 lines
- [ ] All public methods have Javadoc
- [ ] Closed and resumed session successfully
- [ ] Code compiles: `mvn compile`
- [ ] PROGRESS.md updated with refactoring summary
- [ ] Understand context management workflow

## Strategy Cards

- **Card #13 - Context Awareness:** Watch token usage
- **Card #14 - Session Memory:** Use /remember for decisions
- **Card #15 - Resuming Work:** Provide brief summary when reopening

## /remember Command Examples

```
/remember OrderService needs methods under 20 lines per project rules

/remember createOrder() should be split into: validateOrder, calculateTotal, createNewOrder

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
