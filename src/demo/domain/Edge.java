package demo.domain;

import java.util.Objects;

public class Edge<V> {

    private final V start;

    private final V end;

    public Edge(V start, V end) {
        this.start = start;
        this.end = end;
    }

    public V getStart() {
        return start;
    }

    public V getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Edge)){
            return false;
        }
        Edge<?> edge = (Edge<?>) o;
        return start.equals(edge.start) &&
                end.equals(edge.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
