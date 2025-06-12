package com.musclemart.musclemart.service;

import com.musclemart.musclemart.entity.User;
import com.musclemart.musclemart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // For signup
    public User signup(User user) {
        return repository.save(user);
    }

    // For login
    public User login(String email, String password) {
        User user = repository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
