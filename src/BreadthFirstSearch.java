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
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();

        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            if (current == destination) {
                return true;
            }

            for (Edge<Vertex<V>> edge : graph.getEdges(current)) {
                Vertex<V> adjacent = (Vertex<V>) edge.getDest();
                if (!visited.contains(adjacent)) {
                    queue.offer(adjacent);
                    visited.add(adjacent);
                }
            }
        }

        return false;
    }
}
