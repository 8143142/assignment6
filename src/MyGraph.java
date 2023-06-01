import java.util.*;

public class MyGraph<V> {
    private Map<Vertex, List<Edge<V>>> graph;

    public MyGraph() {
        graph = new HashMap<>();
    }
    // Adds an edge between source and destination vertices with a given weight
    public void addEdge(Vertex source, Vertex destination, double weight){
        Edge edge = new Edge(source, destination, weight);
        source.addAdjVertex(destination, weight);
        if (!graph.containsKey(source)) graph.put(source, new ArrayList<>());
        graph.get(source).add(edge);
    }
    public void BFS(Vertex start){
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            System.out.print(currentVertex + " ");
            Set<Vertex<V>> neighbors = currentVertex.getAdjVertices().keySet();
            for (Vertex<V> neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

}