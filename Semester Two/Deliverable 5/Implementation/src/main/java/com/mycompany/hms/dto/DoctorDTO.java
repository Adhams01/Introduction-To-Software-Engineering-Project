package com.mycompany.hms.dto;

import lombok.*;

/*
 * Contributed by: Andrew
 * Task: B2 - Doctor DTO
 * Date: May 2026
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DoctorDTO {
    private Long    id;
    private String  name;
    private String  email;
    private String  phone;
    private String  specialty;
    private Boolean available;
}
