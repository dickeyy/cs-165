import java.util.ArrayList;

public class ArrayListLibrary {
    // ArraryList library
    public ArrayList<Book> library;

    public ArrayListLibrary() {
        library = new ArrayList<Book>();
    }

    public int insertSorted(Book newBook, int counter) {
        Book currBook;

        // Add an empty element at end of list
        library.add(null);

        // Loop through elements starting at the end
        for (int i = library.size() - 2; i >= 0; --i) {
            currBook = library.get(i);

            // If the current book's ISBN is larger than newBook's ISBN, shift
            // the current book down 1, count shift operation
            if (currBook.getBookISBN() > newBook.getBookISBN()) {
                library.set(i + 1, currBook);
                ++counter;
            }

            // Otherwise, place newBook at the next location (empty slot),
            // count insert operation
            else {
                library.set(i + 1, newBook);
                ++counter;
                return counter;
            }
        }

        // If we get to the top of the list, place newBook on top
        library.set(0, newBook);
        ++counter;

        return counter;
    }

    public void printLibrary() {
        for (int i = 0; i < library.size(); ++i) {
            library.get(i).printInfo();
            System.out.println();
        }
    }
}