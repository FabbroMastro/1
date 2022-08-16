package com.eriofabbri.meli.app.prestamo.models.response;

public class SolicitudPrestamoResponse {
    private Long loan_id;
    private Double installment;

    public SolicitudPrestamoResponse() {
    }

    public Long getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(Long loan_id) {
        this.loan_id = loan_id;
    }

    public Double getInstallment() {
        return installment;
    }

    public void setInstallment(Double installment) {
        this.installment = installment;
    }
}
