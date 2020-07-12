package demo;

import java.util.List;

import demo.domain.Edge;
import demo.domain.Graph;
import junit.framework.TestCase;
import org.junit.Assert;

public class E2ETest extends TestCase {

    GraphLib subject = new GraphLib();

    public void test_alloperations_undirected() {
        Graph<Integer> graph1 = new Graph<>(false);

        subject.addVertex(graph1, 0);
        subject.addVertex(graph1, 1);
        subject.addVertex(graph1, 2);

        subject.addEdge(graph1, 0, 1);
        subject.addEdge(graph1, 1, 2);

        List<Edge<Integer>> result = subject.getPath(graph1, 0 , 2);

        assertEquals(2, result.size());
        assertEquals(0, result.get(0).getStart().intValue());
        assertEquals(1, result.get(0).getEnd().intValue());

        assertEquals(1, result.get(1).getStart().intValue());
        assertEquals(2, result.get(1).getEnd().intValue());
    }

    public void test_alloperations_directed() {
        Graph<Integer> graph1 = new Graph<>(true);

        subject.addVertex(graph1, 0);
        subject.addVertex(graph1, 1);
        subject.addVertex(graph1, 2);

        subject.addEdge(graph1, 0, 1);
        subject.addEdge(graph1, 1, 2);

        List<Edge<Integer>> result = subject.getPath(graph1, 0 , 2);

        assertEquals(2, result.size());
        assertEquals(0, result.get(0).getStart().intValue());
        assertEquals(1, result.get(0).getEnd().intValue());

        assertEquals(1, result.get(1).getStart().intValue());
        assertEquals(2, result.get(1).getEnd().intValue());
    }


}