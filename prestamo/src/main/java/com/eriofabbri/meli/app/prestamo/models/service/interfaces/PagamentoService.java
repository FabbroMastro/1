package com.eriofabbri.meli.app.prestamo.models.service.interfaces;

import com.eriofabbri.meli.app.prestamo.models.entity.Pagamento;

import java.util.List;

public interface PagamentoService {

    public List<Pagamento> findAll();
    public Pagamento findById(Long id);
    public Long savePagamento(Pagamento pagamento);
}
