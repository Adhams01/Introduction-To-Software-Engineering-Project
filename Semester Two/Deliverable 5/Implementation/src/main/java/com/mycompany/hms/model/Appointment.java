package com.mycompany.hms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

/*
 * Contributed by: Maged
 * Task: M0 - Appointment Entity Model
 * Date: May 2026
 */
@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Patient ID is required")
    @Column(nullable = false)
    private Long patientId;

    @NotNull(message = "Doctor ID is required")
    @Column(nullable = false)
    private Long doctorId;

    @NotBlank(message = "Date is required")
    @Column(nullable = false)
    private String date;        // YYYY-MM-DD

    @NotBlank(message = "Time slot is required")
    @Column(nullable = false)
    private String timeSlot;    // HH:MM

    @Column(length = 500)
    private String reason;

    @Builder.Default
    @Column(nullable = false)
    private String status = "PENDING"; // PENDING / CONFIRMED / CANCELLED
}
