package com.eriofabbri.meli.app.target.models.dao;

import com.eriofabbri.meli.app.target.models.entity.Target;
import org.springframework.data.repository.CrudRepository;

//Interface para el manejo de las funciones JPA
public interface TargetDao extends CrudRepository<Target, Long> {
}
