package com.example.projectonecs320.contactservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("Carlos", "Martínez", "9876543210", "456 Avenida Central");

        assertNotNull(contact.getContactID()); // The ID should be automatically generated
        assertEquals("Carlos", contact.getFirstName());
        assertEquals("Martínez", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("456 Avenida Central", contact.getAddress());
    }

    // Test invalid first name (too long)
    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("CarlosAlejandro", "Martínez", "9876543210", "456 Avenida Central");
        });
    }

    // Test invalid last name (too long)
    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Carlos", "MartínezMartínezMartínez", "9876543210", "456 Avenida Central");
        });
    }

    // Test invalid phone number (wrong length)
    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Carlos", "Martínez", "12345", "456 Avenida Central");
        });
    }

    // Test invalid address (too long)
    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Carlos", "Martínez", "9876543210", "456 Avenida Central, Piso 3, Apt 12, Sector Oeste");
        });
    }

    // Test updating first name with a valid input
    @Test
    public void testSetFirstName() {
        Contact contact = new Contact("Carlos", "Martínez", "9876543210", "456 Avenida Central");
        contact.setFirstName("Lucía");
        assertEquals("Lucía", contact.getFirstName());
    }

    // Test updating first name with an invalid input
    @Test
    public void testSetFirstNameInvalid() {
        Contact contact = new Contact("Carlos", "Martínez", "9876543210", "456 Avenida Central");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("LucíaFernández");
        });
    }

    // Test updating last name with a valid input
    @Test
    public void testSetLastName() {
        Contact contact = new Contact("Carlos", "Martínez", "9876543210", "456 Avenida Central");
        contact.setLastName("González");
        assertEquals("González", contact.getLastName());
    }

    // Test updating last name with an invalid input
    @Test
    public void testSetLastNameInvalid() {
        Contact contact = new Contact("Carlos", "Martínez", "9876543210", "456 Avenida Central");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("GonzálezGonzález");
        });
    }

    // Test updating phone with a valid input
    @Test
    public void testSetPhone() {
        Contact contact = new Contact("Carlos", "Martínez", "9876543210", "456 Avenida Central");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    // Test updating phone with an invalid input
    @Test
    public void testSetPhoneInvalid() {
        Contact contact = new Contact("Carlos", "Martínez", "9876543210", "456 Avenida Central");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("09876");
        });
    }

    // Test updating address with a valid input
    @Test
    public void testSetAddress() {
        Contact contact = new Contact("Carlos", "Martínez", "9876543210", "456 Avenida Central");
        contact.setAddress("789 Calle Sol");
        assertEquals("789 Calle Sol", contact.getAddress());
    }

    // Test updating address with an invalid input
    @Test
    public void testSetAddressInvalid() {
        Contact contact = new Contact("Carlos", "Martínez", "9876543210", "456 Avenida Central");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("Calle muy larga con descripción adicional que supera el límite de caracteres");
        });
    }
}
