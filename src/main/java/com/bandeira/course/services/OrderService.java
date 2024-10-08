package com.bandeira.course.services;

import com.bandeira.course.entities.Order;
import com.bandeira.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List <Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById( Long id ) {
        Optional <Order> optional = orderRepository.findById(id);
        return optional.get();

    }

}
