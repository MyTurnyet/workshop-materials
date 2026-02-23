# Strategy Card #1: Reading Files

## When to Use
When you need to view file contents to understand code, find bugs, or review structure.

## Command
```
Read [file_path]
```

## Key Points
- Claude uses Read tool automatically when you ask about files
- Can read any file Claude has access to
- Shows line numbers for easy reference
- Can read partial files (with offset/limit)

## Example Prompts
```
"Read Calculator.java to show me the percentage method"

"Read the test file to understand what's failing"

"Show me the contents of CalculatorService.java"
```

## Tips
- Start by reading test files to understand requirements
- Read multiple related files to understand relationships
- Reference specific line numbers when discussing code

## Related Tools
- Grep: Search file contents
- Glob: Find files by pattern

---
**Workshop Challenge:** Challenge 1 - Calculator Service
