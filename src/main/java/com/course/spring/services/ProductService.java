package com.course.spring.services;

import com.course.spring.entities.Category;
import com.course.spring.entities.Product;
import com.course.spring.repositories.CategoryRepository;
import com.course.spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Para permitir a injeção de dependência, poderia ser um @Component
public class ProductService {
    @Autowired // Injeção de dependências
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
}
