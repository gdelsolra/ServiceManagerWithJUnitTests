package com.example.projectonecs320.taskservice;

import java.util.UUID;

public class Task {
    private final String taskId;
    private String name;
    private String description;

    /**
     * Constructor for the Task class.
     * Generates a unique task ID and initializes the name and description.
     * @param name the name of the task
     * @param description the description of the task
     * @throws IllegalArgumentException if the name or description is invalid
     */
    public Task(String name, String description) {
        // Generate a unique 10-character task ID
        this.taskId = generateUniqueID();
        setName(name);
        setDescription(description);
    }

    /**
     * Generates a unique 10-character task ID using a random UUID.
     * @return the unique task ID
     */
    private String generateUniqueID() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }

    /**
     * Gets the task ID.
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Gets the task name.
     * @return the task name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the task name.
     * Validates that the name is not null and does not exceed 20 characters.
     * @param name the name to set
     * @throws IllegalArgumentException if the name is invalid
     */
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must not be null and must be 20 characters or less.");
        }
        this.name = name;
    }

    /**
     * Gets the task description.
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the task description.
     * Validates that the description is not null and does not exceed 50 characters.
     * @param description the description to set
     * @throws IllegalArgumentException if the description is invalid
     */
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and must be 50 characters or less.");
        }
        this.description = description;
    }
}
