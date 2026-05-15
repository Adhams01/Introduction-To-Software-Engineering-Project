package com.mycompany.hms.dto;

import jakarta.validation.constraints.*;
import lombok.*;

/*
 * Contributed by: Andrew
 * Task: B3 - Doctor Request DTO
 * Date: May 2026
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DoctorRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotBlank(message = "Specialty is required")
    private String specialty;

    @Builder.Default
    private Boolean available = true;
}
