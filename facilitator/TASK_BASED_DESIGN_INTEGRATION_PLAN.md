# Task-Based Design Integration Plan
## Claude Code CLI Workshop Enhancement

## Overview
This plan outlines how to integrate task-based design practice into the Claude Code CLI workshop. Participants will learn to use markdown checklists as a planning, tracking, and collaboration tool when working with Claude. This practice will be introduced conceptually before Challenge 5 and practiced in Challenges 5 and 6.

## Goals
- **Primary goal**: Teach participants to use task checklists as a "contract" between them and Claude for implementing features
- **Secondary goals**:
  - Show how to plan before coding using Claude-generated task lists
  - Demonstrate progress tracking during implementation
  - Reinforce context management by combining checklists with /remember
- **Success metrics**:
  - 80%+ of participants create and use a checklist in Challenge 5
  - 60%+ of participants successfully use full workflow (plan, track, refine, /remember) in Challenge 6
  - Positive feedback on usefulness of task-based approach

## Proposed Solutions

### Normal Approaches

#### 1. **Simple Introduction + Practice Model**
- **Description**: Add a brief explanation slide/section before Challenge 5, then have participants practice creating checklists with Claude's help in both challenges
- **Pros**:
  - Easy to integrate without major restructuring
  - Minimal time overhead (5-7 minutes for introduction)
  - Natural progression from basic to advanced usage
  - Leverages existing challenge structure
- **Cons**:
  - May feel rushed if participants don't grasp concept quickly
  - Limited time to troubleshoot if participants struggle
  - No dedicated practice before applying to real challenge

#### 2. **Dedicated Mini-Challenge Approach**
- **Description**: Create a new "Challenge 2.5" focused entirely on task-based design, where participants practice creating a simple checklist for a trivial feature before applying to real challenges
- **Pros**:
  - Dedicated learning time ensures understanding
  - Safe practice environment before real application
  - Can include detailed examples and templates
  - Participants have reference material
- **Cons**:
  - Adds 10-15 minutes to workshop timeline
  - May feel like overhead if feature is too simple
  - Requires creating new challenge materials and solutions
  - Breaks flow between existing challenges

### Non-Obvious Approaches

#### 3. **Retrospective Refactoring Approach**
- **Description**: In Challenge 5, have participants FIRST refactor OrderService without a checklist (5 minutes), THEN have Claude analyze what they did and generate a "reverse-engineered" checklist showing what they actually accomplished. Then use proper task-based design for Challenge 6.
- **Pros**:
  - Participants experience the contrast between unstructured and structured approaches
  - Creates "aha moment" when they see value of planning
  - Teaches both planning AND documenting completed work
  - No additional time needed (uses Challenge 5 time differently)
  - Unique pedagogical approach that sticks in memory
- **Cons**:
  - May confuse participants about when to use checklists
  - Risk that participants like unstructured approach and resist checklists
  - Requires careful facilitation to frame the lesson correctly

#### 4. **Pair Planning Protocol Approach**
- **Description**: Introduce checklists as a "protocol" for human-AI pair programming. Create a strategy card that frames it as a communication pattern: "When starting complex work, agree on the plan first." Integrate examples throughout challenges where Claude asks "Should I create a checklist for this?"
- **Pros**:
  - Frames checklists as professional practice, not just workshop exercise
  - Makes concept transferable to real work (participants will use it naturally)
  - Can be introduced gradually across multiple challenges
  - Teaches meta-skill of when to use structured vs. unstructured approaches
  - Creates a mental model: "Claude and I agree on a plan together"
- **Cons**:
  - More abstract concept may take longer to grasp
  - Requires creating new strategy card and updating multiple challenges
  - Facilitator needs to model the behavior consistently
  - May not fit time constraints if not carefully designed

## Recommended Approach

**Hybrid: Simple Introduction + Pair Planning Protocol**

Combine approaches #1 and #4 for maximum effectiveness within time constraints:

1. **Before Challenge 5**: Add 5-minute introduction to task-based design framed as a pair programming protocol
2. **Challenge 5**: Claude generates checklist, participants follow it while refactoring OrderService
3. **Challenge 6**: Full workflow - participants work WITH Claude to create, refine, and track checklist
4. **Support materials**: Create strategy card on task-based design for ongoing reference

