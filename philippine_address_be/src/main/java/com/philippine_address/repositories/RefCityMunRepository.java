package com.philippine_address.repositories;

import com.philippine_address.models.RefCityMun;
import com.philippine_address.models.RefProvince;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RefCityMunRepository extends CrudRepository<RefCityMun, Integer> {
    List<RefCityMun> findByRefProvince(RefProvince refProvince);
}
