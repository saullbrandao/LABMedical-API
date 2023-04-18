package com.labmedicine.labmedicalapi.loaders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final AddressDataLoader addressDataLoader;
    private final UserDataLoader userDataLoader;
    private final PatientDataLoader patientDataLoader;

    public DataLoader(AddressDataLoader addressDataLoader, UserDataLoader userDataLoader, PatientDataLoader patientDataLoader) {
        this.addressDataLoader = addressDataLoader;
        this.userDataLoader = userDataLoader;
        this.patientDataLoader = patientDataLoader;
    }

    @Override
    public void run(String... args) throws Exception {
        addressDataLoader.loadAddressData();
        userDataLoader.loadUserData();
        patientDataLoader.loadPatientData();
    }
}
