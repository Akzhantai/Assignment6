import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public abstract class Search<V> {
    protected WeightedGraph<V> graph;

    public Search(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public abstract boolean hasPath(Vertex<V> source, Vertex<V> destination);
}
