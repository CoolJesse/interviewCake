//Implement with an iterative solution !!!/////////////////////////////


class findingRotationsPoint{

	public static int search(String[] list){
		return searchForWord(list, 0, list.length);
	}

	public static int searchForWord(String[] list, int index_1, int index_2){

		if(index_2 < index_1)
			return -1;

		int middle = index_1 + ((index_2 - index_1) / 2);

	/** Found the rotationPoint **/
		if(list[middle].compareToIgnoreCase(list[0]) < 0 && list[middle - 1].compareToIgnoreCase(list[0]) > 0)
			return middle;

	/** We have found a word that comes alphabetically before the word at list[0],
	but not the pivot point **/
		else if(list[middle].compareToIgnoreCase(list[0]) < 0)
			return searchForWord(list, index_1, middle + 1);
	/** This word comes alphabetically before word at list[0] and thus is located
	before out pivot point. **/
		else
			return searchForWord(list, middle, index_2);
	}
}
