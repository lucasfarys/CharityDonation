package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Uuid;

public interface UuidRepository extends JpaRepository<Uuid,Long> {
    Long countAllByUuid(String uuid);
    Uuid findAllByUuid(String uuid);
}
