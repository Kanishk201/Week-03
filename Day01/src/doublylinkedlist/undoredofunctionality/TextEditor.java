package doublylinkedlist.undoredofunctionality;

class TextEditor {
    private TextState head;
    private TextState tail;
    private TextState current;
    private int count;
    private final int maxSize;

    public TextEditor(int maxSize) {
        this.maxSize = maxSize;
    }

    // Add a new text state
    public void addState(String content) {
        TextState newState = new TextState(content);
        if (current != null && current.next != null) {
            current.next = null;
            tail = current;
        }
        if (tail == null) {
            head = tail = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
        }
        current = tail;
        count++;

        // Maintain size limit
        if (count > maxSize) {
            head = head.next;
            head.prev = null;
            count--;
        }
    }

    // Undo functionality
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.content);
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    // Redo functionality
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.content);
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    // Display the current state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No current state available.");
        }
    }
}
