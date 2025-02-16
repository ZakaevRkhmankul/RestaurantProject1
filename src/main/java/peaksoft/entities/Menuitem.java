package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "menultems")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Menuitem {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @SequenceGenerator(name = "menuitem_gen",sequenceName = "menuitem_seq")
    Long id;
    String name;
    String image;
    int price;
    String description;
    Boolean isVegetarian;
}
