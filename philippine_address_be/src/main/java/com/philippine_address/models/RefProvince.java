package com.philippine_address.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reference_province")
public class RefProvince {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String psgcCode;
    private String provDesc;



    @OneToMany(mappedBy = "refprovince", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "region_code")
    private RefRegion refRegion;

    @OneToMany(mappedBy = "refProvince", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RefCityMun> refCityMuns;

    public RefProvince(){}

    public RefProvince(String psgcCode, String provDesc, String provCode) {
        this.psgcCode = psgcCode;
        this.provDesc = provDesc;


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

    public String getProvDesc() {
        return provDesc;
    }

    public void setProvDesc(String provDesc) {
        this.provDesc = provDesc;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public RefRegion getRefregion() {
        return refRegion;
    }

    public void setRefregion(RefRegion refRegion) {
        this.refRegion = refRegion;
    }

    public List<RefCityMun> getRefCityMuns() {
        return refCityMuns;
    }

    public void setRefCityMuns(List<RefCityMun> refCityMuns) {
        this.refCityMuns = refCityMuns;
    }
}
