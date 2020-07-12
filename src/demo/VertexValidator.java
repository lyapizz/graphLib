package demo;

import java.util.LinkedList;
import java.util.Map;

public class VertexValidator{

    public <V> boolean validate(V start, V end, Map<V, LinkedList<V>> adjacencyList) {
        if (isVertexOutOfGraphDimensions(start, adjacencyList)) {
            return false;
        }
        if (isVertexOutOfGraphDimensions(end, adjacencyList)) {
            return false;
        }

        return vertexHasNeigbours(start, adjacencyList);
    }

    private <V> boolean vertexHasNeigbours(V start, Map<V, LinkedList<V>> adjacencyList) {
        if (adjacencyList.get(start).isEmpty()) {
            System.out.println("Vertex " + start.toString() + " is isolated.");
            return false;
        }
        return true;
    }

    private <V> boolean isVertexOutOfGraphDimensions(V start, Map<V, LinkedList<V>> adjacencyList) {
        if (adjacencyList.get(start) == null) {
            System.out.println("Vertex " + start.toString() + " is out of graph's dimenstions.");
            return true;
        }
        return false;
    }
}
