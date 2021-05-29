package com.pinhobrunodev.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinhobrunodev.course.entities.User;
import com.pinhobrunodev.course.repositories.UserRepository;

// Registrando a classe como um componente do Spring
@Service
public class UserService {
	
	
	// Injecao de dependencia
	@Autowired
	private UserRepository ur;
	
	
	
	// Salvando
	public User save(User entity) {
	return ur.save(entity);
	}
	
	
	// Deletar
	
	public void delete(Long id) {
		ur.deleteById(id);
	}
	
	// Retornando todos os dados da tabela
	public List<User> findAll(){
		return ur.findAll();
	}
	
	// Retornando usuario pelo id
	
	public User findById(Long id) {
	Optional<User>obj=ur.findById(id);
	// Retorna o obj do tipo User que estiver dentro do Optional
	return obj.get();
	}
	
}
