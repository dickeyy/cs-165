public class LLTest {
    public static void main(String args[]) {
        MyLinkedList<Integer> ll = new MyLinkedList<>();

        // Testing add methods
        System.out.println("Testing Add");
        ll.add(40);
        ll.add(10);
        ll.add(20);
        ll.add(1, 30);
        ll.add(3, 100);
        ll.add(65);
        ll.add(2);
        System.out.println("Expected: 40 30 10 100 20 65 2");
        System.out.println("Actual: " + ll);
        System.out.println();

        // Testing remove methods
        System.out.println("Testing Remove");
        ll.remove();
        ll.remove(2);
        ll.remove(3);
        ll.remove((Integer) 2);
        System.out.println("Expected: 30 10 20");
        System.out.println("Actual: " + ll);
        System.out.println("Size should be 3 -> " + ll.size());
        System.out.println();

        // Testing Contains
        System.out.println("Testing Contains");
        ll.add(2); // to make it a little bigger
        System.out.println("Should be true -> " + ll.contains(2));
        System.out.println("Should be false -> " + ll.contains(65));
        System.out.println("Should be true -> " + ll.contains(30));
        System.out.println();

        // Testing Get
        System.out.println("Testing Get");
        System.out.println("Actual list: " + ll);
        System.out.print("List using get: ");
        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " ");
        }
        System.out.println("\n");

        // Testing indexOf
        System.out.println("Testing indexOf");
        System.out.println("Should be 2 -> " + ll.indexOf(20));
        System.out.println("Should be 3 -> " + ll.indexOf(2));
        System.out.println("Should be -1 -> " + ll.indexOf(65));
        System.out.println();

        System.out.println("Testing Clear & isEmpty");
        ll.clear();
        System.out.println("Size should be 0 -> " + ll.size());
        System.out.println("Index of 2 should be -1 -> " + ll.indexOf(2));
        System.out.println("IsEmpty should return true -> " + ll.isEmpty());
        System.out.println();
        System.out.println("Adding in new Values");
        ll.add(3);
        ll.add(5);
        ll.add(6);
        System.out.println("Testing Index of After Clear");
        System.out.println("Should be -1 -> " + ll.indexOf(20));
        System.out.println("Should be 0 -> " + ll.indexOf(3));
        System.out.println("Should be 2 -> " + ll.indexOf(6));
        MyLinkedList<String> lls = new MyLinkedList<>();
        // I'd recommend testing your code to make sure it works

    }
}