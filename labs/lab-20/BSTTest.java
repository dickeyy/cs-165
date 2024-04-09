/* BSTtest class
 *  Made by Toby Patterson for CS165 at CSU
 *  6/25/2020
 *  Some tests for the Binary Tree Traversals lab. */

public class BSTTest {

    public static void main(String[] args) {
        Integer[] bst1Arr = { 30, 22, 10, 25, 232 };
        BST bsTree1 = new BST(bst1Arr);

        System.out.print("inorder, postorder, preorder for bsTree1: \n");
        System.out.println("inorder should be: \n10 22 25 30 232");
        bsTree1.inorder();
        System.out.println();
        System.out.println("postorder should be: \n10 25 22 232 30");
        bsTree1.postorder();
        System.out.println();
        System.out.println("preorder should be: \n30 22 10 25 232");
        bsTree1.preorder();
        System.out.println("\n");

        Integer[] bst2Arr = { 50, 112, 20, 30, 2, 6, 53 };
        BST bsTree2 = new BST(bst2Arr);
        System.out.print("inorder, postorder, preorder for bsTree2: \n");
        System.out.println("inorder should be: \n2 6 20 30 50 53 112");
        bsTree2.inorder();
        System.out.println();
        System.out.println("postorder should be: \n6 2 30 20 53 112 50");
        bsTree2.postorder();
        System.out.println();
        System.out.println("preorder should be: \n50 20 2 6 30 112 53");
        bsTree2.preorder();
        System.out.println("\n");

        System.out.println("Testing Search");
        System.out.println("bsTree1(30) should be true -> " + bsTree1.search(30));
        System.out.println("bsTree1(11033) should be false-> " + bsTree1.search(11033));
        System.out.println("bsTree2(50) should be true -> " + bsTree2.search(50));
        System.out.println("bsTree2(3) should be false -> " + bsTree2.search(3));
    }
}
