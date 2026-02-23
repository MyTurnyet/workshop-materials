# Challenge 6 Solution: Build BookService (Capstone)

## Overview

This capstone challenge integrates all learned Claude Code skills to build a complete REST API from scratch.

## Approach

There are multiple valid approaches. This solution presents one recommended path.

---

## Step 1: Planning (2 minutes)

### Understand Requirements

**Prompt to Claude:**
```
I'm building a complete BookService for the claude-code-workshop. Review the requirements in CHALLENGE-06-Build-BookService-Capstone.md and help me create a step-by-step implementation plan.
```

**Expected Plan:**
1. Create Book.java entity
2. Create BookRepository.java interface
3. Create BookService.java interface
4. Create BookServiceImpl.java with business logic
5. Create BookServiceTest.java with comprehensive tests
6. Verify everything compiles and tests pass

### Optional: Use /ideate or Plan Mode

```
/ideate Create a plan for building a complete Book Management API with entity, repository, service, and tests
```

---

## Step 2: Create Book Entity (3 minutes)

**Prompt to Claude:**
```
Create Book.java entity in src/main/java/com/workshop/book/ with:

Properties (all private):
- Long id
- String title
- String author
- String isbn
- int publishedYear
- String genre
- double price
- int stockQuantity

Requirements:
- Public getters and setters for all fields
- Javadoc on all public methods
- Follow project rules in .claude/rules.md
```

**Expected Result:**

```java
package com.workshop.book;

/**
 * Entity representing a book in the system.
 */
public class Book {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private int publishedYear;
    private String genre;
    private double price;
    private int stockQuantity;

    /**
     * Gets the book ID.
     * @return the book ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the book ID.
     * @param id the book ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    // ... similar getters and setters for all fields
}
```

---

## Step 3: Create Repository Interface (2 minutes)

**Prompt to Claude:**
```
Create BookRepository.java interface in src/main/java/com/workshop/book/ with:

Methods:
- List<Book> findAll()
- Optional<Book> findById(Long id)
- Book save(Book book)
- Book update(Long id, Book book)
- void delete(Long id)
- List<Book> findByAuthor(String author)
- List<Book> findByGenre(String genre)
- Optional<Book> findByIsbn(String isbn)

All methods must have complete Javadoc with @param and @return tags.
```

**Expected Result:**

```java
package com.workshop.book;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Book data access operations.
 */
public interface BookRepository {

    /**
     * Retrieves all books.
     * @return list of all books
     */
    List<Book> findAll();

    /**
     * Finds a book by its ID.
     * @param id the book ID
     * @return Optional containing the book if found, empty otherwise
     */
    Optional<Book> findById(Long id);

    /**
     * Saves a new book.
     * @param book the book to save
     * @return the saved book with generated ID
     */
    Book save(Book book);

    /**
     * Updates an existing book.
     * @param id the book ID
     * @param book the updated book data
     * @return the updated book
     */
    Book update(Long id, Book book);

    /**
     * Deletes a book by ID.
     * @param id the book ID to delete
     */
    void delete(Long id);

    /**
     * Finds all books by a specific author.
     * @param author the author name
     * @return list of books by the author
     */
    List<Book> findByAuthor(String author);

    /**
     * Finds all books of a specific genre.
     * @param genre the genre
     * @return list of books in the genre
     */
    List<Book> findByGenre(String genre);

    /**
     * Finds a book by its ISBN.
     * @param isbn the ISBN
     * @return Optional containing the book if found, empty otherwise
     */
    Optional<Book> findByIsbn(String isbn);
}
```

---

## Step 4: Create Service Interface (2 minutes)

**Prompt to Claude:**
```
Create BookService.java interface in src/main/java/com/workshop/book/ with the same CRUD methods as BookRepository, plus business operations. Include complete Javadoc.
```

**Expected Result:**

