package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.ChequeRequest;
import peaksoft.dto.responses.ChequeResponse;
import peaksoft.dto.responses.SimpleResponse;
import peaksoft.service.ChequeService;
import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cheques")
public class ChequeApi {
    private final ChequeService chequeService;

    @PostMapping
    public SimpleResponse createCheque(@RequestBody ChequeRequest chequeRequest) {
        chequeService.saveCheque(chequeRequest);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Cheque created")
                .build();
    }
    @GetMapping("/{id}")
    public ChequeResponse getCheque(@PathVariable Long id) {
        return chequeService.getCheque(id);
    }
    @DeleteMapping("/{id}")
    public SimpleResponse deleteCheque(@PathVariable Long id) {
        chequeService.deleteCheque(id);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Cheque deleted")
                .build();
    }
    @GetMapping("/total-cum")
    public  ResponseEntity<BigDecimal> getTotalSumForWaiterByDay(
            @RequestParam Long waiterId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        BigDecimal totalSum = chequeService.getTotalSumForWaiterByDay(waiterId, date);
        return ResponseEntity.ok(totalSum != null ? totalSum : BigDecimal.ZERO);
    }
    @GetMapping("/average-by-day")
    public ResponseEntity<BigDecimal> getAverageChequeSumByDay(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        BigDecimal avgSum = chequeService.getAverageChequeSumByDay(date);
        return ResponseEntity.ok(avgSum);
    }
}
