package com.philippine_address.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reference_city")
public class RefCityMun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String psgcCode;
    private String citymunDesc;
    private String regDesc;

    @OneToMany(mappedBy = "refcitymun", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "province_code")
    private RefProvince refProvince;

    @OneToMany(mappedBy = "refCityMun", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RefBrgy> refbrgies;


    public RefCityMun() {
    }

    public RefCityMun(String psgcCode, String citymunDesc, String regDesc) {
        this.psgcCode = psgcCode;
        this.citymunDesc = citymunDesc;
        this.regDesc = regDesc;
    }
    public int getId() {
        return id;
    }

    public String getPsgcCode() {
        return psgcCode;
    }

    public void setPsgcCode(String psgcCode) {
        this.psgcCode = psgcCode;
    }


    public String getCitymunDesc() {
        return citymunDesc;
    }

    public void setCitymunDesc(String citymunDesc) {
        this.citymunDesc = citymunDesc;
    }

    public String getRegDesc() {
        return regDesc;
    }

    public void setRegDesc(String regDesc) {
        this.regDesc = regDesc;
    }

    public void setRefProvince(RefProvince refProvince) {
        this.refProvince = refProvince;
    }

    public void setRefbrgies(List<RefBrgy> refbrgies) {
        this.refbrgies = refbrgies;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public RefProvince getRefProvince() {
        return refProvince;
    }

    public List<RefBrgy> getRefbrgies() {
        return refbrgies;
    }
}

