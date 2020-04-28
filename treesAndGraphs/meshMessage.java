import java.util.Map;
import java.util.HashMap;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;
*/
//public class Solution {
public class meshMessage{

/****** getPath algorithm looks for shortest path between startNode and endNode **********************/
    public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode){
    // find the shortest route in the network between the two users
        if(graph.isEmpty())
            throw new NullPointerException("Empty graph!");

    // Test to make sure both origin and destination are present in graph //
        if(!graph.containsKey(startNode))
            throw new IllegalArgumentException("startNode not present");
        if(!graph.containsKey(endNode))
            throw new IllegalArgumentException("endNode not present");

    // If startNode and end node are the same node //
        if(startNode.equals(endNode))
            return new String[]{startNode};

    // To avoid cycles and reconstruct path we add names visited to hashmap //
		Map<String, String> path = new HashMap<>();
		path.put(startNode, null);

        Deque<String> q = new ArrayDeque<>();
        //q.addLast(new String[]{startNode});
        q.addLast(startNode);

		while(!q.isEmpty()){
			String person = q.removeFirst();
			if(person.equals(endNode))
				return reconstructPath(path, startNode, endNode);

			for(String neighbor : graph.get(person)){
				if(!path.containsKey(neighbor)){
					q.add(neighbor);
					path.put(neighbor, person);
				}
			}
		}

        return null;
    }
/** Contains() helper function scans String array looking for v1 and returns true if found **/
    private static boolean contains(String[] array, String v1){
        for(String v2 : array){
            if(v2.equals(v1))
                return true;
        }
        return false;
    }
/****** Function to back track and recontruct path from start to finish *******/
public static String[] reconstructPath(Map<String, String> howWeReachedNodes,
    String startNode, String endNode) {

    List<String> shortestPath = new ArrayList<>();

    // start from the end of the path and work backwards
    String currentNode = endNode;

    while (currentNode != null) {
        shortestPath.add(currentNode);
        currentNode = howWeReachedNodes.get(currentNode);
    }

	Collections.reverse(shortestPath);
    return shortestPath.toArray(new String[shortestPath.size()]);
}

/***********************************************************************************************/
/********************************************* TESTS *******************************************/
/*
    @Test
    public void twoHopPath1Test() {
        final String[] expected = {"a", "c", "e"};
        final String[] actual = getPath(getNetwork(), "a", "e");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoHopPath2Test() {
        final String[] expected = {"d", "a", "c"};
        final String[] actual = getPath(getNetwork(), "d", "c");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath1Test() {
        final String[] expected = {"a", "c"};
        final String[] actual = getPath(getNetwork(), "a", "c");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath2Test() {
        final String[] expected = {"f", "g"};
        final String[] actual = getPath(getNetwork(), "f", "g");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath3Test() {
        final String[] expected = {"g", "f"};
        final String[] actual = getPath(getNetwork(), "g", "f");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void zeroHopPath() {
        final String[] expected = {"a"};
        final String[] actual = getPath(getNetwork(), "a", "a");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void noPathTest() {
        final String[] actual = getPath(getNetwork(), "a", "f");
        assertNull(actual);
    }

    @Test(expected = Exception.class)
    public void startNodeNotPresentTest() {
        getPath(getNetwork(), "h", "a");
    }

    @Test(expected = Exception.class)
    public void endNodeNotPresentTest() {
        getPath(getNetwork(), "a", "h");
    }
*/
/************************************************************/
    private static Map<String, String[]> getNetwork() {
        return new HashMap<String, String[]>() { {
            put("a", new String[] {"b", "c", "d"});
            put("b", new String[] {"a", "d"});
            put("c", new String[] {"a", "e"});
            put("d", new String[] {"a", "b"});
            put("e", new String[] {"c"});
            put("f", new String[] {"g"});
            put("g", new String[] {"f"});
        }};
    }
/************************************************************/
    public static void main(String[] args) {

		System.out.println(Arrays.toString(getPath(getNetwork(), "a", "e")));
		System.out.println(Arrays.toString(getPath(getNetwork(), "d", "c")));
		System.out.println(Arrays.toString(getPath(getNetwork(), "a", "e")));
		/*
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
		*/
    }
}
