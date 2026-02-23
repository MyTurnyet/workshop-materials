# Strategy Card #2: Making Edits

## When to Use
When you need to modify existing code (fix bugs, add features, refactor).

## Command
```
Edit [file_path]
old_string: [exact text to replace]
new_string: [replacement text]
```

## Key Points
- Edit tool requires EXACT string matching
- Include enough context to make the match unique
- Preserves indentation automatically
- Can replace all occurrences with replace_all flag

## Example Prompts
```
"Fix the percentage calculation bug by multiplying before dividing"

"Add logging to the performAddition method"

"Rename the calc method to calculateTotalValue"
```

## Tips
- Copy exact text from Read output for old_string
- If Edit fails (not unique), include more surrounding context
- Always verify with Read after editing
- Test changes with Bash after editing

## Common Mistakes
- Not matching indentation exactly
- Including line numbers in old_string
- String not unique in file

---
**Workshop Challenge:** Challenge 1 - Calculator Service
