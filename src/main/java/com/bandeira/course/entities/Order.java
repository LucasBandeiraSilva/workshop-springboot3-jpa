package com.bandeira.course.entities;

import com.bandeira.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant instant;
    private Integer orderStatus;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    @OneToMany(mappedBy = "id.order")
    private Set <OrderItem> items = new HashSet <>();
    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private Payment payment;

    public Order() {
    }

    public Order( Long id, Instant instant, User client,OrderStatus orderStatus ) {
        this.id = id;
        this.instant = instant;
        this.client = client;
        setOrderStatus(orderStatus);
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant( Instant instant ) {
        this.instant = instant;
    }

    public User getClient() {
        return client;
    }

    public void setClient( User client ) {
        this.client = client;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus( OrderStatus orderStatus ) {
        if (orderStatus != null) this.orderStatus = orderStatus.getCode();

    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment( Payment payment ) {
        this.payment = payment;
    }

    public Set <OrderItem> getItems() {
        return items;
    }

    public Double getTotal(){
        return items.stream().map(OrderItem::getSubTotal).reduce(.0,Double::sum);
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;
        return getId().equals(order.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
