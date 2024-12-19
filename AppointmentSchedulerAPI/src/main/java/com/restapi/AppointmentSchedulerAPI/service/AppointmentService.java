package com.restapi.AppointmentSchedulerAPI.service;

import java.util.List;
import java.util.Optional;

import com.restapi.AppointmentSchedulerAPI.dto.AppointmentDTO;
import com.restapi.AppointmentSchedulerAPI.entity.Appointment;

public interface AppointmentService {
	List<Appointment> getAllAppointments();
	Optional<Appointment> getElementById(Long id);
	Appointment saveAppointment(Appointment appointment);
	Appointment updateAppointment(Long id, Appointment appointment);
	Appointment getAppointment(Long id);
	boolean deleteAppointment(Long id);
	Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO);

}
