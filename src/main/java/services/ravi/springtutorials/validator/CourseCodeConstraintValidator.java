package services.ravi.springtutorials.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode){
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String courseCode, ConstraintValidatorContext context) {
        boolean result;
        if(courseCode != null){
            result = courseCode.startsWith(coursePrefix);
        }else{
            result = true;
        }
        return result;
    }
}
