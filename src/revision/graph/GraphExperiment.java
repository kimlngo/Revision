package revision.graph;

public class GraphExperiment {
    public static void main(String[] args) {
        Graph graph = new Graph();

        for(int i = 0; i < 6; i++) {
            graph.addVertex(String.valueOf((char)('A' + i)));
        }

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("D", "E");
        graph.addEdge("D", "F");
        graph.addEdge("C", "E");
        graph.addEdge("E", "F");

        System.out.println("Depth First Search");
        System.out.println(graph.dfsTraverse("A"));

        System.out.println("Breath First Search");
        Graph g = new Graph();
        for(int i = 0; i < 6; i++) {
            g.addVertex(String.valueOf((char)('A' + i)));
        }

        g.addEdge("A", "B");
        g.addEdge("A", "E");
        g.addEdge("B", "C");
        g.addEdge("B", "D");
        g.addEdge("C", "D");
        g.addEdge("D", "E");
        g.addEdge("D", "F");
        g.addEdge("E", "F");

        System.out.println(g.bfsTraverse("A"));
    }
}
