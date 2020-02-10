package pl.coderslab.charity.service;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InstitutionService {
    private InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }


    public List<InstitutionDTO> getAllInstitutions(){
        List<InstitutionDTO> result = new ArrayList<>();
        List<Institution> preresult = institutionRepository.findAll();
        preresult.forEach(p->{
            InstitutionDTO institution = new InstitutionDTO();
            institution.setId(p.getId());
            institution.setName(p.getName());
            institution.setDescription(p.getDescription());
            result.add(institution);
        });
        return result;
    }
    public Institution getInstitutionById(Long id){
        return institutionRepository.findIstitutionById(id);
    }
    public Institution getInstitutionByName(String name){
        return institutionRepository.findInstitutionByName(name);
    }
    public void deleteInstitution(Long id){
        institutionRepository.deleteById(id);
    }
    public void updateInstitution(InstitutionDTO institutionDTO){
        ModelMapper modelMapper = new ModelMapper();
        Institution institution = institutionRepository.getOne(institutionDTO.getId());
        institution = modelMapper.map(institutionDTO,Institution.class);
        institutionRepository.save(institution);
    }
    public void saveInstitution(InstitutionDTO institutionDTO){
        ModelMapper modelMapper = new ModelMapper();
        Institution institution = modelMapper.map(institutionDTO,Institution.class);
        institutionRepository.save(institution);
    }
}