**Why this combination:**
- Minimal time overhead (5 minutes introduction)
- Frames concept professionally (pair programming protocol)
- Progressive complexity (generated → collaborative)
- Creates transferable mental model
- Includes reference material (strategy card)
- Works within existing time constraints

## Tasks & Milestones

### Phase 1: Content Creation
- [ ] Write introduction section/slide explaining task-based design concept
- [ ] Create Strategy Card: "Task-Based Design with Claude" (card-15)
- [ ] Update CHALLENGE-05 to include task checklist generation step
- [ ] Update CHALLENGE-06 to include full task-based workflow
- [ ] Create example checklist templates for reference

### Phase 2: Solution Materials
- [ ] Create solution for Challenge 5 showing expected checklist format
- [ ] Create solution for Challenge 6 showing iterative checklist refinement
- [ ] Add hints for each challenge related to checklist creation
- [ ] Update facilitator guide with timing and talking points

### Phase 3: Supporting Materials
- [ ] Update FACILITATOR_GUIDE.md with task-based design facilitation notes
- [ ] Add task-based design section to QUICK_START_GUIDE.md
- [ ] Update PROGRESS.md template to include checklist usage tracking
- [ ] Create facilitator talking points for introduction

### Phase 4: Testing & Refinement
- [ ] Test updated Challenge 5 with checklist generation
- [ ] Test updated Challenge 6 with full workflow
- [ ] Verify timing fits within existing schedule
- [ ] Get feedback on clarity of instructions

## Detailed Implementation Plan

### Introduction Before Challenge 5 (5 minutes)

**Timing**: After Challenge 4 wrap-up (around 1:15 mark), before starting Challenge 5

**Content to cover:**
1. **Concept**: "Task checklists as a contract between you and Claude"
2. **Why**: Planning prevents scope creep, tracks progress, maintains context
3. **How**: Ask Claude to create a checklist markdown file with implementation tasks
4. **When**: Use for any feature that has 3+ steps or spans multiple files

**Format**:
- 1 slide or verbal explanation
- Show example checklist (BookService or similar)
- Emphasize: "You'll practice this in Challenges 5 and 6"

### Updated Challenge 5: Refactor OrderService (15 minutes)

**New workflow:**
1. **Phase 1: Planning (3 min)**
   - Ask Claude: "Please analyze OrderService and create a refactoring checklist in REFACTOR-TASKS.md"
   - Review the generated checklist
   - Use /remember to save the plan

2. **Phase 2: Execute (8 min)**
   - Work through checklist items with Claude
   - Reference checklist as you go
   - Claude checks off completed items (or participants do)

3. **Phase 3: Close/Resume (2 min)**
   - Exit Claude Code
   - Restart and reference the checklist
   - Verify Claude remembers the context

4. **Phase 4: Verify (2 min)**
   - Check all items completed
   - Run tests

**Key learning**: Claude generates plan, you follow it together

### Updated Challenge 6: Build BookService Capstone (20 minutes)

**New workflow:**
1. **Phase 1: Collaborative Planning (4 min)**
   - Discuss requirements with Claude
   - Ask: "Let's create a comprehensive checklist together for building BookService"
   - Review and refine the generated checklist
   - Add any missing items participants identify

2. **Phase 2: Implementation (12 min)**
   - Work through checklist systematically
   - Check off items as completed (actively update the file)
   - Use /remember for key decisions
   - Refine checklist if scope changes

3. **Phase 3: Verification (4 min)**
   - Verify all checklist items completed
   - Run comprehensive tests
   - Review the journey (show before/after checklist)

**Key learning**: Full collaborative workflow - plan, track, refine, complete

### Strategy Card: Task-Based Design (NEW - card-15)

**Front:**
```markdown
# Task-Based Design with Claude

## When to Use
- Features with 3+ implementation steps
- Multi-file changes
- Complex refactoring
- When you need to track progress
- When you might need to pause and resume

## Basic Pattern
1. Ask Claude to create a task checklist
2. Review and refine together
3. Work through tasks systematically
4. Check off items as completed
5. Use /remember for important context
```

