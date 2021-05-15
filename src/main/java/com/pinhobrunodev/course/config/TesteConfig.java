package com.pinhobrunodev.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pinhobrunodev.course.entities.User;
import com.pinhobrunodev.course.repositories.UserRepository;

/**
 * 
 * @author bruno
 *
 * Configurando a classe de teste  que vai fazer o seedind
 * do nosso banco de dados
 */
@Configuration
@Profile("test")
// A inteface CommandLineRunner, permite que qualquer comando seja executado durante a execucao do programa
public class TesteConfig implements CommandLineRunner {
	// Injecao de dependencia
	@Autowired
	private UserRepository ur;
	
	// Vamos instanciar objetos  e salvar no nosso banco de dados h2
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		// Salvando uma lista de objetos dentro do banco de dados
		ur.saveAll(Arrays.asList(u1,u2));
	}
	
	
	
	
	
	
	
}
