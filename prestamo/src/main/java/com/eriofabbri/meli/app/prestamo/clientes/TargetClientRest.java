package com.eriofabbri.meli.app.prestamo.clientes;

import com.eriofabbri.meli.app.prestamo.models.Target;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "target")
public interface TargetClientRest {

    @GetMapping("/listar")
    public List<Target> listar();

    @GetMapping("/ver/{id}")
    public Target detalle(@PathVariable Long id);

    @PostMapping("/actualizar_target")
    public Long saveTarget(Target target);
}
