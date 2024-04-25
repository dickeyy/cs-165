import java.io.*;
import java.util.Scanner;

public class TestTables {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String tableType = scnr.nextLine().toLowerCase();
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

        if (tableType.equals("chained")) {
            /* Table tests */

            ChainedTable table = new ChainedTable(names.length - 2);
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
        if (tableType.equals("double")) {
            DoubleTable table = new DoubleTable(names.length - 2);
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
        if (tableType.equals("linear")) {
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
        if (tableType.equals("quadratic")) {
            QuadraticTable table = new QuadraticTable(names.length - 2);
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
}
