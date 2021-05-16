package com.pinhobrunodev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinhobrunodev.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
