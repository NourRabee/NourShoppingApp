////////////////////////////////////////////////
//          author: Nour
//          filename: BaseRequest.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.common.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class BaseRequest<T> {
    public abstract T getId();

    public abstract void setId(T t);

}
