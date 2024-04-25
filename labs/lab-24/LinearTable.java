public class LinearTable implements ITable {

    String[] table;
    int numItems;

    public LinearTable(int numSlots) {
        table = new String[numSlots];
        this.numItems = 0;
    }

    /**
     * TODO - Complete This Function
     * This function should insert the key at the index given by the hash.
     * To do this:
     * Before anything check if the table is full meaning that all slots are full. if it's full return false.
     * 1. get the hash of the key using hash() and calculate the index using modulo
     * 2. check if the slot in table is empty and if so insert also make sure to check for duplicates at all steps.
     * 3. if the slot at hash(key) is full then try the slot at index = (hash() + 1) % numSlots
     * 4. repeat step 3 until you find an empty slot
     * 5. if the insert is successful return true and increment the numItems.
     *
     * check to make sure that item is not already in the bucket. We don't want to insert a duplicate.
     *
     * @param key - item to insert into the table
     * @return True if the item could be inserted or false if it is a duplicate
     */
    @Override
    public boolean insert(String key) {
        if (numItems == table.length) {
            return false;
        }

        int index = hash(key) % table.length;
        int i = 1;

        while (table[index] != null) {
            if (table[index].equals(key)) {
                return false;
            }
            index = (hash(key) + i) % table.length;
            i++;
            if (index == hash(key) % table.length) {
                return false;
            }
        }

        table[index] = key;
        numItems++;

        return true;
    }

    /**
     * This method should return the string or null if there is no matching element
     * To do this:
     * 1. calculate the hash and then the index using modulo
     * 2. if the key is not in that spot AND that spot is full then
     * use linear probing as described in the insert method to search for it
     * 3. when you are probing if you find an empty slot you know that the key cannot possibly be in the rest of the
     * table so you may return false and if reach the index you first calculated then you also know that the key is not
     * in the table.
     * @param key
     * @return
     */
    @Override
    public boolean search(String key) {
        int index = hash(key) % table.length;
        int i = 1;

        while (table[index] != null) {
            if (table[index].equals(key)) {
                return true;
            }
            index = (hash(key) + i) % table.length;
            i++;
            if (index == hash(key) % table.length) {
                return false;
            }
        }

        return false;
    }

    /**
     * a hash function which simply uses Java's built in function for hashing strings.
     * @param key
     * @return
     */
    public int hash(String key) {
        return Math.abs(key.hashCode());
    }

    /**
     * Should return a string representation of the table like:
     * slot 1: item or list of items
     * slot 2: item or list of items
     * ...
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            ret.append(String.format("Bucket %d: %s\n", i, table[i]));
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        /* Table tests */
        String[] names = {
            "Liam",
            "Noah",
            "William",
            "James",
            "Oliver",
            "Benjamin",
            "Charlotte",
            "Mia",
            "Evelyn",
            "Harper",
            "Lucas",
            "Mason",
            "Lucas"
        };
        LinearTable table = new LinearTable(names.length - 2);
        for (String name : names) {
            table.insert(name);
        }
        System.out.println(table);
        /* search() tests */
        String name = "Liam";
        boolean search = table.search(name);
        System.out.printf("Testing search(%s)...\n", name);
        if (!search) {
            System.out.print("FAILURE -> ");
        } else {
            System.out.print("PASSED -> ");
        }
        System.out.printf("Expected: %b, Actual: %b\n", true, search);

        String name2 = "Joshua";
        boolean search2 = table.search(name2);
        System.out.printf("Testing search(%s)...\n", name2);
        if (search2) {
            System.out.print("FAILURE -> ");
        } else {
            System.out.print("PASSED -> ");
        }
        System.out.printf("Expected: %b, Actual: %b\n", false, search2);
    }
}
