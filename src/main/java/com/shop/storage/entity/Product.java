package com.shop.storage.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Igor on 25.06.2015.
 */
@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "User.findAll",
                query = "SELECT p FROM Product p"),
        @NamedQuery(name = "User.findByPartOfName",
                query = "SELECT p FROM Product p WHERE p.name LIKE :code"),
        @NamedQuery(name = "User.findByPartOfBrandName",
                query = "SELECT p FROM Product p WHERE p.brandname LIKE :code"),
        @NamedQuery(name = "User.findByPriceBetween",
                query = "SELECT p FROM Product p WHERE p.price BETWEEN :lowPrice and :highPrice"),
        @NamedQuery(name = "User.findTotalAll",
                query = "SELECT COUNT(p) FROM Product p"),
        @NamedQuery(name = "User.findTotalByPartOfName",
                query = "SELECT COUNT(p) FROM Product p WHERE p.name LIKE :code"),
        @NamedQuery(name = "User.findTotalByPartOfBrandName",
                query = "SELECT COUNT(p) FROM Product p WHERE p.brandname LIKE :code"),
        @NamedQuery(name = "User.findTotalByPriceBetween",
                query = "SELECT COUNT(p) FROM Product p WHERE p.price BETWEEN :lowPrice and :highPrice")
})
public class Product {

    private Long id;
    private String name;
    private String brandName;
    private String description;
    private BigDecimal price;
    private Order order;

    public Product() {
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "brandname")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
