package com.pinhobrunodev.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinhobrunodev.course.entities.Order;
import com.pinhobrunodev.course.repositories.OrderRepository;

// Registrando a classe como um componente do Spring
@Service
public class OrderService {
	
	
	// Injecao de dependencia
	@Autowired
	private OrderRepository ur;
	
	// Retornando todos os dados da tabela
	public List<Order> findAll(){
		return ur.findAll();
	}
	
	// Retornando pedido pelo id
	
	public Order findById(Long id) {
	Optional<Order>obj=ur.findById(id);
	// Retorna o obj do tipo Pedido que estiver dentro do Optional
	return obj.get();
	}
	
}
