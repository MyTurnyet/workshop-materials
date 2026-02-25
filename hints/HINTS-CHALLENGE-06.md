# Challenge 6 Hints: Build BookService (Capstone)

This is the capstone challenge integrating all learned skills, including **task-based design**. Use these hints only if stuck.

---

## Task-Based Design Workflow Hints

**IMPORTANT:** Challenge 6 requires using the full task-based design workflow. Don't skip this!

### Level 1: Getting Started with Task-Based Design

**If you're not sure how to start:**
1. First, discuss requirements with Claude
2. Ask Claude to create a comprehensive checklist in BOOK-SERVICE-TASKS.md
3. Review and refine the checklist together
4. Use /remember to save the plan
5. Then start implementing, following the checklist

**Example prompts:**
```
"I'm building a complete BookService. Let's discuss the requirements and create an implementation plan."

"Create a comprehensive task checklist in BOOK-SERVICE-TASKS.md with phases for: Setup, Entity, Repository, Service Interface, Service Implementation, Validation, Testing, and Verification."

"/remember Created BOOK-SERVICE-TASKS.md with 40+ tasks across 8 phases"
```

### Level 2: Checklist Structure

Your BOOK-SERVICE-TASKS.md should have these sections:
- **Setup & Planning** (2-3 tasks)
- **Entity Layer** (4-5 tasks for Book.java)
- **Repository Layer** (8-10 tasks for CRUD + custom finders)
- **Service Layer - Interface** (3-4 tasks)
- **Service Layer - Implementation** (8-10 tasks for CRUD + custom methods)
- **Validation Methods** (5-6 tasks for business rules)
- **Testing** (15-20 tasks covering all scenarios)
- **Final Verification** (5-6 tasks)

**Total:** ~40-50 tasks

### Level 3: Complete Task-Based Workflow

**Phase 1: Planning (4 min)**
```
"I'm building BookService with: Book entity (8 properties), BookRepository (CRUD + 3 finders), BookService with validation (stock>=0, price>0, ISBN format, year 1450-current). Create detailed checklist in BOOK-SERVICE-TASKS.md."

[Review checklist with Claude, refine if needed]

"/remember Created BOOK-SERVICE-TASKS.md with implementation plan"
"/remember Business rules: stock>=0, price>0, ISBN format, year 1450-current"
```

**Phase 2: Implementation (12 min)**
```
"Following BOOK-SERVICE-TASKS.md 'Entity Layer' section, create Book.java"
[After completion] "Mark Entity Layer tasks complete"

"Following 'Repository Layer', create BookRepository"
[Mark complete]

"Following 'Service Layer', create BookService interface and BookServiceImpl with validation"
[Mark complete]

"Following 'Validation Methods', implement all business rule validators"
[Mark complete]

"Following 'Testing', create BookServiceTest with comprehensive tests"
[Mark complete]
```

**Phase 3: Verification (4 min)**
```
"Read BOOK-SERVICE-TASKS.md. What's incomplete?"
"Run mvn compile and mvn test"
"Verify all methods under 20 lines and have Javadoc"
"Mark Final Verification tasks complete"
```

### Common Task-Based Design Issues

**Issue: "I forgot to create the checklist"**
Stop now and create it! Don't continue coding without a plan. It will save time.

**Issue: "The checklist is too long (60+ tasks)"**
Good! That means you're being thorough. Just work through it systematically.

**Issue: "I'm not marking tasks complete"**
Set a reminder: after each section, mark tasks complete. Or ask Claude to do it.

**Issue: "The checklist doesn't match what I'm doing"**
That's okay! Update the checklist. Add tasks, remove tasks, refine as you go.

---

## General Strategy

### Level 1 (Gentle Nudge)
Start with the foundation and build up:
1. Book entity (data model)
2. BookRepository interface (data access contract)
3. BookService interface (business contract)
4. BookServiceImpl (business logic)
5. BookServiceTest (verification)

### Level 2 (Stronger Hint)
Use your skills:
- Your custom java-service-generator skill can create the boilerplate
- Project rules will automatically apply
- Focus on business rules: stock >= 0, price > 0, valid ISBN, reasonable year
- Don't forget comprehensive tests

### Level 3 (Near-Solution)
Follow this exact sequence:
```
Step 1: Create Book.java entity with all properties
Step 2: Create BookRepository.java interface
Step 3: Create BookService.java interface
Step 4: Create BookServiceImpl.java with validation and logging
Step 5: Create BookServiceTest.java with mocks
Step 6: Run mvn test to verify
```

---

## Part 1: Book Entity

### Level 1 (Gentle Nudge)
Create a Book.java class in `src/main/java/com/workshop/book/` with these properties: id, title, author, isbn, publishedYear, genre, price, stockQuantity. Use proper data types.

### Level 2 (Stronger Hint)
Prompt to Claude:
```
Create Book.java entity in src/main/java/com/workshop/book/ with:
- Private fields: Long id, String title, String author, String isbn, int publishedYear, String genre, double price, int stockQuantity
- Public getters and setters for all fields
- Javadoc on all public methods (following project rules)
```

### Level 3 (Near-Solution)
```
Create Book.java:
package com.workshop.book;

public class Book {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private int publishedYear;
    private String genre;
    private double price;
    private int stockQuantity;

    // Generate getters and setters with Javadoc
}
```

---

## Part 2: Repository Interface

### Level 1 (Gentle Nudge)
Create BookRepository.java interface with CRUD methods and custom finders. Return types should use Optional<Book> for single results and List<Book> for multiple.

