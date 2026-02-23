# Strategy Card #14: Session Memory (/remember)

## When to Use
Use /remember to save important information that you'll need in future sessions or later in the current session.

## Command
```
/remember [information to save]
```

## What to Remember
- **Architectural Decisions:** "UserService uses repository pattern"
- **Design Choices:** "We're using JWT for authentication, not sessions"
- **Refactoring Plans:** "Extract 5 responsibilities from UserManagementService"
- **Important Context:** "Database uses PostgreSQL 12"
- **Conventions:** "All dates use ISO-8601 format"

## Example Usage
```
/remember UserManagementService needs to be split into 5 classes: UserService, UserValidator, EmailService, AuditLogger, and CacheService

/remember We decided to use bcrypt for password hashing, not MD5

/remember API follows RESTful conventions: GET /api/users, POST /api/users, etc.
```

## Benefits
- Information persists across sessions
- No need to re-explain context
- Helps maintain consistency
- Useful for long-running projects

## Best Practices
- Remember key decisions, not implementation details
- Use clear, concise statements
- Remember "why" not just "what"
- Update/correct if decisions change

## When It's Useful
- Multi-session refactorings
- Long-term projects
- Team conventions
- Architecture patterns

## Retrieving Memories
Claude will automatically reference remembered information when relevant. You can also ask: "What have we remembered about this project?"

---
**Workshop Challenge:** Challenge 5 - Legacy System
