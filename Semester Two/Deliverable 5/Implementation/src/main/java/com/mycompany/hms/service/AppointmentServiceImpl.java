package com.mycompany.hms.service;

import com.mycompany.hms.dto.AppointmentDTO;
import com.mycompany.hms.dto.AppointmentRequest;
import com.mycompany.hms.exception.ResourceNotFoundException;
import com.mycompany.hms.model.Appointment;
import com.mycompany.hms.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Contributed by: Andrew (POST), Yassin (PUT), Maged (DELETE)
 * Task: B3, Y2, M1 - Appointment Service Implementation
 * Date: May 2026
 */
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO getAppointmentById(Long id) {
        Appointment appt = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with id: " + id));
        return toDTO(appt);
    }

    @Override
    public AppointmentDTO createAppointment(AppointmentRequest request) {
        Appointment appt = Appointment.builder()
                .patientId(request.getPatientId())
                .doctorId(request.getDoctorId())
                .date(request.getDate())
                .timeSlot(request.getTimeSlot())
                .reason(request.getReason())
                .status("CONFIRMED")
                .build();
        return toDTO(appointmentRepository.save(appt));
    }

    @Override
    public AppointmentDTO updateAppointment(Long id, AppointmentRequest request) {
        Appointment existing = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with id: " + id));
        existing.setPatientId(request.getPatientId());
        existing.setDoctorId(request.getDoctorId());
        existing.setDate(request.getDate());
        existing.setTimeSlot(request.getTimeSlot());
        existing.setReason(request.getReason());
        return toDTO(appointmentRepository.save(existing));
    }

    @Override
    public void deleteAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Appointment not found with id: " + id);
        }
        appointmentRepository.deleteById(id);
    }

    private AppointmentDTO toDTO(Appointment appt) {
        return AppointmentDTO.builder()
                .id(appt.getId())
                .patientId(appt.getPatientId())
                .doctorId(appt.getDoctorId())
                .date(appt.getDate())
                .timeSlot(appt.getTimeSlot())
                .reason(appt.getReason())
                .status(appt.getStatus())
                .build();
    }
}
