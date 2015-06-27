package com.shop.storage.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Igor on 25.06.2015.
 */

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "User.findAll",
                query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findByUsername",
                query = "SELECT u FROM User u WHERE u.name = :name"),
        @NamedQuery(name = "User.findByPartOfName",
                query = "SELECT u FROM User u WHERE u.name LIKE :code")})
public class User {

    private Long id;
    private String name;
    private String pass;
    private String address;
    private Integer age;
    private List<Order> orders;

    public User() {

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

    @Column(name = "pass")
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
