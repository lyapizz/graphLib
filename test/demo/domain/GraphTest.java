package demo.domain;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

public class GraphTest extends TestCase {

    //<editor-fold desc="tests for addVertex">
    public void testAddVertexDirected_newOne_addedToList() {
        Graph<Integer> directedGraph = new Graph<>(true);
        directedGraph.addVertex(1);

        assertEquals(Set.of(1), directedGraph.getVertices());
    }

    public void testAddVertexDirected_newTwo_addedToList() {
        Graph<Integer> directedGraph = new Graph<>(true);
        directedGraph.addVertex(1);
        directedGraph.addVertex(2);

        assertEquals(Set.of(1, 2), directedGraph.getVertices());
    }

    public void testAddVertexDirected_dublicate_addedToList() {
        Graph<Integer> directedGraph = new Graph<>(true);
        directedGraph.addVertex(1);
        directedGraph.addVertex(1);

        assertEquals(Set.of(1), directedGraph.getVertices());
    }

    public void testAddVertexUndirected_newOne_addedToList() {
        Graph<Integer> directedGraph = new Graph<>(false);
        directedGraph.addVertex(1);

        assertEquals(Set.of(1), directedGraph.getVertices());
    }

    public void testAddVertexUndirected_newTwo_addedToList() {
        Graph<Integer> directedGraph = new Graph<>(false);
        directedGraph.addVertex(1);
        directedGraph.addVertex(2);

        assertEquals(Set.of(1, 2), directedGraph.getVertices());
    }

    public void testAddVertexUndirected_dublicate_addedToList() {
        Graph<Integer> directedGraph = new Graph<>(false);
        directedGraph.addVertex(1);
        directedGraph.addVertex(1);

        assertEquals(Set.of(1), directedGraph.getVertices());
    }
    //</editor-fold>

    //<editor-fold desc="tests for addEdge">
    public void testAddEdge_Undirected_bothAdded() {
        Graph<Integer> directedGraph = new Graph<>(false);
        directedGraph.addEdge(0, 1);

        LinkedList<Integer> listForZeroVertex = new LinkedList<>();
        listForZeroVertex.add(1);

        LinkedList<Integer> listForOneVertex = new LinkedList<>();
        listForOneVertex.add(0);

        assertEquals(Map.of(0, listForZeroVertex, 1, listForOneVertex), directedGraph.getAdjacencyMap());
    }

    public void testAddEdge_Directed_onlyoneAdded() {
        Graph<Integer> directedGraph = new Graph<>(true);
        directedGraph.addEdge(0, 1);

        LinkedList<Integer> listForZeroVertex = new LinkedList<>();
        listForZeroVertex.add(1);

        assertEquals(Map.of(0, listForZeroVertex, 1, new LinkedList<>()), directedGraph.getAdjacencyMap());
    }
    //</editor-fold>
}