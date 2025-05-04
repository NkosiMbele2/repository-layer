package api.test;

import api.PatientController;
import model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import services.PatientService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PatientControllerTest {
    @Test
    public void testCreatePatient() {
        PatientService mockService = mock(PatientService.class);
        PatientController controller = new PatientController(mockService);
        Patient patient = new Patient("1", "John Doe");

        when(mockService.createPatient(any(Patient.class))).thenReturn(patient);

        ResponseEntity<Patient> response = controller.createPatient(patient);
        assertEquals("John Doe", response.getBody().getName());
    }

    @Test
    public void testGetAllPatients() {
        PatientService mockService = mock(PatientService.class);
        PatientController controller = new PatientController(mockService);

        when(mockService.getAllPatients()).thenReturn(List.of(new Patient("1", "Jane")));

        ResponseEntity<List<Patient>> response = controller.getAllPatients();
        assertEquals(1, response.getBody().size());
    }
}
