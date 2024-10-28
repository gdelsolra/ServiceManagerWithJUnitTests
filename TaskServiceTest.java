package com.example.projectonecs320.taskservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the TaskService class.
 */
public class TaskServiceTest {

    /**
     * Test to verify that a task can be successfully added to the TaskService.
     * A new Task object is created and added to the service, then we retrieve
     * it by its ID and check if it was successfully added.
     */
    @Test
    public void testAddTaskSuccess() {
        TaskService service = new TaskService();
        Task task = new Task("Task Name", "Task description");  // Create a new Task object
        service.addTask(task);  // Add the Task object to the TaskService
        assertEquals(task, service.getTaskById(task.getTaskId()));  // Ensure the task was added successfully
    }

    /**
     * Test to verify that a task can be successfully deleted from the TaskService.
     * A new Task object is created, added to the service, and then deleted by its ID.
     * We check that the deletion returns true, meaning the task was successfully deleted.
     */
    @Test
    public void testDeleteTaskSuccess() {
        TaskService service = new TaskService();
        Task task = new Task("Task Name", "Task description");  // Create a new Task object
        service.addTask(task);  // Add the Task object to the TaskService
        assertTrue(service.deleteTask(task.getTaskId()));  // Ensure the task is deleted successfully
    }

    /**
     * Test to verify that attempting to delete a task with a non-existent ID returns false.
     * We attempt to delete a task with an ID that doesn't exist in the service, and
     * expect the result to be false, meaning no task was deleted.
     */
    @Test
    public void testDeleteTaskFailure() {
        TaskService service = new TaskService();
        assertFalse(service.deleteTask("NonExistentID"));  // Try to delete a task that doesn't exist
    }

    /**
     * Test to verify that the task's name can be updated successfully.
     * A Task object is created and added to the service. The name is then updated
     * using the service, and we verify that the name was updated correctly.
     */
    @Test
    public void testUpdateTaskNameSuccess() {
        TaskService service = new TaskService();
        Task task = new Task("Old Name", "Task description");  // Create a new Task object
        service.addTask(task);  // Add the Task object to the TaskService
        service.updateTaskName(task.getTaskId(), "New Name");  // Update the task's name
        assertEquals("New Name", task.getName());  // Ensure the task's name was updated successfully
    }

    /**
     * Test to verify that the task's description can be updated successfully.
     * A Task object is created and added to the service. The description is then updated
     * using the service, and we verify that the description was updated correctly.
     */
    @Test
    public void testUpdateTaskDescriptionSuccess() {
        TaskService service = new TaskService();
        Task task = new Task("Task Name", "Old description");  // Create a new Task object
        service.addTask(task);  // Add the Task object to the TaskService
        service.updateTaskDescription(task.getTaskId(), "New description");  // Update the task's description
        assertEquals("New description", task.getDescription());  // Ensure the task's description was updated successfully
    }

    /**
     * Test to verify that attempting to update the name of a non-existent task throws an IllegalArgumentException.
     * We use the lambda expression (->) to invoke the method that we expect to throw the exception. The test
     * passes if an IllegalArgumentException is thrown as expected when trying to update a task that doesn't exist.
     *
     * Explanation of the lambda (->):
     * The lambda expression (->) is used to define an anonymous function, which, in this case, is used to invoke
     * the updateTaskName method. If the method throws the expected exception, the test passes.
     */
    @Test
    public void testUpdateNonExistentTaskName() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            // Attempt to update a task with an ID that does not exist in the service
            service.updateTaskName("NonExistentID", "New Name");
        });
    }

    /**
     * Test to verify that attempting to update the description of a non-existent task throws an IllegalArgumentException.
     * Like the previous test, the lambda expression (->) is used to invoke the method that is expected to throw the exception.
     * The test passes if an IllegalArgumentException is thrown as expected when trying to update a non-existent task.
     */
    @Test
    public void testUpdateNonExistentTaskDescription() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            // Attempt to update the description of a task with an ID that does not exist in the service
            service.updateTaskDescription("NonExistentID", "New description");
        });
    }
}

