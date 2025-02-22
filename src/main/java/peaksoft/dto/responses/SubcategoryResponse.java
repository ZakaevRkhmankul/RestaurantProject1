package peaksoft.dto.responses;

import lombok.*;
import peaksoft.entities.Category;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryResponse {
    private Long id;
    private String name;
    private CategoryResponse categoryResponse;
}
