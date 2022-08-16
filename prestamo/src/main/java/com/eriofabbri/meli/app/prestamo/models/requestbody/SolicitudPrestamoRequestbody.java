package com.eriofabbri.meli.app.prestamo.models.requestbody;

public class SolicitudPrestamoRequestbody {
    private Long amount;
    private Integer term;
    private Long user_id;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
