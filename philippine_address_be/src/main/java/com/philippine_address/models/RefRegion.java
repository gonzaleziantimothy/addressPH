package com.philippine_address.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reference_region")
public class RefRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String psgcCode;
    private String regDesc;

    @OneToMany(mappedBy = "refregion", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Address> address;

    @OneToMany(mappedBy = "refRegion", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RefProvince> refProvinces;


    public RefRegion() {
    }

    public RefRegion(String psgcCode, String regDesc) {
        this.psgcCode = psgcCode;
        this.regDesc = regDesc;
    }

    public String getPsgcCode() {
        return psgcCode;
    }

    public void setPsgcCode(String psgcCode) {
        this.psgcCode = psgcCode;
    }
    public int getId() {
        return id;
    }


    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<RefProvince> getRefProvinces() {
        return refProvinces;
    }

    public void setRefProvinces(List<RefProvince> refProvinces) {
        this.refProvinces = refProvinces;
    }

    public String getRegDesc() {
        return regDesc;
    }

    public void setRegDesc(String regDesc) {
        this.regDesc = regDesc;
    }
}

