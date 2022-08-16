package com.eriofabbri.meli.app.prestamo.models.dao;

import com.eriofabbri.meli.app.prestamo.models.entity.Prestamo;
import org.springframework.data.repository.CrudRepository;

public interface PrestamoDao extends CrudRepository<Prestamo, Long> {

}
