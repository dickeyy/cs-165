import java.util.*;
import java.util.Scanner;

public class GraphTest {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int numNodes = 10;
        Random r = new Random(2020);
        Graph g = new Graph(numNodes);
        for (int i = 0; i < numNodes; i++) {
            g.addEdge(i, g.getRand(r, numNodes, i));
            g.addEdge(i, g.getRand(r, numNodes, i));
            g.addEdge(i, g.getRand(r, numNodes, i));
        }
        System.out.println(g);
        try {
            g.addEdge(-3, 20);
        } catch (NoSuchElementException e) {
            System.out.println("You threw the exception. Yay!");
        }
        //        /* Testing BFS */
        System.out.println("\nBFS 1:");
        g.breadthFirst(0);
        System.out.println("\nBFS 2:");
        g.breadthFirst(6);
        System.out.println("\nBFS 3:");
        g.breadthFirst(4);
    }
}
