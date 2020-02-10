package pl.coderslab.charity.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ZipCodeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidZipCode {
    String message() default "Nieprawidłowy kod pocztowy";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
