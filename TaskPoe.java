/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taskpoe;
import javax.swing.*;
/**
 *
 * @author RC_Student_lab
 */
public class TaskPoe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   TaskManager taskManager = new TaskManager();

        while (true) {
            String menu = """
                    Select an option:
                    1. Add Task
                    2. Search Task by Name
                    3. Delete Task
                    4. Display All Tasks
                    5. Exit
                    """;

            String choice = JOptionPane.showInputDialog(menu);

            if (choice == null || choice.equals("5")) {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                break;
            }

            switch (choice) {
                case "1" -> {
                    String developer = JOptionPane.showInputDialog("Enter Developer Name:");
                    if (developer == null || developer.isBlank()) break;

                    String taskName = JOptionPane.showInputDialog("Enter Task Name:");
                    if (taskName == null || taskName.isBlank()) break;

                    int taskDuration;
                    try {
                        taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid duration. Please enter a number.");
                        break;
                    }

                    String taskStatus = JOptionPane.showInputDialog("Enter Task Status (e.g., To Do, Doing, Done):");
                    if (taskStatus == null || taskStatus.isBlank()) break;

                    taskManager.addTask(new Task(developer, taskName, taskDuration, taskStatus));
                }
                case "2" -> {
                    String taskName = JOptionPane.showInputDialog("Enter Task Name to Search:");
                    if (taskName == null || taskName.isBlank()) break;

                    Task task = taskManager.searchTaskByName(taskName);
                    if (task != null) {
                        JOptionPane.showMessageDialog(null, "Task Found:\n" + task);
                    } else {
                        JOptionPane.showMessageDialog(null, "Task not found!");
                    }
                }
                case "3" -> {
                    String taskName = JOptionPane.showInputDialog("Enter Task Name to Delete:");
                    if (taskName == null || taskName.isBlank()) break;

                    if (!taskManager.deleteTask(taskName)) {
                        JOptionPane.showMessageDialog(null, "Task not found!");
                    }
                }
                case "4" -> taskManager.displayAllTasks();
                default -> JOptionPane.showMessageDialog(null, "Invalid option!");
            }
        }
    }
}
