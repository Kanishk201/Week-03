package circularlinkedlist.taskscheduler;

class TaskScheduler {
    private Task head;
    private Task tail;

    // Add a task at the beginning
    public void addTaskAtBeginning(int taskID, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // Add a task at the end
    public void addTaskAtEnd(int taskID, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    // Add a task at a specific position
    public void addTaskAtPosition(int taskID, String taskName, int priority, String dueDate, int position) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (position == 1) {
            addTaskAtBeginning(taskID, taskName, priority, dueDate);
            return;
        }
        Task current = head;
        int count = 1;
        while (current.next != head && count < position - 1) {
            current = current.next;
            count++;
        }
        if (count == position - 1) {
            newTask.next = current.next;
            current.next = newTask;
            if (current == tail) {
                tail = newTask;
                tail.next = head;
            }
        } else {
            System.out.println("Position out of bounds.");
        }
    }

    // Remove a task by Task ID
    public void removeTaskByID(int taskID) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        Task current = head;
        Task prev = tail;
        do {
            if (current.taskID == taskID) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                System.out.println("Task with ID " + taskID + " removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Task with ID " + taskID + " not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        System.out.println("Current Task: " + head.taskName + " [ID: " + head.taskID + ", Priority: " + head.priority + ", Due Date: " + head.dueDate + "]");
        head = head.next;
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        Task current = head;
        System.out.println("All Tasks:");
        do {
            System.out.println("Task ID: " + current.taskID + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for tasks by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        Task current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                System.out.println("Task ID: " + current.taskID + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }
}

