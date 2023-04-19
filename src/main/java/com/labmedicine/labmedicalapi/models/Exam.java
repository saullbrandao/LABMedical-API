package com.labmedicine.labmedicalapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "exams")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private String name, type, fileUrl, result, laboratory;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @NotNull
    private Patient patient;
}
