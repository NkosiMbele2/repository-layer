@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @PostMapping("/{id}/checkout")
    public ResponseEntity<?> checkoutBook(@PathVariable String id) {
        Book book = bookService.checkoutBook(id);
        return ResponseEntity.ok(Map.of("message", "Book checked out", "book", book));
    }
}
