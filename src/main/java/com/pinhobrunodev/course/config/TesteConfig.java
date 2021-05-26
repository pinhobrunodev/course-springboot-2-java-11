package com.pinhobrunodev.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pinhobrunodev.course.entities.Category;
import com.pinhobrunodev.course.entities.Order;
import com.pinhobrunodev.course.entities.OrderItem;
import com.pinhobrunodev.course.entities.Payment;
import com.pinhobrunodev.course.entities.Product;
import com.pinhobrunodev.course.entities.User;
import com.pinhobrunodev.course.entities.enums.OrderStatus;
import com.pinhobrunodev.course.repositories.CategoryRepository;
import com.pinhobrunodev.course.repositories.OrderItemRepository;
import com.pinhobrunodev.course.repositories.OrderRepository;
import com.pinhobrunodev.course.repositories.ProductRepository;
import com.pinhobrunodev.course.repositories.UserRepository;

/**
 * 
 * @author bruno
 *
 *         Configurando a classe de teste que vai fazer o seedind do nosso banco
 *         de dados
 */
@Configuration
@Profile("test")
// A inteface CommandLineRunner, permite que qualquer comando seja executado durante a execucao do programa
public class TesteConfig implements CommandLineRunner {
	// Injecao de dependencia
	@Autowired
	private UserRepository ur;

	@Autowired
	private OrderRepository or;
	
	@Autowired
	private CategoryRepository cr;

	@Autowired
	private  ProductRepository pr;
	
	@Autowired
	private OrderItemRepository oir;
	
	// Vamos instanciar objetos e salvar no nosso banco de dados h2
	@Override
	public void run(String... args) throws Exception {
		
		// Posso colocar no comeco pois independente
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		// Seeding product
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

		// Seeding user
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//Formato UTC = >  ANO-MES-DIATHORA:MINUTO:SEGUNDOZ
		/*
		 * SETANDO OS PEDIDOS COM OS OBJETOS DO TIPO USUARIO
		 */
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID ,u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT ,u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1); 
		

		
		// Salvando uma lista de objetos dentro do banco de dados
		cr.saveAll(Arrays.asList(cat1,cat2,cat3));
		pr.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		ur.saveAll(Arrays.asList(u1, u2));
		or.saveAll(Arrays.asList(o1,o2,o3));
		//Associando objetos (Product && Category)
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		//Salvando novamente o produto , porem com as associacoes
		pr.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		// Seed orderItem
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		oir.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment pay1 = new Payment(null,Instant.parse("2019-06-20T21:53:07Z"),o1);
		// Para salvar um obj dependente na relacao OneToOne, nao chamamos o Repository do propio objeto
		o1.setPayment(pay1);
		or.save(o1);
	}

}
