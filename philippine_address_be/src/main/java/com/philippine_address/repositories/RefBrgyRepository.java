package com.philippine_address.repositories;

import com.philippine_address.models.RefBrgy;
import com.philippine_address.models.RefCityMun;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RefBrgyRepository extends CrudRepository<RefBrgy, Integer> {
    List <RefBrgy>  findByRefCityMun(RefCityMun refCityMun);
}
