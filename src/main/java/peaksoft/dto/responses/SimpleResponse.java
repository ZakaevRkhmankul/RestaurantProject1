package peaksoft.dto.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Builder
@Getter
@Setter
public class SimpleResponse {
    HttpStatus httpStatus;
    String message;

    public SimpleResponse() {
    }

    public SimpleResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
