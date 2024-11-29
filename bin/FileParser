class FileParser {
    public static Graph parseFile(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(filePath))));
        String line;
        Graph graph = null;

        while ((line = br.readLine()) != null) {
            if (line.startsWith("p")) {
                String[] parts = line.split(" ");
                int vertices = Integer.parseInt(parts[2]);
                int edges = Integer.parseInt(parts[3]);
                graph = new Graph(vertices);
            } else if (line.startsWith("a")) {
                String[] parts = line.split(" ");
                int source = Integer.parseInt(parts[1]) - 1;
                int destination = Integer.parseInt(parts[2]) - 1;
                int weight = Integer.parseInt(parts[3]);
                graph.addEdge(source, destination, weight);
            }
        }

        br.close();
        return graph;
    }
}
