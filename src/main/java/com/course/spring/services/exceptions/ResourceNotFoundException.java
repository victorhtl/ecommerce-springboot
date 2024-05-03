package com.course.spring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id){
        // Mensagem de erro para objeto nao encontrado
        super("Resource not found. Id: " + id);
    }
}
