package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.dto.responses.ChequeResponse;
import peaksoft.entities.Cheque;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ChequeRepo extends JpaRepository<Cheque, Long> {
    @Query("SELECT SUM(c.priceAverage) FROM Cheque c WHERE c.user.id = :waiterId AND c.createdAt = :date")
    BigDecimal getTotalSumForWaiterByDay(@Param("waiterId") Long waiterId, @Param("date") LocalDate date);

    @Query("SELECT AVG(c.priceAverage) FROM Cheque c WHERE c.createdAt = :date")
    BigDecimal getAverageChequeSumByDay(@Param("date") LocalDate date);

}
