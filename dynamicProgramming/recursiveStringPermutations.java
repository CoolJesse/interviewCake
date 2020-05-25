import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Arrays;

/*
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;
*/

public class recursiveStringPermutations{

    public static Set<String> getPermutations(String inputString) {

        // generate all permutations of the input string
        if(inputString.length() <= 1)
            return new HashSet<>(Collections.singletonList(inputString));

        String firstLetter = inputString.substring(0, 1);
        String allButFirst = inputString.substring(1);

        // Recursive call to getPermutations() ////////////
        Set<String> result = getPermutations(allButFirst);
        ///////////////////////////////////////////////////

        for(Object current : result.toArray()){

            StringBuilder fullWord = new StringBuilder(firstLetter);
            fullWord.append(current.toString());

            result.add(fullWord.toString());
            result.remove(current.toString());

            for(int i=0; i < fullWord.length()-1; i++){
                char temp = fullWord.charAt(i);
                fullWord.setCharAt(i, fullWord.charAt(i+1));
                fullWord.setCharAt(i+1, temp);
                result.add(fullWord.toString());
            }
        }
        return result;
    }

/*****************************************************************************/
/********************************** Tests ************************************/
    /*
    @Test
    public void emptyStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList(""));
        final Set<String> actual = getPermutations("");
        assertEquals(expected, actual);
    }

    @Test
    public void oneCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("a"));
        final Set<String> actual = getPermutations("a");
        assertEquals(expected, actual);
    }

    @Test
    public void twoCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("ab", "ba"));
        final Set<String> actual = getPermutations("ab");
        assertEquals(expected, actual);
    }

    @Test
    public void threeCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca",
                                                                 "cab", "cba"));
        final Set<String> actual = getPermutations("abc");
        assertEquals(expected, actual);
    }
    */
/******************************************************************************/
/************************** Main body of the program **************************/
    public static void main(String[] args) {
	/* 
	Result result = JUnitCore.runClasses(Solution.class);
	for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
	
	*/
    }
}
