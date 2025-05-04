
package services;

import models.Appointment;
import repositories.inmemory.InMemoryAppointmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
    private AppointmentService service;

    @BeforeEach
    void setUp() {
        service = new AppointmentService(new InMemoryAppointmentRepository());
    }

    @Test
    void testSaveAndFind() {
        Appointment entity = new Appointment("id1");
        service.save(entity);
        Optional<Appointment> found = service.findById("id1");
        assertTrue(found.isPresent());
        assertEquals("id1", found.get().getId());
    }

    @Test
    void testDelete() {
        Appointment entity = new Appointment("id2");
        service.save(entity);
        service.delete("id2");
        assertFalse(service.findById("id2").isPresent());
    }
}
