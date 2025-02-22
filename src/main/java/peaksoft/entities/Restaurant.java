package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.enums.RestType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_gen")
    @SequenceGenerator(name = "restaurant_gen", sequenceName = "restaurant_seq", allocationSize = 1)
    Long id;
    String name;
    String location;
    @Enumerated(EnumType.STRING)
    @Column(name = "rest_type")
    RestType restType;

    int numberOfEmployees;
    String service;

    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE})
    List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    List<MenuItem>menuItems=new ArrayList<>();
}
