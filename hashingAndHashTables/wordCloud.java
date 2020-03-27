import java.util.Map;
import java.util.HashMap;

class wordCloud{
	public static Map<String, Integer> solution(String s){

	/** Convert all characters to lowercase and return a string buffer **/
		StringBuffer theString = new StringBuffer(s.toLowerCase());
		Map<String, Integer> allCharacters = new HashMap<>();

	/** Iterate through string buffer looking for words *****************/
		for(int i=0, j=0; i < theString.length(); i = j+1){
			j=i;
			while(j < theString.length()){
				if(Character.isLetter(theString.charAt(j)) ||
				Character.isDigit(theString.charAt(j)))
					j++;

				else if(theString.charAt(j) == '-' || theString.charAt(j) == '\'')
					j++;

				else
					break;

			}

		/** if j == i then first character tested is not a letter **/
			if(j != i){
				String word = theString.substring(i, j);

				if(allCharacters.containsKey(word)){
					int counter = allCharacters.get(word);
					counter++;
					allCharacters.replace(word, counter);
				}

				else
					allCharacters.put(word, 1);
			}
		/***********************************************************/
		}
		return allCharacters;
	}
	/***********************************************************************/
	public static void main(String[] args){

		System.out.println("Testing!!!");
		String testString_1 = "After beating the eggs, Dana read the next step: Add milk and eggs, then add flour and sugar.";
		String testString_2 = "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake. The bill came to five dollars.";
		String testString_3 = "Fuck the World's fuck you!";

		Map<String, Integer> result = solution(testString_1);
		System.out.println("Number of words of testString_1: " + result.size());
		result = solution(testString_2);
		System.out.println("Number of words of testString_2: " + result.size());
		result = solution(testString_3);
		System.out.println("Number of words of testString_2: " + result.size());
	}
}
