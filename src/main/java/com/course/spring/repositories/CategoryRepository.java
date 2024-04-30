package com.course.spring.repositories;

import com.course.spring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Classe que traz os métodos de acesso ao banco
@Repository // Opcional pois o JpaRepository já tem
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
