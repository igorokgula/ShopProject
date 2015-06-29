package com.shop.storage.repository.implementation;

import com.shop.storage.entity.OrderItem;
import com.shop.storage.repository.OrderItemRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Igor on 27.06.2015.
 */
public class JPAOrderItemRepository implements OrderItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(OrderItem orderItem) {
        entityManager.persist(orderItem);
        return orderItem.getId();
    }
}
