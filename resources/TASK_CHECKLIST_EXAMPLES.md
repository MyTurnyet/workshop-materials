# Task Checklist Examples
## Reference Material for Workshop Participants

This document provides example task checklists for common development scenarios. Use these as templates when creating your own checklists with Claude.

---

## Table of Contents
1. [Simple Bug Fix Checklist](#simple-bug-fix-checklist)
2. [Refactoring Checklist](#refactoring-checklist)
3. [New Feature Implementation](#new-feature-implementation)
4. [Complete Service Implementation](#complete-service-implementation)

---

## Simple Bug Fix Checklist

**Use for**: Quick bug fixes or small code changes

```markdown
# Bug Fix: [Bug Description]

## Investigation
- [ ] Reproduce the bug
- [ ] Read relevant code
- [ ] Identify root cause
- [ ] Document findings

## Implementation
- [ ] Fix the bug
- [ ] Add/update tests to cover the bug
- [ ] Verify fix works

## Verification
- [ ] Run affected tests
- [ ] Run full test suite
- [ ] Manual testing if needed
```

**Example: Calculator Percentage Bug**
```markdown
# Bug Fix: Calculator Percentage Method Returns Wrong Values

## Investigation
- [x] Reproduce bug with test
- [x] Read Calculator.java percentage method
- [x] Identified root cause: integer division issue (100 instead of 100.0)

## Implementation
- [ ] Change 100 to 100.0 in percentage calculation
- [ ] Verify calculation logic correct

## Verification
- [ ] Run CalculatorTest
- [ ] Both tests should pass
- [ ] Run mvn test for full suite
```

---

## Refactoring Checklist

**Use for**: Cleaning up existing code, reducing complexity

```markdown
# Refactoring: [Class/Module Name]

## Analysis
- [ ] Read current code
- [ ] Identify code smells
- [ ] List problems to fix
- [ ] Document current responsibilities

## Planning
- [ ] Define refactoring goals
- [ ] Identify methods to extract
- [ ] Identify renaming needs
- [ ] Check project rules compliance

## Method Extraction
- [ ] Extract long method 1
- [ ] Extract long method 2
- [ ] Create helper methods

## Renaming
- [ ] Rename unclear method 1
- [ ] Rename unclear method 2
- [ ] Rename unclear variables

## Documentation
- [ ] Add/update Javadoc
- [ ] Add inline comments where needed

## Verification
- [ ] All methods meet size limits
- [ ] All tests still pass
- [ ] Code follows project rules
- [ ] No functionality changed
```

**Example: OrderService Refactoring (Challenge 5)**
```markdown
# OrderService Refactoring Checklist

## Analysis
- [x] Read OrderService.java
- [x] Identified issues:
  - 300+ lines (too long)
  - Methods over 50 lines
  - Multiple responsibilities
  - Poor naming (calc, getHistory)
  - Missing Javadoc

## Planning
- [x] Create this checklist
- [x] Use /remember to save strategy

## Method Extraction
- [ ] Break down createOrder method (currently 60+ lines)
  - [ ] Extract validateOrder()
  - [ ] Extract calculateTotal()
  - [ ] Extract createNewOrder()
- [ ] Break down updateOrderStatus method
- [ ] Extract validation into separate methods

## Renaming
- [ ] Rename calc() to calculateCustomerTotal()
- [ ] Rename getHistory() to getCustomerOrderHistory()
- [ ] Review all method names for clarity

## Documentation
- [ ] Add Javadoc to all public methods
- [ ] Ensure @param and @return tags present
- [ ] Add class-level Javadoc

## Verification
- [ ] All methods under 20 lines (project rule)
- [ ] Run mvn compile - no errors
- [ ] Run tests - all pass
- [ ] Review against project rules
- [ ] Update PROGRESS.md
```

---

## New Feature Implementation

**Use for**: Adding new functionality to existing system

```markdown
# Feature: [Feature Name]

## Planning
- [ ] Review requirements
- [ ] Identify affected files/modules
- [ ] List dependencies
- [ ] Create task breakdown

## Setup
- [ ] Create necessary files/classes
- [ ] Set up test fixtures
- [ ] Import required dependencies

## Core Implementation
- [ ] Implement function 1
- [ ] Implement function 2
- [ ] Implement function 3
- [ ] Add error handling

## Integration
- [ ] Connect to existing system
- [ ] Update interfaces if needed
- [ ] Handle edge cases

## Testing
- [ ] Write unit tests
- [ ] Write integration tests
- [ ] Test error scenarios
- [ ] Verify coverage

## Documentation
- [ ] Add code documentation
- [ ] Update README if needed
- [ ] Add usage examples

## Final Steps
- [ ] Code review checklist
- [ ] Run full test suite
- [ ] Manual testing
- [ ] Update project documentation
```

---

## Complete Service Implementation

**Use for**: Building a complete service layer from scratch (like Challenge 6)

```markdown
# Service Implementation: [ServiceName]

## Setup & Planning
- [ ] Review requirements
- [ ] Create implementation checklist
- [ ] Use /remember to save context

## Entity Layer
- [ ] Create [Entity].java class
- [ ] Add all properties with correct types
- [ ] Generate getters and setters
- [ ] Add entity-level validation annotations
- [ ] Add Javadoc to entity

## Repository Layer
- [ ] Create [Entity]Repository interface
- [ ] Add CRUD method signatures:
  - [ ] findAll()
  - [ ] findById()
  - [ ] save()
  - [ ] update()
  - [ ] delete()
- [ ] Add custom query methods
- [ ] Complete Javadoc for all methods

## Service Layer - Interface
- [ ] Create [Entity]Service interface
- [ ] Define business method signatures
- [ ] Add Javadoc describing contracts
- [ ] Consider business operations beyond CRUD

## Service Layer - Implementation
- [ ] Create [Entity]ServiceImpl class
- [ ] Add constructor injection for repository
- [ ] Implement CRUD operations:
  - [ ] create[Entity]
  - [ ] find[Entity]ById
  - [ ] findAll[Entity]s
  - [ ] update[Entity]
  - [ ] delete[Entity]
- [ ] Implement custom business methods
- [ ] Add logging throughout
- [ ] Ensure methods follow size rules

## Validation Logic
- [ ] Create input validation helper method
- [ ] Create business rule validation methods
- [ ] Add appropriate error handling
- [ ] Use clear error messages

## Testing
- [ ] Create [Entity]ServiceTest class
- [ ] Set up Mockito mocks for repository
- [ ] Test CRUD operations:
  - [ ] Test create success
  - [ ] Test create with null input
  - [ ] Test findById success
  - [ ] Test findById not found
  - [ ] Test findAll
  - [ ] Test update success
  - [ ] Test update with invalid data
  - [ ] Test delete success
- [ ] Test business rule validations
- [ ] Test error scenarios
- [ ] Verify code coverage (target: 80%+)

## Final Verification
- [ ] Run mvn compile - verify no errors
- [ ] Run mvn test - all tests pass
- [ ] Check all methods follow project rules
- [ ] Verify all public methods have Javadoc
- [ ] Update PROGRESS.md
```

**Example: BookService Implementation (Challenge 6)**
```markdown
# BookService Implementation Checklist

## Setup & Planning
- [x] Review requirements with Claude
- [x] Create this task checklist
- [ ] Use /remember to save plan

## Entity Layer
- [ ] Create Book.java entity class
- [ ] Add all 8 properties:
  - [ ] id (Long)
  - [ ] title (String)
  - [ ] author (String)
  - [ ] isbn (String)
  - [ ] publishedYear (int)
  - [ ] genre (String)
  - [ ] price (double or BigDecimal)
  - [ ] stockQuantity (int)
- [ ] Generate getters and setters
- [ ] Add Javadoc to entity class

## Repository Layer
- [ ] Create BookRepository interface
- [ ] Add CRUD method signatures
- [ ] Add custom finders:
  - [ ] findByAuthor(String author)
  - [ ] findByGenre(String genre)
  - [ ] findByIsbn(String isbn)
- [ ] Complete Javadoc for all methods

## Service Layer - Interface
- [ ] Create BookService interface
- [ ] Define business method signatures
- [ ] Add Javadoc to interface

## Service Layer - Implementation
- [ ] Create BookServiceImpl class
- [ ] Add constructor injection for repository
- [ ] Implement CRUD operations:
  - [ ] createBook(Book book)
  - [ ] findBookById(Long id)
  - [ ] findAllBooks()
  - [ ] updateBook(Book book)
  - [ ] deleteBook(Long id)
- [ ] Implement custom finders:
  - [ ] findBooksByAuthor(String author)
  - [ ] findBooksByGenre(String genre)
- [ ] Add logging using Logger

## Validation Methods
- [ ] Create validateBookInput(Book book) helper method
- [ ] Create validateStock(int stock) - must be >= 0
- [ ] Create validatePrice(double price) - must be > 0
- [ ] Create validateISBN(String isbn) - format check
- [ ] Create validatePublishedYear(int year) - 1450 to current year
- [ ] Add clear error messages for all validations

## Testing
- [ ] Create BookServiceTest class
- [ ] Set up Mockito mocks (@Mock, @InjectMocks)
- [ ] Test createBook:
  - [ ] Test successful creation
  - [ ] Test with null book
  - [ ] Test with invalid stock
  - [ ] Test with invalid price
  - [ ] Test with invalid ISBN
  - [ ] Test with invalid year
- [ ] Test findBookById:
  - [ ] Test found
  - [ ] Test not found
- [ ] Test findAllBooks
- [ ] Test updateBook
- [ ] Test deleteBook
- [ ] Test findBooksByAuthor
- [ ] Test findBooksByGenre
- [ ] Verify 80%+ code coverage

## Final Verification
- [ ] Run mvn compile - no errors
- [ ] Run mvn test - all tests pass
- [ ] Check all methods under 20 lines (project rule)
- [ ] Verify all public methods have Javadoc
- [ ] Confirm all validations working
- [ ] Update PROGRESS.md

## Notes
- Using BigDecimal for price (project rule for financial calculations)
- ISBN validation regex: ^\d{10}(\d{3})?$ (10 or 13 digits)
- Remember to use @Service annotation on implementation
- Log important operations (create, update, delete)
```

---

## Tips for Creating Effective Checklists

### 1. Right Level of Granularity
- **Too vague**: "Implement the service" ❌
- **Too detailed**: "Add semicolon on line 42" ❌
- **Just right**: "Implement createBook method with validation" ✅

### 2. Use Action Verbs
Start each task with a clear action:
- Create...
- Implement...
- Test...
- Verify...
- Add...
- Update...

### 3. Group Related Tasks
Organize tasks into logical phases or categories:
- Setup
- Implementation
- Testing
- Verification

### 4. Include Verification Steps
Always have verification tasks:
- Run tests
- Compile code
- Check against requirements
- Review code quality

### 5. Add Context Where Helpful
```markdown
- [ ] Validate ISBN format
  - Pattern: ^\d{10}(\d{3})?$
  - Must be 10 or 13 digits
```

### 6. Update as You Go
It's okay to:
- Add tasks you discover mid-implementation
- Remove tasks that aren't needed
- Break down tasks that are too large
- Combine tasks that are too granular

### 7. Mark Progress Clearly
- Incomplete: `- [ ]`
- Completed: `- [x]`
- Blocked: `- [ ] Task name (BLOCKED: reason)`
- In Progress: `- [ ] Task name (IN PROGRESS)`

---

## Checklist Size Guidelines

| Feature Size | Typical Task Count | Notes |
|--------------|-------------------|-------|
| Bug fix | 3-8 tasks | Investigation + fix + verification |
| Small refactoring | 5-12 tasks | Analysis + extraction + verification |
| Simple feature | 8-15 tasks | Setup + implementation + testing |
| Medium feature | 15-25 tasks | Multiple components + tests + integration |
| Complex feature | 25-40 tasks | Consider breaking into multiple checklists |

If your checklist exceeds 40 tasks, consider:
- Breaking it into multiple checklists by phase
- Creating a high-level checklist with linked detailed checklists
- Simplifying the scope

---

## Using Checklists with Claude

### Creating Checklists
```
"Please create a task checklist in TASKS.md for implementing [feature/refactoring]"

"Analyze [requirements] and generate an implementation checklist"

"Let's create a detailed checklist together for building [component]"
```

### Working with Checklists
```
"Following our checklist in TASKS.md, let's start with task 1"

"Mark the 'Create entity class' task as complete in TASKS.md"

"We've completed tasks 1-5. What's next on the checklist?"

"This checklist is too detailed. Can you consolidate related tasks?"
```

### Refining Checklists
```
"Add a new task: 'Validate ISBN format' between tasks 8 and 9"

"Break down the 'Implement service' task into smaller subtasks"

"Update the checklist based on what we just discovered"
```

### Using with /remember
```
/remember Created TASKS.md with 15 implementation tasks organized into 4 phases

/remember Completed tasks 1-7 in checklist. Currently on task 8: implementing validation

/remember Our checklist shows we still need to complete testing phase (tasks 12-15)
```

---

## Real-World Applications

Task checklists are valuable for:

1. **Feature Implementation** - Plan before coding
2. **Bug Investigation** - Systematic debugging approach
3. **Code Review** - Checklist of review criteria
4. **Refactoring** - Track improvements systematically
5. **Onboarding** - Help new team members get started
6. **Sprint Planning** - Break down user stories
7. **Migration Projects** - Track multi-step conversions
8. **API Integration** - Checklist of integration steps
9. **Security Audit** - Systematic security review
10. **Performance Optimization** - Track optimization tasks

---

## Remember

**Task checklists are tools, not constraints**

- Use them when they help (complex tasks, multi-step features)
- Skip them when they don't (trivial changes, quick fixes)
- Refine them as you learn (add/remove/reorganize tasks)
- Share them with your team (improve collaboration)
- Keep them simple (clarity over completeness)

The goal is to **stay focused, track progress, and communicate clearly** with Claude (and your team).
