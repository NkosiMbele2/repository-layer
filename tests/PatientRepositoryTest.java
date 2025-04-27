import repositories.inmemory.InMemoryPatientRepository;
import repositories.PatientRepository;

public class PatientRepositoryTest {
    public static void main(String[] args) {
        PatientRepository repo = new InMemoryPatientRepository();

        // Suppose Patient has a constructor like: Patient(String id, String name)
        Patient patient = new Patient("1", "John Doe");
        repo.save(patient);

        assert repo.findById("1").isPresent();
        assert repo.findAll().size() == 1;

        repo.delete("1");
        assert repo.findAll().isEmpty();

        System.out.println("All PatientRepository tests passed!");
    }
}
