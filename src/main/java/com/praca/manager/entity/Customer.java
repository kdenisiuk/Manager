package com.praca.manager.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customer_id;

    @Column(name = "owner")
    private String owner;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    List<Details> details;

    public Customer(){
    }

    public Customer(String owner,
                    String address,
                    String phoneNumber){
                        this.owner = owner;
                        this.address = address;
                        this.phoneNumber = phoneNumber;
    }

    public Integer getCustomer_id() {

        return customer_id;
    }

    public String getOwner() {

        return owner;
    }

    public void setOwner(String firstName) {

        this.owner = firstName;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address){

        this.address = address;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customer_id +
                ", firstName='" + owner + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}