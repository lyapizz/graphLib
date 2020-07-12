package demo.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<V> {

    private final Map<V, LinkedList<V>> adjacencyMap = new HashMap<>();

    private final boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public void addVertex(V vertex) {
        if (adjacencyMap.containsKey(vertex)) {
            return;
        }
        adjacencyMap.put(vertex, new LinkedList<>());
    }

    public void addEdge(V start, V end) {
        addVertex(start);
        addVertex(end);

        addEdgeToList(start, end);
        if (!isDirected) {
            addEdgeToList(end, start);
        }
    }

    private void addEdgeToList(V start, V end) {
        LinkedList<V> currentListForVertex = adjacencyMap.get(start);
//        LinkedList<V> currentListForVertex = adjacencyMap.getOrDefault(start, new LinkedList<>());

        if (!currentListForVertex.contains(end)) {
            currentListForVertex.add(end);
        }
    }

    public Map<V, LinkedList<V>> getAdjacencyMap() {
        return adjacencyMap;
    }

    Set<V> getVertices() {
        return adjacencyMap.keySet();
    }

}
