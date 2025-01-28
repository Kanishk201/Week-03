package doublylinkedlist.librarymanagementsystem;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBookAtEnd("Book1", "Author1", "Fiction", 1, true);
        library.addBookAtEnd("Book2", "Author2", "Science", 2, false);
        library.addBookAtBeginning("Book3", "Author3", "History", 3, true);
        library.addBookAtPosition("Book4", "Author4", "Fiction", 4, true, 2);

        library.displayBooksForward();
        library.displayBooksReverse();

        library.searchBook("Author2");
        library.updateAvailabilityStatus(2, true);
        library.removeBookByID(3);

        library.displayBooksForward();
        System.out.println("Total Books: " + library.countBooks());
    }
}

