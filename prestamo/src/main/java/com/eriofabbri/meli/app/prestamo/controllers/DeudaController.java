package com.eriofabbri.meli.app.prestamo.controllers;

import com.eriofabbri.meli.app.prestamo.models.entity.Prestamo;
import com.eriofabbri.meli.app.prestamo.models.response.DeudaResponse;
import com.eriofabbri.meli.app.prestamo.models.response.DeudaTotalResponse;
import com.eriofabbri.meli.app.prestamo.models.service.interfaces.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class DeudaController {

    @Autowired
    private PrestamoService prestamoService;

    //endpoint para
    @GetMapping("/deuda/fecha/{fecha}")
    public ResponseEntity getController(@PathVariable String fecha) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date dateTo = format.parse(fecha);


        List<Prestamo> prestamos = prestamoService.findAll();
        List<Prestamo> hastafecha = new ArrayList<>();

        for (int i = 0; i < prestamos.size(); i++){
            Prestamo prestamo = prestamos.get(i);
            Date prestamo_date = format.parse(prestamo.getDate());

            if(prestamo_date.getTime() < dateTo.getTime()){
                hastafecha.add(prestamo);
            }
        }

        Prestamo prestamo = hastafecha.get(0);

        DeudaResponse dudaResponse = new DeudaResponse();
        dudaResponse.setBalance(prestamo.getAmount().floatValue());

        return  ResponseEntity.ok(dudaResponse);

    }

    @GetMapping("/deuda_total/fecha/{fecha}/target/{target}")
    public ResponseEntity getController1(@PathVariable String fecha,@PathVariable String target) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date dateTo = format.parse(fecha);


        List<Prestamo> prestamos = prestamoService.findAll();
        List<Prestamo> hastafecha = new ArrayList<>();
        List<Prestamo> targetlist = new ArrayList<>();

        if(!fecha.equals("") && !target.equals("")) {

            for (int i = 0; i < prestamos.size(); i++) {
                Prestamo prestamo = prestamos.get(i);
                Date prestamo_date = format.parse(prestamo.getDate());

                if (prestamo_date.getTime() < dateTo.getTime()) {
                    hastafecha.add(prestamo);
                }
            }

                for (int i = 0; i < hastafecha.size(); i++) {
                    Prestamo prestamo = hastafecha.get(i);
                    if (prestamo.getTarget().equals(target)) {
                        targetlist.add(prestamo);
                    }
                }
        }


        DeudaTotalResponse deudaTotalResponse = new DeudaTotalResponse();
        Float deuda = 0f;
        for (int i = 0; i < targetlist.size(); i++){
            Prestamo prestamo = targetlist.get(i);
            deuda = deuda + prestamo.getAmount();

        }
        deudaTotalResponse.setBalance(deuda);
        return  ResponseEntity.ok(deudaTotalResponse);

    }
}
