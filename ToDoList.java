import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- ToDo List ---");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    deleteTask(scanner);
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    markAsComplete(scanner);
                    break;
                case 5:
                    System.out.println("Exiting ToDo List. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter the task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("Enter the task number to delete: ");
        int taskNumber = scanner.nextInt();

        if (isValidTaskNumber(taskNumber)) {
            String deletedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task deleted: " + deletedTask);
        } else {
            System.out.println("Invalid task number. Please enter a valid task number.");
        }
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void markAsComplete(Scanner scanner) {
        System.out.print("Enter the task number to mark as complete: ");
        int taskNumber = scanner.nextInt();

        if (isValidTaskNumber(taskNumber)) {
            String completedTask = tasks.get(taskNumber - 1);
            System.out.println("Task marked as complete: " + completedTask);
            // You can add additional logic here to handle completed tasks if needed.
        } else {
            System.out.println("Invalid task number. Please enter a valid task number.");
        }
    }

    private static boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 1 && taskNumber <= tasks.size();
    }
}
