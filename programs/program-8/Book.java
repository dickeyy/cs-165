public class Book {

    private String bookTitle;
    private String bookAuthor;
    private long bookISBN;

    public Book() {
        bookTitle = "";
        bookAuthor = "";
        bookISBN = 0;
    }

    public Book(String userBookTitle, String userBookAuthor, long userBookISBN) {
        bookTitle = userBookTitle;
        bookAuthor = userBookAuthor;
        bookISBN = userBookISBN;
    }

    public long getBookISBN() {
        return bookISBN;
    }

    public void printInfo() {
        System.out.println("Title: " + bookTitle);
        System.out.println("Author: " + bookAuthor);
        System.out.println("ISBN: " + bookISBN);
    }
}