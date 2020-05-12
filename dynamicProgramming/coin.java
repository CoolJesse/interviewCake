import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
/*
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;
*/

//public class Solution {
/**************************** Iterative Solution ****************************/
	public class coin{

		public static int changePossibilities(int amount, int[] denominations){
			int[] possibilities = new int[amount + 1];
			Arrays.fill(possibilities, 0);
			possibilities[0] = 1;

			for(int i=0; i < denominations.length; i++){
				int coin = denominations[i];

				for(int j=coin; j <= amount; j++){
					possibilities[j] += possibilities[j-coin];
				}
			}
			return possibilities[amount];
		}
/**************************** Recursive Solution ****************************/
/*
public class coin{

    private static Map<String, Integer> memo = new HashMap<>();

    public static int changePossibilities(int amount, int[] denominations) {

        // calculate the number of ways to make change
        if(denominations == null || denominations.length == 0)
            return 0;
        return changePossibilities(amount, denominations, 0);
    }

    public static int changePossibilities(int amountLeft, int[] denominations, int currentIndex){

		String memoKey = amountLeft + ", " + currentIndex;
        if (memo.containsKey(memoKey))
            return memo.get(memoKey);

        if(amountLeft == 0) return 1;
		if(currentIndex == denominations.length) return 0;

        int currentCoin = denominations[currentIndex];

        if(currentCoin > amountLeft) return 0;
        if(amountLeft < 0) return 0;

        int numPossibilities = 0;
        while(amountLeft >= 0){
            numPossibilities += changePossibilities(amountLeft, denominations, currentIndex + 1);
            amountLeft -= currentCoin;
        }

        memo.put(memoKey, numPossibilities);
        return numPossibilities;

    }
	*/
/******************************************************************************/
/*********************************** tests ************************************/
/*
	@Test
    public void sampleInputTest() {
        final int actual = changePossibilities(4, new int[] {1, 2, 3});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void oneWayToMakeZeroCentsTest() {
        final int actual = changePossibilities(0, new int[] {1, 2});
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void noWaysIfNoCoinsTest() {
        final int actual = changePossibilities(1, new int[] {});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void bigCoinValueTest() {
        final int actual = changePossibilities(5, new int[] {25, 50});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void bigTargetAmountTest() {
        final int actual = changePossibilities(50, new int[] {5, 10});
        final int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void changeForOneDollarTest() {
        final int actual = changePossibilities(100, new int[] {1, 5, 10, 25, 50});
        final int expected = 292;
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
*/
	public static void main(String[] args) {
		/*final int actual = changePossibilities(4, new int[] {1, 2, 3});
		final int expected = 4;*/

		final int actual = changePossibilities(100, new int[] {1, 5, 10, 25, 50});
		final int expected = 292;

		System.out.println("Actual: " + actual + " Expected: " + expected);
	}


}
