package com.example.projectonecs320.appointmentservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class AppointmentTest {

    /**
     * Tests that an appointment is successfully created with valid data.
     * Ensures the appointment ID is generated, the date is valid, and the description is correct.
     */
    @Test
    public void testAppointmentCreationSuccess() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment(futureDate, "Test Description");

        // Ensure the appointment fields are set correctly
        assertNotNull(appointment.getAppointmentId());  // Check if appointment ID is generated
        assertEquals(futureDate, appointment.getAppointmentDate());  // Check if date is correct
        assertEquals("Test Description", appointment.getAppointmentDescription());  // Check if description is correct
    }

    /**
     * Tests that an exception is thrown when the appointment description exceeds 50 characters.
     *
     * @throws IllegalArgumentException if the description is too long.
     */
    @Test
    public void testAppointmentDescriptionTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(futureDate, "This description is way too long for the appointment object to handle properly.");
        });
    }

    /**
     * Tests that an exception is thrown when the appointment date is in the past.
     *
     * @throws IllegalArgumentException if the date is in the past.
     */
    @Test
    public void testAppointmentDateInPast() {
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // 1 day in the past
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(pastDate, "Valid Description");
        });
    }
}
