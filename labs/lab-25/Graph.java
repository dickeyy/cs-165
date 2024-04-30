import java.util.*;

public class Graph {

    ArrayList<List<Integer>> adjList;

    /**
     * Initializes the Graph to have adjacency lists for each node in the graph
     * @param numNodes
     */
    public Graph(int numNodes) {
        adjList = new ArrayList<List<Integer>>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

    /**TODO - Complete This Method
     * This method should add a new edge to the graph by getting the adjacency list for node1 and
     * adding the node2 to that list.
     *
     * It should also add the node1 to node2's adjacency list.
     *
     * If either node is not in the graph(if the given index is less than 0 or if it's out of bounds for the
     * list throw a NoSuchElementException
     *
     *
     * @param node1 - a node in the graph
     * @param node2 - a node in the graph
     * @throws java.util.NoSuchElementException if the node is not in the graph
     */
    public void addEdge(int node1, int node2) {
        if (node1 < 0 || node1 >= adjList.size() || node2 < 0 || node2 >= adjList.size()) {
            throw new NoSuchElementException();
        }
        adjList.get(node1).add(node2);
        adjList.get(node2).add(node1);
    }

    /**TODO - Complete This Method
     * 1. For a BFS you need a Queue to keep track of the unvisited nodes and a list to keep track of the
     *  visited nodes(Note: you can use a LinkedList like a queue add() and poll())
     * 2. start by "visiting" the startNode and adding it to the unvisited queue
     * 3. then while there are still items in the unvisited queue:
     *      pop the node off the front of the queue and store it
     *
     *      print out "Visited Node " + the number of the node you just popped off the queue
     *
     *      add all the unvisited neighbours of the current node to the unvisited queue
     *
     *      mark them all as visited by adding them to the visited list
     */
    public void breadthFirst(int startNode) {
        Queue<Integer> unvisited = new LinkedList<>();
        List<Integer> visited = new ArrayList<>();
        unvisited.add(startNode);
        visited.add(startNode);
        while (!unvisited.isEmpty()) {
            int node = unvisited.poll();
            System.out.println("Visited Node " + node);
            for (int i : adjList.get(node)) {
                if (!visited.contains(i)) {
                    unvisited.add(i);
                    visited.add(i);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        int i = 1;
        for (List<Integer> l : adjList) {
            String list = String.format("Node %d: %s\n", i, l);
            ret.append(list);
            i++;
        }
        return ret.toString();
    }

    public static int getRand(Random r, int numNodes, int i) {
        int rand = r.nextInt(numNodes);
        while (rand == i) {
            rand = r.nextInt(numNodes);
        }
        return rand;
    }

    public static void main(String[] args) {
        /* Testing Graph */
        int numNodes = 10;
        Random r = new Random(2020);
        Graph g = new Graph(numNodes);
        for (int i = 0; i < numNodes; i++) {
            g.addEdge(i, getRand(r, numNodes, i));
            g.addEdge(i, getRand(r, numNodes, i));
            g.addEdge(i, getRand(r, numNodes, i));
        }
        System.out.println(g);
        try {
            g.addEdge(-3, 20);
        } catch (NoSuchElementException e) {
            System.out.println("You threw the exception. Yay!");
        }
        //        /* Testing BFS */
        //        System.out.println("\nBFS 1:");
        //        g.breadthFirst(0);
        //        System.out.println("\nBFS 2:");
        //        g.breadthFirst(6);
        //        System.out.println("\nBFS 3:");
        //        g.breadthFirst(4);
        //        /* Testing Exception on addEdge() */

    }
}
