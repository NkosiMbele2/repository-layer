
package factories;

import repositories.BookRepository;
import repositories.inmemory.InMemoryBookRepository;
// Future: import future.DatabaseBookRepository;

public class RepositoryFactory {
    public static BookRepository getBookRepository(String storageType) {
        switch (storageType.toUpperCase()) {
            case "MEMORY":
                return new InMemoryBookRepository();
            // case "DATABASE":
            //     return new DatabaseBookRepository();
            default:
                throw new IllegalArgumentException("Invalid storage type: " + storageType);
        }
    }
}
