import java.util.Scanner;
import java.util.ArrayList;

public class PhotoLineups {

    /*
     * Write a program that lists all ways people can line up for a photo (all
     * permutations of a list of Strings). The program will read a list of one word
     * names into ArrayList nameList (until -1), and use a recursive method to
     * create and output all possible orderings of those names separated by a comma,
     * one ordering per line.
     * 
     * When the input is:
     * 
     * Julia Lucas Mia -1
     * then the output is (must match the below ordering):
     * 
     * Julia, Lucas, Mia
     * Julia, Mia, Lucas
     * Lucas, Julia, Mia
     * Lucas, Mia, Julia
     * Mia, Julia, Lucas
     * Mia, Lucas, Julia
     */

    // TODO: Write method to create and output all permutations of the list of
    // names.
    public static void printAllPermutations(ArrayList<String> permList, ArrayList<String> nameList) {

        // Base case: If the list is empty, print the list of permutations
        if (nameList.size() == 0) {
            for (int i = 0; i < permList.size(); i++) {
                if (i == permList.size() - 1) {
                    System.out.print(permList.get(i));
                } else {
                    System.out.print(permList.get(i) + ", ");
                }
            }
            System.out.println();
        } else {
            // Recursive case: For each name in the list, add it to the permutation list,
            // remove it from the name list, and call the method again
            for (int i = 0; i < nameList.size(); i++) {
                permList.add(nameList.get(i));
                nameList.remove(i);
                printAllPermutations(permList, nameList);
                nameList.add(i, permList.get(permList.size() - 1));
                permList.remove(permList.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> permList = new ArrayList<String>();
        String name;

        // TODO: Read a list of names into nameList; stop when -1 is read. Then call
        // recursive method.

        name = scnr.next();
        while (!name.equals("-1")) {
            nameList.add(name);
            name = scnr.next();
        }

        printAllPermutations(permList, nameList);

        scnr.close();
    }
}
