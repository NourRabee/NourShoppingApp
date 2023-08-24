////////////////////////////////////////////////
//          author: Nour
//          filename: BaseResponse.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.common.dto;

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
public abstract class BaseResponse {

    private String id;
    private String description;
}
