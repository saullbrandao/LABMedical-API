package com.labmedicine.labmedicalapi.services;

import com.labmedicine.labmedicalapi.dtos.AddressDto;
import com.labmedicine.labmedicalapi.mappers.AddressMapper;
import com.labmedicine.labmedicalapi.models.Address;
import com.labmedicine.labmedicalapi.repositories.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public Address create(AddressDto addressDto) {
        Address address = addressMapper.map(addressDto);

        return addressRepository.save(address);
    }

    public List<Address> listAll() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Address not found"));
    }
}
