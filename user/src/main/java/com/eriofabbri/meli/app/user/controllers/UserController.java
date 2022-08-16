package com.eriofabbri.meli.app.user.controllers;

import com.eriofabbri.meli.app.user.models.User;
import com.eriofabbri.meli.app.user.models.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
//Rest Controller para la declaracion de los endpoint para el manejo de la informacion de user
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/listar")
    public List<User> listar(){
        return new ArrayList<>(userService.findAll());
    }
    
    @GetMapping("/ver/{id}")
    public User detalle(@PathVariable Long id) {
        return userService.findById(id);

    }
}