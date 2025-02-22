package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.StopListRequest;
import peaksoft.dto.responses.SimpleResponse;
import peaksoft.dto.responses.StopListResponse;
import peaksoft.service.StopListService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stopLists")
public class StopListApi {

    private final StopListService stopListService;

    @PostMapping
    public SimpleResponse save(@RequestBody StopListRequest stopListRequest) {
        stopListService.save(stopListRequest);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved stop list")
                .build();
    }

    @GetMapping("/{id}")
    public StopListResponse findById(@PathVariable("id") Long id) {
        return stopListService.getStopList(id);
    }
    @GetMapping
    public List<StopListResponse> findAll() {
        return stopListService.getStopLists();
    }
    @PutMapping("/{id}")
    public SimpleResponse update(@PathVariable Long id,@RequestBody StopListRequest stopListRequest) {
        stopListService.update(id, stopListRequest);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully updated stop list")
                .build();
    }
    @DeleteMapping("/{id}")
    public SimpleResponse delete(@PathVariable Long id) {
        stopListService.delete(id);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully deleted stop list")
                .build();
    }
}
