package com.pinhobrunodev.course.resources;
// testar o REST 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinhobrunodev.course.entities.Order;
import com.pinhobrunodev.course.services.OrderService;

/*
 * Reosource e um recurso web que e implementado por um controllador Rest
 */



@RestController // -> Indica que a classe UserResourece vai ser controlado por um controller do tipo REST
@RequestMapping(value = "/orders") // -> Nome do recurso(caminhos do recurso)
public class OrderResource {

	
	@Autowired
	private OrderService us;
	
	//Metodo de endpoint para acessar Pedidos
	// Responde uma requisicao do tipo GET
	@GetMapping
	// Retorna uma lista de Pedidos
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = us.findAll();
		return ResponseEntity.ok().body(list);
		// -> Ok  = resposta com sucesso http
		// body() = corpo da resposta que vai ser enviada
	}
	
	// Requisicao vai aceitar um id na url
	@GetMapping(value = "/{id}")
	// Colocamos o @PathVariable para o Spring entender que sera o id informado na url
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = us.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