**Back:**
```markdown
## Example Prompts

"Please create a checklist in TASKS.md for implementing [feature]"

"Analyze this code and create a refactoring checklist"

"Let's plan the BookService implementation together - create a checklist"

"Update the checklist - mark task 3 complete and add a new task for validation"

## Benefits
✓ Clear roadmap prevents scope creep
✓ Easy to track progress
✓ Maintains context across sessions
✓ Helps communicate intent to Claude
✓ Creates documentation of work done

## Checklist Format
```markdown
# Feature Implementation Plan

## Setup
- [ ] Review requirements
- [ ] Create entity class
- [ ] Create repository interface

## Core Implementation
- [ ] Implement service methods
- [ ] Add validation logic

## Testing
- [ ] Write unit tests
- [ ] Run all tests
- [ ] Verify coverage
```
```

## Considerations

### Technical
- Checklist files should be in markdown format for easy editing
- Use standard checkbox syntax: `- [ ]` for incomplete, `- [x]` for complete
- Keep checklists in project root or docs/ folder for visibility
- Claude can read and update checklists programmatically

### UX (Participant Experience)
- Make checklist creation feel natural, not forced
- Show value immediately (don't just explain it)
- Allow flexibility - checklists are guides, not rigid requirements
- Celebrate when participants complete all checklist items

### Risk: Potential Challenges
1. **Time pressure**: Participants may skip checklist creation to "save time"
   - *Mitigation*: Show that planning saves time overall, facilitator enforces workflow

2. **Confusion about format**: Participants unsure how detailed to make checklists
   - *Mitigation*: Provide clear examples, show 3-7 tasks is typical

3. **Claude generates too many/few tasks**: Checklist not useful
   - *Mitigation*: Teach participants to refine: "This is too detailed, combine tasks" or "Break down task 3 into subtasks"

4. **Forgetting to use checklist after creating it**: Creates extra work without benefit
   - *Mitigation*: Facilitator checks in: "Are you following your checklist?" during work time

5. **Participants don't understand why they're doing this**: Feels like busywork
   - *Mitigation*: Strong framing in introduction emphasizing real-world value

## Resources Needed

### New Materials to Create
1. Introduction slide/content (5 minutes of material)
2. Strategy Card 15: Task-Based Design
3. Updated Challenge 5 instructions
4. Updated Challenge 6 instructions
5. Example checklists (2-3 templates)
6. Solution checklists for challenges 5 and 6
7. Facilitator talking points

### Materials to Update
1. FACILITATOR_GUIDE.md - add timing and talking points for task-based design
2. Slide deck - add 1 slide before Challenge 5
3. PROGRESS.md - optional: add checklist tracking
4. Hints for challenges 5 and 6 - add checklist-specific hints

### Tools/Dependencies
- No new tools needed
- Participants already have markdown file creation capability
- Claude Code already supports reading/writing markdown files

## Timeline Estimate

**Content Creation Phase**:
- Introduction content and slide (1 hour)
- Strategy card creation (1 hour)
- Challenge updates (2 hours)
- Example checklists (30 minutes)

**Solution Creation Phase**:
- Solutions for challenges 5 and 6 (2 hours)
- Hints creation (1 hour)
- Facilitator guide updates (1 hour)

**Testing Phase**:
- Self-test both challenges (45 minutes)
- Timing verification (30 minutes)
- Refinement based on testing (1 hour)

**Total effort**: Approximately 10-12 hours

## Success Criteria

**Immediate (During Workshop)**
- Participants successfully create checklists in Challenge 5
- Participants reference and follow checklists during implementation
- Facilitator observes participants checking off completed tasks
- Less confusion/scope creep during Challenge 6 compared to previous workshops

**Post-Workshop**
- Feedback forms mention task-based design as valuable technique
- Participants report planning to use checklists in real work
- Reduced "I got lost halfway through" comments in feedback

**Long-Term**
- Participants post about using task-based design in their projects
- Technique becomes standard practice in participant's workflows
- Other facilitators adopt this enhancement for their workshops

## Next Steps

### Immediate Actions
1. Review this plan and approve approach
2. Decide on exact wording for introduction content
3. Confirm timing works within 2-hour workshop constraint
4. Assign content creation tasks

### After Approval
1. Create introduction slide/content
2. Write Strategy Card 15
3. Update Challenge 5 and 6 materials
4. Create example checklists
5. Update facilitator guide
6. Test updated challenges

### Before Workshop
1. Ensure all materials are printed/accessible
2. Practice introduction delivery (5-minute segment)
3. Prepare checklist examples for demonstration
4. Brief facilitators on new workflow

## Alternative Scenarios

### If Time is Too Tight (Minimal Approach)
- Skip formal introduction
- Add checklist step to Challenge 6 only
- Provide strategy card as reference
- Brief mention: "Many developers use checklists with Claude - try it in Challenge 6"

### If More Time Available (Enhanced Approach)
- Create dedicated mini-challenge (Challenge 2.5)
- Show live demonstration of checklist creation
- Include retrospective discussion after Challenge 6 on effectiveness
- Create video tutorial on task-based design

### If Participants Struggle with Concept
- Pivot to demonstration mode: facilitator creates checklist live
- Simplify checklists to 3-5 top-level tasks only
- Focus on Challenge 6 only, skip Challenge 5 checklist
- Provide pre-made checklist template they can customize

## Appendix: Example Checklists

### Example 1: Simple Refactoring Checklist (Challenge 5 style)
```markdown
# OrderService Refactoring Checklist

## Analysis
- [x] Identify code smells in OrderService
- [x] Document current method complexity

## Refactoring
- [ ] Extract order validation into separate method
- [ ] Extract order calculation logic
- [ ] Simplify main processOrder method
- [ ] Ensure all methods under 20 lines (project rule)

## Verification
- [ ] Run all tests
- [ ] Verify no functionality changed
- [ ] Check code coverage maintained
```

### Example 2: Comprehensive Feature Checklist (Challenge 6 style)
```markdown
# BookService Implementation Plan

## Setup
- [ ] Create Book entity with all fields (title, author, ISBN, price)
- [ ] Create BookRepository interface extending CrudRepository
- [ ] Create BookService class skeleton

## Core CRUD Implementation
- [ ] Implement createBook method
- [ ] Implement findBookById method
- [ ] Implement findAllBooks method
- [ ] Implement updateBook method
- [ ] Implement deleteBook method

## Validation
- [ ] Add ISBN format validation (13 digits)
- [ ] Add price validation (positive numbers only)
- [ ] Add null/empty title validation
- [ ] Add proper error handling for all validations

## Testing
- [ ] Write test for createBook
- [ ] Write test for findBookById
- [ ] Write test for findAllBooks
- [ ] Write test for updateBook
- [ ] Write test for deleteBook
- [ ] Write tests for validation failures
- [ ] Verify 80%+ code coverage

## Final Verification
- [ ] Run mvn test - all tests pass
- [ ] Review code follows project rules
- [ ] Check all requirements met
```

### Example 3: Collaborative Planning Checklist (Shows refinement)
```markdown
# BookService Implementation Plan v2

## Initial Setup ✓
- [x] Create Book entity with all fields
- [x] Create BookRepository interface
- [x] Create BookService class skeleton

## Core Implementation (IN PROGRESS)
- [x] Implement createBook
- [x] Implement findById
- [ ] Implement findAll
- [ ] Implement update
- [ ] Implement delete

## Validation (UPDATED - Added after discussion)
- [ ] ISBN validation helper method
- [ ] Price validation helper method
- [ ] Integration validation into service methods
- [ ] Custom exceptions for validation failures

## Testing
- [x] Test for createBook (COMPLETED)
- [ ] Test for findById
- [ ] Remaining CRUD tests
- [ ] Validation failure tests
- [ ] Integration test suite

## Bonus (If Time Permits)
- [ ] Search by author functionality
- [ ] Price range filtering
- [ ] Pagination support

## NOTES
- Using BigDecimal for price (project rule)
- ISBN validation regex: ^\d{13}$
- Remember to use @Service annotation
```

---

**Document prepared by**: Claude (ideate skill)
**Date**: 2026-02-24
**Status**: Draft for review
**Next reviewer**: Workshop facilitator team
