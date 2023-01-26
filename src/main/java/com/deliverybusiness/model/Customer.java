package com.deliverybusiness.model;

import com.deliverybusiness.model.view.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name="Customer")
public class Customer {
    @Id //prestavlja primary key
    @Column(name = "ID")
    private int id;
    @JsonView(View.Public.class)
    @Column(name = "FullName")
    private String fullName;
    @JsonView(View.Internal.class)
    @Column(name = "Address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "City", referencedColumnName = "ID")
    private City city;



    public Customer() {
    }

    public Customer(int id, String fullName, String address, City city) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}


