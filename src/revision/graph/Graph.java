package revision.graph;

import java.util.*;

public class Graph {
    private Map<String, List<String>> adjacencyList = new HashMap<>();

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        this.adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(String v1, String v2) {
        if (adjacencyList.get(v1) == null || adjacencyList.get(v2) == null) {
            System.out.println("One or Two vertex are not in the graph");
            return;
        }

        adjacencyList.get(v1)
                     .add(v2);
        adjacencyList.get(v2)
                     .add(v1);
    }

    public void removeEdge(String v1, String v2) {
        if (adjacencyList.get(v1) == null || adjacencyList.get(v2) == null) {
            System.out.println("One or Two vertex are not in the graph");
            return;
        }

        adjacencyList.get(v1)
                     .remove(v2);
        adjacencyList.get(v2)
                     .remove(v1);
    }

    public void removeVertex(String v) {
        if (adjacencyList.get(v) == null) {
            System.out.println("The vertex is not in the graph");
            return;
        }

        //creating a new array list as neighbor to avoid
        //concurrent modification exception
        List<String> neighbors = new ArrayList<>(adjacencyList.get(v));
        neighbors.forEach(n -> this.removeEdge(n, v));

        adjacencyList.remove(v);
    }

    public List<String> dfsTraverse(String start) {
        List<String> result = new ArrayList<>();
        Map<String, Boolean> visited = new HashMap<>();

        dfsTraverseHelper(start, visited, result);
        return result;
    }

    private void dfsTraverseHelper(String v, Map<String, Boolean> visited, List<String> result) {
        if(v == null) return;

        visited.put(v, true);
        result.add(v);

        for(String neighbor : adjacencyList.get(v)) {
            if(visited.get(neighbor) == null || !visited.get(neighbor)) {
                dfsTraverseHelper(neighbor, visited, result);
            }
        }
    }

    public List<String> bfsTraverse(String start) {
        List<String> result = new ArrayList<>();
        Map<String, Boolean> visited = new HashMap<>();

        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            if(visited.get(cur) == null || !visited.get(cur)) {
                visited.put(cur, true);
                result.add(cur);

                List<String> neighbors = adjacencyList.get(cur);
                queue.addAll(neighbors.stream()
                                      .filter(n -> visited.get(n) == null || !visited.get(n))
                                      .toList());
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return this.adjacencyList.toString();
    }
}
