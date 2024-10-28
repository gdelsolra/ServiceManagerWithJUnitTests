package com.example.projectonecs320.contactservice;

import java.util.UUID;

/**
 * The Contact class stores contact details, including the contact ID, first name,
 * last name, phone number, and address.
 *
 * All fields are updatable except for the contact ID.
 *
 * @param contactID  Unique identifier for the contact (automatically generated)
 * @param firstName  First name of the contact (cannot be null, max length 10)
 * @param lastName   Last name of the contact (cannot be null, max length 10)
 * @param phone      Phone number of the contact (must be exactly 10 digits)
 * @param address    Address of the contact (cannot be null, max length 30)
 *
 * @return The methods return the respective values of the fields or void for setters.
 *
 */
public class Contact {
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor to initialize the Contact object with required fields
    public Contact(String firstName, String lastName, String phone, String address) {
        // Generate a unique 10-character contact ID
        this.contactID = UUID.randomUUID().toString().substring(0, 10);

        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        // Assign values if all validations pass
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter methods to access private fields
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setter methods to update the fields that can be updated
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
