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

	   int index = intArray.length-1;

	   // Find first node of cycle //
	   for(int k = intArray.length; k > 0; k--)
		   index = intArray[index]-1;

	   int index2 = intArray[index]-1;
	   int cycleLength = 1;

	   // Find length of cycle //
	   while(index2 != index){
		   index2 = intArray[index2]-1;
		   cycleLength++;
	   }

	   index = intArray.length-1;
	   index2 = index;

	   // move first pointer ahead by size of cycle //
	   while(cycleLength > 0){
		   index2 = intArray[index2]-1;
		   cycleLength--;
	   }

	   // find duplicate value
	   while(index2 != index){
		   index2 = intArray[index2]-1;
		   index = intArray[index]-1;
	   }

	   return index+1;
   }
   /*************************************************************************/
   /***************************** tests *************************************/

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
