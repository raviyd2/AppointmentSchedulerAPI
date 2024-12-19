package com.restapi.AppointmentSchedulerAPI.controller;

import com.restapi.AppointmentSchedulerAPI.dto.AppointmentDTO;
import com.restapi.AppointmentSchedulerAPI.entity.Appointment;
import com.restapi.AppointmentSchedulerAPI.exception.AppointmentNotFoundException;
import com.restapi.AppointmentSchedulerAPI.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments") 
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK); 
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointment(id);
        return new ResponseEntity<>(appointment, HttpStatus.OK); 
    }

    
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment createdAppointment = appointmentService.saveAppointment(appointment);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED); 
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        Appointment updatedAppointment = appointmentService.updateAppointment(id, appointment);
        if (updatedAppointment != null) {
            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK); 
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        boolean isDeleted = appointmentService.deleteAppointment(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }

    
    @PutMapping("/dto/{id}")
    public ResponseEntity<Appointment> updateAppointmentUsingDTO(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO) {
        Appointment updatedAppointment = appointmentService.updateAppointment(id, appointmentDTO);
        if (updatedAppointment != null) {
            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK); 
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }
}
