/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager;

import java.util.ArrayList;
import java.util.regex.*;
import javax.swing.*;

/**
 *
 * @author lab_services_student
 */
public class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    // Constructor to initialize a Task instance
    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = generateTaskID(); // Generate task ID automatically
         // Generate task ID
       
    }

    /**
     * Generates a unique Task ID based on the task name, task number, and
     * developer details.
     * 
     * @return A string representing the unique task ID.
     */
    private String generateTaskID() {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + 
               developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }

    // Getters and Setters
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public void setDeveloperDetails(String developerDetails) {
        this.developerDetails = developerDetails;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * Returns a string representation of the task, formatted for easy reading.
     * 
     * @return A string containing task details.
     */
    @Override
    public String toString() {
        return "Task Name: " + taskName +
               "\nTask Number: " + taskNumber +
               "\nTask Description: " + taskDescription +
               "\nDeveloper Details: " + developerDetails +
               "\nTask Duration: " + taskDuration + " hours" +
               "\nTask ID: " + taskID +
               "\nTask Status: " + taskStatus;
    }
}
