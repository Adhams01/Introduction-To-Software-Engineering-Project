package com.mycompany.hms.dto;

import jakarta.validation.constraints.*;
import lombok.*;

/*
 * Contributed by: Adham
 * Task: A2 - Patient Request DTO
 * Date: May 2026
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email address")
    private String email;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^[0-9+\\-\\s]{7,20}$", message = "Phone must be a valid number")
    private String phone;

    private String birthDate;  // Optional: YYYY-MM-DD

    private String gender;     // Optional: MALE / FEMALE / OTHER
}
