package com.eriofabbri.meli.app.user.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eriofabbri.meli.app.user.models.User;
import com.eriofabbri.meli.app.user.models.dao.UserDao;

@Service("serviceRestTemplate")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {

        return (List<User>) userDao.findAll();
    }
    @Override
    public User findById(Long id) {
        return userDao.findById(id).orElse(null);
    }
}
