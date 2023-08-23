////////////////////////////////////////////////
//          author: Nour
//          filename: BaseModel.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.common.model;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseModel {
    private Long creationTime;
    private Long lastUpdateTime;
    private String version;

}
