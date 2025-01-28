package circularlinkedlist.roundrobinscheduling;

class CircularLinkedList {
    private Process head = null;

    // Add a new process to the circular linked list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    // Remove a process by Process ID after its execution
    public void removeProcess(int processId) {
        if (head == null) {
            return;
        }
        Process temp = head;
        Process prev = null;
        do {
            if (temp.processId == processId) {
                if (prev != null) {
                    prev.next = temp.next;
                } else {
                    if (temp.next == head) {
                        head = null;
                    } else {
                        Process last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = temp.next;
                        last.next = head;
                    }
                }
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Display the current state of the circular linked list (queue)
    public void displayList() {
        if (head == null) {
            System.out.println("No processes in the list.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime +
                    ", Remaining Time: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
        System.out.println("--------------------------");
    }

    // Get the head process (first process in the circular list)
    public Process getHead() {
        return head;
    }

    // Set the head process
    public void setHead(Process head) {
        this.head = head;
    }
}

// RoundRobinScheduler class to handle the round-robin scheduling algorithm
class RoundRobinScheduler {
    private CircularLinkedList queue;
    private int timeQuantum;

    public RoundRobinScheduler(CircularLinkedList queue, int timeQuantum) {
        this.queue = queue;
        this.timeQuantum = timeQuantum;
    }

    // Simulate the round-robin scheduling
    public void roundRobinScheduling() {
        if (queue.getHead() == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int processCount = 0;
        Process temp = queue.getHead();

        // Calculate the total waiting time and total turnaround time
        do {
            processCount++;
            totalWaitingTime += temp.burstTime - temp.remainingTime;
            totalTurnaroundTime += temp.burstTime;
            temp = temp.next;
        } while (temp != queue.getHead());

        temp = queue.getHead();
        int round = 1;
        while (processCount > 0) {
            System.out.println("Round " + round++);
            if (temp.remainingTime > 0) {
                if (temp.remainingTime > timeQuantum) {
                    temp.remainingTime -= timeQuantum;
                } else {
                    timeQuantum = temp.remainingTime;
                    temp.remainingTime = 0;
                    queue.removeProcess(temp.processId);
                    processCount--;
                }
            }
            queue.displayList();
            temp = temp.next;
        }

        // Calculate and display the average waiting time and turnaround time
        double avgWaitingTime = (double) totalWaitingTime / processCount;
        double avgTurnaroundTime = (double) totalTurnaroundTime / processCount;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
}
