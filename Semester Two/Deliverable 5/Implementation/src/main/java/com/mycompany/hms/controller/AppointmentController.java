package com.mycompany.hms.controller;

import com.mycompany.hms.dto.AppointmentDTO;
import com.mycompany.hms.dto.AppointmentRequest;
import com.mycompany.hms.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Contributed by: Andrew (POST), Yassin (PUT), Maged (DELETE)
 * Task: B3, Y2, M1 - Appointment CRUD
 * Date: May 2026
 */
@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
@Tag(name = "Appointment Service", description = "APIs for scheduling and managing appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Operation(summary = "Get all appointments", description = "Retrieves a list of all scheduled appointments")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of appointments")
    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @Operation(summary = "Get appointment by ID", description = "Retrieves a specific appointment by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Appointment found",
                     content = @Content(schema = @Schema(implementation = AppointmentDTO.class))),
        @ApiResponse(responseCode = "404", description = "Appointment not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(
            @Parameter(description = "ID of the appointment to retrieve", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @Operation(summary = "Create a new appointment", description = "Schedules a new appointment between a patient and doctor")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Appointment created successfully",
                     content = @Content(schema = @Schema(implementation = AppointmentDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
        @ApiResponse(responseCode = "404", description = "Patient or doctor not found", content = @Content)
    })
    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Appointment details to create", required = true)
            @Valid @RequestBody AppointmentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appointmentService.createAppointment(request));
    }

    @Operation(summary = "Update an appointment", description = "Updates an existing appointment's details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Appointment updated successfully",
                     content = @Content(schema = @Schema(implementation = AppointmentDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
        @ApiResponse(responseCode = "404", description = "Appointment not found", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(
            @Parameter(description = "ID of the appointment to update", required = true)
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Updated appointment details", required = true)
            @Valid @RequestBody AppointmentRequest request) {
        return ResponseEntity.ok(appointmentService.updateAppointment(id, request));
    }

    @Operation(summary = "Delete an appointment", description = "Cancels and removes an appointment from the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Appointment deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Appointment not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(
            @Parameter(description = "ID of the appointment to delete", required = true)
            @PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
