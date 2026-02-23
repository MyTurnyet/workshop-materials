# Strategy Card #10: When to Delegate to Sub-agents

## When to Use Sub-agents

### Large Codebase Searches
- Searching across 20+ files
- Finding patterns across modules
- Understanding architecture

### Complex Multi-step Tasks
- Tasks requiring multiple tool invocations
- Research that needs thorough exploration
- Tasks that can work independently

### Parallel Work
- Multiple independent searches
- Running different analyses simultaneously
- Background research while you work

## Sub-agent Types

### Explore Agent
**Use for:** Finding code, understanding patterns, research
**Example:** "Use Explore agent to find all authentication code"

### Plan Agent
**Use for:** Designing implementations, architectural decisions
**Example:** "Use Plan agent to design new API endpoint"

### Bash Agent
**Use for:** Complex terminal operations
**Example:** "Use Bash agent to run test suite and analyze failures"

## When NOT to Use
- Simple, single-file tasks
- Quick edits
- When you already know the answer
- Tasks requiring immediate interaction

## Example Prompt
```
Use Task tool with Explore sub-agent to find all files related to authentication. Look for JWT, token, and security-related code.
```

## Tips
- Give sub-agents clear, specific objectives
- Let them work autonomously
- Review findings and ask follow-ups
- Use for tasks that would take you 5+ tool calls

---
**Workshop Challenge:** Challenge 4 - E-commerce API
