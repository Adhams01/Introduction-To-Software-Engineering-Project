package com.mycompany.hms.service;

import com.mycompany.hms.dto.AppointmentDTO;
import com.mycompany.hms.dto.AppointmentRequest;

import java.util.List;

/*
 * Contributed by: Maged
 * Task: M0 - Appointment Service Interface
 * Date: May 2026
 */
public interface AppointmentService {

    List<AppointmentDTO> getAllAppointments();

    AppointmentDTO getAppointmentById(Long id);

    AppointmentDTO createAppointment(AppointmentRequest request);

    AppointmentDTO updateAppointment(Long id, AppointmentRequest request);

    void deleteAppointment(Long id);
}
