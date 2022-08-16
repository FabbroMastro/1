package com.eriofabbri.meli.app.prestamo.controllers;

import com.eriofabbri.meli.app.prestamo.models.entity.Pagamento;
import com.eriofabbri.meli.app.prestamo.models.entity.Prestamo;
import com.eriofabbri.meli.app.prestamo.models.requestbody.RegistroPagosRequestBody;

import com.eriofabbri.meli.app.prestamo.models.service.interfaces.PagamentoService;
import com.eriofabbri.meli.app.prestamo.models.service.interfaces.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistroPagosController {
    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping("/pago-debito")
    public ResponseEntity postController(@RequestBody RegistroPagosRequestBody registroPagosRequestBody) {

        Prestamo prestamo = prestamoService.findById(registroPagosRequestBody.getLoan_id());
        Pagamento pagamento = new Pagamento();
        pagamento.setLoan_id(registroPagosRequestBody.getLoan_id());

        Float debit = prestamo.getAmount() - registroPagosRequestBody.getAmount();

        prestamo.setAmount(debit.longValue());
        prestamoService.savePrestamo(prestamo);

        pagamento.setDebit(debit.longValue());
        pagamentoService.savePagamento(pagamento);
        prestamo.setAmount(debit.longValue());
        return ResponseEntity.ok(pagamento);
    }

    }
