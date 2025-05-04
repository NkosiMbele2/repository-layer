
package services;

import repositories.MedicationRepository;
import models.Medication;
import java.util.Optional;
import java.util.List;

public class MedicationService {
    private final MedicationRepository medicationRepo;

    public MedicationService(MedicationRepository medicationRepo) {
        this.medicationRepo = medicationRepo;
    }

    public void save(Medication medication) {
        medicationRepo.save(medication);
    }

    public Optional<Medication> findById(String id) {
        return medicationRepo.findById(id);
    }

    public List<Medication> findAll() {
        return medicationRepo.findAll();
    }

    public void delete(String id) {
        medicationRepo.delete(id);
    }
}
