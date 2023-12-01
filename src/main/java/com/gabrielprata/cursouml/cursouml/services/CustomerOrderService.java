package com.gabrielprata.cursouml.cursouml.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielprata.cursouml.cursouml.domain.CustomerOrder;
import com.gabrielprata.cursouml.cursouml.exception.ObjectNotFoundException;
import com.gabrielprata.cursouml.cursouml.repositories.CustomerOrderRepository;

//Anotação para indicar que a classe é um Service
@Service
public class CustomerOrderService {

    // O Autowired serve para o Spring Boot instanciar a depência automaticamente
    @Autowired
    private CustomerOrderRepository repo;

    public CustomerOrder search(Integer id) {
        Optional<CustomerOrder> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not Found! Id: " + id + ", Tipo: " + CustomerOrder.class.getName()));
    }
}
