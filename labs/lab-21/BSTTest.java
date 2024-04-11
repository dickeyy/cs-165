/* BSTTest class
 *  Some tests for the Binary Tree of <extends Comparable> lab. */

public class BSTTest {

    public static void main(String[] args) {
        Integer[] bst1Arr = { 50, 112, 20, 30, 2, 6, 53 };
        BST<Integer> bsTree1 = new BST<>(bst1Arr);
        System.out.print("inorder, postorder, preorder for bsTree1: \n");
        System.out.println("inorder should be 2 6 20 30 50 53 112 ->");
        System.out.print("Your result: ");
        bsTree1.inorder();
        System.out.println();
        System.out.println("postorder should be 6 2 30 20 53 112 50 ->");
        System.out.print("Your result: ");
        bsTree1.postorder();
        System.out.println();
        System.out.println("preorder should be 50 20 2 6 30 112 53 ->");
        System.out.print("Your result: ");
        bsTree1.preorder();
        System.out.println("\n");

        String[] bst2Arr = { "hello", "I", "Am", "here" };
        BST<String> bsTree2 = new BST<>(bst2Arr);
        System.out.print("inorder, postorder, preorder for bsTree2: \n");
        System.out.println("inorder should be Am I hello here ->");
        System.out.print("Your result: ");
        bsTree2.inorder();
        System.out.println();
        System.out.println("postorder should be Am I here hello ->");
        System.out.print("Your result: ");
        bsTree2.postorder();
        System.out.println();
        System.out.println("preorder should be hello I Am here ->");
        System.out.print("Your result: ");
        bsTree2.preorder();
        System.out.println("\n");

        System.out.println("Testing Search");
        System.out.println("bsTree1(50) should be true -> " + bsTree1.search(50));
        System.out.println("bsTree1(112) should be true -> " + bsTree1.search(112));
        System.out.println("bsTree1(3) should be false -> " + bsTree1.search(3));
        System.out.println("bsTree2(\"hello\") should be true -> " + bsTree2.search("hello"));
        System.out.println("bsTree2(\"I\") should be true -> " + bsTree2.search("I"));
        System.out.println(
            "bsTree2(\"explosion\") should be false -> " + bsTree2.search("explosion")
        );
        System.out.println();

        /* Test Code for remove is going to be dependent on implementation.
         * For this lab, you will swap the node to be deleted with its inorder successor.
         */

        System.out.println("Testing Remove");
        System.out.println(
            "inorder after calling bsTree2.remove(\"hello\") should be Am I here ->"
        );
        bsTree2.remove("hello");
        System.out.print("Your result: ");
        bsTree2.inorder();
        System.out.println('\n');

        System.out.println("root of bsTree2 after bsTree2.remove(\"hello\") should be here -> ");
        System.out.println("Your result: " + bsTree2.getRoot().element);
        System.out.println();

        System.out.println("inorder after calling bsTree2.remove(\"I\") should be Am here ->");
        bsTree2.remove("I");
        System.out.print("Your result: ");
        bsTree2.inorder();
        System.out.println("\n");

        System.out.println("inorder after calling bsTree2.remove(\"Am\") should be here ->");
        bsTree2.remove("Am");
        System.out.print("Your result: ");
        bsTree2.inorder();
        System.out.println("\n");
    }
}
