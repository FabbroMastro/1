package com.eriofabbri.meli.app.prestamo.models.service.interfaces;

import com.eriofabbri.meli.app.prestamo.models.Target;

import java.util.List;

public interface getTargetService {
    public List<Target> findAll();
    public Target findById(Long id);

    public Long saveTarget(Target target);
}
