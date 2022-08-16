package com.eriofabbri.meli.app.prestamo.models.service;

import com.eriofabbri.meli.app.prestamo.models.dao.PagamentoDao;
import com.eriofabbri.meli.app.prestamo.models.entity.Pagamento;
import com.eriofabbri.meli.app.prestamo.models.service.interfaces.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PagamentoServiceimpl implements PagamentoService {

    @Autowired
    private PagamentoDao pagamentoDao;

    @Override
    public List<Pagamento> findAll() {
        return (List<Pagamento>) pagamentoDao.findAll();
    }

    @Override
    public Pagamento findById(Long id) {
        return pagamentoDao.findById(id).orElse(null);
    }

    @Override
    public Long savePagamento(Pagamento pagamento) {
        return pagamentoDao.save(pagamento).getId();
    }
}
