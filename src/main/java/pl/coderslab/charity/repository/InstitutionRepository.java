package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Institution;

public interface InstitutionRepository extends JpaRepository<Institution,Long> {
    Institution findIstitutionById(Long id);

}
