
package future;

import repositories.BookRepository;
import java.util.List;
import java.util.Optional;

public class DatabaseBookRepository implements BookRepository {
    @Override
    public void save(Book book) {
        throw new UnsupportedOperationException("DatabaseBookRepository not yet implemented.");
    }

    @Override
    public Optional<Book> findById(String id) {
        throw new UnsupportedOperationException("DatabaseBookRepository not yet implemented.");
    }

    @Override
    public List<Book> findAll() {
        throw new UnsupportedOperationException("DatabaseBookRepository not yet implemented.");
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("DatabaseBookRepository not yet implemented.");
    }
}
