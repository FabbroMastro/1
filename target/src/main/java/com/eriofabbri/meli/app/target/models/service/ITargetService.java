package com.eriofabbri.meli.app.target.models.service;

import com.eriofabbri.meli.app.target.models.entity.Target;

import java.util.List;

/*Esta es el servicio donde declaramos nuestros metodos para emplementar las actiones de JPA para el manejo de la informacion de H2*/
public interface ITargetService {

    public List<Target> findAll();
    public Target findById(Long id);
    public  Long ActualizarTarget(Target target);
}
