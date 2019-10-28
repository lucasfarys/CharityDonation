package pl.coderslab.charity.service;


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
}
