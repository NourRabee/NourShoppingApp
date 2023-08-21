////////////////////////////////////////////////
//          author: Nour
//          filename: NameExistsValidator.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.customAnnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import ps.exalt.shopping.app.repository.ProductRepository;

public class StringFieldExistsValidator implements ConstraintValidator<StringFieldExists,
        String> {

    private String fieldName;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void initialize(StringFieldExists constraintAnnotation) {
        fieldName = constraintAnnotation.fieldName();
        System.out.println(fieldName);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Allow null values if needed
        }

        // Perform the database check using repository
        boolean exists = productRepository.existsByName(value);
        return !exists; // Return true if the value doesn't exist
    }
}