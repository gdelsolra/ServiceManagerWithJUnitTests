package com.example.projectonecs320.contactservice;

import java.util.HashMap;
import java.util.Map;

/**
 * The ContactService class manages contacts by adding, deleting, and updating contact records.
 * It uses a HashMap to store contacts in memory, keyed by the unique contact ID.
 */
public class ContactService {
    // Store contacts in a HashMap, with contactID as the key and Contact as the value
    private Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact to the service.
     *
     * @param contact The contact object to be added.
     * @throws IllegalArgumentException if the contact ID already exists.
     */
    public void addContact(Contact contact) {
        // Add contact to the HashMap using its auto-generated ID
        String contactID = contact.getContactID();
        if (contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contactID, contact);
    }

    /**
     * Deletes a contact by contact ID.
     *
     * @param contactID The unique identifier of the contact to be deleted.
     */
    public void deleteContact(String contactID) {
        contacts.remove(contactID);
    }

    /**
     * Updates the first name of a contact based on contact ID.
     *
     * @param contactID     The unique identifier of the contact to update.
     * @param newFirstName  The new first name to set.
     */
    public void updateFirstName(String contactID, String newFirstName) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setFirstName(newFirstName);
        }
    }

    /**
     * Updates the last name of a contact based on contact ID.
     *
     * @param contactID      The unique identifier of the contact to update.
     * @param newLastName    The new last name to set.
     */
    public void updateLastName(String contactID, String newLastName) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setLastName(newLastName);
        }
    }

    /**
     * Updates the phone number of a contact based on contact ID.
     *
     * @param contactID  The unique identifier of the contact to update.
     * @param newPhone   The new phone number to set.
     */
    public void updatePhone(String contactID, String newPhone) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setPhone(newPhone);
        }
    }

    /**
     * Updates the address of a contact based on contact ID.
     *
     * @param contactID   The unique identifier of the contact to update.
     * @param newAddress  The new address to set.
     */
    public void updateAddress(String contactID, String newAddress) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            contact.setAddress(newAddress);
        }
    }

    /**
     * Retrieves a contact based on contact ID.
     *
     * @param contactID The unique identifier of the contact to retrieve.
     * @return The contact object associated with the provided contact ID, or null if not found.
     */
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