### Level 2 (Stronger Hint)
```
Create BookRepository.java interface with methods:
- List<Book> findAll()
- Optional<Book> findById(Long id)
- Book save(Book book)
- Book update(Long id, Book book)
- void delete(Long id)
- List<Book> findByAuthor(String author)
- List<Book> findByGenre(String genre)
- Optional<Book> findByIsbn(String isbn)
All with complete Javadoc
```

### Level 3 (Near-Solution)
Look at the UserService you generated in Challenge 3 - use similar pattern but adapt for Book entity.

---

## Part 3: Service Implementation

### Level 1 (Gentle Nudge)
BookServiceImpl needs:
- Constructor injection for repository
- Validation methods for all business rules
- Logging for all operations
- Methods under 20 lines (extract validation helpers)

### Level 2 (Stronger Hint)
Business rules to implement:
```java
// Validation helper methods:
private void validateBook(Book book) {
    if (book == null) throw new IllegalArgumentException("Book cannot be null");
    validateTitle(book.getTitle());
    validateAuthor(book.getAuthor());
    validateIsbn(book.getIsbn());
    validatePrice(book.getPrice());
    validateStock(book.getStockQuantity());
    validatePublishedYear(book.getPublishedYear());
}

private void validateStock(int stock) {
    if (stock < 0) throw new IllegalArgumentException("Stock cannot be negative");
}

private void validatePrice(double price) {
    if (price <= 0) throw new IllegalArgumentException("Price must be positive");
}

// etc for other validations
```

### Level 3 (Near-Solution)
Use your java-service-generator skill to create the boilerplate:
```
/java-service-generator Book
```
Then enhance the generated BookServiceImpl with:
- Business rule validation
- Logging using Logger
- All methods under 20 lines

---

## Part 4: Testing

### Level 1 (Gentle Nudge)
BookServiceTest needs:
- @Mock BookRepository
- Mockito to mock repository responses
- Tests for all CRUD operations
- Tests for validation (null checks, business rules)
- Tests for edge cases

### Level 2 (Stronger Hint)
Test structure:
```java
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository repository;

    private BookService service;

    @BeforeEach
    public void setUp() {
        service = new BookServiceImpl(repository);
    }

    @Test
    public void testCreateBook_Valid() {
        // Arrange: Create valid book, mock repository.save()
        // Act: service.create(book)
        // Assert: Verify saved, verify repository called
    }

    @Test
    public void testCreateBook_NullBook() {
        // Should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            service.create(null);
        });
    }

    // More tests...
}
```

### Level 3 (Near-Solution)
```
Create BookServiceTest.java with:
1. Mock BookRepository using @Mock
2. Test createBook with valid data
3. Test createBook with null book (should throw exception)
4. Test createBook with negative stock (should throw exception)
5. Test createBook with negative price (should throw exception)
6. Test findById when book exists
7. Test findById when book doesn't exist
8. Test update
9. Test delete
Use Mockito's when() and verify() methods
```

---

## Common Issues

### Issue 1: Tests won't compile
**Symptom:** Cannot resolve Mockito classes
**Fix:** Check pom.xml has mockito-core dependency (should already be there)

### Issue 2: Validation too complex
**Symptom:** Methods over 20 lines
**Fix:** Extract validation into separate helper methods

### Issue 3: Forgot logging
**Symptom:** No logs when running
**Fix:** Add Logger field and log before/after operations

### Issue 4: Tests don't mock properly
**Symptom:** NullPointerException in tests
**Fix:** Use `when(repository.save(any())).thenReturn(book)` to mock responses

---

## Business Rules Reference

```java
// Stock validation
if (stockQuantity < 0) {
    throw new IllegalArgumentException("Stock cannot be negative");
}

// Price validation
if (price <= 0) {
    throw new IllegalArgumentException("Price must be positive");
}

// ISBN validation (basic)
if (isbn == null || isbn.trim().isEmpty()) {
    throw new IllegalArgumentException("ISBN required");
}

// Published year validation
int currentYear = java.time.Year.now().getValue();
if (publishedYear < 1450 || publishedYear > currentYear) {
    throw new IllegalArgumentException("Published year must be between 1450 and " + currentYear);
}

// Title validation
if (title == null || title.trim().isEmpty()) {
    throw new IllegalArgumentException("Title required");
}

// Author validation
if (author == null || author.trim().isEmpty()) {
    throw new IllegalArgumentException("Author required");
}
```

---

## Time Management

If running short on time, prioritize:
1. **Must have:** Entity, Repository interface, Service interface (5 min)
2. **Should have:** ServiceImpl with basic CRUD (8 min)
3. **Nice to have:** Full validation (3 min)
4. **If time:** Comprehensive tests (4 min)

---

## Integration Checklist

Make sure you're using all learned concepts:
- [ ] Project rules automatically applied (methods <20 lines, Javadoc)
- [ ] Constructor injection used
- [ ] Logging implemented (Logger, not System.out)
- [ ] Validation present
- [ ] Tests use Mockito
- [ ] Code compiles: `mvn compile`
- [ ] Tests pass: `mvn test`

---

## Still Stuck?

1. Look at UserService you generated in Challenge 3
2. Look at Calculator and OrderService for patterns
3. Check solutions/challenge-06/ for complete solution
4. Ask facilitator for help
5. Pair with another participant

Remember: Quality over speed. Better to have working CRUD than incomplete everything!
