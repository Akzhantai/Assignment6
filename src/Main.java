public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        graph.addEdge(v1, v2, 2.0);
        graph.addEdge(v1, v3, 1.5);
        graph.addEdge(v2, v3, 3.0);
        graph.addEdge(v3, v4, 2.5);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph);
        System.out.println("Path exists (BFS): " + bfs.hasPath(v1, v4));

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph);
        System.out.println("Path exists (Dijkstra): " + dijkstra.hasPath(v1, v4));
    }
}
