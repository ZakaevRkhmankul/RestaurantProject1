package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.dto.responses.GetSubcategoryResponse;
import peaksoft.entities.Subcategory;

import java.util.List;
@Repository
public interface SubcategoryRepo extends JpaRepository<Subcategory, Long> {

    @Query("select new peaksoft.dto.responses.GetSubcategoryResponse(sub.id ,sub.name, c.name) " +
            "from Subcategory sub join Category c on sub.category.id = c.id order by sub.id desc ")
    List<GetSubcategoryResponse> findAllSubcategoriesByCategoryId(@Param("categoryId") Long categoryId);
}
