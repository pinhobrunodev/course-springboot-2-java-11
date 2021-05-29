package com.pinhobrunodev.course.resources;
// testar o REST 

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pinhobrunodev.course.entities.User;
import com.pinhobrunodev.course.services.UserService;

/*
 * Reosource e um recurso web que e implementado por um controllador Rest
 */



@RestController // -> Indica que a classe UserResourece vai ser controlado por um controller do tipo REST
@RequestMapping(value = "/users") // -> Nome do recurso(caminhos do recurso)
public class UserResource {

	
	@Autowired
	private UserService us;
	
	
	
	// Salvando
	// Usamos o @RequestBody pois vai receber um obj para ser salvo
	@PostMapping
	public ResponseEntity<User> save(@RequestBody User entity){
		// Gerar o endereco para informar que foi uma insercao com codigo 201
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		entity = us.save(entity);
		return ResponseEntity.created(uri).body(entity);
	}
	
	
	
	//Deletando
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		us.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//Metodo de endpoint para acessar Usuarios
	// Responde uma requisicao do tipo GET
	@GetMapping
	// Retorna uma lista de usuarios
	public ResponseEntity<List<User>> findAll(){
		List<User> list = us.findAll();
		return ResponseEntity.ok().body(list);
		// -> Ok  = resposta com sucesso http
		// body() = corpo da resposta que vai ser enviada
	}
	
	// Requisicao vai aceitar um id na url
	@GetMapping(value = "/{id}")
	// Colocamos o @PathVariable para o Spring entender que sera o id informado na url
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = us.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
