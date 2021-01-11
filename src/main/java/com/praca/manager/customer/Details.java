package com.praca.manager.customer;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "delivered")
    private boolean delivered;

    @Column(name = "received")
    private String received;

    @Column(name = "returned")
    private String returned;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name="manufacturer_pattern")
    private String manufacturerPattern;

    @Column(name = "pattern_number")
    private String patternNumber;

    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "repair")
    private String repair;

    @Column(name = "power_supply")
    private String powerSupply;

    @Column(name = "battery")
    private boolean battery;

    @Column(name = "comments")
    private String comments;

    @Column(name = "document_internal")
    private String documentInternal;

    @Column(name = "document_external")
    private String documentExternal;

    @Column(name = "document_warranty")
    private String documentWarranty;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    //private Customer customer;
    private Customer customer;

    public Details(){}

    public Details(Integer id, boolean delivered, String received, String returned,
                   String manufacturer, String manufacturerPattern, String patternNumber,
                   String symptoms, String repair, String powerSupply, boolean battery,
                   String comments, String documentInternal, String documentExternal,
                   String documentWarranty, Customer customer) {
        this.id = id;
        this.delivered = delivered;
        this.received = received;
        this.returned = returned;
        this.manufacturer = manufacturer;
        this.manufacturerPattern = manufacturerPattern;
        this.patternNumber = patternNumber;
        this.symptoms = symptoms;
        this.repair = repair;
        this.powerSupply = powerSupply;
        this.battery = battery;
        this.comments = comments;
        this.documentInternal = documentInternal;
        this.documentExternal = documentExternal;
        this.documentWarranty = documentWarranty;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String in) {
        this.received = in;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String out) {
        this.returned = out;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String name) {
        this.manufacturer = name;
    }

    public String getManufacturerPattern() {
        return manufacturerPattern;
    }

    public void setManufacturerPattern(String model) {
        this.manufacturerPattern = model;
    }

    public String getPatternNumber() {
        return patternNumber;
    }

    public void setPatternNumber(String serialNumber) {
        this.patternNumber = serialNumber;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getRepair() {
        return repair;
    }

    public void setRepair(String repair) {
        this.repair = repair;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public boolean isBattery() {
        return battery;
    }

    public void setBattery(boolean battery) {
        this.battery = battery;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDocumentInternal() {
        return documentInternal;
    }

    public void setDocumentInternal(String inner) {
        this.documentInternal = inner;
    }

    public String getDocumentExternal() {
        return documentExternal;
    }

    public void setDocumentExternal(String outer) {
        this.documentExternal = outer;
    }

    public String getDocumentWarranty() {
        return documentWarranty;
    }

    public void setDocumentWarranty(String warranty) {
        this.documentWarranty = warranty;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }
}