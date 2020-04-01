import java.util.Random;

class shuffle{

	private static Random rand = new Random();

	public static int getRandom(int floor, int ceiling){
		return rand.nextInt((ceiling - floor) + 0) + floor;
	}

	public static void swap(int[] array, int index_1, index_2){

		if(index_1 < array.length && index_2 < array.length){
			int temp = array[index_1];
			array[index_1] = array[index_2];
			array[index_2] = temp;
		}
	}

	public static void solution(int[] array){

	// Fisher-Yates shuffle //
		for(int i=0; i < array.length; i++){
			int otherIndex = getRandom(i, array.length);

			if( i != otherIndex)
				swap(array, i, otherIndex);
		}
	}
}
