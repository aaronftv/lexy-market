package com.aaron.merch_aaron.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="clientes")
public class CostumerEnt {
    @Id
    @Column(name="id")
    private String clientId;

    @Column(name="nombre")
    private String firstName;

    @Column(name="apellidos")
    private String lastName;

    @Column(name="celular")
    private Integer phoneNumber;

    @Column(name="direccion")
    private String address;

    @Column(name="correo_electronico")
    private String email;

    @OneToMany(mappedBy = "costumer")
    private List<PurchaseEnt> purchases;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

