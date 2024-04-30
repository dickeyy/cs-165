// GraphAbstract.java - abstract class for graph assignment
// Author: Chris Wilcox
// Date:   4/16/2017
// Class:  CS165
// Email:  wilcox@cs.colostate.edu

import java.util.ArrayList;

public abstract class GraphAbstract {

    // Represents a graph edge
    public class GraphEdge implements Comparable<GraphEdge> {

        public int fromIndex; // index of "from" city
        public int toIndex; // index of "to" city
        public int mileage; // mileage between cities

        public GraphEdge(int from, int to, int mileage) {
            this.fromIndex = from;
            this.toIndex = to;
            this.mileage = mileage;
        }

        public int compareTo(GraphEdge edge) {
            return this.mileage - edge.mileage;
        }
    }

    // Represents a graph node (and incident edges)
    public class GraphNode {

        public String name; // City name
        public ArrayList<GraphEdge> edges; // Distances

        public GraphNode(String name) {
            this.name = name;
            edges = new ArrayList<>();
        }

        public boolean equals(Object object) {
            return object instanceof GraphNode && ((GraphNode) object).name.equals(this.name);
        }

        public int hashCode() {
            return super.hashCode();
        }
    }

    // Graph data structures
    public static ArrayList<GraphNode> cities = new ArrayList<>();
    public static ArrayList<GraphEdge> mileages = new ArrayList<>();

    /**
     * Reads mileage chart from CSV file and builds lists of nodes (cities) and edges (distances).
     * <p>
     * The first line contains all the cities which should be represented as {@link GraphNode}s <br>
     * The successive lines start with a city, followed by a list of mileages to other cities.
     * <p>
     * To avoid redundancy, not all the values are filled in, ignore empty entries. <br>
     * When you read a mileage, for example from Fort Collins to Denver, create only one
     * entry in the mileages array, but add the edge to both cities.
     * <p>
     * First extract all the edges, then sort the edges by mileage, then add the edges
     * associated with each node.
     * @param filename the CSV file
     */
    public abstract void readGraph(String filename);

    // Print graph in depth first search order
    public abstract void depthFirst(String startCity);

    // Print graph in breadth first search order
    public abstract void breadthFirst(String startCity);
}
