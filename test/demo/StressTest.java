package demo;

import java.util.List;

import demo.domain.Edge;
import demo.domain.Graph;
import junit.framework.TestCase;

public class StressTest extends TestCase {

    GraphLib subject = new GraphLib();

    public void test_billionVertex_notConnected() {
        Graph<Integer> graph1 = new Graph<>(false);

        for (int i = 0; i < 1000000; i++) {
            subject.addVertex(graph1, i);
        }
        long startTime = System.currentTimeMillis();
        List<Edge<Integer>> result = subject.getPath(graph1, 0, 2);
        long endTime = System.currentTimeMillis();

        assertEquals(0, result.size());
        assertTrue(endTime - startTime < 200);
    }

    public void test_thousandVertex_simpleLongWay() {
        Graph<Integer> graph1 = new Graph<>(false);

        for (int i = 0; i < 1000; i++) {
            subject.addVertex(graph1, i);
            if( i != 999) {
                subject.addEdge(graph1, i, i + 1);
            }
        }
        long startTime = System.currentTimeMillis();
        List<Edge<Integer>> result = subject.getPath(graph1, 0, 999);
        long endTime = System.currentTimeMillis();

        assertEquals(999, result.size());
        assertTrue(endTime - startTime < 200);
    }

    public void test_tenthousandVertex_simpleLongWay() {
        Graph<Integer> graph1 = new Graph<>(false);

        for (int i = 0; i < 10000; i++) {
            subject.addVertex(graph1, i);
            if( i != 9999) {
                subject.addEdge(graph1, i, i + 1);
            }
        }
        long startTime = System.currentTimeMillis();
        List<Edge<Integer>> result = subject.getPath(graph1, 0, 9999);
        long endTime = System.currentTimeMillis();

        assertEquals(9999, result.size());
        assertTrue(endTime - startTime < 400);
    }

}