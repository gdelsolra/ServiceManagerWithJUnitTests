package com.example.projectonecs320.appointmentservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AppointmentServiceTest {

    private AppointmentService service;

    /**
     * Initializes the AppointmentService object before each test.
     * This ensures each test has a fresh service to work with.
     */
    @BeforeEach
    public void setUp() {
        service = new AppointmentService(); // Initialize a new AppointmentService before each test
    }

    /**
     * Tests that an appointment is successfully added to the appointment service.
     * Ensures the appointment can be retrieved by its ID after being added.
     */
    @Test
    public void testAddAppointmentSuccess() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment(futureDate, "Test Description");

        service.addAppointment(appointment);  // Add the appointment

        // Ensure the appointment was added successfully
        assertEquals(appointment, service.getAppointmentById(appointment.getAppointmentId()));
    }

    /**
     * Tests that an appointment is successfully deleted from the appointment service.
     * Ensures the appointment can no longer be retrieved by its ID after being deleted.
     */
    @Test
    public void testDeleteAppointmentSuccess() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment(futureDate, "Test Description");

        service.addAppointment(appointment);  // Add the appointment
        service.deleteAppointment(appointment.getAppointmentId());  // Delete the appointment

        // Ensure the appointment was deleted
        assertNull(service.getAppointmentById(appointment.getAppointmentId()));
    }

    /**
     * Tests that an exception is thrown when trying to delete a non-existent appointment.
     *
     * @throws IllegalArgumentException if the appointment ID does not exist.
     */
    @Test
    public void testDeleteNonExistentAppointment() {
        // Attempt to delete an appointment that does not exist
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("NonExistentID"));
    }
}
