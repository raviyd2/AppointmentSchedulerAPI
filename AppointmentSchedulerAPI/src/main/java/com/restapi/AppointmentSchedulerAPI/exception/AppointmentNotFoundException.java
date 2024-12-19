package com.restapi.AppointmentSchedulerAPI.exception;

public class AppointmentNotFoundException extends RuntimeException {
	public AppointmentNotFoundException(String message) {
        super(message); 
    }
}
