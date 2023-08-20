////////////////////////////////////////////////
//          author: Nour
//          filename: ValidEnum.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.customAnnotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


/**
 * Target annotation -> specify exactly which kind of java element the
 * ValidCategory annotation is valid to be used on.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {EnumValidator.class})
public @interface ValidEnum {
    Class<? extends Enum<?>> enumClass();

    String message() default "Invalid category";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}