
package services;

import models.Prescription;
import repositories.inmemory.InMemoryPrescriptionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PrescriptionServiceTest {
    private PrescriptionService service;

    @BeforeEach
    void setUp() {
        service = new PrescriptionService(new InMemoryPrescriptionRepository());
    }

    @Test
    void testSaveAndFind() {
        Prescription entity = new Prescription("id1");
        service.save(entity);
        Optional<Prescription> found = service.findById("id1");
        assertTrue(found.isPresent());
        assertEquals("id1", found.get().getId());
    }

    @Test
    void testDelete() {
        Prescription entity = new Prescription("id2");
        service.save(entity);
        service.delete("id2");
        assertFalse(service.findById("id2").isPresent());
    }
}
