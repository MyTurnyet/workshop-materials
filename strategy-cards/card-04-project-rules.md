# Strategy Card #4: Project Rules

## When to Use
When starting a new project or want to enforce coding standards across all Claude Code interactions.

## Location
```
.claude/rules.md
```

## Purpose
Define project-specific rules that Claude will follow automatically for ALL interactions in this project.

## Common Rules
- Method length limits (e.g., "methods under 20 lines")
- Documentation requirements (e.g., "Javadoc on all public methods")
- Naming conventions (e.g., "Google Java Style Guide")
- Architecture patterns (e.g., "use constructor injection")
- Logging standards (e.g., "use SLF4J, not System.out")

## Example Rules File
```markdown
# Project Coding Standards

## Method Length
- All methods must be under 20 lines

## Documentation
- All public methods must have Javadoc

## Naming
- Follow Google Java Style Guide
- No abbreviations
```

## Benefits
- Consistent code quality
- No need to repeat standards
- Enforced automatically
- Can be version controlled

## Tips
- Be specific ("methods under 20 lines" not "keep methods small")
- Start with most important rules
- Can update rules anytime
- Share rules across team

---
**Workshop Challenge:** Challenge 2 - Inventory System
