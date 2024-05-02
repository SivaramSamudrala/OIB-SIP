package oibsip_task5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

// Book class to represent individual books
class Digital_Libary_Management {
    private String title;
    private String author;
    private String category;
    private int quantity;

    public Book(String title, String author, String category, int quantity) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// User class to represent individual library users
class User {
    private String name;
    private String email;
    private int memberId;

    public User(String name, String email, int memberId) {
        this.name = name;
        this.email = email;
        this.memberId = memberId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getMemberId() {
        return memberId;
    }
}

// Library class to manage books and users
public class Library {
    private static HashMap<String, Book> books = new HashMap<>();
    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Admin module functions
    public static void adminModule() {
        // Add books to the library
        System.out.println("Admin Module - Add Books");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        books.put(title, new Book(title, author, category, quantity));
        System.out.println("Book added successfully!");
    }

    // User module functions
    public static void userModule() {
        // Display available books
        System.out.println("User Module - View Books");
        for (Book book : books.values()) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " (" + book.getCategory() + ") - Available: " + book.getQuantity());
        }
    }

    public static void main(String[] args) {
        // Sample data - books and users
        books.put("Java Programming", new Book("Java Programming", "John Smith", "Programming", 5));
        books.put("Python Basics", new Book("Python Basics", "Alice Johnson", "Programming", 3));
        users.add(new User("John Doe", "john.doe@example.com", 1001));
        users.add(new User("Alice Smith", "alice.smith@example.com", 1002));

        // Main menu
        System.out.println("Welcome to the Digital Library Management System");
        System.out.println("1. Admin Module");
        System.out.println("2. User Module");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                adminModule();
                break;
            case 2:
                userModule();
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
        }
    }
}
