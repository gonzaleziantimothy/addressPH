package com.philippine_address.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reference_brgy")
public class RefBrgy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String regCode;
    private String provCode;
    private String brgyDesc;

    @OneToMany(mappedBy = "refbrgy", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Address> address;

    @ManyToOne
    @JoinColumn(name = "citymunicipality_code")
    private RefCityMun refCityMun;



    public RefBrgy(){}

    public RefBrgy(String regCode, String provCode, String brgyDesc) {
        this.regCode = regCode;
        this.provCode = provCode;
        this.brgyDesc = brgyDesc;
    }
    public int getId() {
        return id;
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    public String getProvCode() {
        return provCode;
    }

    public void setProvCode(String provCode) {
        this.provCode = provCode;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public RefCityMun getRefCityMun() {
        return refCityMun;
    }

    public void setRefCityMun(RefCityMun refCityMun) {
        this.refCityMun = refCityMun;
    }

    public String getBrgyDesc() {
        return brgyDesc;
    }

    public void setBrgyDesc(String brgyDesc) {
        this.brgyDesc = brgyDesc;
    }
}

