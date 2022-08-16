package com.eriofabbri.meli.app.prestamo.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eriofabbri.meli.app.prestamo.clientes.UserClientRest;
import com.eriofabbri.meli.app.prestamo.models.User;
import com.eriofabbri.meli.app.prestamo.models.service.interfaces.getUserService;


@Service("UserFeingService")
public class UserFeingService implements getUserService {

    @Autowired
    UserClientRest userClientRest;

    @Override
    public List<User> findAll() {
        return userClientRest.listar().stream().collect(Collectors.toList());
    }

    @Override
    public User findById(Long id) {
        return userClientRest.detalle(id);
    }
}
