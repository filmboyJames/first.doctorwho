package first.doctorwho.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DoctorNotFoundException extends Exception {
    public DoctorNotFoundException(String id) {
        super("Doctor with id " + id + " not found");
    }
}

