package com.labmedicine.labmedicalapi.loaders;

import com.labmedicine.labmedicalapi.models.Appointment;
import com.labmedicine.labmedicalapi.repositories.AppointmentRepository;
import com.labmedicine.labmedicalapi.repositories.PatientRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppointmentDataLoader {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    public AppointmentDataLoader(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    public void loadAppointmentData() {
        if(appointmentRepository.count() == 0) {
            Appointment appointment1 = Appointment.builder()
                    .description("At vero eos et accusamus et iusto odio dignissimos ducimus")
                    .reason("Et harum quidem")
                    .patient(patientRepository.findById(1L).get())
                    .precautions("Nam libero tempore")
                    .prescription("Itaque earum rerum hic")
                    .build();

            Appointment appointment2 = Appointment.builder()
                    .description("Excepteur sint occaecat cupidatat non proident")
                    .reason("Neque porro quisquam")
                    .patient(patientRepository.findById(1L).get())
                    .precautions("Facilisi etiam dignissim")
                    .prescription("Cursus euismod quis viverra nibh")
                    .build();

            Appointment appointment3 = Appointment.builder()
                    .description("Integer feugiat scelerisque varius morbi enim nunc faucibus a. Metus dictum at tempor commodo ullamcorper.")
                    .reason("Sagittis aliquam malesuada")
                    .patient(patientRepository.findById(2L).get())
                    .precautions("Turpis cursus in hac")
                    .prescription("Id semper risus in hendrerit")
                    .build();

            Appointment appointment4 = Appointment.builder()
                    .description("At vero eos et accusamus et iusto odio dignissimos ducimus")
                    .reason("Et harum quidem")
                    .patient(patientRepository.findById(2L).get())
                    .precautions("Diam sollicitudin tempor")
                    .prescription("Adipiscing elit duis")
                    .build();

            appointmentRepository.saveAll(List.of(appointment1, appointment2, appointment3, appointment4));
        }
    }
}
