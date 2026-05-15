package com.mycompany.hms.dto;

import lombok.*;

/*
 * Contributed by: Adham
 * Task: A2 - Patient DTO
 * Date: May 2026
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDTO {

    private Long   id;
    private String name;
    private String email;
    private String phone;
    private String birthDate;
    private String gender;
}
