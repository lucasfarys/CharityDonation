package pl.coderslab.charity.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.repository.DonationRepository;

@Service
@Transactional
public class DonationService {
    private DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Long getQuantityOfBags(){
        return donationRepository.getQuantityBags();
    }
    public Long getQuantityOfInstitutions(){
        return donationRepository.getNumberOfInstitutions();
    }

}
