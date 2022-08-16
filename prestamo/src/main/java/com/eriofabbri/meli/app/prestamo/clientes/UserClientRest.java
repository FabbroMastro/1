package com.eriofabbri.meli.app.prestamo.clientes;

import com.eriofabbri.meli.app.prestamo.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user")
public interface UserClientRest {

    @GetMapping("/listar")
    public List<User> listar();

    @GetMapping("/ver/{id}")
    public User detalle(@PathVariable Long id);
}
