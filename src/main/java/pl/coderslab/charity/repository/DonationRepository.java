package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;

public interface DonationRepository extends JpaRepository<Donation,Long> {
    @Query(value = "SELECT SUM(quantity) AS quantityBags FROM donations",nativeQuery = true)
    Long getQuantityBags();
    @Query(value = "SELECT COUNT( institution_id) FROM donations",nativeQuery = true)
    Long getNumberOfInstitutions();

}
