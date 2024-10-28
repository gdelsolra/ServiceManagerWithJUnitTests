package com.example.projectonecs320.contactservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService(); // Ensure this is correctly initialized
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Verify that the contact is successfully added
        assertNotNull(contactService.getContact(contact.getContactID()));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Delete and verify that the contact is removed
        contactService.deleteContact(contact.getContactID());
        assertNull(contactService.getContact(contact.getContactID()));
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Update and verify the first name
        contactService.updateFirstName(contact.getContactID(), "Jane");
        assertEquals("Jane", contactService.getContact(contact.getContactID()).getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Update and verify the last name
        contactService.updateLastName(contact.getContactID(), "Smith");
        assertEquals("Smith", contactService.getContact(contact.getContactID()).getLastName());
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Update and verify the phone number
        contactService.updatePhone(contact.getContactID(), "0987654321");
        assertEquals("0987654321", contactService.getContact(contact.getContactID()).getPhone());
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Update and verify the address
        contactService.updateAddress(contact.getContactID(), "456 Elm St");
        assertEquals("456 Elm St", contactService.getContact(contact.getContactID()).getAddress());
    }

    @Test
    public void testGetContact() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Verify retrieval of the contact
        Contact retrievedContact = contactService.getContact(contact.getContactID());
        assertNotNull(retrievedContact);
        assertEquals("John", retrievedContact.getFirstName());
    }
}

