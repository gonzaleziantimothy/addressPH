package com.philippine_address.repositories;


import com.philippine_address.models.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}

