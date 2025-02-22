package peaksoft.service;

import org.springframework.data.repository.query.Param;
import peaksoft.dto.request.SubcategoryRequest;
import peaksoft.dto.responses.GetSubcategoryResponse;
import peaksoft.dto.responses.SubcategoryResponse;


import java.util.List;

public interface SubcategoryService {
    void saveSubcategoryToCategory(Long categoryId, SubcategoryRequest subcategoryRequest);
    SubcategoryResponse getSubcategory(Long id);
    List<SubcategoryResponse> getAllSubcategories();
    void updateSubcategory(Long id, SubcategoryRequest subcategoryRequest,Long categoryId);
    void deleteSubcategory(Long id);
    List<GetSubcategoryResponse> findAllSubcategoriesByCategoryId(@Param("categoryId") Long categoryId);
}
