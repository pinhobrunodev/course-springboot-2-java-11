package com.pinhobrunodev.course.resources;
// testar o REST 

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinhobrunodev.course.entities.User;

/*
 * Reosource e um recurso web que e implementado por um controllador Rest
 */


@RestController // -> Indica que a classe UserResourece vai ser controlado por um controller do tipo REST
@RequestMapping(value = "/users") // -> Nome do recurso(caminhos do recurso)
public class UserResource {

	//Metodo de endpoint para acessar Usuarios
	// Responde uma requisicao do tipo GET
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1l, "bruno", "bruno@gmail.com", "999999999", "123");
		return ResponseEntity.ok().body(u);
		// -> Ok  = resposta com sucesso http
		// body() = corpo da resposta que vai ser enviada
	}
	
}
