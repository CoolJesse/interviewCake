import java.util.Set;
import java.util.HashSet;

class inFlight{
	public boolean solution(int flightLength, int[] movieLengths){

/** Create hashmap to hold movie times and count number of films of same length **/
		Set<int> times = new HashSet<>();

/** Pass through array looking for match and populating hashmap o(n) **********/
	for( int firstMovie : movieLength){
		int secondMovie = flightLength - firstMovie;

		if(times.contains(secondMovie))
			return true;

		else
			times.add(firstMovie);
	}

/** No two movies found to fill time requirement ******************************/
	return false;

}
