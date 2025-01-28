package circularlinkedlist.roundrobinscheduling;

public class Main {
    public static void main(String[] args) {
        // Create circular linked list and add processes
        CircularLinkedList queue = new CircularLinkedList();
        queue.addProcess(1, 10, 3);
        queue.addProcess(2, 5, 1);
        queue.addProcess(3, 8, 2);
        queue.addProcess(4, 6, 4);

        // Create a RoundRobinScheduler and run the simulation with a time quantum
        int timeQuantum = 4;
        RoundRobinScheduler scheduler = new RoundRobinScheduler(queue, timeQuantum);
        scheduler.roundRobinScheduling();
    }
}
