
/*
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;
*/
public class cakeThief {
/****************************** Nested Inner Class ****************************/
    public static class CakeType {

        final int weight;
        final int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value  = value;
        }
    }
/**************************** Iterative Solution ******************************/
/*
    public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {

        // calculate the maximum value that we can carry
        long[] maxCapacity = new long[weightCapacity + 1];

        for(int i=0; i < maxCapacity.length; i++){
            for(CakeType thisCake : cakeTypes){

                if(thisCake.weight == 0 && thisCake.value != 0)
                    throw new RuntimeException("Zero weight but not zero value!");

                int prevMaxIndex = i - thisCake.weight;

                if(prevMaxIndex >= 0){
                    maxCapacity[i] = Math.max(maxCapacity[i], thisCake.value + maxCapacitygibson sg[prevMaxIndex]);
                }
            }
        }

        return maxCapacity[weightCapacity];
    }
*/
/**************************** Recursive Solution ******************************/
/*
    public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity){

		if(weightCapacity <= 0)
			return 0;

		long maxValue = maxDuffelBagValue(cakeTypes, weightCapacity - 1);

		for(CakeType thisCake : cakeTypes){

			if(thisCake.weight <= weightCapacity){
				if(thisCake.weight == 0){
					if(thisCake.value != 0)
						throw new RuntimeException("Zero weight but not zero value!");
				}
				else{
					maxValue = Math.max(maxValue, maxDuffelBagValue(cakeTypes,
					weightCapacity - thisCake.weight) + thisCake.value);
				}
			}
		}
		return maxValue;
	}
*/
/****************************** Recursion with memoization  **********************/
    public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity){

		long[] maxValues = new long[weightCapacity + 1];

		return maxDuffelBagValue(cakeTypes, weightCapacity, maxValues);
	}

    public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity, long[] record){

		if(weightCapacity <= 0)
			return 0;

		if(record[weightCapacity] != 0)
			return record[weightCapacity];

		long maxValue = maxDuffelBagValue(cakeTypes, weightCapacity - 1, record);

		for(CakeType thisCake : cakeTypes){

			if(thisCake.weight <= weightCapacity){
				if(thisCake.weight == 0){
					if(thisCake.value != 0)
						throw new RuntimeException("Zero weight but not zero value!");
				}
				else
					maxValue = Math.max(maxValue, maxDuffelBagValue(cakeTypes, weightCapacity - thisCake.weight) + thisCake.value);
			}
		}
		record[weightCapacity] = maxValue;
		return maxValue;
	}

/******************************************************************************/
/*********************************** tests ************************************/
/*
    @Test
    public void oneCakeTest() {
        final CakeType[] cakeTypes = {new CakeType(2, 1)};
        final int weightCapacity = 9;
        final long expected = 4;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void twoCakesTest() {
        final CakeType[] cakeTypes = {new CakeType(4, 4), new CakeType(5, 5)};
        final int weightCapacity = 9;
        final long expected = 9;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void onlyTakeLessValuableCakeTest() {
        final CakeType[] cakeTypes = {new CakeType(4, 4), new CakeType(5, 5)};
        final int weightCapacity = 12;
        final long expected = 12;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void lotsOfCakesTest() {
        final CakeType[] cakeTypes = {
            new CakeType(2, 3), new CakeType(3, 6), new CakeType(5, 1),
            new CakeType(6, 1), new CakeType(7, 1), new CakeType(8, 1)
        };
        final int weightCapacity = 7;
        final long expected = 12;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void valueToWeightRatioIsNotOptimalTest() {
        final CakeType[] cakeTypes = {new CakeType(51, 52), new CakeType(50, 50)};
        final int weightCapacity = 100;
        final long expected = 100;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void zeroCapacityTest() {
        final CakeType[] cakeTypes = {new CakeType(1, 2)};
        final int weightCapacity = 0;
        final long expected = 0;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test
    public void cakeWithZeroValueAndWeightTest() {
        final CakeType[] cakeTypes = {new CakeType(0, 0), new CakeType(2, 1)};
        final int weightCapacity = 7;
        final long expected = 3;
        final long actual = maxDuffelBagValue(cakeTypes, weightCapacity);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void cakeWithNonZeroValueAndZeroWeightTest() {
        final CakeType[] cakeTypes = {new CakeType(0, 5)};
        final int weightCapacity = 5;
        maxDuffelBagValue(cakeTypes, weightCapacity);
    }
*/

    public static void main(String[] args) {
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
