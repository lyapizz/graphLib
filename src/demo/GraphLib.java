package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import demo.domain.Edge;
import demo.domain.Graph;

public class GraphLib {

    VertexValidator validator;

    PathFinder pathFinder;

    public GraphLib() {
        validator = new VertexValidator();
        pathFinder = new PathFinder();
    }

    public <V> void addVertex(Graph<V> graph, V vertex) {
        graph.addVertex(vertex);
    }

    public <V> void addEdge(Graph<V> graph, V start, V end) {
        graph.addEdge(start, end);
    }

    public <V> List<Edge<V>> getPath(Graph<V> graph, V start, V end) {
        Map<V, LinkedList<V>> adjacencyMap = graph.getAdjacencyMap();

        if (!validator.validate(start, end, adjacencyMap)) {
            System.out.println("Path between " + start + " and " + end + " is not found!");
            return Collections.emptyList();
        }

        // map for storing flag that we already visit this vertex
        Map<V, Boolean> wasHere = new HashMap<>();
        // queue for bfs algorithm
        Queue<V> vertexQueue = new LinkedList<>();
        // helper map to restore a path at the end
        Map<V, V> predecessorMap = new HashMap<>();

        // mark start as visited
        wasHere.put(start, true);
        vertexQueue.add(start);

        V curVertex;
        while (!vertexQueue.isEmpty()) {
            curVertex = vertexQueue.poll();
            // iterate over neighbours
            for (V neighbourVertex : adjacencyMap.get(curVertex)) {
                // find final vertex
                if (neighbourVertex.equals(end)) {
                    predecessorMap.put(neighbourVertex, curVertex);
                    return pathFinder.findPath(start, end, predecessorMap);
                }
                // it's a new vertex, we weren't here before
                if (!wasHere.containsKey(neighbourVertex)) {
                    predecessorMap.put(neighbourVertex, curVertex);
                    wasHere.put(neighbourVertex, true); // mark as visited
                    vertexQueue.add(neighbourVertex);
                }
            }
        }
        System.out.println("Path between " + start + " and " + end + " is not found!");
        return Collections.emptyList();
    }


}
