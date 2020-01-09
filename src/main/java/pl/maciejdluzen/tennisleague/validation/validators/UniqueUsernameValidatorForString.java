package pl.maciejdluzen.tennisleague.validation.validators;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.maciejdluzen.tennisleague.services.ValidationService;
import pl.maciejdluzen.tennisleague.validation.constraints.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;

@Component
@Scope("prototype")
@Slf4j
@RequiredArgsConstructor
public class UniqueUsernameValidatorForString implements ConstraintValidator<UniqueUsername, String> {

    private final ValidationService validationService;

    public void initialize(UniqueUsername constraint) {

    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.debug("Validating unique username: {}", value);
        boolean unique = validationService.isUniqueUsername(value);
        log.debug("Is username '{}' unique? {}", value, unique);
        return unique;
    }
}
