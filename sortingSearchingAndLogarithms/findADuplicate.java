import java.util.Arrays;
//Find a Duplicate Space Edition
public class findADuplicate{

	public int solution(int[] intArray){

		if(intArray == null)
			throw new NullPointerException("Null array!");

		if(intArray.length < 2)
			throw new IllegalArgumentException("Array has less than 2 elements!");

		int floor = 1;
		int ceiling = intArray.length - 1;

		while(floor < ceiling){
			int middle = floor + ((ceiling - floor) / 2);
			int lowerFloor = floor;
			int lowerCeiling = middle;
			int upperFloor = middle + 1;
			int upperCeiling = ceiling;

			int itemsInLowerRange = 0;
			for(int items : intArray){
			// Is in lower range //
				if(items >= lowerFloor && items <= lowerCeiling)
					itemsInLowerRange++;
			}

			int distincePossibleIntegersInLowerRange = lowerCeiling - lowerFloor + 1;

		// Duplicate must be in lower range //
			if(itemsInLowerRange > distincePossibleIntegersInLowerRange){
				floor = lowerFloor;
				ceiling = lowerCeiling;
			}
		// Duplicate must be in upper range //
			else{
				floor = upperFloor;
				ceiling = upperCeiling;
			}
		}
	// Floor and Ceiling converge, we found a repeat. //
		return floor;
	}
}
