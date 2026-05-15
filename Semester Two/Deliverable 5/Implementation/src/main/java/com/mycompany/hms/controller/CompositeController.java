package com.mycompany.hms.controller;

import com.mycompany.hms.exception.ResourceNotFoundException;
import com.mycompany.hms.model.Appointment;
import com.mycompany.hms.model.Doctor;
import com.mycompany.hms.model.Patient;
import com.mycompany.hms.repository.AppointmentRepository;
import com.mycompany.hms.repository.DoctorRepository;
import com.mycompany.hms.repository.PatientRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * Contributed by: Andrew (implementation), Adham (design)
 * Task: B4, A4 - Composite Service "Book Appointment"
 * This service orchestrates Patient + Doctor + Appointment APIs
 * Date: May 2026
 */
@RestController
@RequestMapping("/api/composite")
@RequiredArgsConstructor
@Tag(name = "Composite Service", description = "Orchestrated APIs that combine multiple services")
public class CompositeController {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    /*
     * Book Appointment - Composite Service
     * Steps:
     * 1. Check patient exists
     * 2. Check doctor exists
     * 3. Create appointment
     * 4. Return combined response
     */
    @Operation(
        summary = "Book an appointment (Composite)",
        description = """
            Orchestrates the complete appointment booking process:
            1. Validates patient exists
            2. Validates doctor exists
            3. Creates the appointment
            4. Returns comprehensive booking details including patient and doctor information
            """
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Appointment booked successfully",
                     content = @Content(schema = @Schema(implementation = BookingResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
        @ApiResponse(responseCode = "404", description = "Patient or doctor not found", content = @Content)
    })
    @PostMapping("/book-appointment")
    public ResponseEntity<BookingResponse> bookAppointment(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Booking request with patient ID, doctor ID, date, time slot, and optional reason",
                required = true)
            @Valid @RequestBody BookingRequest request) {

        // Step 1: find patient
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Patient not found: " + request.getPatientId()));

        // Step 2: find doctor
        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found: " + request.getDoctorId()));

        // Step 3: create appointment
        Appointment appt = Appointment.builder()
                .patientId(patient.getId())
                .doctorId(doctor.getId())
                .date(request.getDate())
                .timeSlot(request.getTimeSlot())
                .reason(request.getReason())
                .status("CONFIRMED")
                .build();
        Appointment saved = appointmentRepository.save(appt);

        // Step 4: build response with all info
        BookingResponse response = BookingResponse.builder()
                .appointmentId(saved.getId())
                .patientId(patient.getId())
                .patientName(patient.getName())
                .doctorId(doctor.getId())
                .doctorName(doctor.getName())
                .doctorSpecialty(doctor.getSpecialty())
                .date(saved.getDate())
                .timeSlot(saved.getTimeSlot())
                .reason(saved.getReason())
                .status(saved.getStatus())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Inner class for request
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class BookingRequest {
        @NotNull(message = "patientId required")
        private Long patientId;
        @NotNull(message = "doctorId required")
        private Long doctorId;
        @NotBlank(message = "date required")
        private String date;
        @NotBlank(message = "timeSlot required")
        private String timeSlot;
        private String reason;
    }

    // Inner class for response
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class BookingResponse {
        private Long appointmentId;
        private Long patientId;
        private String patientName;
        private Long doctorId;
        private String doctorName;
        private String doctorSpecialty;
        private String date;
        private String timeSlot;
        private String reason;
        private String status;
    }
}
