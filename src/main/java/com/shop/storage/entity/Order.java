package com.shop.storage.entity;

import com.shop.storage.enums.OrderStatus;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Igor on 25.06.2015.
 */
@Entity
@Table(name = "order")
@NamedQueries({
        @NamedQuery(name = "Order.findAll",
                query = "SELECT o FROM Order o where o.user = :userId"),
        @NamedQuery(name = "Order.findDelivered",
                query = "SELECT o FROM Order o where o.status = 'DELIVERED' and  o.user = :userId"),
        @NamedQuery(name = "Order.findCanceled",
                query = "SELECT o FROM Order o where o.status = 'CANCELED' and  o.user = :userId"),
        @NamedQuery(name = "Order.findExpectedDelivery",
                query = "SELECT o FROM Order o where o.status = 'EXPECTED_DELIVERY' and  o.user = :userId"),
        @NamedQuery(name = "Order.findByTimeBetween",
                query = "SELECT o FROM Order o where (o.time between :lowTime and  :highTime) and o.user = :userId"),
        @NamedQuery(name = "Order.findTotalAll",
                query = "SELECT COUNT(o) FROM Order o and  o.user = :userId"),
        @NamedQuery(name = "Order.findTotalDelivered",
                query = "SELECT COUNT(o) FROM Order o where o.status = 'DELIVERED' and  o.user = :userId"),
        @NamedQuery(name = "Order.findTotalCanceled",
                query = "SELECT COUNT(o) FROM Order o where o.status = 'CANCELED' and  o.user = :userId"),
        @NamedQuery(name = "Order.findTotalExpectedDelivery",
                query = "SELECT COUNT(o) FROM Order o where o.status = 'EXPECTED_DELIVERY' and  o.user = :userId")
})

public class Order {

    private Long id;
    private User user;
    private OrderStatus orderStatus;
    private Timestamp time;
    private BigDecimal price;
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

    @Column(name = "order_status")
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Column(name = "time")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
