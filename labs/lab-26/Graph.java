/* Graph class
 * Template made by Toby Patterson
 * With the help of: https://www.cs.colostate.edu/~cs165/.Spring20/assignments/P8/doc/
 * Completed by: your name here
 * 6/2/2020
 * For cs165 at CSU
 *
 * A basic graph which has a depth first search print method. It uses
 * link references to keep track of edges.
 * */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Graph<E extends Comparable<E>> extends GraphAbstract<E> {

    public Graph() {
        nodes = new ArrayList<GraphNode>();
    }

    /* addEdge
     * Params: data1 & data2, both data items to be added and connected
     * If the either of the data items are not in the nodes ArrayList,
     * add them as new nodes. Otherwise, find the nodes in the ArrayList so
     * you can make them point to each other. Implement so there are no duplicates
     * added to either of the nodes neighbors ArrayList.
     * TODO: implement this method.
     * */
    @Override
    public void addEdge(E data1, E data2) {
        // first find the nodes in the graph
        GraphNode node1 = null;
        GraphNode node2 = null;
        for (GraphNode node : nodes) {
            if (node.data.equals(data1)) {
                node1 = node;
            }
            if (node.data.equals(data2)) {
                node2 = node;
            }
        }

        // if the nodes are not in the graph, add them
        if (node1 == null) {
            node1 = new GraphNode(data1);
            nodes.add(node1);
        }

        if (node2 == null) {
            node2 = new GraphNode(data2);
            nodes.add(node2);
        }

        // add the nodes to each other's neighbors
        if (!node1.neighbors.contains(node2)) {
            node1.neighbors.add(node2);
        }

        if (!node2.neighbors.contains(node1)) {
            node2.neighbors.add(node1);
        }
    }

    /* depthFirst
     * Param: startNode, the node to start the traversal at
     *
     * First, find the startNode based off of startItem (hint: indexOf())
     * I recommend having an ArrayList of GraphNodes called visisted to keep
     * track of the nodes you've visited.
     *
     * Prints all of the nodes in the graph in depth first order (with a space between nodes)
     * TODO: implement this method.
     * */
    @Override
    public void depthFirst(E startItem) {
        GraphNode startNode = null;
        for (GraphNode node : nodes) {
            if (node.data.equals(startItem)) {
                startNode = node;
            }
        }

        ArrayList<GraphNode> visited = new ArrayList<GraphNode>();
        depthFirst(startNode, visited);
    }

    // Recursive helper method for depthFirst
    private void depthFirst(GraphNode curr, ArrayList<GraphNode> visited) {
        System.out.print(curr.data + " ");
        visited.add(curr);

        for (GraphNode neighbor : curr.neighbors) {
            if (!visited.contains(neighbor)) {
                depthFirst(neighbor, visited);
            }
        }
    }
}
