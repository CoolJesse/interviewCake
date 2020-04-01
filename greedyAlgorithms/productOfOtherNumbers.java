class productOfOtherNumbers{

	public int[] getProductOfAllIntsExceptIndex(int[] intArray){

		if(intArray.length < 2)
			throw new IllegalArgumentException("This method requires at least 2 numbers.");

		int[] productOfAllOtherInts = new int[intArray.length];
		int productSoFar = 1;

		for(int i=0; i < intArray.length; i++){
			productOfAllOtherInts[i] = productSoFar;
			productSoFar *= intArray[i];
		}

		for(int i=intArray.length-1; i >= 0; i--){
			productOfAllOtherInts[i] *= productSoFar;
			productSoFar *= intArray[i];
		}

		return productOfAllOtherInts;
	}
}
