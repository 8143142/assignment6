import java.util.HashMap;
import java.util.Map;
public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjVertices;

    // Adds an adjacent vertex and its weight to the current vertex
    public void addAdjVertex(Vertex<V> dest, double weight) {
        adjVertices.put(dest, weight);
    }

    public Map<Vertex<V>, Double> getAdjVertices() {
        return adjVertices;
    }

}