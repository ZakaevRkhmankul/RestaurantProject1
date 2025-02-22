package peaksoft.dto.responses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.MenuItem;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ChequeResponse {
    private String waiterFullName;
    private List<MenuItem> MenuItems;
    private double averagePrice;
    private double servicePercentage;
    private double grandTotal;

    public ChequeResponse() {
    }
}
