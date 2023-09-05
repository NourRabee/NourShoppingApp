package ps.exalt.shopping.app.common.error.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import ps.exalt.shopping.app.common.dto.BaseResponse;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class BaseErrorResponse extends BaseResponse {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
    private String messageDetail;
}
