package demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import junit.framework.TestCase;

public class VertexValidatorTest extends TestCase {

    VertexValidator subject = new VertexValidator();

    public void testValidate_positive() {
        Map<Integer, LinkedList<Integer>> input = prepareInput();

        boolean result = subject.validate(0, 1, input);

        assertTrue(result);
    }

    public void testValidate_startOutOfBounds_false() {
        Map<Integer, LinkedList<Integer>> input = prepareInput();

        boolean result = subject.validate(100, 1, input);

        assertFalse(result);
    }

    public void testValidate_endOutOfBounds_false() {
        Map<Integer, LinkedList<Integer>> input = prepareInput();

        boolean result = subject.validate(0, 100, input);

        assertFalse(result);
    }

    public void testValidate_endHasNoNeigbours_false() {
        Map<Integer, LinkedList<Integer>> input = prepareInput();

        boolean result = subject.validate(1, 0, input);

        assertFalse(result);
    }

    private Map<Integer, LinkedList<Integer>> prepareInput() {
        Map<Integer, LinkedList<Integer>> input = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        input.put(0, list);

        input.put(1, new LinkedList<>());
        return input;
    }
}