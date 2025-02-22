package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menuItems")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "menuitem_gen")
    @SequenceGenerator(name = "menuitem_gen", sequenceName = "menuitem_seq")
    Long id;
    String name;
    @Getter
    String image;
    int price;
    String description;
    Boolean isVegetarian;
    @ManyToOne
    Restaurant restaurant;
    @ManyToMany
    List<Cheque>cheques=new ArrayList<>();
    @OneToOne
    StopList stoplist;
    @ManyToOne
    Subcategory subcategory;
}
