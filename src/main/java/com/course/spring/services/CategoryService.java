package com.course.spring.services;

import com.course.spring.entities.Category;
import com.course.spring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Para permitir a injeção de dependência, poderia ser um @Component
public class CategoryService {
    @Autowired // Injeção de dependências
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.get();
    }
}
