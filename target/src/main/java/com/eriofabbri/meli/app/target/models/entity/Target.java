package com.eriofabbri.meli.app.target.models.entity;

import javax.persistence.*;
import java.io.Serializable;

/*En este archivo declaramos la entidad que se va a inizializar y crear la tabla donde se identfica nuestro target */
@Entity
@Table(name = "Targets")
public class Target implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "target_name")
    private String target;
    private int cant;
    private Long amount_total;
    private Float rate;
    @Column(name = "maax")
    private Long max;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public Long getAmount_total() {
        return amount_total;
    }

    public void setAmount_total(Long amount_total) {
        this.amount_total = amount_total;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    private static final long serialVersionUID = 1285454306356845809L;
}
