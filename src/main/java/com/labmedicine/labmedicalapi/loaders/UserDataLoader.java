package com.labmedicine.labmedicalapi.loaders;

import com.labmedicine.labmedicalapi.models.User;
import com.labmedicine.labmedicalapi.repositories.UserRepository;
import com.labmedicine.labmedicalapi.utils.MaritalStatus;
import com.labmedicine.labmedicalapi.utils.MedicalSpecialization;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class UserDataLoader  {
    private final UserRepository userRepository;

    public UserDataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void loadUserData() {
//      Only runs if the table is empty
        if (userRepository.count() == 0) {
            User user1 = User.builder()
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

            User user2 = User.builder()
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

            userRepository.saveAll(List.of(user1, user2));
        }
    }
}
