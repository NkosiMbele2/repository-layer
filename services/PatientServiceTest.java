package tests;

import entities.Patient;
import repositories.inmemory.InMemoryPatientRepository;
import services.PatientService;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PatientServiceTest {
    private PatientService patientService;

    @BeforeEach
    public void setup() {
        patientService = new PatientService(new InMemoryPatientRepository());
    }

    @Test
    public void testRegisterPatientSuccess() {
        Patient patient = new Patient("p001", "John Doe", LocalDate.of(1990, 5, 15), "0821234567");
        Patient saved = patientService.registerPatient(patient);

        assertNotNull(saved);
        assertEquals("John Doe", saved.getName());
    }

    @Test
    public void testRegisterPatientMissingIdThrowsException() {
        Patient patient = new Patient(null, "Jane", LocalDate.of(1985, 3, 20), "0834567890");

        assertThrows(IllegalArgumentException.class, () -> patientService.registerPatient(patient));
    }

    @Test
    public void testUpdatePatientInfo() {
        Patient patient = new Patient("p002", "Alice", LocalDate.of(1992, 1, 1), "0711111111");
        patientService.registerPatient(patient);

        Patient updated = new Patient("p002", "Alice Updated", LocalDate.of(1992, 1, 1), "0722222222");
        Patient result = patientService.updatePatientInfo("p002", updated);

        assertEquals("Alice Updated", result.getName());
        assertEquals("0722222222", result.getContactNumber());
    }

    @Test
    public void testDeletePatient() {
        Patient patient = new Patient("p003", "Bob", LocalDate.of(1980, 9, 10), "0744444444");
        patientService.registerPatient(patient);
        patientService.deletePatient("p003");

        assertTrue(patientService.getPatientById("p003").isEmpty());
    }
}