```java
package com.workshop.book;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for book business operations.
 */
public interface BookService {

    /**
     * Retrieves all books in the system.
     * @return list of all books
     */
    List<Book> findAll();

    /**
     * Finds a book by its ID.
     * @param id the book ID
     * @return Optional containing the book if found
     * @throws IllegalArgumentException if id is null
     */
    Optional<Book> findById(Long id);

    /**
     * Creates a new book.
     * @param book the book to create
     * @return the created book
     * @throws IllegalArgumentException if book is invalid
     */
    Book create(Book book);

    /**
     * Updates an existing book.
     * @param id the book ID
     * @param book the updated book data
     * @return the updated book
     * @throws IllegalArgumentException if id or book is invalid
     */
    Book update(Long id, Book book);

    /**
     * Deletes a book by ID.
     * @param id the book ID to delete
     * @throws IllegalArgumentException if id is null or book not found
     */
    void delete(Long id);

    /**
     * Finds all books by author.
     * @param author the author name
     * @return list of books by the author
     */
    List<Book> findByAuthor(String author);

    /**
     * Finds all books by genre.
     * @param genre the genre
     * @return list of books in the genre
     */
    List<Book> findByGenre(String genre);

    /**
     * Finds a book by ISBN.
     * @param isbn the ISBN
     * @return Optional containing the book if found
     */
    Optional<Book> findByIsbn(String isbn);
}
```

---

## Step 5: Create Service Implementation (8 minutes)

### Part A: Basic Structure with Constructor Injection

**Prompt to Claude:**
```
Create BookServiceImpl.java in src/main/java/com/workshop/book/ that:
1. Implements BookService interface
2. Uses constructor injection for BookRepository
3. Has a Logger field
4. Implements all interface methods with basic logic
5. Follows project rules (methods under 20 lines)
```

### Part B: Add Validation

**Prompt to Claude:**
```
Add validation helper methods to BookServiceImpl:

1. validateBook(Book book) - validates entire book
2. validateTitle(String title) - title not null/empty
3. validateAuthor(String author) - author not null/empty
4. validateIsbn(String isbn) - ISBN not null/empty, basic format check
5. validatePrice(double price) - price > 0
6. validateStock(int stock) - stock >= 0
7. validatePublishedYear(int year) - between 1450 and current year

All validation methods should throw IllegalArgumentException with clear messages.
Each method under 10 lines.
```

### Part C: Implement Create Method with Validation

**Prompt to Claude:**
```
Implement the create method in BookServiceImpl:
1. Call validateBook(book) first
2. Log the operation
3. Call repository.save(book)
4. Log success
5. Return the created book
6. Method must be under 20 lines
```

**Expected Implementation:**

```java
package com.workshop.book;

import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Implementation of BookService with validation and logging.
 */
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class.getName());
    private final BookRepository repository;

    /**
     * Constructor with dependency injection.
     * @param repository the book repository
     */
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAll() {
        LOGGER.info("Finding all books");
        return repository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Book ID cannot be null");
        }
        LOGGER.info("Finding book with ID: " + id);
        return repository.findById(id);
    }

    @Override
    public Book create(Book book) {
        LOGGER.info("Creating new book");
        validateBook(book);
        Book created = repository.save(book);
        LOGGER.info("Book created with ID: " + created.getId());
        return created;
    }

    @Override
    public Book update(Long id, Book book) {
        if (id == null) {
            throw new IllegalArgumentException("Book ID cannot be null");
        }
        LOGGER.info("Updating book with ID: " + id);
        validateBook(book);
        Book updated = repository.update(id, book);
        LOGGER.info("Book updated successfully");
        return updated;
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Book ID cannot be null");
        }
        LOGGER.info("Deleting book with ID: " + id);
        repository.delete(id);
        LOGGER.info("Book deleted successfully");
    }

    @Override
    public List<Book> findByAuthor(String author) {
        LOGGER.info("Finding books by author: " + author);
        return repository.findByAuthor(author);
    }

    @Override
    public List<Book> findByGenre(String genre) {
        LOGGER.info("Finding books by genre: " + genre);
        return repository.findByGenre(genre);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        LOGGER.info("Finding book by ISBN: " + isbn);
        return repository.findByIsbn(isbn);
    }

    // Validation helper methods

    private void validateBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        validateTitle(book.getTitle());
        validateAuthor(book.getAuthor());
        validateIsbn(book.getIsbn());
        validatePrice(book.getPrice());
        validateStock(book.getStockQuantity());
        validatePublishedYear(book.getPublishedYear());
    }

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Book title is required");
        }
    }

    private void validateAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Book author is required");
        }
    }

    private void validateIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN is required");
        }
    }

    private void validatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
    }

    private void validateStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }
    }

    private void validatePublishedYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1450 || year > currentYear) {
            throw new IllegalArgumentException(
                "Published year must be between 1450 and " + currentYear);
        }
    }
}
```

