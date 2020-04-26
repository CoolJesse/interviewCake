import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

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
            throw new RuntimeException("startNode not present");
        if(!graph.containsKey(endNode))
            throw new RuntimeException("endNode not present");

    // If startNode and end node are the same node //
        if(startNode.equals(endNode))
            return new String[]{startNode};

    // To avoid cycles we add names visited to hashset //
        Set<String> illegalNames = new HashSet<>();
        illegalNames.add(startNode);

        Queue<String[]> q = new LinkedList<>();
        q.add(new String[]{startNode});

        while(q.size() > 0){
            String[] people = q.poll();
		// Check to see if last name in list is the the endNode //
            if(people[people.length-1].equals(endNode))
				return people;

            for(String name : graph.get(people[people.length-1])){
                if(!illegalNames.contains(name)){
					String[] newPeople = Arrays.copyOf(people, people.length+1);
					newPeople[newPeople.length-1] = name;
                    q.add(newPeople);
                    illegalNames.add(name);
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
