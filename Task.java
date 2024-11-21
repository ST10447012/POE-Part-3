/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskpoe;

/**
 *
 * @author RC_Student_lab
 */
public class Task {
    private String developer;
    private String taskName;
    private int taskDuration;
    private String taskStatus;

    public Task(String developer, String taskName, int taskDuration, String taskStatus) {
        this.developer = developer;
        this.taskName = taskName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    @Override
    public String toString() {
        return "Developer: " + developer +
               ", Task Name: " + taskName +
               ", Duration: " + taskDuration + " hours" +
               ", Status: " + taskStatus;
    }
}
