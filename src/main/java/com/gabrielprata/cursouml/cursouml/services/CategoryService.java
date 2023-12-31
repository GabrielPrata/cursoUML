package com.gabrielprata.cursouml.cursouml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielprata.cursouml.cursouml.domain.Category;
import com.gabrielprata.cursouml.cursouml.exception.ObjectNotFoundException;
import com.gabrielprata.cursouml.cursouml.repositories.CategoryRepository;

//Anotação para indicar que a classe é um Service
@Service
public class CategoryService {

    // O Autowired serve para o Spring Boot instanciar a depência automaticamente
    @Autowired
    private CategoryRepository repo;

    public Category search(Integer id) {
        Optional<Category> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not Found! Id: " + id + ", Tipo: " + Category.class.getName()));
    }
}
