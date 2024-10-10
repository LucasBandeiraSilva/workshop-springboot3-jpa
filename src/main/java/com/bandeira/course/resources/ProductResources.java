package com.bandeira.course.resources;

import com.bandeira.course.entities.Category;
import com.bandeira.course.entities.Product;
import com.bandeira.course.repositories.ProductRepository;
import com.bandeira.course.services.CategoryService;
import com.bandeira.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>>findAll(){
        return ResponseEntity.ok().body(productService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product>findById( @PathVariable Long id ){
        return ResponseEntity.ok().body(productService.findById(id));
    }
}
