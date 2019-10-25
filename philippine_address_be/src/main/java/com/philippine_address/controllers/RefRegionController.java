package com.philippine_address.controllers;


import com.philippine_address.models.RefRegion;
import com.philippine_address.repositories.RefRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@CrossOrigin(origins = "http://localhost:3000")
public class RefRegionController {
    @Autowired
    RefRegionRepository refRegionRepository;
    @GetMapping("/regions")
    public Iterable<RefRegion> getRefRegion(){
        return refRegionRepository.findAll();
    }
    @GetMapping("/regions/{id}")
    public void getRefRegionByID(@PathVariable Integer id){
        refRegionRepository.findById(id);
    }

    @DeleteMapping("regions/{id}")
    public void deleteRefRegion(@PathVariable Integer id){

        refRegionRepository.deleteById(id);
    }
}