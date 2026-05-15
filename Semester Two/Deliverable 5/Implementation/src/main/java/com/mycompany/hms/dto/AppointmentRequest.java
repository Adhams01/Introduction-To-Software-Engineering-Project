package com.mycompany.hms.dto;

import jakarta.validation.constraints.*;
import lombok.*;

/*
 * Contributed by: Andrew (POST), Yassin (PUT)
 * Task: B3, Y2 - Appointment Request DTO
 * Date: May 2026
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AppointmentRequest {

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotNull(message = "Doctor ID is required")
    private Long doctorId;

    @NotBlank(message = "Date is required")
    private String date;      // YYYY-MM-DD

    @NotBlank(message = "Time slot is required")
    private String timeSlot;  // HH:MM

    private String reason;
}
