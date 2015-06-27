package com.shop.storage.repository.implementation;

import com.shop.storage.repository.UserRepository;
import com.shop.storage.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * Created by Igor on 25.06.2015.
 */
@Repository("customerRepository")
public class JPAUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager manager;
    private static final Logger logger = LogManager.getLogger();

    public List<User> getAllCustomers() {
        return null;
    }

    public void addCustomer(User user) {
        user.setPass(getEncodedString(user.getPass()));
        manager.persist(user);
    }

    public void updateCustomer(User user) {

    }

    public List<User> getCustomersByName() {
        return null;
    }

    private String getDecodedString(String str) {
        String rez = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            rez = new String(messageDigest.digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            logger.error(e);
        }
        return rez;
    }

    private String getEncodedString(String str) {
        String rez = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            rez = new String(messageDigest.digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            logger.error(e);
        }
        return rez;
    }
}