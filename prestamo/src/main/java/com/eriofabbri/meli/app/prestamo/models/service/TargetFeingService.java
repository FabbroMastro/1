package com.eriofabbri.meli.app.prestamo.models.service;

import com.eriofabbri.meli.app.prestamo.clientes.TargetClientRest;
import com.eriofabbri.meli.app.prestamo.models.Target;
import com.eriofabbri.meli.app.prestamo.models.service.interfaces.getTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service("TargetFeingService")
public class TargetFeingService implements getTargetService {

    @Autowired
    TargetClientRest targetClientRest;

    @Override
    public List<Target> findAll() {
        return targetClientRest.listar().stream().collect(Collectors.toList());
    }

    @Override
    public Target findById(Long id) {
        return targetClientRest.detalle(id);
    }

    @Override
    public Long saveTarget(Target target) {
        return targetClientRest.saveTarget(target);
    }
}
