////////////////////////////////////////////////
//          author: Nour
//          filename: NameExists.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.customAnnotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StringFieldExistsValidator.class})
public @interface StringFieldExists {
    String message() default "Value already exists";

    String fieldName();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}