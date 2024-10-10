package com.bandeira.course.repositories;

import com.bandeira.course.entities.Category;
import com.bandeira.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
