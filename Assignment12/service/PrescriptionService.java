
package services;

import repositories.PrescriptionRepository;
import models.Prescription;
import java.util.Optional;
import java.util.List;

public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepo;

    public PrescriptionService(PrescriptionRepository prescriptionRepo) {
        this.prescriptionRepo = prescriptionRepo;
    }

    public void save(Prescription prescription) {
        prescriptionRepo.save(prescription);
    }

    public Optional<Prescription> findById(String id) {
        return prescriptionRepo.findById(id);
    }

    public List<Prescription> findAll() {
        return prescriptionRepo.findAll();
    }

    public void delete(String id) {
        prescriptionRepo.delete(id);
    }
}
