# Task-Based Design Introduction
## For Facilitators - Present Before Challenge 5

**Timing**: 5 minutes
**When**: After Challenge 4 wrap-up (around 1:15 mark), before starting Challenge 5

---

## Introduction Script

### Opening (1 minute)

"Before we start Challenge 5, I want to introduce you to a powerful technique for working with Claude Code: **task-based design**.

Think about this: when you work with another developer on a feature, what's the first thing you do? You plan together, right? You break down the work, agree on what needs to happen, and track progress.

The same principle applies when working with Claude. Task-based design means creating a **checklist markdown file** that acts as a contract between you and Claude."

### The Concept (2 minutes)

**What is it?**
"Task-based design is simple: before implementing a feature, you create a markdown checklist that lists all the tasks needed. Claude can help you create this checklist, and then you work through it together.

**Why use it?**
Let me show you why this matters:

1. **Prevents scope creep** - Clear boundaries on what you're building
2. **Tracks progress** - You always know where you are
3. **Maintains context** - Claude can reference the plan throughout
4. **Creates documentation** - You have a record of what was done

**When to use it?**
Use task-based design whenever you're working on:
- Features with 3 or more implementation steps
- Changes spanning multiple files
- Complex refactoring
- Anything you might need to pause and resume later

### Example Demonstration (1.5 minutes)

"Let me show you what this looks like in practice."

**[Display example checklist]**

```markdown
# BookService Implementation Plan

## Setup
- [ ] Create Book entity class
- [ ] Create BookRepository interface
- [ ] Create BookService class skeleton

## Core Implementation
- [ ] Implement createBook method
- [ ] Implement findBookById method
- [ ] Add validation logic

## Testing
- [ ] Write unit tests
- [ ] Run all tests
- [ ] Verify coverage
```

"Notice the structure:
- Organized into phases (Setup, Implementation, Testing)
- Each task is specific and actionable
- Uses standard markdown checkbox syntax: `- [ ]` for incomplete
- You check off items as you complete them: `- [x]`

You can ask Claude: 'Please analyze the requirements and create a task checklist in TASKS.md' - and Claude will generate something like this for you."

### Practice in Challenges (30 seconds)

"You'll practice this technique twice today:

**Challenge 5**: Claude will generate a refactoring checklist for you. Your job is to follow it and see how it helps maintain focus.

**Challenge 6**: You'll use the full workflow - work WITH Claude to create the checklist, refine it, track progress, and use `/remember` to maintain context.

By the end, you'll have a technique you can use on every project."

### Closing & Strategy Card Reference (30 seconds)

"I'm giving you Strategy Card 15 on Task-Based Design as a reference. It has example prompts and tips for creating effective checklists.

Remember: the checklist is a guide, not a prison. You can refine it as you go. The goal is clarity and communication with Claude.

Any quick questions before we dive into Challenge 5?"

---

## Visual Aid Suggestion

If using slides, create one slide with:

**Title**: Task-Based Design with Claude

**Content**:
- **What**: Markdown checklist as a "contract" with Claude
- **Why**: Planning, tracking, context management
- **When**: Features with 3+ steps, multi-file changes, refactoring
- **How**: Ask Claude to create checklist → Work through it together

**Example** (show simple 3-task checklist)

---

## Facilitator Notes

**Key Points to Emphasize:**
- This is a professional practice, not just a workshop exercise
- Saves time in the long run (even though it feels like overhead)
- Makes complex tasks manageable
- You and Claude create the plan together

**Common Questions & Answers:**

**Q: "Isn't this extra work?"**
A: "It feels like it at first, but planning actually saves time by preventing false starts and keeping you focused. Try it in Challenge 5 and see."

**Q: "How detailed should the checklist be?"**
A: "Typically 5-10 tasks for a feature. If you have more than 15, you might be breaking things down too much. If fewer than 3, you probably don't need a checklist."

**Q: "What if the plan changes mid-implementation?"**
A: "That's fine! Update the checklist. Ask Claude: 'We need to add a task for validation between steps 3 and 4.' The checklist evolves with your understanding."

**Q: "Do I have to use this every time?"**
A: "No. For quick one-line fixes, skip it. For anything that takes more than 5 minutes or touches multiple files, consider using it."

**Tone & Energy:**
- Keep it practical and concrete
- Show enthusiasm but don't oversell
- Emphasize: "Try it and see if it helps YOU"
- Frame as a professional technique, like using git branches

**Timing Tips:**
- If running behind: Cut demonstration to 1 minute, show example only
- If ahead of schedule: Take 1-2 questions
- Don't let this section exceed 6 minutes total

---

## After Introduction

**Transition to Challenge 5:**
"Alright, let's put this into practice. Challenge 5 is about refactoring OrderService, and you're going to start by having Claude create a refactoring checklist for you. Open CHALLENGE-05-Refactor-OrderService.md to begin."

**What to Watch For During Challenge 5:**
- Participants actually creating the checklist (don't skip this step!)
- Format issues (help with markdown syntax if needed)
- Participants referencing the checklist as they work
- People checking off completed tasks

**Quick Checkpoint at 5-minute mark:**
"Everyone should have a checklist by now. If you don't, raise your hand."
