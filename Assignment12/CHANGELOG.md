# CHANGELOG

## [v1.0.0] - 2025-05-04

### 🚀 Added
- REST API endpoints for Book, User, and Patient entities.
- Service layer implementing business logic (e.g., book checkout validation).
- Swagger/OpenAPI documentation (available at `/docs/swagger-ui/index.html`).
- In-memory repository implementations for all domain entities.

### 🐛 Fixed
- Bug with duplicate patient creation.
- 500 error on missing book ID during checkout.

### 📦 Changed
- Refactored `BookService` for better exception handling.
- Improved repository factory to support additional backends.
