package pl.maciejdluzen.tennisleague.validation.validators;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.cfg.context.Constrainable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.maciejdluzen.tennisleague.services.ValidationService;
import pl.maciejdluzen.tennisleague.validation.constraints.UniqueEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@Scope("prototype")
@Slf4j
public class UniqueEmailValidatorForString implements ConstraintValidator<UniqueEmail, String> {

    private ValidationService validationService;

    public void initialize(UniqueEmail constraint) {
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.debug("Validating unique email: {}", value);
        boolean unique = validationService.isUniqueEmail(value);
        log.debug("Is email '{}' unique? {}", value, unique);
        return unique;
    }

    @Autowired
    public void setValidationService(ValidationService validationService) {
        this.validationService = validationService;
    }
}
