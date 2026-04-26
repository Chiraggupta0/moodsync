package com.moodsync.service;

import org.springframework.stereotype.Service;
import com.moodsync.repository.UserRepository;
import com.moodsync.model.User;
import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository repo;

    public AuthService(UserRepository repo){this.repo=repo;}

    public User register(User user){
        return repo.save(user);
    }

    public Optional<User> login(String username){
        return repo.findByUsername(username);
    }
}
