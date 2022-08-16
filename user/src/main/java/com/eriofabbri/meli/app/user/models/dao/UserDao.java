package com.eriofabbri.meli.app.user.models.dao;

import com.eriofabbri.meli.app.user.models.User;
import org.springframework.data.repository.CrudRepository;
//Interface para el manejo de las funciones JPA
public interface UserDao extends CrudRepository<User, Long> {


}
