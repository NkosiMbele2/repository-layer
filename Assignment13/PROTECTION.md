# Branch Protection Rules

## Why We Protect the `main` Branch

To ensure code quality, stability, and team collaboration, we enforce the following rules on the `main` branch:

### ✅ Pull Request Reviews
All changes must be reviewed by at least one team member before merging.  
This prevents bugs, encourages code quality, and promotes collaboration.

### ✅ Status Checks
CI pipelines must pass before a PR can be merged.  
This ensures:
- Code compiles correctly
- Unit tests pass
- Linting/formatting is respected

### 🚫 No Direct Pushes
We disallow direct pushes to the `main` branch.  
All changes must go through a Pull Request (PR), reducing the chance of accidental or unreviewed changes.

### 🔒 Admin Enforcement
Even repository admins must follow the rules. This keeps the development process consistent for everyone.

## Summary
Branch protection rules enforce professional workflows and reduce technical debt by ensuring every line of code is reviewed and verified before reaching production.
