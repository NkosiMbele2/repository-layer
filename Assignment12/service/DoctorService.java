
package services;

import repositories.DoctorRepository;
import models.Doctor;
import java.util.Optional;
import java.util.List;

public class DoctorService {
    private final DoctorRepository doctorRepo;

    public DoctorService(DoctorRepository doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public void save(Doctor doctor) {
        doctorRepo.save(doctor);
    }

    public Optional<Doctor> findById(String id) {
        return doctorRepo.findById(id);
    }

    public List<Doctor> findAll() {
        return doctorRepo.findAll();
    }

    public void delete(String id) {
        doctorRepo.delete(id);
    }
}
