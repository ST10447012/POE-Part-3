/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskpoe;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author RC_Student_lab
 */
public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        JOptionPane.showMessageDialog(null, "Task '" + task.getTaskName() + "' added successfully!");
    }

    public Task searchTaskByName(String taskName) {
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                return task;
            }
        }
        return null;
    }

    public boolean deleteTask(String taskName) {
        Task task = searchTaskByName(taskName);
        if (task != null) {
            tasks.remove(task);
            JOptionPane.showMessageDialog(null, "Task '" + taskName + "' deleted successfully!");
            return true;
        }
        return false;
    }

    public void displayAllTasks() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        StringBuilder output = new StringBuilder("All Tasks:\n");
        for (Task task : tasks) {
            output.append(task).append("\n");
        }
        JOptionPane.showMessageDialog(null, output.toString());
    }
}
