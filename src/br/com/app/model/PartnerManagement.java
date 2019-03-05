package br.com.app.model;

import java.sql.Timestamp;

/**
 *
 * @author carlos
 */
public class PartnerManagement {
  
    public String e_partner_id;
    public Timestamp created;
    public String name;
    public String address;
    public String phone1;
    public String phone2;
    public String email;
    public String cnpj;
    public String description;
    public String socialNetwork;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }
}
