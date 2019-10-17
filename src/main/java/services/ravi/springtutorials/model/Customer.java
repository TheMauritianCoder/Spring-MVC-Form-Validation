package services.ravi.springtutorials.model;

import lombok.Data;
import services.ravi.springtutorials.validator.CourseCode;

import javax.validation.constraints.*;

@Data
public class Customer {
    private String firstname;

    @NotNull(message = "lastname is required.")
    @Size(min=1, message = "lastname is required.")
    private String lastname;

    @NotNull(message = "Free passes is required.")
    @Min(value = 0, message = "Free passes must be >= 0")
    @Max(value = 10, message = "Free passes must be <= 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

    @CourseCode()
    private String courseCode;
}
