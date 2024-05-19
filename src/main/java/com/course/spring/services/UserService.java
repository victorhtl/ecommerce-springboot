package com.course.spring.services;

/*
* This class acts between the controller and the database access*/

import com.course.spring.entities.User;
import com.course.spring.repositories.UserRepository;
import com.course.spring.services.exceptions.DatabaseException;
import com.course.spring.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        // Tries to find the obj. If don't, returns my exception
        return user.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        try {
            userRepository.deleteById(id);
        } catch(DataIntegrityViolationException e) { // Illegal delete
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user){
        try {
            User entity = userRepository.getReferenceById(id);
            updateData(entity, user);
            return userRepository.save(entity);
        } catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(User entity, User user){
        entity.setLogin(user.getLogin());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
