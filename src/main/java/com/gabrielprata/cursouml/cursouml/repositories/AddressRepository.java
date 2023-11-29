package com.gabrielprata.cursouml.cursouml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielprata.cursouml.cursouml.domain.Address;

//Anotação para indicar que a classe é um repository
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
