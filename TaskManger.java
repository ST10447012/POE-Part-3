/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taskmanager;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.Collections;
import java.util.Comparator;        
import javax.swing.*;
/**
 *
 * @author lab_services_student
 */
public class TaskManager {
    // Data storage for tasks
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban", "EasyKanban", JOptionPane.INFORMATION_MESSAGE);

         while (true) {
        String menu = "Choose an action:\n";
        menu += "1. Add Task\n";
        menu += "2. Display Tasks (Status: Done)\n";
        menu += "3. Longest Task\n";
        menu += "4. Search Task\n";
        menu += "5. Search by Developer\n";
        menu += "6. Delete Task\n";
        menu += "7. Display All Tasks\n";
        menu += "8. Exit\n";

        String input = JOptionPane.showInputDialog(null, menu, "Main Menu", JOptionPane.QUESTION_MESSAGE);
        
        // If user clicks "Cancel" or enters nothing, exit the loop
        if (input == null || input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Exiting application. Goodbye!", "Exit", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            continue;
        }

        switch (choice) {
            case 1 -> addTask();
            case 2 -> displayTasksByStatus();
            case 3 -> displayLongestTask();
            case 4 -> searchTaskByName();
            case 5 -> searchTasksByDeveloper();
            case 6 -> deleteTask();
            case 7 -> displayAllTasks();
            case 8 -> {
                JOptionPane.showMessageDialog(null, "Exiting application. Goodbye!", "Exit", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    private static void addTask() {
        String developer = JOptionPane.showInputDialog(null, "Enter Developer Name:", "Add Task", JOptionPane.QUESTION_MESSAGE);
        if (developer == null || developer.isEmpty()) return;

        String taskName = JOptionPane.showInputDialog(null, "Enter Task Name:", "Add Task", JOptionPane.QUESTION_MESSAGE);
        if (taskName == null || taskName.isEmpty()) return;

        String durationInput = JOptionPane.showInputDialog(null, "Enter Task Duration (in hours):", "Add Task", JOptionPane.QUESTION_MESSAGE);
        if (durationInput == null || durationInput.isEmpty()) return;

        int duration;
        try {
            duration = Integer.parseInt(durationInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid duration. Task not added.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String status = JOptionPane.showInputDialog(null, "Enter Task Status (e.g., Pending, Done):", "Add Task", JOptionPane.QUESTION_MESSAGE);
        if (status == null || status.isEmpty()) return;

        String taskId = generateTaskID(taskName, tasks.size() + 1, developer);
       tasks.add(new Task(taskName, tasks.size() + 1, "Task Description", developer, duration, status)); 


        JOptionPane.showMessageDialog(null, "Task added successfully!\nTask ID: " + taskId, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void displayTasksByStatus() {
        StringBuilder result = new StringBuilder("Tasks with Status 'Done':\n");
        boolean found = false;

        for (Task task : tasks) {
            if ("Done".equalsIgnoreCase(task.getTaskStatus())) {
                result.append(task).append("\n");
                found = true;
            }
        }

        if (!found) result.append("No tasks found.");
        JOptionPane.showMessageDialog(null, result.toString(), "Tasks (Status: Done)", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void displayLongestTask() {
    if (tasks.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No tasks available.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Task longestTask = null;
    int maxDuration = -1;

    for (Task task : tasks) {
        if (task.getTaskDuration() > maxDuration) {
            maxDuration = task.getTaskDuration();
            longestTask = task;
        }
    }

    if (longestTask != null) {
        JOptionPane.showMessageDialog(null, "Task with Longest Duration:\n" + longestTask, "Longest Task", JOptionPane.INFORMATION_MESSAGE);
    }
}

    

    private static void searchTaskByName() {
        String taskName = JOptionPane.showInputDialog(null, "Enter Task Name to Search:", "Search Task", JOptionPane.QUESTION_MESSAGE);
        if (taskName == null || taskName.isEmpty()) return;

        StringBuilder result = new StringBuilder();
        boolean found = false;

        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                result.append(task).append("\n");
                found = true;
            }
        }

        if (!found) result.append("Task not found.");
        JOptionPane.showMessageDialog(null, result.toString(), "Search Task", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void searchTasksByDeveloper() {
        String developer = JOptionPane.showInputDialog(null, "Enter Developer Name to Search:", "Search by Developer", JOptionPane.QUESTION_MESSAGE);
        if (developer == null || developer.isEmpty()) return;

        StringBuilder result = new StringBuilder("Tasks for Developer " + developer + ":\n");
        boolean found = false;

        for (Task task : tasks) {
            if (task.getDeveloperDetails().equalsIgnoreCase(developer)) {
                result.append(task).append("\n");
                found = true;
            }
        }

        if (!found) result.append("No tasks found.");
        JOptionPane.showMessageDialog(null, result.toString(), "Search by Developer", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void deleteTask() {
        String taskName = JOptionPane.showInputDialog(null, "Enter Task Name to Delete:", "Delete Task", JOptionPane.QUESTION_MESSAGE);
        if (taskName == null || taskName.isEmpty()) return;

        boolean removed = tasks.removeIf(task -> task.getTaskName().equalsIgnoreCase(taskName));
        String message = removed ? "Task deleted successfully." : "Task not found.";
        JOptionPane.showMessageDialog(null, message, "Delete Task", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void displayAllTasks() {
        StringBuilder result = new StringBuilder("All Tasks:\n");
        if (tasks.isEmpty()) {
            result.append("No tasks available.");
        } else {
            for (Task task : tasks) {
                result.append(task).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, result.toString(), "All Tasks", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String generateTaskID(String taskName, int taskNumber, String developer) {
        return taskName.substring(0, 2).toUpperCase() + taskNumber + developer.substring(0, 2).toUpperCase();
    }
}
