package com.philippine_address.controllers;

import com.philippine_address.models.RefProvince;
import com.philippine_address.models.RefRegion;
import com.philippine_address.repositories.RefProvinceRepository;
import com.philippine_address.repositories.RefRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@CrossOrigin(origins = "http://localhost:3000")
public class RefProvinceController {
    @Autowired
    RefProvinceRepository refProvinceRepository;
    @Autowired
    RefRegionRepository refRegionRepository;

    @GetMapping("/provinces")
    public Iterable<RefProvince> getRefProvince(){
        return refProvinceRepository.findAll();
    }

    @GetMapping("/provinces/{id}")
    public RefProvince getRefProvinceByID(@PathVariable Integer id){
        return refProvinceRepository.findById(id).get();
    }

    @GetMapping("provinces/region/{region_id}")
    public Iterable<RefProvince> getRefProvinceByRefRegion(@PathVariable Integer region_id){
        RefRegion region = refRegionRepository.findById(region_id).get();
        return refProvinceRepository.findByRefRegion(region);
    }

    @DeleteMapping("provinces/{id}")
    public void deleteRefProvince(@PathVariable Integer id){

        refProvinceRepository.deleteById(id);
    }

}