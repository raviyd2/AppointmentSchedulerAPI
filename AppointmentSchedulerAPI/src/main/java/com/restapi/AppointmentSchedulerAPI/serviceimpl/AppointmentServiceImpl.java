package com.restapi.AppointmentSchedulerAPI.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.AppointmentSchedulerAPI.dto.AppointmentDTO;
import com.restapi.AppointmentSchedulerAPI.entity.Appointment;
import com.restapi.AppointmentSchedulerAPI.exception.AppointmentNotFoundException;
import com.restapi.AppointmentSchedulerAPI.repository.AppointmentRepository;
import com.restapi.AppointmentSchedulerAPI.service.AppointmentService;

import jakarta.transaction.Transactional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	@Override
	public Optional<Appointment> getElementById(Long id) {
		return appointmentRepository.findById(id);
	}

	@Override
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	@Transactional
	public Appointment updateAppointment(Long id, Appointment appointment) {
		Optional<Appointment> existAppointmentOpt = appointmentRepository.findById(id);
		if(existAppointmentOpt.isPresent()) {
			Appointment exitAppointment = existAppointmentOpt.get();
			appointment.setId(id);
			return appointmentRepository.save(appointment);
		}
			
		return null;
	}

	@Override
	public Appointment getAppointment(Long id) {
		Optional<Appointment> appointmentOpt = appointmentRepository.findById(id);
		return appointmentOpt.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with id: " + id));
	}

	@Override
	public boolean deleteAppointment(Long id) {
		if(appointmentRepository.existsById(id)) {
			appointmentRepository.deleteById(id);
			return true;
		}
		return false;
				
	}

	@Override
	public Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO) {
		Optional<Appointment> existAppointmentOpt = appointmentRepository.findById(id);
		if(existAppointmentOpt.isPresent()){
			Appointment existAppointment = existAppointmentOpt.get();
			existAppointment.setClientName(appointmentDTO.getClientName());	
			existAppointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
			existAppointment.setAppointmentTime(appointmentDTO.getAppointmentTime());
			existAppointment.setService(appointmentDTO.getService());
			existAppointment.setStatus(appointmentDTO.getStatus());
			return appointmentRepository.save(existAppointment);
		}
		return null;
	}
	

	
}
