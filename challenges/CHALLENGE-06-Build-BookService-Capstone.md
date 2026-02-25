# Challenge 6: Build BookService - Capstone Challenge

**Duration:** 20 minutes
**Difficulty:** Advanced (Integrates all concepts)
**Project:** claude-code-workshop (same directory)

## Learning Objectives
- **Use full task-based design workflow** (plan, track, refine)
- Apply all learned Claude Code skills
- Build a complete feature from scratch
- Demonstrate mastery of tools, rules, skills, and sub-agents
- Create production-quality code
- Practice collaborative planning with Claude

## Scenario

The final challenge! Build a complete Book Management API for the platform, integrating everything you've learned:
- Basic commands (Read, Edit, Write, Bash)
- Project rules (automatically applied)
- Custom skills (use your java-service-generator if you want)
- Sub-agents (for research if needed)
- Context management (for this 20-minute task)

This is your opportunity to demonstrate Claude Code mastery.

## Your Mission

Build a complete, production-ready BookService with:
1. Entity layer (Book.java)
2. Repository layer (BookRepository.java)
3. Service layer (BookService.java, BookServiceImpl.java)
4. Comprehensive tests (BookServiceTest.java)

## Starting Point

You're in `claude-code-workshop/` with:
- Established project rules in `.claude/rules.md`
- Your custom java-service-generator skill (from Challenge 3)
- Empty `src/main/java/com/workshop/book/` directory
- All previous work completed

## Requirements

### 1. Book Entity
Create `Book.java` with:
- Properties: id (Long), title (String), author (String), isbn (String), publishedYear (int), genre (String), price (double), stockQuantity (int)
- All fields private with getters/setters
- Proper data types
- Follows project rules (Javadoc on getters/setters)

### 2. Repository Interface
Create `BookRepository.java` with:
- Standard CRUD: findAll(), findById(), save(), update(), delete()
- Custom queries: findByAuthor(), findByGenre(), findByIsbn()
- Return types: List<Book>, Optional<Book>
- Complete Javadoc

### 3. Service Interface
Create `BookService.java` with:
- Business method signatures
- Complete Javadoc
- All CRUD operations
- Search operations

### 4. Service Implementation
Create `BookServiceImpl.java` with:
- Constructor injection for repository
- All CRUD operations implemented
- Input validation (null checks, business rules)
- Logging using java.util.logging.Logger
- Business logic:
  - Stock cannot be negative
  - Price must be positive
  - ISBN validation (basic format check)
  - Published year must be reasonable (1450-current year)

### 5. Unit Tests
Create `BookServiceTest.java` with:
- Mock repository using Mockito
- Test all CRUD operations
- Test validation (null checks)
- Test business rules
- Test edge cases
- Minimum 80% coverage

## Task-Based Design Workflow

This challenge uses the **full task-based design workflow** you learned. You'll collaborate with Claude to plan, implement, track, and refine your work.

### Phase 1: Collaborative Planning (4 min)

**Step 1: Discuss requirements with Claude (1 min)**

**Prompt to Claude:**
```
I'm building a complete BookService API for the platform. Here are the requirements:
- Book entity with properties: id, title, author, isbn, publishedYear, genre, price, stockQuantity
- Repository interface with CRUD + custom finders
- Service with business validation
- Comprehensive tests

Help me understand what we need to build.
```

**Step 2: Create implementation checklist together (2 min)**

**Prompt to Claude:**
```
Let's create a comprehensive task checklist together in BOOK-SERVICE-TASKS.md. Include:
1. Setup tasks
2. Entity creation
3. Repository interface
4. Service interface and implementation
5. Validation logic
6. Testing tasks
7. Final verification

Organize by phases and make each task concrete and actionable.
```

