package com.course.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.course.spring.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

// Classe que traz os métodos de acesso ao banco
@Repository // Opcional pois o JpaRepository já tem
public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails finByLogin(String login);
}
