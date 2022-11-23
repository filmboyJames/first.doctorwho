package first.doctorwho.repository;

import first.doctorwho.exception.DoctorNotFoundException;
import first.doctorwho.model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class DoctorRepository {

    List<Doctor> doctors = new ArrayList<>();

    public DoctorRepository() {
        doctors.add(new Doctor(
                UUID.randomUUID().toString(),
                "1st",
                "William Hartnell",
                1963,
                1966
        ));
        doctors.add(new Doctor(
                UUID.randomUUID().toString(),
                "2nd",
                "Patrick Troughton",
                1966,
                1969
        ));
    }
    public List<Doctor> findAll() {
        return doctors;
    }

    public Doctor findById(String id) throws DoctorNotFoundException {
            return doctors.stream().filter(doctor -> doctor.id().equals(id)).findFirst().orElseThrow();
    }


    public Doctor create(Doctor doctor) {
        doctors.add(doctor);
        return doctor;
    }

    public void update(Doctor doctor, String id) {
            Doctor existing = doctors.stream().filter(d -> d.id().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
            int i = doctors.indexOf(existing);
            doctors.set(i, doctor);
    }

    public void delete(String id) {
            doctors.removeIf(doctor -> doctor.id().equals(id));
    }
}
