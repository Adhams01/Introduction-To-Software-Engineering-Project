package com.mycompany.hms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

/*
 * Contributed by: Adham
 * Task: A2 - Patient Entity Model
 * Date: May 2026
 */
@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9+\\-\\s]{7,20}$", message = "Phone number must be valid")
    @Column(nullable = false)
    private String phone;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(length = 10)
    private String gender;
}