Claude will generate something like:
```markdown
# BookService Implementation Checklist

## Setup & Planning
- [x] Review requirements with Claude
- [x] Create task checklist

## Entity Layer
- [ ] Create Book.java entity class
- [ ] Add all 8 properties with proper types
- [ ] Generate getters and setters
- [ ] Add Javadoc to entity class

## Repository Layer
- [ ] Create BookRepository interface
- [ ] Add CRUD method signatures
- [ ] Add custom finders (findByAuthor, findByGenre, findByIsbn)
- [ ] Complete Javadoc for all methods

## Service Layer - Interface
- [ ] Create BookService interface
- [ ] Define business method signatures
- [ ] Add Javadoc to interface

## Service Layer - Implementation
- [ ] Create BookServiceImpl class
- [ ] Implement constructor injection
- [ ] Implement createBook with validation
- [ ] Implement findBookById
- [ ] Implement findAllBooks
- [ ] Implement updateBook with validation
- [ ] Implement deleteBook
- [ ] Implement findByAuthor
- [ ] Implement findByGenre
- [ ] Add logging throughout

## Validation Methods
- [ ] Create validateBookInput helper method
- [ ] Create validateStock helper method (>= 0)
- [ ] Create validatePrice helper method (> 0)
- [ ] Create validateISBN helper method
- [ ] Create validatePublishedYear helper method (1450-current)

## Testing
- [ ] Create BookServiceTest class
- [ ] Set up Mockito mocks
- [ ] Test createBook success case
- [ ] Test createBook with null input
- [ ] Test findBookById
- [ ] Test findAllBooks
- [ ] Test updateBook
- [ ] Test deleteBook
- [ ] Test stock validation
- [ ] Test price validation
- [ ] Test ISBN validation
- [ ] Test year validation
- [ ] Verify 80%+ coverage

## Final Verification
- [ ] Run mvn compile - verify no errors
- [ ] Run mvn test - all tests pass
- [ ] Check all methods follow project rules (<20 lines)
- [ ] Verify all public methods have Javadoc
- [ ] Update PROGRESS.md
```

**Step 3: Review and refine checklist (1 min)**

Review the checklist together:
```
This looks good! Can we add a note about using BigDecimal for price under validation tasks?
```

Use /remember to save the plan:
```
/remember Created BOOK-SERVICE-TASKS.md with comprehensive implementation checklist

/remember Building BookService with: Entity (Book), Repository (BookRepository), Service (BookService + Impl), Tests

/remember Business rules to implement: stock >= 0, price > 0, ISBN format check, publishedYear 1450-current

/remember Following project rules: methods <20 lines, complete Javadoc, constructor injection
```

### Phase 2: Systematic Implementation (12 min)

Work through your checklist systematically. Reference it frequently and mark tasks complete as you go.

**For Entity Layer (3 min):**
```
Following our BOOK-SERVICE-TASKS.md, let's start with the Entity Layer section. Create Book.java with all properties and follow project rules.
```

**For Repository Layer (2 min):**
```
Moving to Repository Layer in our checklist. Create BookRepository interface with CRUD and custom finders. Mark entity tasks complete.
```

**For Service Layer (5 min):**
```
Now the Service Layer section. Create BookService interface and BookServiceImpl. Implement all CRUD methods with validation from our Validation Methods section. Mark repository tasks complete as we go.
```

**For Testing (2 min):**
```
Final section: Testing. Create BookServiceTest with mocks and comprehensive test cases. Mark service tasks complete.
```

**Track your progress actively:**
- Mark tasks complete as you finish them: `- [x]`
- Ask Claude to update the checklist: `"Mark the 'Create Book.java' task complete"`
- Use /remember for key decisions:
  ```
  /remember Completed entity and repository layers. All 15 tasks done. Moving to service implementation.

  /remember Used BigDecimal for price per project financial calculation rule

  /remember Added comprehensive validation with clear error messages in BookServiceImpl
  ```

### Phase 3: Verification (4 min)

**Step 1: Check the checklist (1 min)**
```
Read BOOK-SERVICE-TASKS.md. What tasks are still incomplete?
```

**Step 2: Verify requirements met (1 min)**
```
Verify our BookService meets all requirements:
1. All methods under 20 lines
2. All public methods have Javadoc
3. All business rules implemented
4. Tests comprehensive with 80%+ coverage
```

**Step 3: Run tests (2 min)**
```
Run mvn compile and mvn test to verify everything works
```

### Phase 4: Final Documentation (optional, if time permits)

```
Update PROGRESS.md with BookService completion. Include: what was built, how many tasks completed, any challenges faced.
```

## Success Criteria

Task-Based Design:
- [ ] **Created BOOK-SERVICE-TASKS.md** collaboratively with Claude
- [ ] **Followed checklist systematically** during implementation
- [ ] **Actively tracked progress** (marked tasks complete as finished)
- [ ] **Used /remember** to maintain context throughout
- [ ] **All checklist tasks completed**

