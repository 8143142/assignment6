# assignment6 documentation <img src="https://github.com/blackcater/blackcater/raw/main/images/Hi.gif" height="32"/></h1>
Here is full explanation of methods 
--------    ---------    --------
<b><p>MyGraph class<p></b>
<b>Methods:</b><br>
<b><p> :one: addEdge<p></b>
<b>Description:</b> *This method adds an edge between the source and destination vertices with the given weight. It creates a new Edge object, adds the destination vertex to the adjacency list of the source vertex using the addAdjVertex method, and adds the edge to the graph's data structure.*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
// Adds an edge between source and destination vertices with a given weight
    public void addEdge(Vertex source, Vertex destination, double weight){
        Edge edge = new Edge(source, destination, weight);
        source.addAdjVertex(destination, weight);
        if (!graph.containsKey(source)) graph.put(source, new ArrayList<>());
        graph.get(source).add(edge);
    }
```
--------    ---------    --------
  <b><p> :two: BFS<p></b>
<b>Description:</b> *This method performs Breadth-First Search (BFS) starting from the start vertex. It uses a Queue and a Set to keep track of visited vertices. It starts by adding the start vertex to the queue and visited set. Then it iteratively dequeues vertices from the queue, prints them, and adds their unvisited neighbors to the queue and visited set.*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
// Performs Breadth-First Search (BFS) starting from the given start vertex
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
```
--------    ---------    --------
   <b><p> :three: dijkstra<p></b>
<b>Description:</b> *This method performs Dijkstra's algorithm starting from the start vertex. It calculates the shortest path distances from the start vertex to all other vertices in the graph. It initializes a distances map with initial distances set to Double.MAX_VALUE for all vertices except the start vertex (which is set to 0). It uses a PriorityQueue to prioritize vertices based on their current distance. It iteratively selects the vertex with the minimum distance from the priority queue, updates the distances to its neighbors if a shorter path is found, and continues until the queue is empty. Finally, it returns the distances map.*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
// Performs Dijkstra's algorithm starting from the given start vertex
 public Map<Vertex, Double> dijkstra(Vertex start) {
        Map<Vertex, Double> distances = new HashMap<>();
        for (Vertex node : graph.keySet()) {
            distances.put(node, Double.MAX_VALUE);
        }
        distances.put(start, 0d);

        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            for (Edge neighbor : graph.get(currentVertex)) {
                double distance = distances.get(currentVertex) + neighbor.getWeight();
                if (distance < distances.get(currentVertex)) {
                    distances.put(currentVertex, distance);
                    queue.add((Vertex) neighbor.getDest());
                }
            }
        }
        return distances;
    }
```
--------    ---------    --------
