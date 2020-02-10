package pl.coderslab.charity.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ValidZipCode,String> {
    public void initialize(ValidZipCode constraint) {
    }

    public boolean isValid(String zip, ConstraintValidatorContext context) {
        if(zip.matches("[1-9]d{2}-d{3}") | zip.matches("[1-9]d{2}d{3}")){
            return true;
        }else{
            return false;
        }
    }
}
