package com.eriofabbri.meli.app.target.models.service;

import com.eriofabbri.meli.app.target.models.dao.TargetDao;
import com.eriofabbri.meli.app.target.models.entity.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*Implementamos los metodos que declaramos en nuestros Service*/
@Service
public class TargetServiceImpl implements ITargetService{
    @Autowired
    private TargetDao targetDao;

    @Override
    public List<Target> findAll() {
        return (List<Target>) targetDao.findAll();
    }

    @Override
    public Target findById(Long id) {
        return targetDao.findById(id).orElse(null);
    }

    @Override
    public Long ActualizarTarget(Target target) {return targetDao.save(target).getId();}


}
