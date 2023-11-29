package com.gabrielprata.cursouml.cursouml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielprata.cursouml.cursouml.domain.Customer;
import com.gabrielprata.cursouml.cursouml.exception.ObjectNotFoundException;
import com.gabrielprata.cursouml.cursouml.repositories.CustomerRepository;

//Anotação para indicar que a classe é um Service
@Service
public class CustomerService {

    // O Autowired serve para o Spring Boot instanciar a depência automaticamente
    @Autowired
    private CustomerRepository repo;

    public Customer search(Integer id) {
        Optional<Customer> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Customer.class.getName()));
    }
}