---

## Step 6: Create Comprehensive Tests (5 minutes)

**Prompt to Claude:**
```
Create BookServiceTest.java in src/test/java/com/workshop/book/ with:

Setup:
- Use @ExtendWith(MockitoExtension.class)
- Mock BookRepository with @Mock
- Create BookService instance in @BeforeEach

Test methods:
1. testCreateBook_Valid - test successful creation
2. testCreateBook_NullBook - should throw exception
3. testCreateBook_NullTitle - should throw exception
4. testCreateBook_EmptyAuthor - should throw exception
5. testCreateBook_NegativePrice - should throw exception
6. testCreateBook_NegativeStock - should throw exception
7. testCreateBook_InvalidYear - should throw exception
8. testFindById_Found - test finding existing book
9. testFindById_NotFound - test book not found
10. testFindById_NullId - should throw exception
11. testUpdate_Valid - test successful update
12. testDelete_Valid - test successful deletion
13. testFindAll - test finding all books
14. testFindByAuthor - test finding by author
15. testFindByGenre - test finding by genre

Use Mockito's when() and verify() methods.
All tests should have clear arrange-act-assert structure.
```

**Expected Test Structure:**

```java
package com.workshop.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Unit tests for BookService.
 */
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
        // Arrange
        Book book = createValidBook();
        when(repository.save(any(Book.class))).thenReturn(book);

        // Act
        Book result = service.create(book);

        // Assert
        assertNotNull(result);
        verify(repository).save(book);
    }

    @Test
    public void testCreateBook_NullBook() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.create(null);
        });
    }

    @Test
    public void testCreateBook_NullTitle() {
        // Arrange
        Book book = createValidBook();
        book.setTitle(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.create(book);
        });
    }

    @Test
    public void testCreateBook_EmptyAuthor() {
        // Arrange
        Book book = createValidBook();
        book.setAuthor("");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.create(book);
        });
    }

    @Test
    public void testCreateBook_NegativePrice() {
        // Arrange
        Book book = createValidBook();
        book.setPrice(-10.0);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.create(book);
        });
    }

    @Test
    public void testCreateBook_NegativeStock() {
        // Arrange
        Book book = createValidBook();
        book.setStockQuantity(-5);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.create(book);
        });
    }

    @Test
    public void testCreateBook_InvalidYearTooEarly() {
        // Arrange
        Book book = createValidBook();
        book.setPublishedYear(1400);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.create(book);
        });
    }

    @Test
    public void testCreateBook_InvalidYearFuture() {
        // Arrange
        Book book = createValidBook();
        book.setPublishedYear(2100);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.create(book);
        });
    }

    @Test
    public void testFindById_Found() {
        // Arrange
        Book book = createValidBook();
        when(repository.findById(1L)).thenReturn(Optional.of(book));

        // Act
        Optional<Book> result = service.findById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(book, result.get());
        verify(repository).findById(1L);
    }

    @Test
    public void testFindById_NotFound() {
        // Arrange
        when(repository.findById(999L)).thenReturn(Optional.empty());

        // Act
        Optional<Book> result = service.findById(999L);

        // Assert
        assertFalse(result.isPresent());
        verify(repository).findById(999L);
    }

    @Test
    public void testFindById_NullId() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.findById(null);
        });
    }

    @Test
    public void testUpdate_Valid() {
        // Arrange
        Book book = createValidBook();
        when(repository.update(eq(1L), any(Book.class))).thenReturn(book);

        // Act
        Book result = service.update(1L, book);

        // Assert
        assertNotNull(result);
        verify(repository).update(1L, book);
    }

    @Test
    public void testDelete_Valid() {
        // Arrange
        doNothing().when(repository).delete(1L);

        // Act
        service.delete(1L);

        // Assert
        verify(repository).delete(1L);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Book> books = Arrays.asList(createValidBook(), createValidBook());
        when(repository.findAll()).thenReturn(books);

        // Act
        List<Book> result = service.findAll();

        // Assert
        assertEquals(2, result.size());
        verify(repository).findAll();
    }

    @Test
    public void testFindByAuthor() {
        // Arrange
        List<Book> books = Arrays.asList(createValidBook());
        when(repository.findByAuthor("Robert Martin")).thenReturn(books);

        // Act
        List<Book> result = service.findByAuthor("Robert Martin");

        // Assert
        assertEquals(1, result.size());
        verify(repository).findByAuthor("Robert Martin");
    }

    @Test
    public void testFindByGenre() {
        // Arrange
        List<Book> books = Arrays.asList(createValidBook());
        when(repository.findByGenre("Technology")).thenReturn(books);

        // Act
        List<Book> result = service.findByGenre("Technology");

        // Assert
        assertEquals(1, result.size());
        verify(repository).findByGenre("Technology");
    }

    // Helper method
    private Book createValidBook() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Clean Code");
        book.setAuthor("Robert Martin");
        book.setIsbn("978-0132350884");
        book.setPublishedYear(2008);
        book.setGenre("Technology");
        book.setPrice(29.99);
        book.setStockQuantity(10);
        return book;
    }
}
```

