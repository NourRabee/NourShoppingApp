package ps.exalt.shopping.app.common.dto;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class BaseRequest<T>{
    public abstract T getId();

    public abstract void setId(T t);

}
