# Assignment6
## Main
``` java
public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(); // Create a new weighted graph

        Vertex<String> v1 = new Vertex<>("A"); // Create vertex v1 with data "A"
        Vertex<String> v2 = new Vertex<>("B"); // Create vertex v2 with data "B"
        Vertex<String> v3 = new Vertex<>("C"); // Create vertex v3 with data "C"
        Vertex<String> v4 = new Vertex<>("D"); // Create vertex v4 with data "D"

        graph.addVertex(v1); // Add v1 to the graph
        graph.addVertex(v2); // Add v2 to the graph
        graph.addVertex(v3); // Add v3 to the graph
        graph.addVertex(v4); // Add v4 to the graph

        graph.addEdge(v1, v2, 2.0); // Add an edge between v1 and v2 with weight 2.0
        graph.addEdge(v1, v3, 1.5); // Add an edge between v1 and v3 with weight 1.5
        graph.addEdge(v2, v3, 3.0); // Add an edge between v2 and v3 with weight 3.0
        graph.addEdge(v3, v4, 2.5); // Add an edge between v3 and v4 with weight 2.5

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph); // Create a breadth-first search object with the graph
        System.out.println("Path exists (BFS): " + bfs.hasPath(v1, v4)); // Check if a path exists between v1 and v4 using BFS

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph); // Create a Dijkstra search object with the graph
        System.out.println("Path exists (Dijkstra): " + dijkstra.hasPath(v1, v4)); // Check if a path exists between v1 and v4 using Dijkstra's algorithm
    }
}
```
## Explanation


## Vertex
``` java
import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data; // The data associated with the vertex
    private Map<Vertex<V>, Double> adjacentVertices; // Map to store adjacent vertices and their corresponding edge weights

    public Vertex(V data) {
        this.data = data; // Set the data associated with the vertex
        this.adjacentVertices = new HashMap<>(); // Initialize the map to store adjacent vertices and edge weights
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight); // Add an adjacent vertex and its corresponding edge weight to the map
    }

    public V getData() {
        return data; // Get the data associated with the vertex
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices; // Get the map of adjacent vertices and their edge weights
    }
}
```
## Explanation

## Edge
``` java
public class Edge<V> {
    private Vertex<V> source; // The source vertex of the edge
    private Vertex<V> dest; // The destination vertex of the edge
    private double weight; // The weight of the edge

    public Edge(Vertex<V> source, Vertex<V> dest, double weight) {
        this.source = source; // Set the source vertex of the edge
        this.dest = dest; // Set the destination vertex of the edge
        this.weight = weight; // Set the weight of the edge
    }

    public Vertex<V> getSource() {
        return source; // Get the source vertex of the edge
    }

    public Vertex<V> getDest() {
        return dest; // Get the destination vertex of the edge
    }

    public double getWeight() {
        return weight; // Get the weight of the edge
    }
}
```
## Explanation


## DijkstraSearch
``` java
public class Edge<V> {
    private Vertex<V> source; // The source vertex of the edge
    private Vertex<V> dest; // The destination vertex of the edge
    private double weight; // The weight of the edge

    public Edge(Vertex<V> source, Vertex<V> dest, double weight) {
        this.source = source; // Set the source vertex of the edge
        this.dest = dest; // Set the destination vertex of the edge
        this.weight = weight; // Set the weight of the edge
    }

    public Vertex<V> getSource() {
        return source; // Get the source vertex of the edge
    }

    public Vertex<V> getDest() {
        return dest; // Get the destination vertex of the edge
    }

    public double getWeight() {
        return weight; // Get the weight of the edge
    }
}
```
## Explanation


## Search
``` java
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public abstract class Search<V> {
    protected WeightedGraph<V> graph; // The weighted graph to perform search operations on

    public Search(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public abstract boolean hasPath(Vertex<V> source, Vertex<V> destination); // Abstract method to check if a path exists between source and destination
}
```
## Explanation


## WeightedGraph
``` java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<Vertex<V>>>> map; // Map to store vertices and their corresponding edges
    private List<Vertex<V>> vertices; // List to store all vertices in the graph

    public WeightedGraph() {
        map = new HashMap<>(); // Initialize the map to store vertices and edges
        vertices = new ArrayList<>(); // Initialize the list to store vertices
    }

    public void addVertex(Vertex<V> vertex) {
        map.put(vertex, new ArrayList<>()); // Add the vertex to the map with an empty list of edges
        vertices.add(vertex); // Add the vertex to the list of vertices
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        if (!map.containsKey(source) || !map.containsKey(dest)) {
            throw new IllegalArgumentException("Source or destination vertex not found in the graph.");
        }
        Edge<Vertex<V>> edge = (Edge<Vertex<V>>) new Edge<>(source, dest, weight); // Create a new edge with the given source, destination, and weight
        map.get(source).add(edge); // Add the edge to the list of edges for the source vertex
    }

    public List<Edge<Vertex<V>>> getEdges(Vertex<V> vertex) {
        return map.get(vertex); // Retrieve the list of edges for the given vertex
    }

    public List<Vertex<V>> getVertices() {
        return vertices; // Retrieve the list of vertices in the graph
    }
}
```
## Explanation


## BreadthFirstSearch
``` java
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph) {
        super(graph);
    }

    @Override
    public boolean hasPath(Vertex<V> source, Vertex<V> destination) {
        Queue<Vertex<V>> queue = new LinkedList<>(); // Queue to store vertices for BFS traversal
        Set<Vertex<V>> visited = new HashSet<>(); // Set to keep track of visited vertices

        queue.offer(source); // Add the source vertex to the queue
        visited.add(source); // Mark the source vertex as visited

        while (!queue.isEmpty()) { // Continue BFS traversal until the queue is empty
            Vertex<V> current = queue.poll(); // Get the next vertex from the queue
            if (current == destination) { // If the current vertex is the destination vertex, a path exists
                return true;
            }

            for (Edge<Vertex<V>> edge : graph.getEdges(current)) { // Iterate over the edges of the current vertex
                Vertex<V> adjacent = (Vertex<V>) edge.getDest(); // Get the adjacent vertex
                if (!visited.contains(adjacent)) { // If the adjacent vertex is not visited
                    queue.offer(adjacent); // Add the adjacent vertex to the queue
                    visited.add(adjacent); // Mark the adjacent vertex as visited
                }
            }
        }

        return false; // No path exists from the source to the destination
    }
}
```
## Explanation




