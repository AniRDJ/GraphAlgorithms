import java.io.*;
import java.util.*;
import java.util.zip.GZIPInputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        Graph coloradoGraph = FileParser.parseFile("colorado.gr.gz");
        Graph bayAreaGraph = FileParser.parseFile("bayArea.gr.gz");
        Graph newYorkGraph = FileParser.parseFile("newYork.gr.gz");

        
        runAlgorithms("Colorado", coloradoGraph);
        runAlgorithms("Bay Area", bayAreaGraph);
        runAlgorithms("New York", newYorkGraph);
    }

    private static void runAlgorithms(String graphName, Graph graph) {
        System.out.println("Resultados para o grafo: " + graphName);
        System.out.println("Vértices: " + graph.vertices + ", Arestas: " + graph.getEdgeCount());

        // Dijkstra
        long startTime = System.nanoTime();
        Dijkstra dijkstra = new Dijkstra();
        int[] dijkstraResult = dijkstra.shortestPath(graph, 0); // Usando o vértice 0 como origem
        long endTime = System.nanoTime();
        System.out.printf("Dijkstra: Tempo = %.4f s\n", (endTime - startTime) / 1e9);

        // Kruskal
        startTime = System.nanoTime();
        Kruskal kruskal = new Kruskal();
        int kruskalCost = kruskal.kruskalMST(graph.vertices, graph.getAllEdges());
        endTime = System.nanoTime();
        System.out.printf("Kruskal: Tempo = %.4f s, Custo = %d\n", (endTime - startTime) / 1e9, kruskalCost);

        // Prim
        startTime = System.nanoTime();
        Prim prim = new Prim();
        int primCost = prim.primMST(graph);
        endTime = System.nanoTime();
        System.out.printf("Prim: Tempo = %.4f s, Custo = %d\n", (endTime - startTime) / 1e9, primCost);

        System.out.println();
    }
}
