package com.course.spring.resources;

import com.course.spring.entities.Category;
import com.course.spring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/category")
public class CategoryResource {

    @Autowired // Injeção de dependência automática
    private CategoryService categories;

    // endpoint
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categoriesList = categories.findAll();
        return ResponseEntity.ok().body(categoriesList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = categories.findById(id);
        return ResponseEntity.ok().body(category);
    }
}
