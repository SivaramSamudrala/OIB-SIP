package oibsip_task5;
import java.util.*;

class Digital_Library_Management {
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

class User {
    private String name;
    private String email;
    private int memberId;

    public User(String name, String email, int memberId) {
        this.name = name;
        this.email = email;
        this.memberId = memberId;
    }

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

class Library {
    private HashMap<String, Book> books;
    private ArrayList<User> users;

    public Library() {
        this.books = new HashMap<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }

    public void removeBook(String title) {
        books.remove(title);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public HashMap<String, Book> getBooks() {
        return books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}

public class LibraryManagementSystem {
    private static Library library;
    private static Scanner scanner;

    public static void adminModule() {
        System.out.println("Admin Module");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. View All Books");
        System.out.println("4. Exit Admin Module");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                removeBook();
                break;
            case 3:
                viewAllBooks();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice");
        }

        adminModule(); // Recursive call to keep admin module running
    }

    public static void addBook() {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter author:");
        String author = scanner.nextLine();
        System.out.println("Enter category:");
        String category = scanner.nextLine();
        System.out.println("Enter quantity:");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Book book = new Book(title, author, category, quantity);
        library.addBook(book);
        System.out.println("Book added successfully!");
    }

    public static void removeBook() {
        System.out.println("Enter title of the book to remove:");
        String title = scanner.nextLine();
        library.removeBook(title);
        System.out.println("Book removed successfully!");
    }

    public static void viewAllBooks() {
        System.out.println("All Books:");
        for (Book book : library.getBooks().values()) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Category: " + book.getCategory() + ", Quantity: " + book.getQuantity());
        }
    }

    public static void main(String[] args) {
        library = new Library();
        scanner = new Scanner(System.in);

        // Sample data - books and users
        library.addBook(new Book("Java Programming", "John Smith", "Programming", 5));
        library.addBook(new Book("Python Basics", "Alice Johnson", "Programming", 3));

        System.out.println("Welcome to the Digital Library Management System");
        System.out.println("1. Admin Module");
        System.out.println("2. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                adminModule();
                break;
            case 2:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
