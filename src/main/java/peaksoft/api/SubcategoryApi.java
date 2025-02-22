package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.SubcategoryRequest;
import peaksoft.dto.responses.GetSubcategoryResponse;
import peaksoft.dto.responses.SimpleResponse;
import peaksoft.dto.responses.SubcategoryResponse;
import peaksoft.service.SubcategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subcategories")
public class SubcategoryApi {
    private final SubcategoryService subcategoryService;

    @PostMapping("/add/{categoryId}")
    public SimpleResponse save(@PathVariable Long categoryId,@RequestBody SubcategoryRequest subcategoryRequest){
        subcategoryService.saveSubcategoryToCategory(categoryId,subcategoryRequest);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Subcategory saved")
                .build();
    }
    @GetMapping("/{id}")
    public SubcategoryResponse getSubcategory(@PathVariable Long id){
      return  subcategoryService.getSubcategory(id);
    }
    @GetMapping
    public List<SubcategoryResponse> getAllSubcategories(){
        return  subcategoryService.getAllSubcategories();
    }
    @PutMapping("/{id}")
    public SimpleResponse updateSubcategory(@PathVariable Long id,@RequestBody SubcategoryRequest subcategoryRequest,@RequestParam Long categoryId){
        subcategoryService.updateSubcategory(id, subcategoryRequest, categoryId);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Subcategory updated")
                .build();
    }
    @DeleteMapping("{id}")
    public SimpleResponse deleteSubcategory(@PathVariable Long id){
        subcategoryService.deleteSubcategory(id);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Subcategory deleted")
                .build();
    }
    @GetMapping("/get/{categoryId}")
    public List<GetSubcategoryResponse> getSubcategoriesByCategoryId(@PathVariable Long categoryId){
        return subcategoryService.findAllSubcategoriesByCategoryId(categoryId);
    }
}
