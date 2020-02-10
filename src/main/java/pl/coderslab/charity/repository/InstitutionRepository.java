package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.charity.model.Institution;

public interface InstitutionRepository extends JpaRepository<Institution,Long> {
    Institution findIstitutionById(Long id);
    Institution findInstitutionByName(String name);

}

