package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    Long quantity;
    @Column(nullable = false)
    String street;
    @Column(nullable = false)
    String city;
    String zipCode;
    LocalDate pickUpDate;
    LocalTime pickUpTime;
    String pickUpComment;
    String phoneNumber;


    @OneToMany(mappedBy = "donation")
    List<Category> categories;
    @ManyToOne
    Institution institution;

}
