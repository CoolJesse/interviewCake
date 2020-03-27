class reverseString{

	public String solution(String s){
		char word = s.toCharArray();

		for(int i=0, j=(word.length-1); i < j; i++, j--){
			char temp = word[i];
			word[i] = word[j];
			word[j] = temp;
		}
		return Arrays.toString(word);
	}
}
