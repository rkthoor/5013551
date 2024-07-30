import java.util.*;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class Library {
    public static Book linearSearch(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(List<Book> books, String title) {
        int low = 0, high = books.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Book midBook = books.get(mid);
            int comparison = midBook.getTitle().compareTo(title);
            if (comparison == 0) {
                return midBook;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(3, "1984", "George Orwell"));
        books.add(new Book(4, "Pride and Prejudice", "Jane Austen"));
        books.add(new Book(5, "The Catcher in the Rye", "J.D. Salinger"));

        // Linear search example
        Book foundBook = Library.linearSearch(books, "1984");
        System.out.println("Linear Search Result: " + foundBook.getTitle());

        // Sorting books by title for binary search
        Collections.sort(books, Comparator.comparing(Book::getTitle));

        // Binary search example
        foundBook = Library.binarySearch(books, "1984");
        System.out.println("Binary Search Result: " + foundBook.getTitle());
    }
}
