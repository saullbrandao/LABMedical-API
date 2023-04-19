package com.labmedicine.labmedicalapi.repositories;

import com.labmedicine.labmedicalapi.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
