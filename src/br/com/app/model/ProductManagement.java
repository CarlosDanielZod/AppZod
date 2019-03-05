package br.com.app.model;

import java.sql.Timestamp;


public class ProductManagement {
    
   public String e_product_id;
   public String e_product_sales_id;
   public String e_partner_id;
   public Timestamp created;
   public Timestamp updated;
   public boolean isActive;
   public String name;
   public int code;
   public int code_additional;
   public String type;
   public int qty;
   public String price;
   public String total;
   public String description;

    public String getE_product_id() {
        return e_product_id;
    }

    public void setE_product_id(String e_product_id) {
        this.e_product_id = e_product_id;
    }

    public String getE_product_sales_id() {
        return e_product_sales_id;
    }

    public void setE_product_sales_id(String e_product_sales_id) {
        this.e_product_sales_id = e_product_sales_id;
    }

    public String getE_partner_id() {
        return e_partner_id;
    }

    public void setE_partner_id(String e_partner_id) {
        this.e_partner_id = e_partner_id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