Technical Requirements:
- [ ] All classes follow project rules (methods <20 lines, Javadoc)
- [ ] Constructor injection used
- [ ] Book entity complete with all properties
- [ ] Repository interface with all methods
- [ ] Service implementation with business logic
- [ ] Comprehensive tests (80%+ coverage)
- [ ] Code compiles: `mvn compile`
- [ ] All tests pass: `mvn test`
- [ ] Logging implemented
- [ ] Input validation present
- [ ] PROGRESS.md updated

## Business Rules to Implement

```java
// In BookServiceImpl validation methods:

1. Stock validation:
   - stockQuantity >= 0 (cannot be negative)

2. Price validation:
   - price > 0 (must be positive)

3. ISBN validation:
   - Not null
   - Basic format check (e.g., 10 or 13 digits with optional hyphens)

4. Published year validation:
   - Between 1450 and current year
   - Cannot be in the future

5. Required fields:
   - title (not null or empty)
   - author (not null or empty)
   - isbn (not null or empty)
```

## Strategy Tips

### Use Task-Based Design (Primary Focus)
- **Plan first:** Create detailed checklist with Claude before coding
- **Reference checklist:** Keep BOOK-SERVICE-TASKS.md open and reference it
- **Track actively:** Mark tasks complete as you go
- **Refine as needed:** Add/modify tasks if you discover new requirements
- **Use /remember:** Save progress and decisions throughout

### Use All Your Claude Code Skills
- **Rules:** Automatically applied from .claude/rules.md
- **Task-based design:** Create and follow checklist (from Challenge 5)
- **Skill:** Use java-service-generator if it helps with boilerplate
- **Sub-agents:** Use Explore if you need to research something
- **Context management:** Use /remember throughout (from Challenge 5)
- **Basic commands:** Read, Edit, Write, Bash throughout

### Recommended Implementation Order (From Your Checklist)
1. Entity (foundation)
2. Repository (data access contract)
3. Service interface (business contract)
4. Service implementation (business logic)
5. Validation helpers (business rules)
6. Tests (verify everything)

### Quality Over Speed
- Follow your checklist - don't skip steps
- Follow all project rules
- Write clean, maintainable code
- Test thoroughly
- Don't skip validation
- Mark tasks complete as you finish them

## Hints

### Hint 1 (Gentle - Task-Based Design)
Don't jump into coding! Start by creating a comprehensive task checklist with Claude. Planning saves time.

### Hint 2 (Stronger - Workflow)
Follow the Phase 1-2-3-4 workflow exactly:
1. Plan (create checklist)
2. Implement (follow checklist, mark tasks done)
3. Verify (check all requirements met)
4. Document (update PROGRESS.md)

### Hint 3 (Implementation Order)
Your checklist should guide you, but the recommended order is:
1. Book.java entity
2. BookRepository.java interface
3. BookService.java interface
4. BookServiceImpl.java with validation and logging
5. BookServiceTest.java with mocks and comprehensive tests

### Hint 4 (Stuck?)
If you're stuck, read your BOOK-SERVICE-TASKS.md. What's the next incomplete task? Ask Claude to help with just that one task.

## Bonus Challenges (If Time Permits)

1. Add BookController REST endpoints
2. Add pagination to findAll()
3. Add search by title
4. Add DTO layer (separate entity from API)
5. Add integration tests

## Final Verification

Before marking complete, verify:

```bash
# Compile
mvn clean compile

# Run tests
mvn test

# Check for test failures
# Expected: All tests pass
```

## What's Next

**Congratulations!** You've completed the Claude Code CLI Workshop!

Your `claude-code-workshop` now has:
- ✅ Fixed Calculator with logging
- ✅ Project rules configured
- ✅ Custom skill created
- ✅ UserService generated
- ✅ Security audit completed
- ✅ Refactored OrderService
- ✅ Complete BookService with tests

### Post-Workshop
1. Update PROGRESS.md with final summary
2. Review your journey through all 6 challenges
3. Share your experience with the group
4. Answer reflection questions in PROGRESS.md

## Reflection Questions

After completing:
1. **How did task-based design (using checklists) help or hinder your work?**
2. **Would you use task checklists in your real projects? Why or why not?**
3. What Claude Code features were most helpful?
4. How did project rules improve your workflow?
5. When would you use sub-agents in real projects?
6. How will you use Claude Code in your daily work?
7. What was the most challenging part?
8. What was the biggest learning?
9. **Did creating a plan first save time or feel like overhead?**

## Keep This Project!

This `claude-code-workshop` is now a complete reference for:
- Claude Code workflows
- Project structure
- Coding standards
- Testing patterns
- Service layer architecture

Use it as a template for future projects!
