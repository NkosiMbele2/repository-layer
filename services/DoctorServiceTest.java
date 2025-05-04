
package services;

import models.Doctor;
import repositories.inmemory.InMemoryDoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorServiceTest {
    private DoctorService service;

    @BeforeEach
    void setUp() {
        service = new DoctorService(new InMemoryDoctorRepository());
    }

    @Test
    void testSaveAndFind() {
        Doctor entity = new Doctor("id1");
        service.save(entity);
        Optional<Doctor> found = service.findById("id1");
        assertTrue(found.isPresent());
        assertEquals("id1", found.get().getId());
    }

    @Test
    void testDelete() {
        Doctor entity = new Doctor("id2");
        service.save(entity);
        service.delete("id2");
        assertFalse(service.findById("id2").isPresent());
    }
}
