package circularlinkedlist.taskscheduler;

public class CircularTaskScheduler {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTaskAtEnd(1, "Task 1", 3, "2025-02-01");
        scheduler.addTaskAtEnd(2, "Task 2", 1, "2025-02-02");
        scheduler.addTaskAtBeginning(3, "Task 3", 2, "2025-01-31");
        scheduler.addTaskAtPosition(4, "Task 4", 5, "2025-02-05", 2);

        scheduler.displayAllTasks();

        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        scheduler.searchTaskByPriority(2);

        scheduler.removeTaskByID(3);
        scheduler.displayAllTasks();
    }
}

