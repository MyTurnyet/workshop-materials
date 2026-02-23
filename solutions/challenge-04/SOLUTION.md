# Challenge 4 Solution: E-commerce API Sub-agents

## Overview

This solution demonstrates how to use sub-agents, particularly the Explore agent, to analyze a large codebase efficiently.

## Step 1: Use Explore Agent to Find Authentication Code (3 minutes)

**Prompt to Claude:**
```
Use Task tool with Explore sub-agent to find all files related to authentication in this codebase. Look for files containing: JWT, token, authentication, auth, security, login, password, and credentials.
```

**Claude Code will:**
1. Invoke Task tool with subagent_type="Explore"
2. Explore agent will use Grep, Glob, and Read tools to search
3. Return comprehensive list of authentication-related files

**Expected Findings:**
- `auth/AuthController.java` - Authentication endpoints
- `auth/AuthService.java` - Authentication logic
- `auth/TokenService.java` - JWT token management
- `security/JwtAuthFilter.java` - Request authentication filter
- `security/SecurityConfig.java` - Security configuration
- `security/JwtUtil.java` - JWT utilities (if present)
- `user/UserRepository.java` - User data access

## Step 2: Analyze Authentication Flow (3 minutes)

**Prompt to Claude:**
```
Based on the files found, explain the complete authentication flow:
1. How does a user log in?
2. How are tokens generated?
3. How are subsequent requests authenticated?
4. Where is the authentication logic implemented?
```

**Expected Analysis:**

### Authentication Flow

1. **Login Request** (`AuthController.login()`)
   - User sends username + password to `/api/auth/login`
   - AuthController receives request

2. **Credential Verification** (`AuthService.authenticate()`)
   - AuthService queries UserRepository for user
   - Password is hashed and compared
   - If valid, User object returned

3. **Token Generation** (`TokenService.generateToken()`)
   - TokenService creates JWT using JwtUtil
   - Token includes username and user ID
   - Token signed with secret key

4. **Response**
   - Token returned to client in AuthResponse
   - Client stores token (typically in localStorage or cookie)

5. **Authenticated Requests** (`JwtAuthFilter`)
   - Client includes token in Authorization header
   - JwtAuthFilter intercepts request
   - Token extracted and validated
   - If valid, request proceeds; if not, 401 returned

### Key Components

- **AuthController**: HTTP endpoints (login, register, refresh, logout)
- **AuthService**: Business logic (authentication, registration)
- **TokenService**: Token lifecycle (generate, validate, invalidate)
- **JwtAuthFilter**: Request interceptor for authentication
- **SecurityConfig**: Security configuration

## Step 3: Security Audit with Explore Agent (3 minutes)

**Prompt to Claude:**
```
Use Task tool with Explore sub-agent to perform a security audit of the authentication system. Look for:
1. Hardcoded secrets or credentials
2. Weak password hashing
3. Missing input validation
4. SQL injection vulnerabilities
5. Insecure token handling
6. CORS misconfigurations
7. Logging of sensitive data
```

**Claude Code will:**
1. Invoke Explore agent with security focus
2. Agent searches for security anti-patterns
3. Returns list of vulnerabilities found

**Expected Security Issues Found:**

### 1. Hardcoded JWT Secret
**File:** `TokenService.java:11`
```java
private static final String JWT_SECRET = "mySecretKey123";
```
**Severity:** HIGH
**Fix:** Use environment variables or secure vault

### 2. Weak Password Hashing (MD5)
**File:** `AuthService.java:36-44`
```java
MessageDigest md = MessageDigest.getInstance("MD5");
```
**Severity:** CRITICAL
**Fix:** Use bcrypt, Argon2, or PBKDF2

### 3. No Password Strength Validation
**File:** `AuthService.java:27`
**Severity:** MEDIUM
**Fix:** Implement password requirements (length, complexity)

### 4. SQL Injection Risk
**File:** `AuthService.java:16` (comment indicates)
**Severity:** CRITICAL
**Fix:** Use parameterized queries/prepared statements

### 5. No Null Check for Auth Header
**File:** `JwtAuthFilter.java:29`
```java
String token = authHeader.substring(7); // No null check!
```
**Severity:** HIGH
**Fix:** Validate authHeader before using

### 6. No Token Refresh Validation
**File:** `TokenService.java:22-26`
**Severity:** MEDIUM
**Fix:** Validate old token before issuing new one

