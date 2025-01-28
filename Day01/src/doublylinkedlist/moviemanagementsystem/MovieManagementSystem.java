package doublylinkedlist.moviemanagementsystem;

class MovieManagementSystem {
    Movie head;
    Movie tail;

    public MovieManagementSystem() {
        head = null;
        tail = null;
    }

    // Add a movie at the beginning
    public void addAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie at the end
    public void addAtEnd(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie at a specific position
    public void addAtPosition(String title, String director, int yearOfRelease, double rating, int position) {
        if (position <= 1) {
            addAtBeginning(title, director, yearOfRelease, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        Movie current = head;
        int index = 1;

        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null) {
            addAtEnd(title, director, yearOfRelease, rating);
        } else {
            newMovie.next = current.next;
            if (current.next != null) {
                current.next.prev = newMovie;
            } else {
                tail = newMovie; // Update tail if adding at the end
            }
            current.next = newMovie;
            newMovie.prev = current;
        }
    }

    // Remove a movie by title
    public void removeByTitle(String title) {
        Movie current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; // Update head if the first node is removed
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; // Update tail if the last node is removed
                }
                System.out.println("Movie removed: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found: " + title);
    }

    // Search for a movie by director
    public void searchByDirector(String director) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                System.out.println("Found Movie: " + current.title + " (" + current.yearOfRelease + "), Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found by director: " + director);
        }
    }

    // Search for a movie by rating
    public void searchByRating(double rating) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Found Movie: " + current.title + " (" + current.yearOfRelease + "), Director: " + current.director);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    // Display all movies in forward order
    public void displayForward() {
        Movie current = head;
        System.out.println("Movies in forward order:");
        while (current != null) {
            System.out.println(current.title + " (" + current.yearOfRelease + "), Director: " + current.director + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movies in reverse order
    public void displayReverse() {
        Movie current = tail;
        System.out.println("Movies in reverse order:");
        while (current != null) {
            System.out.println(current.title + " (" + current.yearOfRelease + "), Director: " + current.director + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Update a movie's rating by title
    public void updateRating(String title, double newRating) {
        Movie current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Updated rating for movie: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found: " + title);
    }
}
