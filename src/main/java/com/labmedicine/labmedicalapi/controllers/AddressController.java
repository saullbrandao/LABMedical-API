package com.labmedicine.labmedicalapi.controllers;

import com.labmedicine.labmedicalapi.dtos.AddressDto;
import com.labmedicine.labmedicalapi.models.Address;
import com.labmedicine.labmedicalapi.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody @Valid AddressDto addressDto, UriComponentsBuilder uriComponentsBuilder) {
        Address address = addressService.create(addressDto);
        URI uri = uriComponentsBuilder.path("/addresses/{id}").buildAndExpand(address.getId()).toUri();
        return ResponseEntity.created(uri).body(address);
    }
}
