import java.io.File;
import java.io.IOException;
import java.util.*;

public class GraphImplementation extends GraphAbstract {

    public static void main(String[] args) {
        GraphImplementation impl = new GraphImplementation();
        Scanner input = new Scanner(System.in);

        // Input file name and starting city
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

        // Print breadth first search
        System.out.println("Breadth First Search:");
        impl.breadthFirst(startCity);
        System.out.println();
    }

    // Reads mileage chart from CSV file
    public void readGraph(String filename) {
        ArrayList<String> lines = readFile(filename);
        String[] citiesArray = lines.get(0).split(",");
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            String city = parts[0];
            addCity(city);
            for (int j = 1; j < parts.length; j++) {
                String dest = citiesArray[j];
                if (!parts[j].isEmpty()) {
                    int dist = Integer.parseInt(parts[j]);
                    addCity(dest);
                    addEdge(city, dest, dist);
                }
            }
        }
    }

    public void depthFirst(String startCity) {
        Set<String> visited = new HashSet<>();
        depthFirstHelper(startCity, visited);
    }

    // Recursive helper method for depth-first search
    private void depthFirstHelper(String city, Set<String> visited) {
        if (!visited.contains(city)) {
            visited.add(city);
            System.out.println("Visited " + city);
            ArrayList<String> neighbors = getNeighbors(city);
            for (String neighbor : neighbors) {
                depthFirstHelper(neighbor, visited);
            }
        }
    }

    public void breadthFirst(String startCity) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(startCity);
        visited.add(startCity);

        while (!queue.isEmpty()) {
            String city = queue.poll();
            System.out.println("Visited " + city);
            ArrayList<String> neighbors = getNeighbors(city);
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
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

    private ArrayList<String> getNeighbors(String city) {
        ArrayList<String> neighbors = new ArrayList<>();
        int index = getIndex(city);
        for (int i = 0; i < numCities(); i++) {
            if (edges[index][i] > 0) {
                neighbors.add(getCity(i));
            }
        }
        Collections.sort(
            neighbors,
            Comparator.comparingInt(neighbor -> edges[index][getIndex(neighbor)])
        );
        return neighbors;
    }

    private String getCity(int index) {
        return cities.get(index);
    }

    private int numCities() {
        return cities.size();
    }

    private ArrayList<String> cities = new ArrayList<>();
    private int[][] edges = new int[100][100];

    // Reads the contents of file to ArrayList
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
