package com.labmedicine.labmedicalapi.loaders;

import com.labmedicine.labmedicalapi.models.Address;
import com.labmedicine.labmedicalapi.repositories.AddressRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressDataLoader {
    private final AddressRepository addressRepository;

    public AddressDataLoader(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void load() {
//      Only runs if the table is empty
        if (addressRepository.count() == 0) {
            Address address1 = Address.builder()
                    .cep("89035-010")
                    .street("Rua Campos Sales")
                    .district("Vila Nova")
                    .city("Blumenau")
                    .state("Santa Catarina")
                    .addressNumber(1000)
                    .build();

            Address address2 = Address.builder()
                    .cep("88706-522")
                    .street("Rua Etelvina da Silva")
                    .district("Rua Etelvina da Silva")
                    .city("Tubarão")
                    .state("Santa Catarina")
                    .addressNumber(451)
                    .build();

            Address address3 = Address.builder()
                    .cep("89026-201")
                    .street("Rua Progresso")
                    .district("Progresso")
                    .city("Blumenau")
                    .state("Santa Catarina")
                    .addressNumber(1000)
                    .build();

            Address address4 = Address.builder()
                    .cep("88805-791")
                    .street("Rua Manoel José da Rosa")
                    .district("Imperatriz")
                    .city("Criciúma")
                    .state("Santa Catarina")
                    .addressNumber(1000)
                    .build();

            addressRepository.saveAll(List.of(address1, address2, address3, address4));
        }
    }
}
