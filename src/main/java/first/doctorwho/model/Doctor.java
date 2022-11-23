package first.doctorwho.model;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public record Doctor(

        @NotBlank(message = "ID is required")
        String id,

    @NotBlank(message = "Doctor number is required")
    String number,

    String actor,

    int startYear,

    int endYear

) {

}
