class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}


class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

}

public class TaskLinkedList {
    private Node head;

    public TaskLinkedList() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public boolean deleteTask(int taskId) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.task.taskId == taskId) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    head = current.next;
                }
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task.taskName);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(1, "Task 1", "Pending"));
        taskList.addTask(new Task(2, "Task 2", "In Progress"));
        taskList.addTask(new Task(3, "Task 3", "Completed"));

        System.out.println("All tasks:");
        taskList.traverseTasks();

        System.out.println("Searching for task with ID 2:");
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found");
        }

        System.out.println("Deleting task with ID 2:");
        boolean isDeleted = taskList.deleteTask(2);
        if (isDeleted) {
            System.out.println("Task deleted");
        } else {
            System.out.println("Task not found");
        }

        System.out.println("All tasks after deletion:");
        taskList.traverseTasks();
    }
}
