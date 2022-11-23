package first.doctorwho.controller;

import first.doctorwho.exception.DoctorNotFoundException;
import first.doctorwho.model.Doctor;
import first.doctorwho.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorRepository doctor;

    @Autowired
    public DoctorController(DoctorRepository doctor) {
        this.doctor = doctor;
    }

    @GetMapping
    public List<Doctor> findAll() {
        return doctor.findAll();
    }

    @GetMapping("/{id}")
    public Doctor findById(@PathVariable String id) throws DoctorNotFoundException {
        return doctor.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Doctor create(@Valid @RequestBody Doctor postDoctor) {
        return doctor.create(postDoctor);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Doctor putDoctor, @PathVariable String id) {
        doctor.update(putDoctor,id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        doctor.delete(id);
    }


}
