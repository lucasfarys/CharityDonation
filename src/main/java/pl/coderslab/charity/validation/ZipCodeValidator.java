package pl.coderslab.charity.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ZipCode,String> {
    public void initialize(ZipCode constraint) {
    }

    public boolean isValid(String zip, ConstraintValidatorContext context) {
        if(zip.matches("[1-9]d{2}-d{3}") | zip.matches("[1-9]d{2}d{3}")){
            return true;
        }else{
            return false;
        }
    }
}
