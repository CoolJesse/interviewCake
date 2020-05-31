import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {

    public static boolean isValid(String code) {

        // determine if the input code is valid
		Deque<Character> queue = new ArrayDeque<>();

		for(int i=0; i<code.length(); i++){
			char thisChar = code.charAt(i);

			if(thisChar == '(' || thisChar =='[' || thisChar == '{')
				queue.push(thisChar);

			else if(thisChar == ')'){
				if(queue.isEmpty() || queue.pop() != '(')
					return false;
			}

			else if(thisChar ==']'){
				if(queue.isEmpty() || queue.pop() != '[')
					return false;
			}

			else if(thisChar == '}'){
				if(queue.isEmpty() || queue.pop() != '{')
					return false;
			}

			else
				; //Do nothing
		}

		if(queue.isEmpty())
        	return true;

		else
			return false;
    }

/******************************************************************************/
/*********************************** tests ************************************/

    @Test
    public void validShortCodeTest() {
        final boolean result = isValid("()");
        assertTrue(result);
    }

    @Test
    public void validLongerCodeTest() {
        final boolean result = isValid("([]{[]})[]{{}()}");
        assertTrue(result);
    }

    @Test
    public void mismatchedOpenerAndCloserTest() {
        final boolean result = isValid("([][]}");
        assertFalse(result);
    }

    @Test
    public void interleavedOpenersAndClosersTest() {
        final boolean result = isValid("([)]");
        assertFalse(result);
    }

    @Test
    public void missingCloserTest() {
        final boolean result = isValid("[[]()");
        assertFalse(result);
    }

    @Test
    public void extraCloserTest() {
        final boolean result = isValid("[[]]())");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = isValid("");
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
