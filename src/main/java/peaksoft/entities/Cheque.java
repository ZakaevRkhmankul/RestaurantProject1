package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cheques")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cheque {
    @Id
    Long id;
    int priceAverage;
    LocalDate createdAt;
    @ManyToOne
    User user;
    @ManyToMany(mappedBy = "cheques")
    List<MenuItem>menuItems=new ArrayList<>();
}