### 7. Token Blacklist Memory Leak
**File:** `TokenService.java:32-35`
**Severity:** MEDIUM
**Fix:** Implement cleanup mechanism or use Redis

### 8. Debug Mode in Production
**File:** `SecurityConfig.java:10`
```java
private static final boolean DEBUG_MODE = true;
```
**Severity:** HIGH
**Fix:** Use environment-based configuration

### 9. CORS Wildcard
**File:** `SecurityConfig.java:13`
```java
private static final String ALLOWED_ORIGINS = "*";
```
**Severity:** HIGH
**Fix:** Specify allowed origins explicitly

### 10. Sensitive Data in Logs
**File:** `SecurityConfig.java:32`
**Severity:** HIGH
**Fix:** Never log secrets or credentials

### 11. Insecure Session Configuration
**File:** `SecurityConfig.java:22-27`
**Severity:** MEDIUM
**Fix:** Shorter timeout, secure cookies

## Step 4: Document Findings (1 minute)

**Prompt to Claude:**
```
Create a security audit report document summarizing:
1. Authentication flow
2. Files involved
3. Security vulnerabilities found
4. Recommended fixes
5. Priority order
```

**Expected Document:**

```markdown
# E-commerce API Authentication Security Audit

## Executive Summary

Conducted security audit of authentication system. Found 11 security issues ranging from MEDIUM to CRITICAL severity.

## Authentication Flow

[Diagram or description from Step 2]

## Files Analyzed

- auth/AuthController.java
- auth/AuthService.java
- auth/TokenService.java
- security/JwtAuthFilter.java
- security/SecurityConfig.java
- security/JwtUtil.java
- user/UserRepository.java

## Critical Issues (Fix Immediately)

1. Weak password hashing (MD5) - CRITICAL
2. SQL injection vulnerability - CRITICAL

## High Priority Issues

3. Hardcoded JWT secret
4. No null check in auth filter (NPE risk)
5. Debug mode enabled
6. CORS wildcard configuration
7. Logging sensitive data

## Medium Priority Issues

8. No password strength validation
9. Token refresh not validated
10. Token blacklist memory leak
11. Insecure session configuration

## Recommendations

### Immediate Actions
- Replace MD5 with bcrypt/Argon2
- Fix SQL injection with parameterized queries
- Move JWT secret to environment variable

### Short-term Actions
- Add null checks in filter
- Disable debug mode
- Configure CORS properly
- Remove sensitive logging

### Long-term Improvements
- Implement password strength requirements
- Add token refresh validation
- Use Redis for token blacklist
- Secure session configuration
```

## Key Learning Points

### 1. Sub-agents are Powerful for Exploration
Without sub-agents: Manually read 50+ files
With Explore agent: Comprehensive analysis in minutes

### 2. Clear Prompts Get Better Results
Specific prompt: "Look for hardcoded secrets, weak hashing, SQL injection"
Better than: "Check for security issues"

### 3. Sub-agents Can Use Multiple Tools
Explore agent uses: Grep, Glob, Read, and more
Works autonomously to complete task

### 4. Follow-up Questions Work
After sub-agent returns, you can ask:
- "Explain this vulnerability in detail"
- "How would you fix issue #3?"
- "Are there similar issues in other files?"

## Common Issues & Troubleshooting

### Issue 1: "Sub-agent didn't find everything"
**Solution:** Provide more specific search terms or ask follow-up questions

### Issue 2: "Don't understand sub-agent findings"
**Solution:** Ask Claude to explain specific findings in detail

### Issue 3: "Sub-agent took too long"
**Solution:** Normal for large codebases; sub-agents are thorough

## Time Breakdown

- **3 min:** Explore agent finds auth files
- **3 min:** Analyze authentication flow
- **3 min:** Security audit with Explore agent
- **1 min:** Document findings

**Total: 10 minutes**

## Alternative Approaches

### Use Multiple Sub-agents in Parallel
```
1. Launch Explore agent for auth code
2. Launch another Explore agent for security issues
3. Both work simultaneously
4. Combine findings
```

### Use Bash Sub-agent for Security Tools
```
Use Bash sub-agent to run:
- SpotBugs for static analysis
- OWASP Dependency Check
- Custom security scanners
```

## Next Challenge

Proceed to Challenge 5: Context Management where you'll learn to manage long-running sessions and save your work.
