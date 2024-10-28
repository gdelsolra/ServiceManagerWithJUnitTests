package com.example.projectonecs320.taskservice;

import java.util.HashMap;
import java.util.Map;

/**
 * TaskService provides methods to manage tasks, including adding, retrieving,
 * and updating task properties such as description.
 */
public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a task to the service.
     *
     * @param task the task to be added
     * @throws IllegalArgumentException if a task with the same ID already exists
     */
    public void addTask(Task task) {
        // Check if a task with the same ID already exists
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID must be unique");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Retrieves a task by its ID.
     *
     * @param taskId the ID of the task to retrieve
     * @return the task associated with the given ID, or null if no such task exists
     */
    public Task getTaskById(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Deletes a task by its ID.
     *
     * @param taskId the ID of the task to delete
     * @return true if the task was deleted, false otherwise
     */
    public boolean deleteTask(String taskId) {
        return tasks.remove(taskId) != null;
    }

    /**
     * Updates the description of a task.
     *
     * @param taskId the ID of the task to update
     * @param newDescription the new description of the task
     * @throws IllegalArgumentException if the task is not found or if the new description is invalid
     */
    public void updateTaskDescription(String taskId, String newDescription) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found");
        }
        task.setDescription(newDescription);
    }

    /**
     * Updates the name of a task.
     *
     * @param taskId the ID of the task to update
     * @param newName the new name of the task
     * @throws IllegalArgumentException if the task is not found or if the new name is invalid
     */
    public void updateTaskName(String taskId, String newName) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found");
        }
        task.setName(newName);
    }
}

