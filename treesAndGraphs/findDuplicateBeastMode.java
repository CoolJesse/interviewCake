import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int findDuplicate(int[] intArray) {

       // find a number that appears more than once ... in O(n) time
	   if(intArray == null)
		   throw new NullPointerException("Empty Array");

	   int i = intArray.length-1;
	   // Find first node of cycle //
	   for(int k = intArray.length; k > 0; k--)
		   i = intArray[i]-1;

	   int j = intArray[i]-1;
	   int cycleLength = 1;

	   // Find length of cycle //
	   while(j != i){
		   j = intArray[j]-1;
		   cycleLength++;
	   }

	   i = intArray.length-1;
	   // move first pointer ahead by size of cycle //
	   while(cycleLength > 0){
		   i = intArray[i] -1;
		   cycleLength--;
	   }

	   j = intArray.length-1;
	   while(j != i){
		   j = intArray[j]-1;
		   i = intArray[i]-1;
	   }

	   return i+1;
   }


    // tests

    @Test
    public void justTheRepeatedNumberTest() {
        final int[] numbers = {1, 1};
        final int expected = 1;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void shortArrayTest() {
        final int[] numbers = {1, 2, 3, 2};
        final int expected = 2;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int[] numbers = {1, 2, 5, 5, 5, 5};
        final int expected = 5;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] numbers = {4, 1, 4, 8, 3, 2, 7, 6, 5};
        final int expected = 4;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
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
