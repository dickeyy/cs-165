import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class IteratorTest {
    public static void main(String[] args) {
        Random r = new Random(678);
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(1000);
            list.add(num);
        }
        System.out.println("Testing add():");
        System.out.println(list);
        System.out.println("size:\texpected: 10 -> actual: " + list.size);
        if (list.size != 10) // exit if add/size doesn't work
            return;

        System.out.println("\nTesting getNode():");
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        System.out.println("item at index 0:\texpected: 3 -> actual: " + list2.getNode(0).data);
        System.out.println("item at index 1:\texpected: 4 -> actual: " + list2.getNode(1).data);
        System.out.println("item at index 2:\texpected: 5 -> actual: " + list2.getNode(2).data);

        // Iterator Test Code
        System.out.println("\nTesting Iterator: ");
        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("size: " + list.size);
        System.out.println("next Index: " + iter.nextIndex());
        try {
            iter.next();
        } catch (NoSuchElementException e) {
            System.err.println("You threw the correct error!");
        } catch (Exception e) {
            System.err.println("You throw the wrong type of Error. Make sure it is a NoSuchElementException.");
        }
    }
}