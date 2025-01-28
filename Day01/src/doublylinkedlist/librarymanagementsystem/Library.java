package doublylinkedlist.librarymanagementsystem;

class Library {
    private Book head;
    private Book tail;
    private int count;

    // Add a new book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }

    // Add a new book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    // Add a new book at a specific position
    public void addBookAtPosition(String title, String author, String genre, int bookID, boolean isAvailable, int position) {
        if (position < 1 || position > count + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addBookAtBeginning(title, author, genre, bookID, isAvailable);
            return;
        }
        if (position == count + 1) {
            addBookAtEnd(title, author, genre, bookID, isAvailable);
            return;
        }
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        Book current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        newBook.next = current.next;
        newBook.prev = current;
        if (current.next != null) current.next.prev = newBook;
        current.next = newBook;
        count++;
    }

    // Remove a book by Book ID
    public void removeBookByID(int bookID) {
        Book current = head;
        while (current != null) {
            if (current.bookID == bookID) {
                if (current == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                count--;
                System.out.println("Book with ID " + bookID + " removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    // Search for a book by Title or Author
    public void searchBook(String query) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(query) || current.author.equalsIgnoreCase(query)) {
                System.out.println("Found: " + current.title + " by " + current.author);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No book found with the query: " + query);
    }

    // Update a book's Availability Status
    public void updateAvailabilityStatus(int bookID, boolean isAvailable) {
        Book current = head;
        while (current != null) {
            if (current.bookID == bookID) {
                current.isAvailable = isAvailable;
                System.out.println("Availability updated for Book ID: " + bookID);
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    // Display books in forward order
    public void displayBooksForward() {
        Book current = head;
        System.out.println("Books (Forward Order):");
        while (current != null) {
            System.out.println(current.title + " by " + current.author + " [ID: " + current.bookID + "] - " + (current.isAvailable ? "Available" : "Not Available"));
            current = current.next;
        }
    }

    // Display books in reverse order
    public void displayBooksReverse() {
        Book current = tail;
        System.out.println("Books (Reverse Order):");
        while (current != null) {
            System.out.println(current.title + " by " + current.author + " [ID: " + current.bookID + "] - " + (current.isAvailable ? "Available" : "Not Available"));
            current = current.prev;
        }
    }

    // Count total books
    public int countBooks() {
        return count;
    }
}
