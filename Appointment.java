package com.example.projectonecs320.appointmentservice;

import java.util.Date;
import java.util.UUID;

/**
 * The Appointment class represents an appointment.
 * Each appointment has a unique ID, a date, and a description.
 */
public class Appointment {

    // Unique appointment ID (not updatable)
    private final String appointmentId;

    // Appointment date (must be in the future)
    private Date appointmentDate;

    // Appointment description (max 50 characters)
    private String appointmentDescription;

    /**
     * Constructor to create an appointment object.
     *
     * @param appointmentDescription the description of the appointment (must be 50 characters or less).
     * @param appointmentDate the date of the appointment (must be in the future).
     * @throws IllegalArgumentException if the date is in the past or the description is invalid.
     */
    public Appointment(Date appointmentDate, String appointmentDescription) {
        this.appointmentId = generateAppointmentId();  // Generate a unique ID
        setAppointmentDate(appointmentDate);  // Validate and set the date
        setAppointmentDescription(appointmentDescription);  // Validate and set the description
    }

    /**
     * Generates a unique appointment ID.
     *
     * @return a 10-character unique ID.
     */
    public String generateAppointmentId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);  // Generate 10-character ID
    }

    /**
     * Sets the appointment date.
     *
     * @param appointmentDate the appointment date to set.
     * @throws IllegalArgumentException if the date is null or in the past.
     */
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date must be in the future and not null.");
        }
        this.appointmentDate = appointmentDate;
    }

    /**
     * Sets the appointment description.
     *
     * @param appointmentDescription the appointment description to set (max 50 characters).
     * @throws IllegalArgumentException if the description is null or exceeds 50 characters.
     */
    public void setAppointmentDescription(String appointmentDescription) {
        if (appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Description must be not null and must be 50 characters or less.");
        }
        this.appointmentDescription = appointmentDescription;
    }

    // Getter methods to access the fields:

    /**
     * Gets the appointment ID.
     *
     * @return the unique appointment ID.
     */
    public String getAppointmentId() {
        return appointmentId;
    }

    /**
     * Gets the appointment date.
     *
     * @return the appointment date.
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * Gets the appointment description.
     *
     * @return the appointment description.
     */
    public String getAppointmentDescription() {
        return appointmentDescription;
    }
}

