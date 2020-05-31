import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {

    public static int getClosingParen(String sentence, int openingParenIndex) {

        // find the position of the matching closing parenthesis
		if(sentence.charAt(openingParenIndex) != '(')
			throw new RuntimeException("Index position does not contain parenthesis");

		Deque<Character> queue = new ArrayDeque<>();

		for(int i=openingParenIndex; i < sentence.length(); i++){
			if(sentence.charAt(i) == '(')
				queue.push('(');

			if(sentence.charAt(i) == ')')
				queue.pop();

			if(queue.isEmpty())
				return i;
		}

        throw new RuntimeException("No closing parenthesis.");
    }

/******************************************************************************/
/*********************************** tests ************************************/

    @Test
    public void allOpenersThenClosersTest() {
        final int expected = 7;
        final int actual = getClosingParen("((((()))))", 2);
        assertEquals(expected, actual);
    }

    @Test
    public void mixedOpenersAndClosersTest() {
        final int expected = 10;
        final int actual = getClosingParen("()()((()()))", 5);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void noMatchingCloserTest() {
        getClosingParen("()(()", 2);
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
