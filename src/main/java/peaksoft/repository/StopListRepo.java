package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.dto.responses.StopListResponse;
import peaksoft.entities.StopList;

import java.util.List;

public interface StopListRepo extends JpaRepository<StopList, Long> {
    @Query("select new peaksoft.dto.responses.StopListResponse(s.id,s.reason,s.date) from StopList s")
    List<StopListResponse> getAll();
}
