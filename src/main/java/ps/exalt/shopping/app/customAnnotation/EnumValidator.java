////////////////////////////////////////////////
//          author: Nour
//          filename: EnumValidator.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.customAnnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ps.exalt.shopping.app.model.Category;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class EnumValidator implements ConstraintValidator<ValidEnum,
        String> {

    private List<String> acceptedValues;

    @Override
    public void initialize(ValidEnum annotation) {
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }
        for (Category validCategory : Category.values()) {
            if (validCategory.name().equals(value)) {
                return true;
            }
        }
        return acceptedValues.contains(value.toString());
    }
}