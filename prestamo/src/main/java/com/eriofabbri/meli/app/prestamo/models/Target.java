package com.eriofabbri.meli.app.prestamo.models;

public class Target {
    private Long id;
    private String target;
    private int cant;
    private Long amount_total;
    private Float rate;
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

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
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
}
