import edu.princeton.cs.algs4.*;

public class GraphProperties {
    private final Graph G;
    private final int[] eccentricity;
    private int diameter;
    private int radius;
    private int center;

    public GraphProperties(Graph G) {
        this.G = G;
        eccentricity = new int[G.V()];
        diameter = Integer.MIN_VALUE;
        radius = Integer.MAX_VALUE;

        // Calculate eccentricity for each vertex
        for (int v = 0; v < G.V(); v++) {
            BreadthFirstPaths bfs = new BreadthFirstPaths(G, v);
            for (int w = 0; w < G.V(); w++) {
                if (bfs.hasPathTo(w)) {
                    eccentricity[v] = Math.max(eccentricity[v], bfs.distTo(w));
                }
            }
        }

        // Calculate diameter and radius
        for (int v = 0; v < G.V(); v++) {
            if (eccentricity[v] > diameter) {
                diameter = eccentricity[v];
            }
            if (eccentricity[v] < radius) {
                radius = eccentricity[v];
            }
        }

        // Calculate center
        for (int v = 0; v < G.V(); v++) {
            if (eccentricity[v] == radius) {
                center = v;
            }
        }
    }

    public int eccentricity(int v) {
        return eccentricity[v];
    }

    public int diameter() {
        return diameter;
    }

    public int radius() {
        return radius;
    }

    public int center() {
        return center;
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        GraphProperties gp = new GraphProperties(G);
        for (int v = 0; v < G.V(); v++) {
            StdOut.printf("Eccentricity of vertex %d: %d\n", v, gp.eccentricity(v));
        }
        StdOut.printf("Diameter: %d\n", gp.diameter());
        StdOut.printf("Radius: %d\n", gp.radius());
        StdOut.printf("Center: %d\n", gp.center());
    }

}
