package com.labmedicine.labmedicalapi.loaders;

import com.labmedicine.labmedicalapi.models.Patient;
import com.labmedicine.labmedicalapi.repositories.AddressRepository;
import com.labmedicine.labmedicalapi.repositories.PatientRepository;
import com.labmedicine.labmedicalapi.utils.MaritalStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class PatientDataLoader {
    private final PatientRepository patientRepository;
    private final AddressRepository addressRepository;

    public PatientDataLoader(PatientRepository patientRepository, AddressRepository addressRepository) {
        this.patientRepository = patientRepository;
        this.addressRepository = addressRepository;
    }

    public void load() {
//      Only runs if the table is empty
        if (patientRepository.count() == 0) {
            Patient patient1 = Patient.builder()
                    .name("Francisco Giovanni Rodrigues")
                    .cpf("91590680944")
                    .rg("415570451")
                    .gender("male")
                    .phone("47984507736")
                    .email("francisco_rodrigues@lavabit.com")
                    .nationality("Brazil")
                    .maritalStatus(MaritalStatus.SINGLE)
                    .birthDate(LocalDate.of(1991, 3, 8))
                    .address(addressRepository.findById(3L).get())
                    .emergencyContact("68999234589")
                    .build();

            Patient patient2 = Patient.builder()
                    .name("Pietra Sônia Laís Ribeiro")
                    .cpf("34131566915")
                    .rg("344736349")
                    .gender("male")
                    .phone("48981828908")
                    .email("pietra_sonia_ribeiro@sheilabenavente.com.br")
                    .nationality("Brazil")
                    .maritalStatus(MaritalStatus.WIDOWED)
                    .birthDate(LocalDate.of(1953, 2, 1))
                    .address(addressRepository.findById(2L).get())
                    .emergencyContact("4836368824")
                    .build();

            patientRepository.saveAll(List.of(patient1, patient2));
        }
    }
}
