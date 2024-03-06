public class BookNode {
    private String bookTitle;
    private String bookAuthor;
    private long bookISBN;
    private BookNode nextNodePtr; // Reference to the next node

    public BookNode() {
        bookTitle = "";
        bookAuthor = "";
        bookISBN = 0;
        nextNodePtr = null;
    }

    // Constructor
    public BookNode(String bookTitleInit, String bookAuthorInit, long bookISBNInit) {
        this.bookTitle = bookTitleInit;
        this.bookAuthor = bookAuthorInit;
        this.bookISBN = bookISBNInit;
        this.nextNodePtr = null;
    }

    // Constructor
    public BookNode(String bookTitleInit, String bookAuthorInit, long bookISBNInit, BookNode nextLoc) {
        this.bookTitle = bookTitleInit;
        this.bookAuthor = bookAuthorInit;
        this.bookISBN = bookISBNInit;
        this.nextNodePtr = nextLoc;
    }

    // insertAfter
    public void insertAfter(BookNode nodeLoc) {
        BookNode tmpNext;

        tmpNext = this.nextNodePtr;
        this.nextNodePtr = nodeLoc;
        nodeLoc.nextNodePtr = tmpNext;
    }

    // setNext
    public void setNext(BookNode nodeLoc) {
        this.nextNodePtr = nodeLoc;
    }

    // Get location pointed by nextNodePtr
    public BookNode getNext() {
        return this.nextNodePtr;
    }

    public long getBookISBN() {
        return this.bookISBN;
    }

    // Print book information
    public void printBookInfo() {
        System.out.println("Title: " + this.bookTitle);
        System.out.println("Author: " + this.bookAuthor);
        System.out.println("ISBN: " + this.bookISBN);
    }
}