package com.mycompany.hms.controller;

import com.mycompany.hms.dto.DoctorDTO;
import com.mycompany.hms.dto.DoctorRequest;
import com.mycompany.hms.service.DoctorService;
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
 * Contributed by: Andrew [Lastname]
 * Task: B2, B3 - Doctor Service + POST APIs
 * Date: May 2026
 */
@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
@Tag(name = "Doctor Service", description = "APIs for managing doctor information")
public class DoctorController {

    private final DoctorService doctorService;

    @Operation(summary = "Get all doctors", description = "Retrieves a list of all registered doctors")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of doctors")
    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @Operation(summary = "Get doctor by ID", description = "Retrieves a specific doctor by their ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Doctor found",
                     content = @Content(schema = @Schema(implementation = DoctorDTO.class))),
        @ApiResponse(responseCode = "404", description = "Doctor not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(
            @Parameter(description = "ID of the doctor to retrieve", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @Operation(summary = "Create a new doctor", description = "Registers a new doctor in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Doctor created successfully",
                     content = @Content(schema = @Schema(implementation = DoctorDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
        @ApiResponse(responseCode = "409", description = "Doctor with this email already exists", content = @Content)
    })
    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Doctor details to create", required = true)
            @Valid @RequestBody DoctorRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(doctorService.createDoctor(request));
    }

    @Operation(summary = "Update a doctor", description = "Updates an existing doctor's information")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Doctor updated successfully",
                     content = @Content(schema = @Schema(implementation = DoctorDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
        @ApiResponse(responseCode = "404", description = "Doctor not found", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(
            @Parameter(description = "ID of the doctor to update", required = true)
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Updated doctor details", required = true)
            @Valid @RequestBody DoctorRequest request) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, request));
    }

    @Operation(summary = "Delete a doctor", description = "Removes a doctor from the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Doctor deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Doctor not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(
            @Parameter(description = "ID of the doctor to delete", required = true)
            @PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
