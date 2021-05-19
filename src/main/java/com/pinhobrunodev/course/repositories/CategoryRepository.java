package com.pinhobrunodev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinhobrunodev.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
