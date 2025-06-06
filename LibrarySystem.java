import java.util.ArrayList;
import java.util.Scanner;

// Book class to store book details
class Book {
    String title;
    String author;
    String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}

// Main Library System class
public class LibrarySystem {
    static ArrayList<Book> library = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n==== Library Menu ====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Search Book by Author");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> searchByTitle();
                case 4 -> searchByAuthor();
                case 5 -> System.out.println("Exiting Library System...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    // Add a new book to the library
    static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        library.add(new Book(title, author, isbn));
        System.out.println("Book added successfully!");
    }

    // View all books in the library
    static void viewBooks() {
        if (library.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("\nBooks in Library:");
        for (Book b : library) {
            System.out.println("Title: " + b.title + ", Author: " + b.author + ", ISBN: " + b.isbn);
        }
    }

    // Search for a book by title
    static void searchByTitle() {
        System.out.print("Enter book title to search: ");
        String searchTitle = scanner.nextLine();
        boolean found = false;

        for (Book b : library) {
            if (b.title.equalsIgnoreCase(searchTitle)) {
                System.out.println("Found - Title: " + b.title + ", Author: " + b.author + ", ISBN: " + b.isbn);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found by title.");
        }
    }

    // Search for a book by author
    static void searchByAuthor() {
        System.out.print("Enter author name to search: ");
        String searchAuthor = scanner.nextLine();
        boolean found = false;

        for (Book b : library) {
            if (b.author.equalsIgnoreCase(searchAuthor)) {
                System.out.println("Found - Title: " + b.title + ", Author: " + b.author + ", ISBN: " + b.isbn);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found by author.");
        }
    }
}
