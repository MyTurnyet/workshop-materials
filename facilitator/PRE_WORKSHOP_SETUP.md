# Pre-Workshop Setup Guide

**Send to Participants:** 1 week before workshop
**Estimated Time:** 15-20 minutes

## Overview

This workshop uses Claude Code CLI to teach AI-assisted development. You'll need to complete this setup before the workshop to ensure we can start on time.

## Prerequisites

- **Java 11 or higher** installed
- **Maven 3.6 or higher** installed
- **Git** (optional, for cloning)
- **Anthropic API key** (you'll get instructions)
- **Terminal/Command line** familiarity

## Step 1: Verify Java and Maven

Open your terminal and run:

```bash
java -version
```
**Expected:** Version 11 or higher

```bash
mvn -version
```
**Expected:** Maven 3.6 or higher

**If not installed:**
- Java: https://adoptium.net/
- Maven: https://maven.apache.org/install.html

## Step 2: Install Claude Code CLI

### macOS/Linux

```bash
# Install via curl
curl -fsSL https://raw.githubusercontent.com/anthropics/claude-code/main/install.sh | sh
```

### Windows

```powershell
# Install via PowerShell
irm https://raw.githubusercontent.com/anthropics/claude-code/main/install.ps1 | iex
```

### Verify Installation

```bash
claude --version
```

**Expected:** Version number displayed (1.0.0 or higher)

## Step 3: Get Anthropic API Key

1. Go to: https://console.anthropic.com/
2. Sign up or log in
3. Navigate to API Keys section
4. Create a new API key
5. **Save this key securely** - you'll need it in the next step

**Note:** You may need to add credit to your account. The workshop typically uses $2-5 of API credits.

## Step 4: Configure Claude Code

Run the configuration command:

```bash
claude code configure
```

When prompted:
- **API Key:** Paste your Anthropic API key
- **Default Model:** Press Enter (uses default)
- **Other settings:** Press Enter for defaults

## Step 5: Download Workshop Project

### Option A: Download Zip
1. Download `claude-code-workshop.zip` from [workshop URL]
2. Extract to your preferred location
3. Note the directory path

### Option B: Clone Repository
```bash
git clone [repository-url]
cd workshop-materials/starter-project/claude-code-workshop
```

## Step 6: Verify Project Setup

Navigate to the project directory:

```bash
cd path/to/claude-code-workshop
```

Compile the project:

```bash
mvn clean compile
```

**Expected:**
- `BUILD SUCCESS` message
- Warnings are OK
- No compilation errors

Run the tests:

```bash
mvn test
```

**Expected:**
- Some tests should FAIL (2 failing tests is correct!)
- Tests: run 8, Failures: 2, Errors: 0, Skipped: 0
- This is intentional - you'll fix them in Challenge 1

**If you see this output, you're ready for the workshop!** ✅

## Step 7: Test Claude Code

Start Claude Code in the project directory:

```bash
claude code
```

**Expected:** Claude Code CLI starts with a prompt like:
```
Claude Code is running...
>
```

Try a simple command:

```
> Read README.md
```

**Expected:** Claude reads and displays the README file.

Exit Claude Code:

```
> exit
```

Or press: `Ctrl+C`

## Verification Checklist

Before the workshop, confirm:

- [ ] Java 11+ installed (`java -version`)
- [ ] Maven 3.6+ installed (`mvn -version`)
- [ ] Claude Code CLI installed (`claude --version`)
- [ ] Anthropic API key configured
- [ ] Workshop project downloaded
- [ ] Project compiles successfully (`mvn compile`)
- [ ] Tests run (2 failures expected) (`mvn test`)
- [ ] Claude Code starts in project directory
- [ ] Can read files with Claude Code

## Troubleshooting

### Issue: "claude: command not found"

**Solution:**
1. Restart your terminal
2. Check installation path is in PATH
3. Try reinstalling Claude Code

### Issue: "API key not configured"

**Solution:**
```bash
claude code configure
```
Re-enter your API key

### Issue: Maven build fails with "Java version too old"

**Solution:**
Update your `pom.xml` to match your Java version:
```xml
<maven.compiler.source>YOUR_VERSION</maven.compiler.source>
<maven.compiler.target>YOUR_VERSION</maven.compiler.target>
```

### Issue: "Tests don't fail as expected"

**Expected Failures:**
- `testPercentageCalculation` - should FAIL
- `testPercentageWithLargeNumbers` - should FAIL

If all tests pass, you may have the solution version. Re-download the starter project.

### Issue: Network/firewall blocking Anthropic API

**Solution:**
- Check corporate firewall settings
- Ensure https://api.anthropic.com is accessible
- May need to configure proxy settings

## Getting Help

If you encounter issues during setup:

1. **Check troubleshooting section above**
2. **Email workshop facilitator:** [email]
3. **Slack channel:** [if applicable]
4. **Bring laptop to workshop** - we can help during setup time

**Important:** Please complete setup before the workshop. We have limited time to troubleshoot on the day.

## What to Bring

On workshop day, bring:
- Laptop with setup completed
- Power adapter
- Notebook for notes (optional)
- Enthusiasm for learning!

## Workshop Day

We'll start promptly at [TIME]. Plan to arrive 10 minutes early for any last-minute setup verification.

You'll be working in the `claude-code-workshop` directory throughout the entire workshop - no need to download or switch projects!

## Questions?

Contact: [facilitator email/slack]

See you at the workshop!
