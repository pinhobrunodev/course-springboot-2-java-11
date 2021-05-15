package com.pinhobrunodev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinhobrunodev.course.entities.User;


// Responsavel por fazer as operacoes com a entidade
public interface UserRepository extends JpaRepository<User, Long> {

}
