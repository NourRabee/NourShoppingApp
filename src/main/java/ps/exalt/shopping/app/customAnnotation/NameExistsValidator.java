////////////////////////////////////////////////
//          author: Nour
//          filename: NameExistsValidator.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.customAnnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import ps.exalt.shopping.app.model.Product;
import ps.exalt.shopping.app.repository.ProductRepository;

import java.util.Optional;


public class NameExistsValidator implements ConstraintValidator<NameExists,
        String> {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Allow null values if needed
        }

        // Perform the database check using repository
        Optional<Product> exists = productRepository.findById(value);
        return exists.isEmpty(); // Return true if the value doesn't exist
    }
}