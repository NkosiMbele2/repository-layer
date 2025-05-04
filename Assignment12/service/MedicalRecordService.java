
package services;

import repositories.MedicalRecordRepository;
import models.MedicalRecord;
import java.util.Optional;
import java.util.List;

public class MedicalRecordService {
    private final MedicalRecordRepository medicalrecordRepo;

    public MedicalRecordService(MedicalRecordRepository medicalrecordRepo) {
        this.medicalrecordRepo = medicalrecordRepo;
    }

    public void save(MedicalRecord medicalrecord) {
        medicalrecordRepo.save(medicalrecord);
    }

    public Optional<MedicalRecord> findById(String id) {
        return medicalrecordRepo.findById(id);
    }

    public List<MedicalRecord> findAll() {
        return medicalrecordRepo.findAll();
    }

    public void delete(String id) {
        medicalrecordRepo.delete(id);
    }
}
