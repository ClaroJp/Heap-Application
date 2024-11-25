import java.util.PriorityQueue;
import java.util.Scanner;

public class ClaroHeap {
    static class Task implements Comparable<Task> {
        String description;
        int priority;

        public Task(String description, int priority) {
            this.description = description;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.priority, other.priority);
        }

        @Override
        public String toString() {
            return "Task: " + description + " (Priority: " + priority + ")";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Task> taskHeap = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Task Priority Manager ===");
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Next Task");
            System.out.println("3. Complete Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter task priority (lower is higher priority): ");
                    int priority = scanner.nextInt();
                    taskHeap.add(new Task(description, priority));
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    if (taskHeap.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("Next Task: " + taskHeap.peek());
                    }
                    break;
                case 3:
                    if (taskHeap.isEmpty()) {
                        System.out.println("No tasks to complete.");
                    } else {
                        System.out.println("Completed Task: " + taskHeap.poll());
                    }
                    break;
                case 4:
                    if (taskHeap.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("All Tasks:");
                        for (Task task : taskHeap) {
                            System.out.println(task);
                        }
                    }
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting Task Priority Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
