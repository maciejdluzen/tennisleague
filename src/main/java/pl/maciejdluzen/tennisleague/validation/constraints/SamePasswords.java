package pl.maciejdluzen.tennisleague.validation.constraints;


import pl.maciejdluzen.tennisleague.validation.validators.SamePasswordValidatorForRegistrationDTO;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SamePasswordValidatorForRegistrationDTO.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SamePasswords {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
