package com.eriofabbri.meli.app.user.models.service;

import com.eriofabbri.meli.app.user.models.User;

import java.util.List;
/*Esta es el servicio donde declaramos nuestros metodos para emplementar las actiones de JPA para el manejo de la informacion de H2*/
public interface UserService {

    public List<User> findAll();
    public User findById(Long id);
}
