
import repositories.inmemory.InMemoryBookRepository;
import repositories.BookRepository;

public class BookRepositoryTest {
    public static void main(String[] args) {
        BookRepository repo = new InMemoryBookRepository();

        Book book = new Book("1", "Effective Java");
        repo.save(book);

        assert repo.findById("1").isPresent();
        assert repo.findAll().size() == 1;

        repo.delete("1");
        assert repo.findAll().isEmpty();

        System.out.println("All BookRepository tests passed!");
    }
}
