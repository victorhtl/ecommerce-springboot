package com.course.spring.services;

import com.course.spring.entities.User;
import com.course.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Para permitir a injeção de dependência, poderia ser um @Component
public class UserService {
    @Autowired // Injeção de dependências
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }
}
