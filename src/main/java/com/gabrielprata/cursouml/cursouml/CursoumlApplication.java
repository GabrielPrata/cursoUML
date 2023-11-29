package com.gabrielprata.cursouml.cursouml;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabrielprata.cursouml.cursouml.domain.Category;
import com.gabrielprata.cursouml.cursouml.domain.City;
import com.gabrielprata.cursouml.cursouml.domain.Product;
import com.gabrielprata.cursouml.cursouml.domain.UF;
import com.gabrielprata.cursouml.cursouml.repositories.CategoryRepository;
import com.gabrielprata.cursouml.cursouml.repositories.CityRepository;
import com.gabrielprata.cursouml.cursouml.repositories.ProductRepository;
import com.gabrielprata.cursouml.cursouml.repositories.UFRepository;

@SpringBootApplication
public class CursoumlApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UFRepository ufRepository;

	@Autowired
	private CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoumlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Passo null no primeiro parâmetro, pois é o banco de dados quem vai gerar os ID's
		Category cat1 = new Category("Computing");
		Category cat2 = new Category("Office");

		Product p1 = new Product("Computer", 2000.00);
		Product p2 = new Product("Printer", 800.00);
		Product p3 = new Product("Mouse", 80.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat1.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		UF uf1 = new UF("Minas Gerais");
		UF uf2 = new UF("São Paulo");

		City c1 = new City("Uberlândia", uf1);
		City c2 = new City("São Paulo", uf2);
		City c3 = new City("Campinas", uf2);

		uf1.getCities().addAll(Arrays.asList(c1));
		uf2.getCities().addAll(Arrays.asList(c2, c3));

		ufRepository.saveAll((Arrays.asList(uf1, uf2)));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		
	}
}
