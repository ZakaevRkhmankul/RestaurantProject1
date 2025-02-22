package peaksoft.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChequeRequest {
        private int priceAverage;
        private String createdAt;
        private Long userId;
        private List<Long> menuItemIds;
}
