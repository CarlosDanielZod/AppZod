package br.com.app.model;

/**
 *
 * @author carlos
 */
public class PaymentsManagement {
    
    public String e_payments_id;
    public String e_product_close_id;
    public String form_payment;
    public String sinal;
    public String total_payable;
    public String total_reimaning;
    public String date_delivery;
    public Boolean isPaid;

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getE_payments_id() {
        return e_payments_id;
    }

    public void setE_payments_id(String e_payments_id) {
        this.e_payments_id = e_payments_id;
    }

    public String getE_product_close_id() {
        return e_product_close_id;
    }

    public void setE_product_close_id(String e_product_close_id) {
        this.e_product_close_id = e_product_close_id;
    }

    public String getForm_payment() {
        return form_payment;
    }

    public void setForm_payment(String form_payment) {
        this.form_payment = form_payment;
    }

    public String getSinal() {
        return sinal;
    }

    public void setSinal(String sinal) {
        this.sinal = sinal;
    }

    public String getTotal_payable() {
        return total_payable;
    }

    public void setTotal_payable(String total_payable) {
        this.total_payable = total_payable;
    }

    public String getTotal_reimaning() {
        return total_reimaning;
    }

    public void setTotal_reimaning(String total_reimaning) {
        this.total_reimaning = total_reimaning;
    }

    public String getDate_delivery() {
        return date_delivery;
    }

    public void setDate_delivery(String date_delivery) {
        this.date_delivery = date_delivery;
    }
}
