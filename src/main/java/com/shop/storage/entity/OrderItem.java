package com.shop.storage.entity;

import com.shop.storage.enums.OrderStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by Igor on 27.06.2015.
 */
@Entity
@Table(name = "order_instance")
public class OrderItem {

    private Long id;
    private Long orderId;
    private OrderStatus orderStatus;
    private Timestamp createTime;

    public OrderItem() {
    }

    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "order_id")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Column(name = "orderStatus")
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Column(name = "time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
