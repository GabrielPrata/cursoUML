package com.gabrielprata.cursouml.cursouml;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabrielprata.cursouml.cursouml.domain.Category;
import com.gabrielprata.cursouml.cursouml.repositories.CategoryRepository;

@SpringBootApplication
public class CursoumlApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;


	public static void main(String[] args) {
		SpringApplication.run(CursoumlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Passo null no primeiro parâmetro, pois é o banco de dados quem vai gerar os ID's
		Category cat1 = new Category("Computing");
		Category cat2 = new Category("Office");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));

	}

}
