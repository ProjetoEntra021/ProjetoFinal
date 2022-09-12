package com.entra21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
