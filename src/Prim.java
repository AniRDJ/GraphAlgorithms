class Prim {
    public int primMST(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.add(new Edge(0, 0, 0)); // Começar do vértice 0
        int mstWeight = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (!visited[current.destination]) {
                visited[current.destination] = true;
                mstWeight += current.weight;

                for (Edge edge : graph.adjacencyList[current.destination]) {
                    if (!visited[edge.destination]) {
                        pq.add(edge);
                    }
                }
            }
        }

        return mstWeight;
    }
}
