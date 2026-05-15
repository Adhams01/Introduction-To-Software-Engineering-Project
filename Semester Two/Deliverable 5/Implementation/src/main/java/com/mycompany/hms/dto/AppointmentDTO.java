package com.mycompany.hms.dto;

import lombok.*;

/*
 * Contributed by: Maged
 * Task: M0 - Appointment DTO
 * Date: May 2026
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AppointmentDTO {
    private Long   id;
    private Long   patientId;
    private Long   doctorId;
    private String date;
    private String timeSlot;
    private String reason;
    private String status;
}
