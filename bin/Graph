class Graph {
    int vertices;
    LinkedList<Edge>[] adjacencyList;
    List<Edge> allEdges;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        allEdges = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyList[source].add(new Edge(source, destination, weight));
        adjacencyList[destination].add(new Edge(destination, source, weight)); // Grafo não direcionado
        allEdges.add(new Edge(source, destination, weight));
    }

    public List<Edge> getAllEdges() {
        return allEdges;
    }

    public int getEdgeCount() {
        return allEdges.size();
    }
}
