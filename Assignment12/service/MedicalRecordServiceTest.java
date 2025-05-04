
package services;

import models.MedicalRecord;
import repositories.inmemory.InMemoryMedicalRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MedicalRecordServiceTest {
    private MedicalRecordService service;

    @BeforeEach
    void setUp() {
        service = new MedicalRecordService(new InMemoryMedicalRecordRepository());
    }

    @Test
    void testSaveAndFind() {
        MedicalRecord entity = new MedicalRecord("id1");
        service.save(entity);
        Optional<MedicalRecord> found = service.findById("id1");
        assertTrue(found.isPresent());
        assertEquals("id1", found.get().getId());
    }

    @Test
    void testDelete() {
        MedicalRecord entity = new MedicalRecord("id2");
        service.save(entity);
        service.delete("id2");
        assertFalse(service.findById("id2").isPresent());
    }
}
