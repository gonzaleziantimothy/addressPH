package com.philippine_address.controllers;

import com.philippine_address.models.RefCityMun;
import com.philippine_address.models.RefProvince;
import com.philippine_address.repositories.RefCityMunRepository;
import com.philippine_address.repositories.RefProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@CrossOrigin(origins = "http://localhost:3000")
public class RefCityMunController {
    @Autowired
    RefCityMunRepository refCityMunRepository;

    @Autowired
    RefProvinceRepository refProvinceRepository;

    @GetMapping("/cities")
    public Iterable<RefCityMun> getRefCityMun(){
        return refCityMunRepository.findAll();
    }
    @GetMapping("/cities/{id}")
    public RefCityMun getRefCityMunByID(@PathVariable Integer id){
        return refCityMunRepository.findById(id).get();
    }

    @GetMapping("cities/province/{province_id}")
    public Iterable<RefCityMun> getRefCityByRefProvince(@PathVariable Integer province_id){
        RefProvince province = refProvinceRepository.findById(province_id).get();
        return refCityMunRepository.findByRefProvince(province);
    }
    @DeleteMapping("cities/{id}")
    public void deleteRefCityMun(@PathVariable Integer id){

        refCityMunRepository.deleteById(id);
    }
}
