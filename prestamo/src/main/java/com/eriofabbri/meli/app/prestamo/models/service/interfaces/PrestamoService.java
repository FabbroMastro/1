package com.eriofabbri.meli.app.prestamo.models.service.interfaces;

import com.eriofabbri.meli.app.prestamo.models.entity.Prestamo;

import java.util.List;

public interface PrestamoService {

    public List<Prestamo> findAll();
    public Prestamo findById(Long id);
    public Long savePrestamo(Prestamo prestamo);

}
