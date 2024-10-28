package com.example.projectonecs320.appointmentservice;

import java.util.HashMap;
import java.util.Map;

/**
 * The AppointmentService class manages appointments.
 * It allows adding, deleting, and storing appointments in-memory.
 */
public class AppointmentService {

    // A map to store appointments with the appointment ID as the key.
    private final Map<String, Appointment> appointments = new HashMap<>();

    /**
     * Adds a new appointment to the appointment service.
     * The appointment ID is already generated inside the Appointment class.
     *
     * @param appointment the appointment object to add. The appointment ID is already generated.
     * @throws IllegalArgumentException if an appointment with the same ID already exists.
     */
    public void addAppointment(Appointment appointment) {
        // Get the appointment's ID from the appointment object
        String appointmentId = appointment.getAppointmentId();

        // Check if the appointment ID is unique
        if (appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID must be unique.");
        }

        // Add the appointment to the map using its ID as the key
        appointments.put(appointmentId, appointment);
    }

    /**
     * Deletes an appointment from the appointment service.
     *
     * @param appointmentId the ID of the appointment to delete.
     * @throws IllegalArgumentException if the appointment ID is not found.
     */
    public void deleteAppointment(String appointmentId) {
        // Check if the appointment ID exists in the map
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID not found.");
        }

        // Remove the appointment from the map
        appointments.remove(appointmentId);
    }
    /**
     * Retrieves an appointment by its ID.
     *
     * @param appointmentId the ID of the appointment to retrieve.
     * @return the appointment object if found, or null if not found.
     */
    public Appointment getAppointmentById(String appointmentId) {
        return appointments.get(appointmentId);  // Retrieve appointment from the map
    }
}

