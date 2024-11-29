public class Kruskal {
    public int kruskalMST(int vertices, List<Edge> edges) {
        edges.sort(Comparator.comparingInt(e -> e.weight));
        UnionFind uf = new UnionFind(vertices);

        int mstWeight = 0;
        for (Edge edge : edges) {
            if (uf.union(edge.source, edge.destination)) {
                mstWeight += edge.weight;
            }
        }

        return mstWeight;
    }
}

class UnionFind {
    int[] parent, rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int node) {
        if (node != parent[node]) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 != root2) {
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
            return true;
        }
        return false;
    }
}
