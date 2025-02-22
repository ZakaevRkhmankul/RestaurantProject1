package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CategoryRequest;
import peaksoft.dto.responses.CategoryResponse;
import peaksoft.dto.responses.SimpleResponse;
import peaksoft.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryApi {
    private final CategoryService categoryService;

    @PostMapping
    public SimpleResponse saveCategory(@RequestBody CategoryRequest categoryRequest) {
         categoryService.saveCategory(categoryRequest);
         return SimpleResponse
                 .builder()
                 .httpStatus(HttpStatus.OK)
                 .message("Category with id " + categoryRequest + " saved")
                 .build();
    }
    @GetMapping("/{id}")
    public CategoryResponse getCategory(@PathVariable Long id) {
       return categoryService.getCategory(id);
    }
    @GetMapping
    public List<CategoryResponse> getCategories() {
        return categoryService.getCategories();
    }
    @PutMapping("/{id}")
    public SimpleResponse updateCategory(@PathVariable Long id,@RequestBody CategoryRequest categoryRequest) {
        categoryService.updateCategory(id, categoryRequest);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Category with id " + id + " updated")
                .build();
    }
}