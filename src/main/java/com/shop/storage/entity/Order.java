package com.shop.storage.entity;

import com.shop.storage.enums.Status;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Igor on 25.06.2015.
 */
@Entity
@Table(name = "order")
@NamedQueries({
        @NamedQuery(name = "Order.findAll",
                query = "SELECT o FROM Order o"),
        @NamedQuery(name = "Order.findDelivered",
                query = "SELECT o FROM Order o where o.status = 'DELIVERED'"),
        @NamedQuery(name = "Order.findCanceled",
                query = "SELECT o FROM Order o where o.status = 'CANCELED'"),
        @NamedQuery(name = "Order.findExpectedDelivery",
                query = "SELECT o FROM Order o where o.status = 'EXPECTED_DELIVERY'")})

public class Order {

    private Long id;
    private User user;
    private Status status;
    private List<Product> products;

    public Order() {
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "customer_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "status")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
