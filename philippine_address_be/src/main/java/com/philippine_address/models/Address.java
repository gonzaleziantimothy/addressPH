package com.philippine_address.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "refbrgy_id")
    private RefBrgy refbrgy;

    @ManyToOne
    @JoinColumn(name = "refcitymun_id")
    private RefCityMun refcitymun;

    @ManyToOne
    @JoinColumn(name = "refprovince_id")
    private RefProvince refprovince;

    @ManyToOne
    @JoinColumn(name = "refregion_id")
    private RefRegion refregion;



    public Address(){}


    public int getId() {
        return id;
    }


    public RefBrgy getRefbrgy() {
        return refbrgy;
    }

    public void setRefbrgy(RefBrgy refbrgy) {
        this.refbrgy = refbrgy;
    }

    public RefCityMun getRefcitymun() {
        return refcitymun;
    }

    public void setRefcitymun(RefCityMun refcitymun) {
        this.refcitymun = refcitymun;
    }

    public RefProvince getRefprovince() {
        return refprovince;
    }

    public void setRefprovince(RefProvince refprovince) {
        this.refprovince = refprovince;
    }

    public RefRegion getRefregion() {
        return refregion;
    }

    public void setRefregion(RefRegion refregion) {
        this.refregion = refregion;
    }



}
