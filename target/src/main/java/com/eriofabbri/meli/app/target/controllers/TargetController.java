package com.eriofabbri.meli.app.target.controllers;


import com.eriofabbri.meli.app.target.TargetApplication;
import com.eriofabbri.meli.app.target.models.entity.Target;
import com.eriofabbri.meli.app.target.models.service.ITargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*Rest Controller de Target para el retrive y actualizar de la informacion de Target */
@RestController
public class TargetController {

    @Autowired
    private ITargetService iTargetService;

    @GetMapping("/listar")
    public List<Target> listar(){
        return new ArrayList<>(iTargetService.findAll());
    }

    @GetMapping("/ver/{id}")
    public Target detalle(@PathVariable Long id) throws InterruptedException {
        Target target = iTargetService.findById(id);
        return target;
    }
    @PostMapping("/actualizar_target")
    public Long ActualizarTarget(Target target){
        return iTargetService.ActualizarTarget(target);
    }

}
