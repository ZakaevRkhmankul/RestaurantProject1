package peaksoft.service;

import org.springframework.data.repository.query.Param;
import peaksoft.dto.request.ChequeRequest;
import peaksoft.dto.responses.ChequeResponse;
import peaksoft.entities.Cheque;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ChequeService {
    void saveCheque(ChequeRequest chequeRequest);
    ChequeResponse getCheque(Long id);
    void deleteCheque(Long id);
    BigDecimal getTotalSumForWaiterByDay(@Param("waiterId") Long waiterId, @Param("date") LocalDate date);
    BigDecimal getAverageChequeSumByDay(@Param("date") LocalDate date);
}
