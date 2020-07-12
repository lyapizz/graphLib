package demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import demo.domain.Edge;

public class PathFinder {

    /**
     * This method find path between start Vertex and end Vertex
     * using information about predecessors in predecessorMap
     */
    public <V> List<Edge<V>> findPath(V start, V end, Map<V, V> predecessorMap) {
        LinkedList<V> result = new LinkedList<>();
        V curVertex = end;
        while (curVertex != start) {
            result.addFirst(curVertex);
            curVertex = predecessorMap.get(curVertex);
        }
        result.addFirst(curVertex);
        return convertToEdges(result);
    }

    private <V> List<Edge<V>> convertToEdges(List<V> restoredPath) {
        List<Edge<V>> result = new ArrayList<>();
        for (int i = 0; i < restoredPath.size() - 1; i++) {
            result.add(new Edge<>(restoredPath.get(i), restoredPath.get(i + 1)));
        }
        return result;
    }
}
