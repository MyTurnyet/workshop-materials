# Strategy Card 15: Task-Based Design with Claude

## When to Use Task-Based Design

Use a task checklist when you're working on:

- **Complex features** with 3+ implementation steps
- **Multi-file changes** that affect several parts of the codebase
- **Refactoring work** where you need to track multiple improvements
- **Long-running tasks** that you might pause and resume
- **Team projects** where you need to document your plan

**Rule of thumb**: If it takes more than 5 minutes or touches multiple files, consider creating a checklist.

---

## The Basic Pattern

### 1. Create the Plan
Ask Claude to generate a task checklist:
```
"Please create a task checklist in TASKS.md for implementing [feature/refactoring]"
```

### 2. Review and Refine
- Read through the generated checklist
- Add missing tasks
- Remove unnecessary steps
- Reorganize if needed

### 3. Work Through Tasks Systematically
- Reference the checklist as you work
- Let Claude see the checklist (it provides context)
- Stay focused on the current task

### 4. Track Progress
Update completed tasks:
- Change `- [ ]` to `- [x]` when done
- Or ask Claude: "Mark task 3 as complete in TASKS.md"

### 5. Use /remember for Context
```
"/remember We've completed tasks 1-3 in TASKS.md. Next is implementing validation."
```

---

## Example Prompts

### Creating Checklists
```
"Please create a checklist in REFACTOR-TASKS.md for refactoring OrderService"

"Analyze the BookService requirements and create an implementation checklist in BOOK-PLAN.md"

"Let's plan this together - create a checklist for adding user authentication"

"Break down this feature into a task checklist with 5-8 concrete steps"
```

### Working with Checklists
```
"Following our checklist, let's start with task 1: creating the entity class"

"We've completed task 3. Mark it complete and move to task 4"

"This checklist is too detailed. Can you consolidate related tasks?"

"Add a new task between 2 and 3: 'Add input validation'"

"Update the checklist based on what we just learned"
```

### Resuming Work
```
"I'm back. Read TASKS.md - we completed tasks 1-4. Let's continue with task 5"

"What's our progress on the checklist? What's left to do?"
```

---

## Benefits of Task-Based Design

✅ **Clear roadmap** - Know exactly what needs to be done
✅ **Prevents scope creep** - Defined boundaries keep you focused
✅ **Easy progress tracking** - See what's done and what's left
✅ **Better context management** - Claude understands the full plan
✅ **Pause and resume easily** - Pick up where you left off
✅ **Creates documentation** - Record of implementation decisions
✅ **Reduces cognitive load** - Focus on one task at a time

---

## Checklist Format Best Practices

### Good Structure
Organize by phases or categories:

```markdown
# Feature Implementation Plan

## Setup
- [ ] Create entity class
- [ ] Create repository interface
- [ ] Set up test fixtures

## Core Implementation
- [ ] Implement create method
- [ ] Implement read method
- [ ] Implement update method
- [ ] Implement delete method

## Validation & Error Handling
- [ ] Add input validation
- [ ] Add error messages
- [ ] Handle edge cases

## Testing
- [ ] Write unit tests
- [ ] Test error cases
- [ ] Verify code coverage
- [ ] Run integration tests

## Final Steps
- [ ] Code review checklist
- [ ] Update documentation
- [ ] Run full test suite
```

### Task Granularity
- **Too vague**: "Implement the service" ❌
- **Too detailed**: "Add semicolon on line 42" ❌
- **Just right**: "Implement createBook method with validation" ✅

### Typical Checklist Size
- **Small feature**: 5-8 tasks
- **Medium feature**: 8-15 tasks
- **Large feature**: 15-25 tasks (or break into multiple checklists)

---

## Tips & Tricks

### Start Simple
Your first checklist doesn't need to be perfect. Start with high-level tasks and refine as you go.

### Iterate the Plan
It's okay to update the checklist mid-implementation:
- Add tasks you discover along the way
- Remove tasks that aren't needed
- Break down tasks that are too complex

### Combine with /remember
Use `/remember` to save important context about the checklist:
```
"/remember Our TASKS.md shows 8 tasks. Completed 1-5. Task 6 blocked pending API decision."
```

### Use Descriptive Filenames
- `REFACTOR-TASKS.md` - for refactoring work
- `FEATURE-PLAN.md` - for new features
- `BOOK-SERVICE-TASKS.md` - for specific service implementation
- `BUG-FIX-CHECKLIST.md` - for complex bug fixes

### Add Notes to Tasks
```markdown
- [ ] Implement validation
  - ISBN must be 13 digits
  - Price must be positive
  - Use regex for ISBN: ^\d{13}$
```

### Track Blockers
```markdown
- [x] Create entity class
- [x] Create repository
- [ ] Implement service (BLOCKED: waiting on database schema)
- [ ] Write tests
```

---

## Common Pitfalls to Avoid

❌ **Skipping checklist creation to "save time"**
  → Planning actually saves time by preventing false starts

❌ **Creating checklist but not following it**
  → The checklist is useless if you ignore it

❌ **Making checklist too rigid**
  → It's a guide, not a contract. Update as needed.

❌ **Overly detailed tasks**
  → Keep tasks actionable but not microscopic

❌ **Forgetting to update completion status**
  → Check off tasks as you go to track progress

---

## Real-World Applications

### In This Workshop
- **Challenge 5**: Claude generates refactoring checklist for OrderService
- **Challenge 6**: Full workflow for building BookService from scratch

### In Your Projects
- **New feature implementation**: Plan before coding
- **Legacy code refactoring**: Track improvements systematically
- **Bug investigation**: Create checklist of things to check
- **Code review prep**: Checklist of review criteria
- **Onboarding tasks**: Help new team members get started
- **Sprint planning**: Break down user stories into tasks

---

## Quick Reference

| Situation | Command |
|-----------|---------|
| Create checklist | `"Create a task checklist in TASKS.md for [feature]"` |
| Review progress | `"Show me what's left in TASKS.md"` |
| Mark complete | `"Mark task 3 as complete"` or manually change `[ ]` to `[x]` |
| Add task | `"Add a new task: 'Add validation' after task 2"` |
| Refine plan | `"This checklist is too detailed, consolidate tasks"` |
| Resume work | `"Read TASKS.md - let's continue where we left off"` |

---

## Remember

**Task-based design is a communication tool** - it helps you and Claude stay aligned on what you're building. Use it whenever you need clarity, focus, or the ability to pause and resume work.

Like any tool, it becomes more natural with practice. Start using it in Challenges 5 and 6, then bring it to your real projects!
