package com.labmedicine.labmedicalapi.loaders;

import com.labmedicine.labmedicalapi.models.Exam;
import com.labmedicine.labmedicalapi.repositories.ExamRepository;
import com.labmedicine.labmedicalapi.repositories.PatientRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamDataLoader {
    private final ExamRepository examRepository;
    private final PatientRepository patientRepository;

    public ExamDataLoader(ExamRepository examRepository, PatientRepository patientRepository) {
        this.examRepository = examRepository;
        this.patientRepository = patientRepository;
    }

    public void loadExamData() {
        if (examRepository.count() == 0) {
            Exam exam1 = Exam.builder()
                    .name("Tristique primis")
                    .type("Condimentum")
                    .result("Quam aliquet integer ligula adipiscing quis tellus nibh quisque nec eget euismod")
                    .laboratory("Malesuada dui purus")
                    .fileUrl("https://www.4devs.com.br/gerador_de_texto_lorem_ipsum")
                    .patient(patientRepository.findById(1L).get())
                    .build();

            Exam exam2 = Exam.builder()
                    .name("At congue porta maecenas")
                    .type("Convallis")
                    .result("Aenean nunc purus imperdiet at non eleifend enim aenean donec")
                    .laboratory("In mattis")
                    .fileUrl("https://www.4devs.com.br/gerador_de_texto_lorem_ipsum")
                    .patient(patientRepository.findById(1L).get())
                    .build();

            Exam exam3 = Exam.builder()
                    .name("Eget fringilla ")
                    .type("Imperdiet")
                    .result("Risus sodales mollis eleifend vitae porta aliquam id, tristique orci rutrum quis leo quisque")
                    .laboratory("Suscipit")
                    .fileUrl("https://www.4devs.com.br/gerador_de_texto_lorem_ipsum")
                    .patient(patientRepository.findById(2L).get())
                    .build();

            Exam exam4 = Exam.builder()
                    .name("Netus turpis lacinia")
                    .type("Orci")
                    .result("Ornare dictum elementum et porttitor et taciti metus a fusce integer, posuere habitant est consectetur rutrum aenean auctor litora donec eros aptent")
                    .laboratory("Adipiscing sollicitudin")
                    .fileUrl("https://www.4devs.com.br/gerador_de_texto_lorem_ipsum")
                    .patient(patientRepository.findById(2L).get())
                    .build();

            examRepository.saveAll(List.of(exam1, exam2, exam3, exam4));
        }
    }
}
