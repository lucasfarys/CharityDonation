package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "institutions")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private Boolean trusted;


    @OneToMany(mappedBy = "institution")
    private List<Donation> donations = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Institution)) return false;
        Institution that = (Institution) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", donations=" + donations +
                '}';
    }
}
