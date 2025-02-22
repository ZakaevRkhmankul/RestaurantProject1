package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.StopListRequest;
import peaksoft.dto.responses.StopListResponse;
import peaksoft.entities.MenuItem;
import peaksoft.entities.StopList;
import peaksoft.repository.MenuItemRepo;
import peaksoft.repository.StopListRepo;
import peaksoft.service.StopListService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StopListServiceImpl implements StopListService {
    private final StopListRepo stopListRepo;
    private final MenuItemRepo menuItemRepo;

    @Override
    public void save(StopListRequest stopListRequest) {
        MenuItem menuItem = menuItemRepo.findById(stopListRequest.getMenuItemId())
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
        StopList stopList = new StopList();
        stopList.setReason(stopListRequest.getReason());
        stopList.setDate(stopListRequest.getDate());
        stopList.setMenuItem(menuItem);
        stopListRepo.save(stopList);
    }

    @Override
    public StopListResponse getStopList(Long id) {
        StopList stopList = stopListRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Stop not found"));
        StopListResponse stopListResponse = new StopListResponse();
        stopListResponse.setId(stopList.getId());
        stopListResponse.setReason(stopList.getReason());
        stopListResponse.setDate(stopList.getDate());
        return stopListResponse;
    }

    @Override
    public List<StopListResponse> getStopLists() {
        return stopListRepo.getAll();
    }

    @Override
    public void update(Long id, StopListRequest newStopListRequest) {
        StopList stopList = stopListRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Stop not found"));
        stopList.setReason(newStopListRequest.getReason());
        stopList.setDate(newStopListRequest.getDate());
        stopListRepo.save(stopList);
    }

    @Override
    public void delete(Long id) {
        stopListRepo.deleteById(id);
    }
}
