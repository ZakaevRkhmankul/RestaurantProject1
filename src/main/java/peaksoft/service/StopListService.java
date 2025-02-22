package peaksoft.service;

import peaksoft.dto.request.StopListRequest;
import peaksoft.dto.responses.StopListResponse;
import peaksoft.entities.StopList;

import java.util.List;

public interface StopListService {
    void save(StopListRequest stopListRequest);
    StopListResponse getStopList(Long id);
    List<StopListResponse> getStopLists();
    void update(Long id,StopListRequest stopListRequest);
    void delete(Long id);
}
