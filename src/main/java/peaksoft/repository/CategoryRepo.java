package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.responses.CategoryResponse;
import peaksoft.entities.Category;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query("select new peaksoft.dto.responses.CategoryResponse(c.id,c.name)from Category c where c.id = :id")
    CategoryResponse getCategory(Long id);

    @Query("select new peaksoft.dto.responses.CategoryResponse(c.id,c.name)from Category c")
    List<CategoryResponse>  getCategories();
}
