package services;

import entities.Patient;
import repositories.PatientRepository;
import java.util.Optional;

public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient registerPatient(Patient patient) {
        if (patient.getId() == null || patient.getName() == null) {
            throw new IllegalArgumentException("Patient must have ID and name.");
        }
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    public void deletePatient(String id) {
        patientRepository.delete(id);
    }

    public Patient updatePatientInfo(String id, Patient updatedInfo) {
        Patient existing = patientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Patient not found"));
        
        existing.setName(updatedInfo.getName());
        existing.setDateOfBirth(updatedInfo.getDateOfBirth());
        existing.setContactNumber(updatedInfo.getContactNumber());
        
        return patientRepository.save(existing);
    }
}
