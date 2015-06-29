package com.shop.storage.repository.implementation;

import com.shop.storage.entity.Order;
import com.shop.storage.repository.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Igor on 27.06.2015.
 */
public class JPAOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(Order order) {
        entityManager.persist(order);
        return order.getId();
    }

    @Override
    public Long update(Order order) {
        entityManager.merge(order);
        return order.getId();
    }

    @Override
    public boolean delete(Order order) {
        entityManager.remove(order);
        return true;
    }

    @Override
    public List<Order> getAllOrders(Long userId, int startingResult, int resultsCount) {
        TypedQuery<Order> query = entityManager.createNamedQuery("Order.findAll", Order.class);
        query.setParameter("userId", userId);
        query.setFirstResult(startingResult);
        query.setMaxResults(resultsCount);
        return query.getResultList();
    }

    @Override
    public List<Order> getDeliveredOrders(Long userId, int startingResult, int resultsCount) {
        TypedQuery<Order> query = entityManager.createNamedQuery("Order.findDelivered", Order.class);
        query.setParameter("userId", userId);
        query.setFirstResult(startingResult);
        query.setMaxResults(resultsCount);
        return query.getResultList();
    }

    @Override
    public List<Order> getCanceledOrders(Long userId, int startingResult, int resultsCount) {
        TypedQuery<Order> query = entityManager.createNamedQuery("Order.findCanceled", Order.class);
        query.setParameter("userId", userId);
        query.setFirstResult(startingResult);
        query.setMaxResults(resultsCount);
        return query.getResultList();
    }

    @Override
    public List<Order> getExpectedDeliveryOrders(Long userId, int startingResult, int resultsCount) {
        TypedQuery<Order> query = entityManager.createNamedQuery("Order.findExpectedDelivery", Order.class);
        query.setParameter("userId", userId);
        query.setFirstResult(startingResult);
        query.setMaxResults(resultsCount);
        return query.getResultList();
    }

    @Override
    public List<Order> getByTimeBetweenOrders(Long userId, Timestamp low, Timestamp high, int startingResult, int resultsCount) {
        TypedQuery<Order> query = entityManager.createNamedQuery("Order.findByTimeBetween", Order.class);
        query.setParameter("userId", userId);
        query.setParameter("lowTime", low);
        query.setParameter("highTime", high);
        query.setFirstResult(startingResult);
        query.setMaxResults(resultsCount);
        return query.getResultList();
    }

    @Override
    public Long getTotalAllOrders(Long userId) {
        TypedQuery<Long> query = entityManager.createNamedQuery("Order.findTotalAll", Long.class);
        query.setParameter("userId", userId);
        return query.getResultList().get(0);
    }

    @Override
    public Long getTotalDeliveredOrders(Long userId) {
        TypedQuery<Long> query = entityManager.createNamedQuery("Order.findTotalDelivered", Long.class);
        query.setParameter("userId", userId);
        return query.getResultList().get(0);
    }

    @Override
    public Long getTotalCanceledOrders(Long userId) {
        TypedQuery<Long> query = entityManager.createNamedQuery("Order.findTotalCanceled", Long.class);
        query.setParameter("userId", userId);
        return query.getResultList().get(0);
    }

    @Override
    public Long getTotalExpectedDeliveryOrders(Long userId) {
        TypedQuery<Long> query = entityManager.createNamedQuery("Order.findTotalExpectedDelivery", Long.class);
        query.setParameter("userId", userId);
        return query.getResultList().get(0);
    }

    @Override
    public Long getTotalByTimeBetweenOrders(Long userId, Timestamp low, Timestamp high) {
        TypedQuery<Long> query = entityManager.createNamedQuery("Order.findTotalByTimeBetween", Long.class);
        query.setParameter("userId", userId);
        query.setParameter("lowTime", low);
        query.setParameter("highTime", high);
        return query.getResultList().get(0);
    }
}
