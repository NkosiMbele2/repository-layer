
package services;

import models.Medication;
import repositories.inmemory.InMemoryMedicationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MedicationServiceTest {
    private MedicationService service;

    @BeforeEach
    void setUp() {
        service = new MedicationService(new InMemoryMedicationRepository());
    }

    @Test
    void testSaveAndFind() {
        Medication entity = new Medication("id1");
        service.save(entity);
        Optional<Medication> found = service.findById("id1");
        assertTrue(found.isPresent());
        assertEquals("id1", found.get().getId());
    }

    @Test
    void testDelete() {
        Medication entity = new Medication("id2");
        service.save(entity);
        service.delete("id2");
        assertFalse(service.findById("id2").isPresent());
    }
}
