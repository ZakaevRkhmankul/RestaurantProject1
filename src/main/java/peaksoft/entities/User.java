package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.enums.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
    Long id;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    @Column(unique = true, nullable = false)
    String email;
    String password;
    @Column(nullable = false)
    String phoneNumber;
    @Enumerated(EnumType.STRING)
    Role role;
    int experience;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Restaurant restaurant;

    @OneToMany(mappedBy = "user")
    List<Cheque>cheques=new ArrayList<>();

}
