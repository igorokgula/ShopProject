package com.shop.logic.service;

import com.shop.storage.entity.User;
import com.shop.storage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Igor on 26.06.2015.
 */
@Service(value = "userService")
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        User user = null;
        try {
            //user = userRepository.getUserByUsername(username);
        } catch (Exception e) {}
        return user;
    }

    @Transactional
    public void registerUser(User user) {

    }

}
