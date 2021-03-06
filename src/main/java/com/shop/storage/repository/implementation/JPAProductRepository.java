package com.shop.storage.repository.implementation;

import com.shop.storage.entity.Product;
import com.shop.storage.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Igor on 27.06.2015.
 */
public class JPAProductRepository implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long save(Product product) {
        entityManager.persist(product);
        return product.getId();
    }

    @Override
    public Long update(Product product) {
        entityManager.merge(product);
        return product.getId();
    }

    @Override
    public boolean delete(Product product) {
        entityManager.remove(product);
        return true;
    }

    @Override
    public Product getById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> getAllProducts(int startingResult, int resultsCount) {
        TypedQuery<Product> query = entityManager.createNamedQuery("User.findAll", Product.class);
        query.setFirstResult(startingResult);
        query.setMaxResults(resultsCount);
        return query.getResultList();
    }

    @Override
    public List<Product> getProductsByName(String name, int startingResult, int resultsCount) {
        TypedQuery<Product> query = entityManager.createNamedQuery("User.findByPartOfName", Product.class);
        query.setParameter("code", "%" + name + "%");
        query.setFirstResult(startingResult);
        query.setMaxResults(resultsCount);
        return query.getResultList();
    }

    @Override
    public List<Product> getProductsByBrandName(String brandName, int startingResult, int resultsCount) {
        TypedQuery<Product> query = entityManager.createNamedQuery("User.findByPartOfBrandName", Product.class);
        query.setParameter("code", "%" + brandName + "%");
        query.setFirstResult(startingResult);
        query.setMaxResults(resultsCount);
        return query.getResultList();
    }

    @Override
    public List<Product> getProductsPriceBetween(BigDecimal low, BigDecimal high, int startingResult, int resultsCount) {
        TypedQuery<Product> query = entityManager.createNamedQuery("User.findByPriceBetween", Product.class);
        query.setParameter("lowPrice", low);
        query.setParameter("highPrice", high);
        query.setFirstResult(startingResult);
        query.setMaxResults(resultsCount);
        return query.getResultList();
    }

    @Override
    public Long getTotalAllProducts() {
        TypedQuery<Long> query = entityManager.createNamedQuery("User.findTotalAll", Long.class);
        return query.getResultList().get(0);
    }

    @Override
    public Long getTotalProductsByName(String name) {
        TypedQuery<Long> query = entityManager.createNamedQuery("User.findTotalByPartOfName", Long.class);
        query.setParameter("code", "%" + name + "%");
        return query.getResultList().get(0);
    }

    @Override
    public Long getTotalProductsByBrandName(String brandName) {
        TypedQuery<Long> query = entityManager.createNamedQuery("User.findTotalByPartOfBrandName", Long.class);
        query.setParameter("code", "%" + brandName + "%");
        return query.getResultList().get(0);
    }

    @Override
    public Long getTotalProductsPriceBetween(BigDecimal low, BigDecimal high) {
        TypedQuery<Long> query = entityManager.createNamedQuery("User.findTotalByPriceBetween", Long.class);
        query.setParameter("lowPrice", low);
        query.setParameter("highPrice", high);
        return query.getResultList().get(0);
    }
}
