package com.restapi.AppointmentSchedulerAPI.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class AppointmentDTO {
	private int id;
	private String clientName;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	private String service;
	private String status;

}
