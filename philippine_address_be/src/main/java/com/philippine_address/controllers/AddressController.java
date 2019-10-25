package com.philippine_address.controllers;


import com.philippine_address.models.*;
import com.philippine_address.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    RefBrgyRepository refbrgyRepository;
    @Autowired
    RefCityMunRepository refCityMunRepository;
    @Autowired
    RefProvinceRepository refProvinceRepository;
    @Autowired
    RefRegionRepository refRegionRepository;

    @GetMapping("/")
    public Iterable<Address> getAddress(){
        return addressRepository.findAll();
    }
    @GetMapping("/{id}")
    public void getAddressByID(@PathVariable Integer id){
        addressRepository.findById(id);
    }

    @PostMapping("/{refregion_id}/{refprovince_id}/{refcitymun_id}/{refbrgy_id}")
    public Address addAddress(
            @RequestBody Address address,
            @PathVariable Integer refregion_id,
            @PathVariable Integer refprovince_id,
            @PathVariable Integer refcitymun_id,
            @PathVariable Integer refbrgy_id
            ){
        RefBrgy refbrgy = refbrgyRepository.findById(refbrgy_id).get();
        RefCityMun refCityMun = refCityMunRepository.findById(refcitymun_id).get();
        RefProvince refProvince = refProvinceRepository.findById(refprovince_id).get();
        RefRegion refRegion = refRegionRepository.findById(refregion_id).get();
        address.setRefbrgy(refbrgy);
        address.setRefcitymun(refCityMun);
        address.setRefprovince(refProvince);
        address.setRefregion(refRegion);
        return addressRepository.save(address);

    }


    @DeleteMapping("address/{id}")
    public void deleteAddress(@PathVariable Integer id){

        addressRepository.deleteById(id);
    }
}


