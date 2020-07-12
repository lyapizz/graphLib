package demo;

import java.util.List;

import demo.domain.Edge;
import demo.domain.Graph;
import junit.framework.TestCase;
import org.junit.Assert;

public class GraphLibTest extends TestCase {

    GraphLib subject = new GraphLib();

    /*
    {0, 1, 1, 1, 0},
    {1, 0, 1, 0, 0},
    {1, 1, 0, 0, 1},
    {1, 0, 0, 0, 0},
    {0, 0, 1, 0, 0},
    */
    public void testGetPath_sampleUndirected_positive() {
        Graph<Integer> graph = createSampleGraph(false);

        List<Edge<Integer>> result = subject.getPath(graph, 0, 4);

        List<Edge<Integer>> expectedList = List.of(new Edge<>(0, 2), new Edge<>(2, 4));
        Assert.assertEquals(expectedList, result);
    }

    /*
    {0, 1, 1, 1, 0},
    {0, 0, 1, 0, 0},
    {0, 0, 0, 0, 1},
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0},
    */
    public void testGetPath_sampleDirected_positive() {
        Graph<Integer> graph = createSampleGraph(true);

        List<Edge<Integer>> result = subject.getPath(graph, 0, 4);

        List<Edge<Integer>> expectedList = List.of(new Edge<>(0, 2), new Edge<>(2, 4));
        Assert.assertEquals(expectedList, result);
    }

    /*
    {0, 1, 1, 1, 0},
    {0, 0, 1, 0, 0},
    {0, 0, 0, 0, 1},
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0},
    */
    public void testGetPath_sampleDirected_noway34() {
        Graph<Integer> graph = createSampleGraph(true);

        List<Edge<Integer>> result = subject.getPath(graph, 3, 4);

        Assert.assertTrue(result.isEmpty());
    }

    /*
    {0, 1, 1, 1, 0},
    {0, 0, 1, 0, 0},
    {0, 0, 0, 0, 1},
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0},
    */
    public void testGetPath_sampleDirected_noway13() {
        Graph<Integer> graph = createSampleGraph(true);

        List<Edge<Integer>> result = subject.getPath(graph, 1, 3);

        Assert.assertTrue(result.isEmpty());
    }

    /*
    {0, 1, 1, 1, 0},
    {0, 0, 1, 0, 0},
    {0, 0, 0, 0, 1},
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0},
    */
    public void testGetPath_sampleDirected_outofBoundsEnd() {
        Graph<Integer> graph = createSampleGraph(true);

        List<Edge<Integer>> result = subject.getPath(graph, 1, 30);

        Assert.assertTrue(result.isEmpty());
    }

    /*
    {0, 1, 1, 1, 0},
    {0, 0, 1, 0, 0},
    {0, 0, 0, 0, 1},
    {0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0},
    */
    public void testGetPath_sampleDirected_outofBoundsStart() {
        Graph<Integer> graph = createSampleGraph(true);

        List<Edge<Integer>> result = subject.getPath(graph, 30, 31);

        Assert.assertTrue(result.isEmpty());
    }

    /*
{0, 1, 1, 1, 0},
{0, 0, 1, 0, 0},
{0, 0, 0, 0, 1},
{0, 0, 0, 0, 0},
{0, 0, 0, 0, 0},
*/
    public void testGetPath_sampleDirected_startEqualsEnd() {
        Graph<Integer> graph = createSampleGraph(true);

        List<Edge<Integer>> result = subject.getPath(graph, 0, 0);

        Assert.assertTrue(result.isEmpty());
    }

    /*
    {1, 0},
    {0, 0},
    */
    public void testGetPath_simpleloop_noway01() {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(0, 0);

        List<Edge<Integer>> result = subject.getPath(graph, 0, 1);

        Assert.assertTrue(result.isEmpty());
    }

    /*
    {1, 0},
    {0, 0},
    */
    public void testGetPath_simpleloopDirected_startEqualsEnd() {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(0, 0);

        List<Edge<Integer>> result = subject.getPath(graph, 0, 0);

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(List.of(new Edge<>(0, 0)), result);
    }

   public void testGetPath_simpleloopUndirected_startEqualsEnd() {
        Graph<Integer> graph = new Graph<>(false);
        graph.addEdge(0, 0);

        List<Edge<Integer>> result = subject.getPath(graph, 0, 0);

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(List.of(new Edge<>(0, 0)), result);
    }

    public void testGetPath_StringType_positive() {
        Graph<String> graph = new Graph<>(true);
        graph.addEdge("a", "b");
        graph.addEdge("b", "c");

        List<Edge<String>> result = subject.getPath(graph, "a", "c");

        List<Edge<String>> expectedList = List.of(new Edge<>("a", "b"), new Edge<>("b", "c"));
        Assert.assertEquals(expectedList, result);
    }

    public void testGetPath_loopOfThreeNodes_noway04() {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(4, 4);

        List<Edge<Integer>> result = subject.getPath(graph, 0, 4);

        Assert.assertTrue(result.isEmpty());
    }

    private Graph<Integer> createSampleGraph(boolean isDirected) {
        Graph<Integer> graph = new Graph<>(isDirected);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        return graph;
    }
}