package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.CategoryRequest;
import peaksoft.dto.responses.CategoryResponse;
import peaksoft.dto.responses.SimpleResponse;
import peaksoft.entities.Category;
import peaksoft.repository.CategoryRepo;
import peaksoft.service.CategoryService;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    @Override
    public SimpleResponse saveCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        categoryRepo.save(category);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Category saved")
                .build();
    }

    @Override
    public CategoryResponse getCategory(Long id) {
        return categoryRepo.getCategory(id);
    }

    @Override
    public List<CategoryResponse> getCategories() {
        return categoryRepo.getCategories() != null ? categoryRepo.getCategories() : new ArrayList<>();
    }

    @Override
    public SimpleResponse updateCategory(Long id, CategoryRequest categoryRequest) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
        if (categoryRequest.getName() != null) {
            category.setName(categoryRequest.getName());
        }
        categoryRepo.save(category);

        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Category updated")
                .build();
    }

    @Override
    public SimpleResponse deleteCategory(Long id) {
        categoryRepo.deleteById(id);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Success")
                .build();
    }

}
