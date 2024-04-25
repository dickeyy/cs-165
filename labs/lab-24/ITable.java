import java.util.ArrayList;
import java.util.List;

public interface ITable {
    /**TODO - Complete This Function
     * This function should insert the key at the index given by the hash.
     * To do this:
     *
     * check to make sure that item is not already in the bucket. We don't want to insert a duplicate
     *
     * @param key - item to insert into the table
     * @return True if the item could be inserted or false if it is a duplicate
     */
    public boolean insert(String key);

    /**
     * This method should return the string or null if there is no matching element
     *
     * @param key
     * @return
     */
    public boolean search(String key);
}
