package com.eriofabbri.meli.app.prestamo.controllers;

import com.eriofabbri.meli.app.prestamo.models.Target;
import com.eriofabbri.meli.app.prestamo.models.User;
import com.eriofabbri.meli.app.prestamo.models.entity.Prestamo;
import com.eriofabbri.meli.app.prestamo.models.requestbody.SolicitudPrestamoRequestbody;
import com.eriofabbri.meli.app.prestamo.models.response.SolicitudPrestamoResponse;
import com.eriofabbri.meli.app.prestamo.models.service.interfaces.PrestamoService;
import com.eriofabbri.meli.app.prestamo.models.service.interfaces.getTargetService;
import com.eriofabbri.meli.app.prestamo.models.service.interfaces.getUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// Este archivo se declaral el restController para el manejo de Solicitud de Prestamo
@RestController
public class SolicitudPrestamoController {

    //getTargetService nos sirve para menjar la informacion desde el database a la aplicacion y viceversa para
    // recaudar la informacion ene el servicio User.
    //Utilizamos el qualificador para indicar que el cliente que tiene que utilizar el servicio de Feing
    @Autowired
    @Qualifier("UserFeingService")
    private getUserService userService;

    //getTargetService nos sirve para menjar la informacion desde el database a la aplicacion y viceversa para
    // recaudar la informacion ene el servicio Target.
    //Utilizamos el qualificador para indicar que el cliente que tiene que utilizar el servicio de Feing

    @Autowired
    @Qualifier("TargetFeingService")
    private getTargetService targetService;

    //PrestamoService nos sirve para manejar la informacion desde el database a la aplicacion y vice versa
    @Autowired
    private PrestamoService prestamoService;



    //Endpoint para solicitar un prestamo mediate responsebody
    @PostMapping("/solicitud-prestamo")
    public ResponseEntity postController(@RequestBody SolicitudPrestamoRequestbody solicitudPrestamoRequestbody) {
        if(solicitudPrestamoRequestbody.equals("")){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

        User user = userService.findById(solicitudPrestamoRequestbody.getUser_id());
        Target data = targetService.findById(user.getTarget_id());
        SolicitudPrestamoResponse prestamoResponse = new SolicitudPrestamoResponse();

        Target target;

        switch (data.getTarget()){
            case "NEW":
                if (data.getCant() < 0 && data.getCant() < 2 )
                {
                    return ResponseEntity.ok("Numero de prestamos superadas");
                }
                if (solicitudPrestamoRequestbody.getAmount()> data.getAmount_total()){
                    return ResponseEntity.ok("Cantidad de prestamo superado");
                }
                target = targetService.findById(user.getTarget_id());
                int cant = target.getCant() + 1;
                target.setCant(cant);
                targetService.saveTarget(target);

                break;
            case "FREQUENT":
                if (data.getCant() < 2 || data.getCant() > 5 )
                {
                    return ResponseEntity.ok("Numero de prestamos superadas");
                }
                if (solicitudPrestamoRequestbody.getAmount()> data.getAmount_total()){
                    return ResponseEntity.ok("Cantidad de prestamo superado");
                }
                target = targetService.findById(user.getTarget_id());
                target.setCant(target.getCant() + 1);
                targetService.saveTarget(target);
                break;
            case "PREMIUM":
                if (data.getCant() < 5 )
                {
                    return ResponseEntity.ok("Numero de prestamos minor que la requerida");
                }
                if (solicitudPrestamoRequestbody.getAmount()> data.getAmount_total()){
                    return ResponseEntity.ok("Cantidad de prestamo superado");
                }
                target = targetService.findById(user.getTarget_id());
                target.setCant(target.getCant() + 1);
                targetService.saveTarget(target);
        }
        //se crea algoritmo para calcular la cuota mensual

       Double r = data.getRate().doubleValue() / 12;
       Double square = 1.0;
       for(int i = 0; i < solicitudPrestamoRequestbody.getTerm(); i++ ){
           square *=  r+1;
       }
       square = square-1 ;

       Double cuota_mensual = r + r/square;
       cuota_mensual = cuota_mensual * solicitudPrestamoRequestbody.getAmount();

       //creamos el date formato iso
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        df.setTimeZone(tz);
        String date = df.format(new Date());

        //creamos la solicitud de prestamo
        Prestamo prestamo = new Prestamo();
        prestamo.setAmount(solicitudPrestamoRequestbody.getAmount());
        prestamo.setRate(data.getRate().doubleValue());
        prestamo.setTerm(solicitudPrestamoRequestbody.getTerm());
        prestamo.setUser_id(user.getId());
        prestamo.setTarget(data.getTarget());
        prestamo.setDate(date);

        prestamoResponse.setLoan_id(prestamoService.savePrestamo(prestamo));
        prestamoResponse.setInstallment(cuota_mensual);

        return ResponseEntity.ok(prestamoResponse);

    }
}
