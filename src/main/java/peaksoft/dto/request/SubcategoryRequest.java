package peaksoft.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.entities.Category;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubcategoryRequest {
    String name;
    Long categoryId;
}
