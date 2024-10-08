package com.bandeira.course.services;

import com.bandeira.course.entities.Category;
import com.bandeira.course.entities.Product;
import com.bandeira.course.repositories.CategoryRepository;
import com.bandeira.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List <Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById( Long id ) {
        Optional <Product> optional = productRepository.findById(id);
        return optional.get();

    }
}
