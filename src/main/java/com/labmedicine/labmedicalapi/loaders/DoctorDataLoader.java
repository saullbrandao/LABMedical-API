package com.labmedicine.labmedicalapi.loaders;

import com.labmedicine.labmedicalapi.models.Doctor;
import com.labmedicine.labmedicalapi.repositories.DoctorRepository;
import com.labmedicine.labmedicalapi.utils.MaritalStatus;
import com.labmedicine.labmedicalapi.utils.MedicalSpecialization;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DoctorDataLoader {
    private final DoctorRepository doctorRepository;

    public DoctorDataLoader(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public void load() {
//      Only runs if the table is empty
        if (doctorRepository.count() == 0) {
            Doctor doctor1 = Doctor.builder()
                    .name("Edson Kevin Joaquim Moura")
                    .cpf("60265245257")
                    .rg("424924948")
                    .gender("male")
                    .phone("68999250664")
                    .email("edsonkevinmoura@plani.com.br")
                    .nationality("Brazil")
                    .maritalStatus(MaritalStatus.MARRIED)
                    .crm("132211234")
                    .specialization(MedicalSpecialization.GENERAL_PRACTITIONER)
                    .birthDate(LocalDate.of(1968, 1, 12))
                    .password("wtraHr0usS")
                    .build();

            Doctor doctor2 = Doctor.builder()
                    .name("Pedro Renato Assis")
                    .cpf("15922717154")
                    .rg("419408071")
                    .gender("male")
                    .phone("68999250664")
                    .email("pedro-assis83@antunez.com.br")
                    .nationality("Brazil")
                    .maritalStatus(MaritalStatus.DIVORCED)
                    .crm("342343425")
                    .specialization(MedicalSpecialization.PEDIATRICS)
                    .birthDate(LocalDate.of(1969, 4, 14))
                    .password("0UnCuiceaX")
                    .build();

            doctorRepository.saveAll(List.of(doctor1, doctor2));
        }
    }
}