---

## Step 7: Verify Everything Works (2 minutes)

### Compile

**Prompt to Claude:**
```
Compile the project: mvn compile
```

**Expected:** BUILD SUCCESS

### Run Tests

**Prompt to Claude:**
```
Run all tests: mvn test
```

**Expected:** All tests pass

### Update Progress

**Prompt to Claude:**
```
Update PROGRESS.md:
- Mark Challenge 6 as completed
- Note: "Created complete BookService with entity, repository, service, and 15 unit tests. All tests passing. Includes validation, logging, and follows all project rules."
```

---

## Alternative Approach: Using Custom Skill

If you created the java-service-generator skill in Challenge 3, you can use it:

```
/java-service-generator Book
```

Then customize the generated code:
1. Add business validation rules
2. Enhance tests with edge cases
3. Add logging
4. Verify everything follows project rules

---

## Success Verification

### Checklist
- [ ] Book.java entity created with all properties
- [ ] BookRepository.java interface with all methods
- [ ] BookService.java interface defined
- [ ] BookServiceImpl.java with:
  - [ ] Constructor injection
  - [ ] All CRUD methods
  - [ ] Validation for all business rules
  - [ ] Logging with Logger
  - [ ] All methods under 20 lines
  - [ ] Javadoc on all public methods
- [ ] BookServiceTest.java with:
  - [ ] Mocked repository
  - [ ] Tests for all CRUD operations
  - [ ] Tests for validation (nulls, business rules)
  - [ ] Tests for edge cases
  - [ ] At least 15 test methods
- [ ] Code compiles: `mvn compile`
- [ ] All tests pass: `mvn test`
- [ ] PROGRESS.md updated

---

## Key Achievements

**You've successfully:**
1. ✅ Built a complete REST API from scratch
2. ✅ Applied all Claude Code concepts learned
3. ✅ Used project rules automatically
4. ✅ Implemented comprehensive validation
5. ✅ Added proper logging
6. ✅ Created thorough test coverage
7. ✅ Followed professional coding standards

---

## Congratulations!

You've completed the Claude Code CLI Workshop! 🎉

Your `claude-code-workshop` now includes:
- Fixed Calculator
- Project rules configured
- Custom skill created
- Generated UserService
- Security audit completed
- Refactored OrderService
- **Complete BookService**

You're now ready to use Claude Code in your daily development work!

---

## Next Steps

1. Review your PROGRESS.md for the complete journey
2. Answer reflection questions
3. Keep claude-code-workshop as a reference
4. Apply Claude Code to your real projects
5. Share learnings with your team
