package br.com.app.model;

import java.sql.Timestamp;

/**
 *
 * @author carlos
 */
public class ClientManagement {
    
   private String e_client_id;
   private String e_product_id;
   private Timestamp created;
   private Timestamp updated;
   private int code;
   private String name;
   private String address;
   private String rg;
   private String cpf;
   private String phone1;
   private String phone2;
   private String email;
   private String description;

    public String getE_client_id() {
        return e_client_id;
    }

    public void setE_client_id(String e_client_id) {
        this.e_client_id = e_client_id;
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

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}