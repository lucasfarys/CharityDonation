package pl.coderslab.charity.service;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dto.DonationDTO;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service
@Transactional
public class DonationService {
    private DonationRepository donationRepository;
    private CategoryService categoryService;
    private InstitutionService institutionService;


    public DonationService(DonationRepository donationRepository, CategoryService categoryService,
                           InstitutionService institutionService) {
        this.donationRepository = donationRepository;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    public Long getQuantityOfBags(){
        return donationRepository.getQuantityBags();
    }
    public Long getQuantityOfInstitutions(){
        return donationRepository.getNumberOfInstitutions();
    }
    public void saveDonation(DonationDTO donationDTO){
        List<Category> categories = categoryService.getCategoryById(donationDTO.getCategories());
        Institution institution = institutionService.getInstitutionByName(donationDTO.getInstitution());
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<DonationDTO,Donation> typeMap = modelMapper.createTypeMap(DonationDTO.class,Donation.class);
        typeMap.addMappings(mapper -> mapper.skip(Donation::setCategories));
        typeMap.addMappings(mapper -> mapper.skip(Donation::setInstitution));
        Donation donation = modelMapper.map(donationDTO,Donation.class);
        donation.setCategories(categories);
        donation.setInstitution(institution);
        donationRepository.save(donation);
    }
    public List<Donation> findMyDonations(Long id){
        return donationRepository.findAllByUserId(id);
    }
    public Donation findDonation(Long id){
        return donationRepository.findAllById(id);
    }
}
