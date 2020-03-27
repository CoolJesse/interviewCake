class cafeOrder{

	public boolean solution{int[] takeOut, int[] dineIn, int[] finalOrder}{

		boolean inOrder = false;

		for(int i=0; j=0; k=0; k < finalOrder.length; k++){

			inOrder = false;

			if(i < takeOut.length){
				if(finalOrder[k] == takeOut[i]){
					inOrder = true;
					i++;
				}
			}

			if(j < dineIn.length){
				if(finalOrder[k] == dineIn[j]){
					inOrder = true;
					j++;
				}
			}

			if(inOrder == false)
				return false;
		}
		return true;
	}
}
