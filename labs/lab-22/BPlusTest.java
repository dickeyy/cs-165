import java.util.*;
import java.util.Scanner;

public class BPlusTest {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int testNum = 0;

        if (scnr.hasNextInt()) {
            testNum = scnr.nextInt();
        } else {
            System.out.println("Enter a test number to run.");
        }

        if (testNum == 1) {
            BPlusTree bpt = new BPlusTree(5);

            bpt.insert(18);
            bpt.insert(23);
            bpt.insert(17);
            bpt.insert(2);

            bpt.insert(26);
            bpt.insert(5);
            bpt.insert(1);
            bpt.insert(8);

            bpt.insert(20);
            bpt.insert(4);
            bpt.insert(16);
            bpt.insert(10);

            bpt.insert(9);
            bpt.insert(0);
            bpt.insert(11);
            bpt.insert(15);

            bpt.insert(19);
            bpt.insert(13);
            bpt.insert(7);
            bpt.insert(25);

            System.out.println(bpt);
        }
        if (testNum == 2) {
            BPlusTree bpt2 = new BPlusTree(5);

            bpt2.insert(19);
            bpt2.insert(24);
            bpt2.insert(18);
            bpt2.insert(3);
            bpt2.insert(25);
            bpt2.insert(6);
            bpt2.insert(2);
            bpt2.insert(9);
            bpt2.insert(21);
            bpt2.insert(5);
            bpt2.insert(17);
            bpt2.insert(11);
            bpt2.insert(10);
            bpt2.insert(1);
            bpt2.insert(12);
            bpt2.insert(16);
            bpt2.insert(20);
            bpt2.insert(14);
            bpt2.insert(8);
            bpt2.insert(26);
            bpt2.insert(35);
            bpt2.insert(40);
            bpt2.insert(7);

            System.out.println(bpt2);
        }
        if (testNum == 3) {
            BPlusTree bpt3 = new BPlusTree(3);

            bpt3.insert(19);
            bpt3.insert(30);
            bpt3.insert(18);
            bpt3.insert(3);
            bpt3.insert(28);
            bpt3.insert(6);
            bpt3.insert(2);
            bpt3.insert(9);
            bpt3.insert(12);
            bpt3.insert(16);
            bpt3.insert(20);

            System.out.println(bpt3);
        }
    }
}
