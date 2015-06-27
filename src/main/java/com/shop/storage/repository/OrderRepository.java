package com.shop.storage.repository;

import com.shop.storage.entity.Order;

import java.util.List;

/**
 * Created by Igor on 25.06.2015.
 */
public interface OrderRepository {
    public Long save(Order order);
    public Long update(Order order);
    public boolean delete(Order order);
    public List<Order> getAllOrders(Long userId, int startingResult, int resultsCount);
    public List<Order> getDeliveredOrders(Long userId, int startingResult, int resultsCount);
    public List<Order> getCanceledOrders(Long userId, int startingResult, int resultsCount);
    public List<Order> getExpectedDeliveryOrders(Long userId, int startingResult, int resultsCount);
    public Long getTotalAllOrders();
    public Long getTotalDeliveredOrders(Long userId);
    public Long getTotalCanceledOrders(Long userId);
    public Long getTotalExpectedDeliveryOrders(Long userId);
}
