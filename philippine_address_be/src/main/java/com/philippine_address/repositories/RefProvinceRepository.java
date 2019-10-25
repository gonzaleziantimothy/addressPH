package com.philippine_address.repositories;

import com.philippine_address.models.RefProvince;
import com.philippine_address.models.RefRegion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RefProvinceRepository extends CrudRepository<RefProvince, Integer> {
    List<RefProvince> findByRefRegion(RefRegion refRegion);
}
