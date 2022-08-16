package com.eriofabbri.meli.app.prestamo.models.service;

import com.eriofabbri.meli.app.prestamo.models.dao.PrestamoDao;
import com.eriofabbri.meli.app.prestamo.models.entity.Prestamo;
import com.eriofabbri.meli.app.prestamo.models.service.interfaces.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoDao prestamoDao;
    @Override
    public List<Prestamo> findAll() {
        return (List<Prestamo>) prestamoDao.findAll();
    }

    @Override
    public Prestamo findById(Long id) {
        return prestamoDao.findById(id).orElse(null);
    }

    @Override
    public Long savePrestamo(Prestamo prestamo) {
        return prestamoDao.save(prestamo).getId();

    }


}
