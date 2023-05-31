import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    public DijkstraSearch(WeightedGraph<V> graph) {
        super(graph);
    }

    @Override
    public boolean hasPath(Vertex<V> source, Vertex<V> destination) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> previousVertices = new HashMap<>();
        Set<Vertex<V>> visited = new HashSet<>();

        for (Vertex<V> vertex : graph.getVertices()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }

        distances.put(source, 0.0);

        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        queue.offer(source);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            if (current == destination) {
                return true;
            }

            visited.add(current);

            for (Edge<Vertex<V>> edge : graph.getEdges(current)) {
                Vertex<V> adjacent = (Vertex<V>) edge.getDest();
                double weight = edge.getWeight();
                double newDistance = distances.get(current) + weight;

                if (newDistance < distances.get(adjacent)) {
                    distances.put(adjacent, newDistance);
                    previousVertices.put(adjacent, current);
                    if (!visited.contains(adjacent)) {
                        queue.offer(adjacent);
                    }
                }
            }
        }

        return false;
    }
}
