package com.mycompany.hms.controller;

import com.mycompany.hms.dto.PatientDTO;
import com.mycompany.hms.dto.PatientRequest;
import com.mycompany.hms.service.PatientService;
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
 * Contributed by: Adham Sobhy
 * Task: A3 - GET APIs for Patient Service
 * Date: May 2026
 */
@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@Tag(name = "Patient Service", description = "APIs for managing patient records")
public class PatientController {

    private final PatientService patientService;

    @Operation(summary = "Get all patients", description = "Retrieves a list of all registered patients")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of patients")
    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @Operation(summary = "Get patient by ID", description = "Retrieves a specific patient by their ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Patient found", 
                     content = @Content(schema = @Schema(implementation = PatientDTO.class))),
        @ApiResponse(responseCode = "404", description = "Patient not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(
            @Parameter(description = "ID of the patient to retrieve", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @Operation(summary = "Create a new patient", description = "Registers a new patient in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Patient created successfully",
                     content = @Content(schema = @Schema(implementation = PatientDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
        @ApiResponse(responseCode = "409", description = "Patient with this email already exists", content = @Content)
    })
    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Patient details to create", required = true)
            @Valid @RequestBody PatientRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(patientService.createPatient(request));
    }

    @Operation(summary = "Update a patient", description = "Updates an existing patient's information")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Patient updated successfully",
                     content = @Content(schema = @Schema(implementation = PatientDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
        @ApiResponse(responseCode = "404", description = "Patient not found", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(
            @Parameter(description = "ID of the patient to update", required = true)
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Updated patient details", required = true)
            @Valid @RequestBody PatientRequest request) {
        return ResponseEntity.ok(patientService.updatePatient(id, request));
    }

    @Operation(summary = "Delete a patient", description = "Removes a patient from the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Patient deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Patient not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(
            @Parameter(description = "ID of the patient to delete", required = true)
            @PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
