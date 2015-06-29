package com.shop.logic.service;

import com.shop.storage.entity.Order;
import com.shop.storage.entity.OrderItem;
import com.shop.storage.enums.OrderStatus;
import com.shop.storage.enums.ProductStatus;
import com.shop.storage.repository.OrderItemRepository;
import com.shop.storage.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Igor on 27.06.2015.
 */
@Service(value = "productService")
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Long makeOrder(Long userId, List<Long> productList) {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        Order order = new Order();
        order.setOrderStatus(OrderStatus.EXPECTED_DELIVERY);
        order.setUser(userService.getUserById(userId));
        order.setTime(currentTime);
        Long orderId = orderRepository.save(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(orderId);
        orderItem.setCreateTime(currentTime);
        orderItem.setOrderStatus(OrderStatus.EXPECTED_DELIVERY);
        orderItemRepository.save(orderItem);

        buyProducts(productList);

        return orderId;
    }

    private void buyProducts(List<Long> productList) {
        for (Long id : productList) {
            productService.setStatus(id, ProductStatus.BOUGHT);
        }
    }

    public Long update(Long orderId, OrderStatus orderStatus) {
        //todo
        return null;
    }

    public boolean delete(Order order) {
        return orderRepository.delete(order);
    }

    public List<Order> getAllOrders(Long userId, int startingResult, int resultsCount) {
        return orderRepository.getAllOrders(userId, startingResult, resultsCount);
    }

    public List<Order> getDeliveredOrders(Long userId, int startingResult, int resultsCount) {
        return orderRepository.getDeliveredOrders(userId, startingResult, resultsCount);
    }

    public List<Order> getCanceledOrders(Long userId, int startingResult, int resultsCount) {
        return orderRepository.getCanceledOrders(userId, startingResult, resultsCount);
    }

    public List<Order> getExpectedDeliveryOrders(Long userId, int startingResult, int resultsCount) {
        return orderRepository.getExpectedDeliveryOrders(userId, startingResult, resultsCount);
    }

    public List<Order> getByTimeBetweenOrders(Long userId, Timestamp low, Timestamp high, int startingResult, int resultsCount) {
        return orderRepository.getByTimeBetweenOrders(userId, low, high, startingResult, resultsCount);
    }

    public Long getTotalAllOrders(Long userId) {
        return getTotalAllOrders(userId);
    }

    public Long getTotalDeliveredOrders(Long userId) {
        return orderRepository.getTotalDeliveredOrders(userId);
    }

    public Long getTotalCanceledOrders(Long userId) {
        return orderRepository.getTotalCanceledOrders(userId);
    }

    public Long getTotalExpectedDeliveryOrders(Long userId) {
        return orderRepository.getTotalExpectedDeliveryOrders(userId);
    }

    public Long getTotalByTimeBetweenOrders(Long userId, Timestamp low, Timestamp high) {
        return orderRepository.getTotalByTimeBetweenOrders(userId, low, high);
    }
}
