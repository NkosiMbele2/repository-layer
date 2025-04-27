# repository-layer

# Repository Layer

## Why Generics?
We used **generics** in `Repository<T, ID>` to avoid duplicating CRUD methods across different entities like Book, Patient, etc.

## Why Factory Pattern?
The **RepositoryFactory** cleanly separates storage decision logic from service logic, ensuring easy extension to future backends (e.g., DatabaseBookRepository, FileSystemBookRepository).

## Future-Proofing
- Adding new storage backends (Database, Filesystem) will require minimal changes—only implementing the Repository interface and updating RepositoryFactory.
