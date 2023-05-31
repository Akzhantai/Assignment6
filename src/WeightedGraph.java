import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<Vertex<V>>>> map;
    private List<Vertex<V>> vertices;

    public WeightedGraph() {
        map = new HashMap<>();
        vertices = new ArrayList<>();
    }

    public void addVertex(Vertex<V> vertex) {
        map.put(vertex, new ArrayList<>());
        vertices.add(vertex);
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        if (!map.containsKey(source) || !map.containsKey(dest)) {
            throw new IllegalArgumentException("Source or destination vertex not found in the graph.");
        }
        Edge<Vertex<V>> edge = (Edge<Vertex<V>>) new Edge<>(source, dest, weight);
        map.get(source).add(edge);
    }

    public List<Edge<Vertex<V>>> getEdges(Vertex<V> vertex) {
        return map.get(vertex);
    }

    public List<Vertex<V>> getVertices() {
        return vertices;
    }
}
