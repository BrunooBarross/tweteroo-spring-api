package com.api.twetero.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.twetero.dto.UserDTO;
import com.api.twetero.models.User;
import com.api.twetero.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public User insert (UserDTO obj) {
        User user = new User(obj);
        return repository.save(user);
    }
}
