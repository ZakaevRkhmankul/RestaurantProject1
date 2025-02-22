package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.SubcategoryRequest;
import peaksoft.dto.responses.CategoryResponse;
import peaksoft.dto.responses.GetSubcategoryResponse;
import peaksoft.dto.responses.SimpleResponse;
import peaksoft.dto.responses.SubcategoryResponse;
import peaksoft.entities.Category;
import peaksoft.entities.Subcategory;
import peaksoft.repository.CategoryRepo;

import peaksoft.repository.SubcategoryRepo;
import peaksoft.service.SubcategoryService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubcategoryServiceImpl implements SubcategoryService {
    private final CategoryRepo categoryRepo;
    private final SubcategoryRepo subcategoryRepo;

    @Override
    public void saveSubcategoryToCategory(Long id, SubcategoryRequest subcategoryRequest) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
        Subcategory subcategory = new Subcategory();
        subcategory.setName(subcategoryRequest.getName());
        subcategory.setCategory(category);
        subcategoryRepo.save(subcategory);
        SimpleResponse.
                builder()
                .httpStatus(HttpStatus.OK)
                .message("Subcategory " + subcategory.getName() + "," + category.getName() + "ге ийгиликтуу сакталды!")
                .build();
    }
    @Override
    public SubcategoryResponse getSubcategory(Long id) {
        Subcategory subcategory =  subcategoryRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Subcategory not found"));
        SubcategoryResponse subcategoryResponse = new SubcategoryResponse();
        subcategoryResponse.setId(subcategory.getId());
        subcategoryResponse.setName(subcategory.getName());
        CategoryResponse categoryResponse = new CategoryResponse();
        Category category = subcategory.getCategory();
        categoryResponse.setName(category.getName());
        categoryResponse.setId(category.getId());
        subcategoryResponse.setCategoryResponse(categoryResponse);
        return subcategoryResponse;
    }

    @Override
    public List<SubcategoryResponse> getAllSubcategories() {
       List<Subcategory> subcategories = subcategoryRepo.findAll();
       List<SubcategoryResponse> subcategoriesResponse = new ArrayList<>();
       for (Subcategory subcategory : subcategories) {
           SubcategoryResponse subcategoryResponse = new SubcategoryResponse();
           subcategoryResponse.setName(subcategory.getName());
           subcategoryResponse.setId(subcategory.getId());
           CategoryResponse categoryResponse = new CategoryResponse();
           Category category = subcategory.getCategory();
           categoryResponse.setName(category.getName());
           categoryResponse.setId(category.getId());
           subcategoryResponse.setCategoryResponse(categoryResponse);
           subcategoriesResponse.add(subcategoryResponse);
       }return subcategoriesResponse;
    }

    @Override
    public void updateSubcategory(Long id, SubcategoryRequest subcategoryRequest,Long categoryId) {
        Subcategory subcategory = subcategoryRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Subcategory not found"));
        subcategory.setName(subcategoryRequest.getName());
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(()->new RuntimeException("Category not found"));
        subcategory.setCategory(category);
        subcategoryRepo.save(subcategory);

    }

    @Override
    public void deleteSubcategory(Long id) {
        Subcategory subcategory = subcategoryRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Subcategory not found"));
        subcategoryRepo.delete(subcategory);
    }

    @Override
    public List<GetSubcategoryResponse> findAllSubcategoriesByCategoryId(Long categoryId) {
        return subcategoryRepo.findAllSubcategoriesByCategoryId(categoryId);
    }


}
