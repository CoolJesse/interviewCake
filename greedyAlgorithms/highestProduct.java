class highestProduct{

	public static int product(int[] arrayOfInts){

		if (arrayOfInts.length < 3)
			throw new IllegalArgumentException("Less than 3 items!");


		int lowestProductOf2 =  arrayOfInts[0] * arrayOfInts[1];
		int highestProductof2 = arrayOfInts[0] * arrayOfInts[1];
		int highestProductOf3 = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];

		int lowest = Math.min(arrayOfInts[0], arrayOfInts[1]);
		int highest = Math.max(arrayOfInts[0], arrayOfInts[1]);

		for(int i=2; i<arrayOfInts.length; i++){

			highestProductOf3 = Math.max(Math.max(highestProductOf3, highestProductof2 * arrayOfInts[i]), lowestProductOf2 * arrayOfInts[i]);

			highestProductof2 = Math.max(Math.max(highestProductof2, highest * arrayOfInts[i]), lowest * arrayOfInts[i]);

			lowestProductOf2 = Math.min(Math.min(lowestProductOf2, highest * arrayOfInts[i]), lowest * arrayOfInts[i]);

			highest = Math.max(highest, arrayOfInts[i]);
			lowest = Math.min(lowest, arrayOfInts[i]);
		}
		return highestProductOf3;
	}

	public static void main(String[] args){}
}
