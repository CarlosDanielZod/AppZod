package br.com.app.model;

import java.sql.Timestamp;

/**
 *
 * @author carlos
 */
public class TicketsManagement {
    
    public String e_ticket_id;
    public String e_client_id;
    public Timestamp created;
    public Timestamp updated;
    public int ticket;
    public int code_client;
    public String name_client;
    public String address;
    public String rg;
    public String cpf;
    public String phone1;
    public String phone2;
    public String email;
    public String description_client;
    public Boolean isActive;

    public String getE_ticket_id() {
        return e_ticket_id;
    }

    public void setE_ticket_id(String e_ticket_id) {
        this.e_ticket_id = e_ticket_id;
    }

    public String getE_client_id() {
        return e_client_id;
    }

    public void setE_client_id(String e_client_id) {
        this.e_client_id = e_client_id;
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

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public int getCode_client() {
        return code_client;
    }

    public void setCode_client(int code_client) {
        this.code_client = code_client;
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) {
        this.name_client = name_client;
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

    public String getDescription_client() {
        return description_client;
    }

    public void setDescription_client(String description_client) {
        this.description_client = description_client;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}