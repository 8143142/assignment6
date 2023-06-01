public class Edge<V> {
    private Vertex<V> source;
    private Vertex<V> dest;
    private Double weight;

    public Edge(Vertex source, Vertex dest, Double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}
