package com.labmedicine.labmedicalapi.loaders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final AddressDataLoader addressDataLoader;
    private final DoctorDataLoader doctorDataLoader;
    private final PatientDataLoader patientDataLoader;
    private final AppointmentDataLoader appointmentDataLoader;
    private final ExamDataLoader examDataLoader;

    public DataLoader(AddressDataLoader addressDataLoader, DoctorDataLoader doctorDataLoader, PatientDataLoader patientDataLoader, AppointmentDataLoader appointmentDataLoader, ExamDataLoader examDataLoader) {
        this.addressDataLoader = addressDataLoader;
        this.doctorDataLoader = doctorDataLoader;
        this.patientDataLoader = patientDataLoader;
        this.appointmentDataLoader = appointmentDataLoader;
        this.examDataLoader = examDataLoader;
    }

    @Override
    public void run(String... args) throws Exception {
        addressDataLoader.load();
        doctorDataLoader.load();
        patientDataLoader.load();
        appointmentDataLoader.load();
        examDataLoader.load();
    }
}
