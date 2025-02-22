package peaksoft.dto.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.entities.Subcategory;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetSubcategoryResponse {
    Long id;
    String subcategoryName;
    String categoryName;
}
