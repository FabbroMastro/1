package com.eriofabbri.meli.app.prestamo.models.service.interfaces;

import com.eriofabbri.meli.app.prestamo.models.User;
import java.util.List;

public interface getUserService {
    public List<User> findAll();
    public User findById(Long id);
}
