package com.bandeira.course.resources;

import com.bandeira.course.entities.Order;
import com.bandeira.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public ResponseEntity<List<Order>>findAll(){
        return ResponseEntity.ok().body(orderService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order>findById( @PathVariable Long id ){
        return ResponseEntity.ok().body(orderService.findById(id));
    }
}
