class reverseWords{

	public void solution(char[] words){

/** Method 1 using additonal (n)space ****************************************/
		char[] sortedWords = new char[words.length];

		int sortIndex = 0;

		for(int i=words.length-1, j=words.length-1; j > words.length;){
			if(words[j-1] = ' '){
				for(int k=j; k<=i; k++){
					sortedWords[sortIndex] = words[k];
					sortIndex++;
				}
				sortedIndex++;
				sortedWords[sortIndex] = ' ';
				j =-2;
				i=j;
			}

			else
				j--;
		}
		words = sortedWords;
/*****************************************************************************/
/** Method 2 sorting in place ***********************************************/
/** First reverse whole string so words are in correct order but letters are
backwards *****************************************************************/
		for(int i=0, j=(words.length-1); i<j; i++, j--){
			char temp = words[i];
			words[i] = words[j];
			words[j] = temp;
		}
/** Now reverse the chars in each word so they are in the correct order *****/
		int i=0, j=0;
		for( ;j < words.length; j++){
			if(words[j] == ' ' || j == words.length){
				for(int k=j-1; k>i; k--, i++){
					char temp = words[i];
					words[i] = words[k];
					words[k] = temp;
				}
				i=j+1;
			}
		}
}
