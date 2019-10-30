package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dto.CategoryDTO;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<CategoryDTO> getAllCategories(){
        List<CategoryDTO> result= new ArrayList<>();
        List<Category> preresult = categoryRepository.findAll();
        preresult.forEach(p ->{
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(p.getId());
            categoryDTO.setName(p.getName());
            result.add(categoryDTO);
        });

        return result;
    }
    public List<Category> getCategoryById(List<Long> id){
        return categoryRepository.findByIdIn(id);
    }
}
