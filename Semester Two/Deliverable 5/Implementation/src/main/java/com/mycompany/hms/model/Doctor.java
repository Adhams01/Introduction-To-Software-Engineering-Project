package com.mycompany.hms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

/*
 * Contributed by: Andrew
 * Task: B2 - Doctor Entity Model
 * Date: May 2026
 */
@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100)
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Phone is required")
    @Column(nullable = false)
    private String phone;

    @NotBlank(message = "Specialty is required")
    @Column(nullable = false)
    private String specialty;

    @Column(nullable = false)
    @Builder.Default
    private Boolean available = true;
}
