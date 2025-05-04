package api.test;

import api.UserController;
import model.User;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import services.UserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {
    @Test
    public void testCreateUser() {
        UserService mockService = mock(UserService.class);
        UserController controller = new UserController(mockService);
        User user = new User("1", "Alice");

        when(mockService.createUser(any(User.class))).thenReturn(user);

        ResponseEntity<User> response = controller.createUser(user);
        assertEquals("Alice", response.getBody().getName());
    }

    @Test
    public void testGetAllUsers() {
        UserService mockService = mock(UserService.class);
        UserController controller = new UserController(mockService);

        when(mockService.getAllUsers()).thenReturn(List.of(new User("1", "Bob")));

        ResponseEntity<List<User>> response = controller.getAllUsers();
        assertEquals(1, response.getBody().size());
    }
}
