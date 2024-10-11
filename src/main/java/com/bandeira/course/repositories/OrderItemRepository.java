package com.bandeira.course.repositories;

import com.bandeira.course.entities.Category;
import com.bandeira.course.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
