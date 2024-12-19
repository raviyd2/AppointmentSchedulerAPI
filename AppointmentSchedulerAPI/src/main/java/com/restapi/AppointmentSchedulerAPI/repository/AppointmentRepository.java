package com.restapi.AppointmentSchedulerAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.AppointmentSchedulerAPI.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


}
