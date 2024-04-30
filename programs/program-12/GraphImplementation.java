// GraphImplementation.java - supplied code for graph assignment

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class GraphImplementation extends GraphAbstract {

    // Main entry point
    public static void main(String[] args) {
        // Instantiate code
        GraphImplementation impl = new GraphImplementation();
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        String startCity = input.nextLine();
        // Read distances chart
        System.out.println("Reading Chart: " + fileName);
        impl.readGraph(fileName);
        System.out.println();

        // Print depth first search
        System.out.println("Depth First Search:");
        impl.depthFirst(startCity);
        System.out.println();

        System.out.println("Breadth First Search:");
        impl.breadthFirst(startCity);
        System.out.println();
    }

    // Reads mileage chart from CSV file
    public void readGraph(String filename) {
        ArrayList<String> lines = readFile(filename);
        for (String line : lines) {
            String[] parts = line.split(",");
            String city = parts[0];
            addCity(city);
            for (int i = 1; i < parts.length; i++) {
                String[] pair = parts[i].split(":");
                String dest = pair[0];
                int dist = Integer.parseInt(pair[1]);
                addCity(dest);
                addEdge(city, dest, dist);
            }
        }
    }

    public void depthFirst(String startCity) {
        depthFirst(getIndex(startCity), new ArrayList<>());
    }

    // Recursive helper method
    public void depthFirst(int index, ArrayList<Integer> visited) {
        visited.add(index);
        System.out.println(getCity(index));
        for (int i = 0; i < numCities(); i++) {
            if (isEdge(index, i) && !visited.contains(i)) {
                depthFirst(i, visited);
            }
        }
    }

    public void breadthFirst(String startCity) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(getIndex(startCity));
        ArrayList<Integer> visited = new ArrayList<>();
        while (!queue.isEmpty()) {
            int index = queue.remove();
            if (!visited.contains(index)) {
                visited.add(index);
                System.out.println(getCity(index));
                for (int i = 0; i < numCities(); i++) {
                    if (isEdge(index, i) && !visited.contains(i)) {
                        queue.add(i);
                    }
                }
            }
        }
    }

    // Helper functions
    private void addCity(String city) {
        if (!cities.contains(city)) {
            cities.add(city);
        }
    }

    private void addEdge(String city1, String city2, int dist) {
        int index1 = getIndex(city1);
        int index2 = getIndex(city2);
        if (index1 != -1 && index2 != -1) {
            edges[index1][index2] = dist;
            edges[index2][index1] = dist;
        }
    }

    private int getIndex(String city) {
        return cities.indexOf(city);
    }

    private String getCity(int index) {
        return cities.get(index);
    }

    private boolean isEdge(int index1, int index2) {
        return edges[index1][index2] > 0;
    }

    private int numCities() {
        return cities.size();
    }

    private ArrayList<String> cities = new ArrayList<>();
    private int[][] edges = new int[100][100];

    /**
     * Reads the contents of file to {@code ArrayList}
     * @param filename the file to read from
     * @return an ArrayList of the contents
     */
    static ArrayList<String> readFile(String filename) {
        ArrayList<String> contents = new ArrayList<>();
        try (Scanner reader = new Scanner(new File(filename))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (!line.isEmpty()) contents.add(line);
            }
        } catch (IOException e) {
            System.err.println("Cannot read chart: " + filename);
        }
        return contents;
    }
}
