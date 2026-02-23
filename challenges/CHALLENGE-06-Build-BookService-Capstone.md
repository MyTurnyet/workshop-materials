# Challenge 6: Build BookService - Capstone Challenge

**Duration:** 20 minutes
**Difficulty:** Advanced (Integrates all concepts)
**Project:** claude-code-workshop (same directory)

## Learning Objectives
- Apply all learned Claude Code skills
- Build a complete feature from scratch
- Demonstrate mastery of tools, rules, skills, and sub-agents
- Create production-quality code

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

## Suggested Approach

### Step 1: Plan (2 min)

**Prompt to Claude:**
```
I'm building a complete BookService for the platform. Help me plan the approach:
1. What order should I create the classes?
2. What are the key business rules?
3. What should I test?
```

Optional: Use /ideate skill or ask Claude to enter plan mode

### Step 2: Generate or Create Boilerplate (3 min)

**Option A - Use Your Skill:**
```
/java-service-generator Book
```

**Option B - Ask Claude:**
```
Create the Book entity, BookService interface, and BookServiceImpl implementation following the project rules in .claude/rules.md.
```

### Step 3: Implement Book Entity (3 min)

**Prompt to Claude:**
```
Create Book.java in src/main/java/com/workshop/book/ with:
- Properties: id, title, author, isbn, publishedYear, genre, price, stockQuantity
- All private fields with public getters/setters
- Javadoc on all public methods
- Follow project rules
```

### Step 4: Implement Repository (2 min)

**Prompt to Claude:**
```
Create BookRepository.java interface with CRUD methods and custom finders (findByAuthor, findByGenre, findByIsbn). Include complete Javadoc.
```

### Step 5: Implement Service (5 min)

**Prompt to Claude:**
```
Create BookService interface and BookServiceImpl implementation with:
- Constructor injection for repository
- All CRUD operations
- Input validation
- Business rules: stock >= 0, price > 0, isbn format, valid year
- Logging
- All methods under 20 lines
- Complete Javadoc
```

### Step 6: Create Tests (4 min)

**Prompt to Claude:**
```
Create BookServiceTest.java with comprehensive unit tests:
- Mock BookRepository using Mockito
- Test all CRUD operations
- Test validation (null checks, business rules)
- Test edge cases
- Use JUnit 5
```

### Step 7: Verify (1 min)

**Prompt to Claude:**
```
Run the tests to verify everything works: mvn test
```

## Success Criteria

Mandatory requirements:
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

### Use All Your Skills
- **Rules:** Automatically applied from .claude/rules.md
- **Skill:** Use java-service-generator if it helps
- **Sub-agents:** Use Explore if you need to research something
- **Basic commands:** Read, Edit, Write, Bash throughout

### Recommended Order
1. Entity (foundation)
2. Repository (data access contract)
3. Service interface (business contract)
4. Service implementation (business logic)
5. Tests (verify everything)

### Quality Over Speed
- Follow all project rules
- Write clean, maintainable code
- Test thoroughly
- Don't skip validation

## Hints

### Hint 1 (Gentle)
Start with the Book entity - it's the foundation everything else builds on.

### Hint 2 (Stronger)
Use your java-service-generator skill to create the boilerplate quickly, then customize it.

### Hint 3 (Solution)
Follow this exact sequence:
1. Book.java entity
2. BookRepository.java interface
3. BookService.java interface
4. BookServiceImpl.java with validation and logging
5. BookServiceTest.java with mocks and comprehensive tests

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
1. What Claude Code features were most helpful?
2. How did project rules improve your workflow?
3. When would you use sub-agents in real projects?
4. How will you use Claude Code in your daily work?
5. What was the most challenging part?
6. What was the biggest learning?

## Keep This Project!

This `claude-code-workshop` is now a complete reference for:
- Claude Code workflows
- Project structure
- Coding standards
- Testing patterns
- Service layer architecture

Use it as a template for future projects!
