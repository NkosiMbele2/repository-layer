package api;

import model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import services.BookService;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void testGetAllBooks() throws Exception {
        when(bookService.getAllBooks()).thenReturn(List.of(new Book("1", "Test Book")));

        mockMvc.perform(get("/api/books"))
               .andExpect(status().isOk());
    }

    @Test
    public void testCheckoutBook() throws Exception {
        Book book = new Book("1", "Test Book");
        when(bookService.checkoutBook("1")).thenReturn(book);

        mockMvc.perform(post("/api/books/1/checkout"))
               .andExpect(status().isOk());
    }
}
