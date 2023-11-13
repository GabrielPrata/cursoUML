package com.gabrielprata.cursouml.cursouml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielprata.cursouml.cursouml.domain.Category;

//Anotação para indicar que a classe é um repository
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
