package demo;

import java.util.List;
import java.util.Map;

import demo.domain.Edge;
import junit.framework.TestCase;

public class PathFinderTest extends TestCase {
    PathFinder subject = new PathFinder();

    public void testPathFind_positive() {
        Map<Integer, Integer> predecessorMap = Map.ofEntries(
                Map. entry(4, 2),
                Map. entry(2, 0));
        List<Edge<Integer>> result = subject.findPath(0, 4, predecessorMap);

        assertEquals(2, result.size());
        assertEquals(0, result.get(0).getStart().intValue());
        assertEquals(2, result.get(0).getEnd().intValue());

        assertEquals(2, result.get(1).getStart().intValue());
        assertEquals(4, result.get(1).getEnd().intValue());

    }
}