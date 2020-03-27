import java.util.Set;
import java.util.HasSet;

class permutationPalindrome{

	public boolean isPalindrome(String s){

	Set<Character> allCharacters = new HashSet<>();

	for(Character thisChar : s.toCharArray()){
		if(allCharacters.contains(thisChar))
			allCharacters.remove(thisChar);

		else
			allCharacters.add(thisChar);
	}

	return allCharacters.size() <= 1;
}
