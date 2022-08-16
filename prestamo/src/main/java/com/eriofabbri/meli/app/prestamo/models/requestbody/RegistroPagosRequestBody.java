package com.eriofabbri.meli.app.prestamo.models.requestbody;

public class RegistroPagosRequestBody {
    private float amount;
    private Long loan_id;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Long getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(Long loan_id) {
        this.loan_id = loan_id;
    }
}
