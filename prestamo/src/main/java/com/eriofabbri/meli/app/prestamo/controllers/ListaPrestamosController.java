package com.eriofabbri.meli.app.prestamo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eriofabbri.meli.app.prestamo.models.entity.Prestamo;
import com.eriofabbri.meli.app.prestamo.models.service.interfaces.PrestamoService;

@RestController
public class ListaPrestamosController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping("/lista-prestamos/from/{from}/to/{to}")
    public List<Prestamo> listar(@PathVariable String from, @PathVariable String to) throws ParseException {
        List<Prestamo> todosPrestamos = prestamoService.findAll();

        Date dateFrom = new SimpleDateFormat("dd-MM-yyyy").parse(from);
        Date dateTo = new SimpleDateFormat("dd-MM-yyyy").parse(to);
        Date datePrestamo;
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");


        List<Prestamo> registroPrestamo = new ArrayList<>();
        for(int i = 0; i < todosPrestamos.size(); i++){
            Prestamo prestamo = todosPrestamos.get(i);
            datePrestamo = formatter.parse(prestamo.getDate());

            if (dateFrom.getTime() < datePrestamo.getTime() && datePrestamo.getTime() < dateTo.getTime()) {
                registroPrestamo.add(prestamo);

            }
        }
        return registroPrestamo;

    }
}
