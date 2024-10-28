package com.example.projectonecs320.taskservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Task class.
 */
public class TaskTest {

    /**
     * Test to verify that a task is created successfully with valid name and description.
     * Ensures that the task ID is generated, has a length of 10 characters, and that
     * the name and description are set correctly.
     */
    @Test
    public void testTaskCreationSuccess() {
        Task task = new Task("Task Name", "Task description");  // Create a valid Task object
        assertNotNull(task.getTaskId());  // Ensure task ID is generated
        assertEquals(10, task.getTaskId().length());  // Ensure task ID is 10 characters long
        assertEquals("Task Name", task.getName());  // Ensure name is set correctly
        assertEquals("Task description", task.getDescription());  // Ensure description is set correctly
    }

    /**
     * Test to verify that creating a task with a name longer than 20 characters throws an IllegalArgumentException.
     * The lambda expression (->) is used to invoke the Task constructor with an invalid name.
     * The test passes if the IllegalArgumentException is thrown.
     */
    @Test
    public void testTaskNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            // Attempt to create a Task with a name that exceeds 20 characters
            new Task("This name is way too long for the task", "Task description");
        });
    }

    /**
     * Test to verify that creating a task with a description longer than 50 characters throws an IllegalArgumentException.
     * The lambda expression (->) is used to invoke the Task constructor with an invalid description.
     * The test passes if the IllegalArgumentException is thrown.
     */
    @Test
    public void testTaskDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            // Attempt to create a Task with a description that exceeds 50 characters
            new Task("Task Name", "This description is way too long for the task object to handle properly.");
        });
    }

    /**
     * Test to verify that creating a task with a null name throws an IllegalArgumentException.
     * The lambda expression (->) is used to invoke the Task constructor with a null name.
     * The test passes if the IllegalArgumentException is thrown.
     */
    @Test
    public void testNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            // Attempt to create a Task with a null name
            new Task(null, "Task description");
        });
    }

    /**
     * Test to verify that creating a task with a null description throws an IllegalArgumentException.
     * The lambda expression (->) is used to invoke the Task constructor with a null description.
     * The test passes if the IllegalArgumentException is thrown.
     */
    @Test
    public void testNullDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            // Attempt to create a Task with a null description
            new Task("Task Name", null);
        });
    }

    /**
     * Test to verify that setting a valid name for a task works correctly.
     * A valid Task object is created, and its name is updated using the setName method.
     * We check that the name was updated successfully.
     */
    @Test
    public void testSetValidName() {
        Task task = new Task("Old Name", "Task description");  // Create a valid Task object
        task.setName("New Name");  // Update the task's name
        assertEquals("New Name", task.getName());  // Ensure the name was updated successfully
    }

    /**
     * Test to verify that attempting to set an invalid name (longer than 20 characters) throws an IllegalArgumentException.
     * The lambda expression (->) is used to invoke the setName method with an invalid name.
     * The test passes if the IllegalArgumentException is thrown.
     */
    @Test
    public void testSetInvalidName() {
        Task task = new Task("Old Name", "Task description");  // Create a valid Task object
        assertThrows(IllegalArgumentException.class, () -> {
            // Attempt to set a name that exceeds 20 characters
            task.setName("This name is way too long for the task");
        });
    }

    /**
     * Test to verify that setting a valid description for a task works correctly.
     * A valid Task object is created, and its description is updated using the setDescription method.
     * We check that the description was updated successfully.
     */
    @Test
    public void testSetValidDescription() {
        Task task = new Task("Task Name", "Old description");  // Create a valid Task object
        task.setDescription("New description");  // Update the task's description
        assertEquals("New description", task.getDescription());  // Ensure the description was updated successfully
    }

    /**
     * Test to verify that attempting to set an invalid description (longer than 50 characters) throws an IllegalArgumentException.
     * The lambda expression (->) is used to invoke the setDescription method with an invalid description.
     * The test passes if the IllegalArgumentException is thrown.
     */
    @Test
    public void testSetInvalidDescription() {
        Task task = new Task("Task Name", "Task description");  // Create a valid Task object
        assertThrows(IllegalArgumentException.class, () -> {
            // Attempt to set a description that exceeds 50 characters
            task.setDescription("This description is way too long for the task object to handle properly.");
        });
    }
}


