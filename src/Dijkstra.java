class Dijkstra {
    public int[] shortestPath(Graph graph, int source) {
        int[] distances = new int[graph.vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Edge(source, source, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            for (Edge edge : graph.adjacencyList[current.destination]) {
                int newDist = distances[current.destination] + edge.weight;
                if (newDist < distances[edge.destination]) {
                    distances[edge.destination] = newDist;
                    pq.add(new Edge(edge.destination, edge.destination, newDist));
                }
            }
        }

        return distances;
    }
}
