package com.bandeira.course.resources;

import com.bandeira.course.entities.Category;
import com.bandeira.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResources {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>>findAll(){
        return ResponseEntity.ok().body(categoryService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category>findById( @PathVariable Long id ){
        return ResponseEntity.ok().body(categoryService.findById(id));
    }
}
