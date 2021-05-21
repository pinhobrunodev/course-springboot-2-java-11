package com.pinhobrunodev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinhobrunodev.course.entities.OrderItem;


// Responsavel por fazer as operacoes com a entidade

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
