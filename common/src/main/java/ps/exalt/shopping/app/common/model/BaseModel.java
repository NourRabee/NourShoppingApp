////////////////////////////////////////////////
//          author: Nour
//          filename: BaseModel.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.common.model;

import jakarta.persistence.MappedSuperclass;
import lombok.*;
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class BaseModel<T> {
    private Long creationTime;
    private Long lastUpdateTime;
    private String version;

    public abstract T getId();

    public abstract void setId(T t);

}
