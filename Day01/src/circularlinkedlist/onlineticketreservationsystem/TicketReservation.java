package circularlinkedlist.onlineticketreservationsystem;

public class TicketReservation {
    public static void main(String[] args) {
        // Create circular linked list to hold ticket reservations
        CircularLinkedList ticketList = new CircularLinkedList();

        // Adding some ticket reservations
        ticketList.addTicket(1, "Alice", "Avengers", "A1", "2025-01-28 18:00");
        ticketList.addTicket(2, "Bob", "Batman", "B2", "2025-01-28 19:00");
        ticketList.addTicket(3, "Charlie", "Avengers", "C3", "2025-01-28 20:00");
        ticketList.addTicket(4, "David", "Spiderman", "D4", "2025-01-28 21:00");

        // Display the current tickets in the list
        ticketList.displayTickets();

        // Search tickets by Customer Name or Movie Name
        ticketList.searchTicket("Alice"); // Search by Customer Name
        ticketList.searchTicket("Avengers"); // Search by Movie Name

        // Remove a ticket by Ticket ID
        ticketList.removeTicket(2); // Remove ticket with ID 2

        // Display the updated list after removal
        ticketList.displayTickets();

        // Calculate and display the total number of booked tickets
        ticketList.totalTicketsBooked();
    }
}
