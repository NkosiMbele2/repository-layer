
package services;

import repositories.AppointmentRepository;
import models.Appointment;
import java.util.Optional;
import java.util.List;

public class AppointmentService {
    private final AppointmentRepository appointmentRepo;

    public AppointmentService(AppointmentRepository appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    public void save(Appointment appointment) {
        appointmentRepo.save(appointment);
    }

    public Optional<Appointment> findById(String id) {
        return appointmentRepo.findById(id);
    }

    public List<Appointment> findAll() {
        return appointmentRepo.findAll();
    }

    public void delete(String id) {
        appointmentRepo.delete(id);
    }
}
