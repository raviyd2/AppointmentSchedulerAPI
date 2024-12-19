package com.restapi.AppointmentSchedulerAPI.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name ="clientName")
	private String clientName;
	@Column(name ="appointmentDate")
	private LocalDate appointmentDate;
	@Column(name ="appointmentTime")
	private LocalTime appointmentTime;
	@Column(name ="service")
	private String service;
	@Column(name ="status")
	private String status;

}
