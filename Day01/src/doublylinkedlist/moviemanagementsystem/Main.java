package doublylinkedlist.moviemanagementsystem;

public class Main {
    public static void main(String[] args) {
        MovieManagementSystem movie = new MovieManagementSystem();

        // Adding movies
        movie.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movie.addAtEnd("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        movie.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movie.addAtPosition("The Dark Knight", "Christopher Nolan", 2008, 9.0, 2);

        // Display movies
        movie.displayForward();
        movie.displayReverse();

        // Search movies
        movie.searchByDirector("Christopher Nolan");
        movie.searchByRating(9.2);

        // Update movie rating
        movie.updateRating("Inception", 9.0);
        movie.displayForward();

        // Remove a movie
        movie.removeByTitle("The Godfather");
        movie.displayForward();
    }
}
