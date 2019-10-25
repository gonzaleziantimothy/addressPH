package com.philippine_address.controllers;


import com.philippine_address.models.RefBrgy;
import com.philippine_address.models.RefCityMun;
import com.philippine_address.repositories.RefBrgyRepository;
import com.philippine_address.repositories.RefCityMunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@CrossOrigin(origins = "http://localhost:3000")
public class RefBrgyController {
    @Autowired
    RefBrgyRepository refbrgyRepository;

    @Autowired
    RefCityMunRepository refCityMunRepository;

    @GetMapping("/barangays")
    public Iterable<RefBrgy> getRefbrgy(){
        return refbrgyRepository.findAll();
    }

    @GetMapping("/barangays/city/{city_id}")
    public Iterable<RefBrgy> getRefbrgyList(@PathVariable Integer city_id){
        RefCityMun city = refCityMunRepository.findById(city_id).get();
        return refbrgyRepository.findByRefCityMun(city);
    }

    @DeleteMapping("barangays/{id}")
    public void deleteRefbrgy(@PathVariable Integer id){
        refbrgyRepository.deleteById(id);
    }
}

