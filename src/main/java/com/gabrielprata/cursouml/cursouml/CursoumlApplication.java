package com.gabrielprata.cursouml.cursouml;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabrielprata.cursouml.cursouml.domain.Address;
import com.gabrielprata.cursouml.cursouml.domain.Category;
import com.gabrielprata.cursouml.cursouml.domain.City;
import com.gabrielprata.cursouml.cursouml.domain.Customer;
import com.gabrielprata.cursouml.cursouml.domain.CustomerOrder;
import com.gabrielprata.cursouml.cursouml.domain.OrderItem;
import com.gabrielprata.cursouml.cursouml.domain.Payment;
import com.gabrielprata.cursouml.cursouml.domain.PaymentWithBankSlip;
import com.gabrielprata.cursouml.cursouml.domain.PaymentWithCard;
import com.gabrielprata.cursouml.cursouml.domain.Product;
import com.gabrielprata.cursouml.cursouml.domain.UF;
import com.gabrielprata.cursouml.cursouml.domain.enums.CustomerType;
import com.gabrielprata.cursouml.cursouml.domain.enums.PaymentStatus;
import com.gabrielprata.cursouml.cursouml.repositories.AddressRepository;
import com.gabrielprata.cursouml.cursouml.repositories.CategoryRepository;
import com.gabrielprata.cursouml.cursouml.repositories.CityRepository;
import com.gabrielprata.cursouml.cursouml.repositories.CustomerOrderRepository;
import com.gabrielprata.cursouml.cursouml.repositories.ProductRepository;
import com.gabrielprata.cursouml.cursouml.repositories.UFRepository;
import com.gabrielprata.cursouml.cursouml.repositories.CustomerRepository;
import com.gabrielprata.cursouml.cursouml.repositories.OrderItemRepository;
import com.gabrielprata.cursouml.cursouml.repositories.PaymentRepository;

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

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private CustomerOrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoumlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Passo null no primeiro parâmetro, pois é o banco de dados quem vai gerar os
		// ID's
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

		Customer cus1 = new Customer("Maria Silva", "maria@mail.com", "12345678910", CustomerType.PESSSOAFISICA);
		cus1.getTelephone().addAll(Arrays.asList("27363323", "93838393"));

		Address ad1 = new Address("Rua Flores", "350C", "Casa", "Jardim Bonito", "12312312", cus1, c1);
		Address ad2 = new Address("Avenida Matos", "105", "Sala 800", "Centro", "38777012", cus1, c2);

		cus1.getAddresses().addAll(Arrays.asList(ad1, ad2));

		customerRepository.saveAll(Arrays.asList(cus1));
		addressRepository.saveAll(Arrays.asList(ad1, ad2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		CustomerOrder order1 = new CustomerOrder(sdf.parse("30/09/2023 10:32"), cus1, ad1);
		CustomerOrder order2 = new CustomerOrder(sdf.parse("10/10/2023 19:35"), cus1, ad2);

		Payment pay1 = new PaymentWithCard(PaymentStatus.QUITADO, order1, 6);
		order1.setPayment(pay1);

		Payment pay2 = new PaymentWithBankSlip(PaymentStatus.PENDENTE, order2, sdf.parse("20/10/2023 18:30"), null);
		order2.setPayment(pay2);

		cus1.getOrders().addAll(Arrays.asList(order1, order2));

		orderRepository.saveAll(Arrays.asList(order1, order2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));

		OrderItem oi1 = new OrderItem(order1, p1, 0.00, 1, p1.getPrice());
		OrderItem oi2 = new OrderItem(order1, p3, 0.00, 2, p3.getPrice());
		OrderItem oi3 = new OrderItem(order2, p2, 100.00, 1, p2.getPrice());

		order1.getItens().addAll(Arrays.asList(oi1, oi2));
		order2.getItens().addAll(Arrays.asList(oi3));

		p1.getItens().addAll(Arrays.asList(oi1));
		p2.getItens().addAll(Arrays.asList(oi2));
		p3.getItens().addAll(Arrays.asList(oi3));

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));

	}
}
