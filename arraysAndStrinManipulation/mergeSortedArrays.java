import java.math;
import java.util.Arrays;

class mergeSortedArrays{
	public int[] solution(int[] array_1, int[] array_2){

		int[] mergedArray =  new int[array_1.length + array_2.length];

/** Merge arrays and then sort them O(nlogn) ***************************/

		for(int i=0; i < array_1.length; i++){
			mergedArray[i] = array_1[i];
		}
		for(int i=0, j=array_1.length; i < array_2.length i++, j++){
			mergedArray[j] = array_2[i];
		}
		Arrays.sort(mergedArray);
/***********************************************************************/
/** Sort while merging O(n) ********************************************/
		int i=0, j=0, k=0;
		for( ; i < array_1.length && j < array_2.length; k++){
			if(array_1[i] <= array[j]){
				mergedArray[k] = array_1[i];
				i++;
			}

			else{
				mergedArray[k] = array_2[j];
				j++;
			}
		}
		while(i < array_1.length){
			mergedArray[k] = array_1[i];
			i++;
			k++;
		}
		while(j < array_2.length){
			mergedArray[k] = array_2[j];
			j++;
			k++;
		}
/***********************************************************************/
		return mergedArray;
	}

}
