package br.com.app.model;

import java.sql.Timestamp;

/**
 *
 * @author carlos
 */
public class ProductSessionManagement {
    
    public String product_session_id;
    public String e_product_id;
    public Timestamp created;
    public String name;
    public int code;
    public int code_additional;
    public String discount;
    public String type;
    public int qty;
    public String labor;
    public String cost_additional;
    public String price_sales;
    public String totalprice_sales;

    public String getProduct_session_id() {
        return product_session_id;
    }

    public void setProduct_session_id(String product_session_id) {
        this.product_session_id = product_session_id;
    }

    public String getE_product_id() {
        return e_product_id;
    }

    public void setE_product_id(String e_product_id) {
        this.e_product_id = e_product_id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode_additional() {
        return code_additional;
    }

    public void setCode_additional(int code_additional) {
        this.code_additional = code_additional;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getLabor() {
        return labor;
    }

    public void setLabor(String labor) {
        this.labor = labor;
    }

    public String getCost_additional() {
        return cost_additional;
    }

    public void setCost_additional(String cost_additional) {
        this.cost_additional = cost_additional;
    }

    public String getPrice_sales() {
        return price_sales;
    }

    public void setPrice_sales(String price_sales) {
        this.price_sales = price_sales;
    }

    public String getTotalprice_sales() {
        return totalprice_sales;
    }

    public void setTotalprice_sales(String totalprice_sales) {
        this.totalprice_sales = totalprice_sales;
    }    
}
