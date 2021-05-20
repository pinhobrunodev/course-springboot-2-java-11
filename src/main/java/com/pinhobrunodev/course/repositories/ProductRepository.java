package com.pinhobrunodev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinhobrunodev.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
