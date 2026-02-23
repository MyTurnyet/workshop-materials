# 👋 Welcome to the Claude Code CLI Workshop!

## Quick Start for Facilitators

**New to this workshop?** Start here!

### 1️⃣ Understand What This Is (2 minutes)
Read: `README.md` - Workshop overview and structure

### 2️⃣ See What's Included (2 minutes)  
Read: `FINAL_PACKAGE_SUMMARY.md` - Complete package contents

### 3️⃣ Verify the Project Works (5 minutes)
```bash
cd starter-project/claude-code-workshop
mvn clean compile    # Should succeed
mvn test             # Should have 2 failures (expected!)
```

### 4️⃣ Learn How to Facilitate (30 minutes)
Read: `facilitator/FACILITATOR_GUIDE.md` - Detailed facilitation instructions

### 5️⃣ Try a Challenge Yourself (20 minutes)
Follow: `challenges/CHALLENGE-01-Fix-Calculator.md`
Use: `solutions/challenge-01/SOLUTION.md` if you get stuck

### 6️⃣ Schedule Your Workshop
- Send `facilitator/PRE_WORKSHOP_SETUP.md` to participants (1 week before)
- Review facilitator guide one more time
- Run the workshop!

---

## Quick Start for Participants

**Here for the workshop?** Start here!

### 1️⃣ Complete Setup (Before Workshop Day)
Follow: `facilitator/PRE_WORKSHOP_SETUP.md`

### 2️⃣ Verify Your Setup
```bash
cd claude-code-workshop
mvn compile    # Should succeed
mvn test       # Should have 2 failures
claude code    # Should start
```

### 3️⃣ On Workshop Day
- Bring laptop with setup completed
- Open `claude-code-workshop` directory
- Follow challenges as instructor guides
- Track progress in `PROGRESS.md`

---

## File Navigation

### 📁 Essential Files
- `README.md` - Workshop overview
- `WORKSHOP_READY.md` - Delivery checklist  
- `FINAL_PACKAGE_SUMMARY.md` - Complete package summary

### 📂 Essential Directories
- `starter-project/claude-code-workshop/` - THE PROJECT
- `challenges/` - 6 challenge guides
- `solutions/` - Step-by-step solutions
- `facilitator/` - Setup + facilitation guide

### 🆘 Need Help?
- **Setup issues**: Check `facilitator/PRE_WORKSHOP_SETUP.md` troubleshooting
- **During workshop**: Use hints in `hints/` directory
- **Stuck on challenge**: Check `solutions/` directory
- **Quick reference**: Use `resources/COMMAND_REFERENCE.md`

---

## Workshop At A Glance

**Duration:** 2 hours
**Format:** Challenge-based, hands-on
**Project:** Single claude-code-workshop that evolves

**Challenges:**
1. Fix Calculator (20 min) - Learn basic commands
2. Add Project Rules (10 min) - Configure standards
3. Generate UserService (10 min) - Create automation
4. Security Audit (10 min) - Use sub-agents
5. Refactor OrderService (15 min) - Manage context
6. Build BookService (20 min) - Integrate everything

**What participants leave with:**
- Working knowledge of Claude Code CLI
- Complete claude-code-workshop project
- Custom automation skill
- Confidence to use at work

---

## Status: ✅ READY TO RUN

All materials complete. Workshop can be delivered immediately.

**Let's get started!** 🚀
