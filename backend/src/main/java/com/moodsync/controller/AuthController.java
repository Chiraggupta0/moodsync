package com.moodsync.controller;

import org.springframework.web.bind.annotation.*;
import com.moodsync.service.AuthService;
import com.moodsync.security.JwtUtil;
import com.moodsync.model.User;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final AuthService service;
    private final JwtUtil jwt;

    public AuthController(AuthService s, JwtUtil j){
        this.service=s;
        this.jwt=j;
    }

    @PostMapping("/register")
    public User register(@RequestBody User u){
        return service.register(u);
    }

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody User u){
        return service.login(u.getUsername())
                .filter(user->user.getPassword().equals(u.getPassword()))
                .map(user->Map.of("token", jwt.generateToken(user.getUsername())))
                .orElseThrow();
    }
}
