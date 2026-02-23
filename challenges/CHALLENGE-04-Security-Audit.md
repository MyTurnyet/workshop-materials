# Challenge 4: Security Audit with Sub-agents

**Duration:** 10 minutes
**Difficulty:** Advanced
**Project:** claude-code-workshop (same directory)

## Learning Objectives
- Understand when to use Task tool with sub-agents
- Learn different sub-agent types (Explore, Plan, Bash)
- Delegate complex searches to sub-agents
- Perform security analysis

## Scenario

The platform has authentication code in the `auth/` package. Your task is to use sub-agents to efficiently find all auth-related code and identify security vulnerabilities.

## Your Mission

1. **Use Explore sub-agent** - Find all authentication code
2. **Analyze findings** - Understand the auth system
3. **Find vulnerabilities** - Identify security issues
4. **Document findings** - Create security audit report

## Starting Point

You're in `claude-code-workshop/` with:
- AuthService.java (has security issues)
- TokenService.java (has security issues)
- Growing codebase with multiple packages

## Tasks

### Task 1: Find All Auth Code (3 min)

**Prompt to Claude:**
```
Use Task tool with Explore sub-agent to find all files related to authentication in this codebase. Look for files with: auth, token, JWT, authentication, and security-related code.
```

Expected findings:
- `auth/AuthService.java`
- `auth/TokenService.java`
- References in other files

### Task 2: Understand Auth Flow (2 min)

**Prompt to Claude:**
```
Based on the files found, explain how authentication works in this platform:
1. How does a user authenticate?
2. How are tokens generated?
3. How are tokens validated?
```

### Task 3: Security Audit (4 min)

**Prompt to Claude:**
```
Use Task tool with Explore sub-agent to identify security vulnerabilities in the authentication code. Look for:
1. Hardcoded credentials
2. Weak password hashing
3. Hardcoded secrets
4. Missing validation
5. Weak token generation
6. Memory leaks
```

Expected vulnerabilities found:
- Hardcoded admin credentials in AuthService
- MD5 password hashing (weak)
- Hardcoded JWT secret in TokenService
- No null checks
- Weak token signing
- Token blacklist memory leak (no cleanup)

### Task 4: Document Findings (1 min)

**Prompt to Claude:**
```
Create a file auth/SECURITY_AUDIT.md documenting all security issues found, their severity, and recommended fixes.
```

## Success Criteria

- [ ] Used Task tool with Explore sub-agent
- [ ] Found all auth-related files
- [ ] Identified at least 5 security vulnerabilities
- [ ] Created SECURITY_AUDIT.md with findings
- [ ] Understand when to use sub-agents
- [ ] PROGRESS.md updated

## Strategy Cards

- **Card #10 - When to Delegate:** Use sub-agents for large searches
- **Card #11 - Sub-agent Types:** Explore=search, Plan=design, Bash=commands
- **Card #12 - Sub-agent Prompts:** Give clear, specific objectives

## Expected Security Issues

Your sub-agent should find:

### Critical Issues
1. **Hardcoded Credentials** - AuthService.java:8-9
   - Admin username and password in code
   - Fix: Use environment variables

2. **Weak Password Hashing** - AuthService.java:23
   - Using MD5 (broken algorithm)
   - Fix: Use bcrypt or Argon2

### High Priority
3. **Hardcoded JWT Secret** - TokenService.java:12
   - Secret key in source code
   - Fix: Use environment variable

4. **Weak Token Generation** - TokenService.java:18
   - Not using standard JWT library
   - Fix: Use proper JWT library

### Medium Priority
5. **Memory Leak** - TokenService.java:15
   - Blacklist never cleans up
   - Fix: Implement cleanup or use Redis

6. **No Null Checks** - TokenService.java:28
   - Can cause NullPointerException
   - Fix: Add validation

## Hints

### Hint 1
Sub-agents work independently and return comprehensive findings. Give them clear objectives.

### Hint 2
The Explore agent can use Grep, Glob, and Read tools to search the codebase thoroughly.

### Hint 3
After sub-agent returns, you can ask follow-up questions about specific findings.

## What's Next

After completing this challenge:
1. Update PROGRESS.md
2. Review SECURITY_AUDIT.md
3. Move to Challenge 5

**Challenge 5** will refactor the messy OrderService using context management and /remember.

## Why Sub-agents?

**Without sub-agents:**
- Manually search auth files
- Read each file individually
- Easy to miss issues
- Time-consuming

**With Explore sub-agent:**
- Comprehensive search
- Thorough analysis
- Returns organized findings
- Much faster

## Real-World Application

Use sub-agents for:
- Security audits across large codebases
- Finding all uses of deprecated APIs
- Understanding unfamiliar codebases
- Researching best practices
- Complex multi-file analyses
