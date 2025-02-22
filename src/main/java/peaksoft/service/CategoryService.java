package peaksoft.service;
import peaksoft.dto.request.CategoryRequest;
import peaksoft.dto.responses.CategoryResponse;
import peaksoft.dto.responses.SimpleResponse;
import peaksoft.entities.Category;

import java.util.List;

public interface CategoryService {
    SimpleResponse saveCategory(CategoryRequest categoryRequest);
    CategoryResponse getCategory(Long id);
    List<CategoryResponse> getCategories();
    SimpleResponse updateCategory(Long id, CategoryRequest categoryRequest);
    SimpleResponse deleteCategory(Long id);
}
