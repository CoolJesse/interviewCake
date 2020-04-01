import java.util.Map;
import java.util.HashMap;

class topScores{

	public static int[] sortScores(int[] scores, int highestPossibleScore){
		Map<Integer, Integer> scoresAndFreq = new HashMap<>();
		int[] sortedScores = new int[scores.length];

		for(int theScore : scores){
			int frequency = scoresAndFreq.get(theScore);
			int incrementedFrequency = (frequency == null) ? 1 : frequency++;
			scoresAndFreq.put(theScore, incrementedFrequency);
		}

		/*
		for(int i=0; i < scores.length; i++){
			if(scoresAndFreq.containsKey(scores[i])){
				int frequency = scoresAndFreq.get(scores[i]);
				frequency++;
				scoresAndFreq.replace(scores[i], frequency);
			}
			else
				scoresAndFreq.put(scores[i], 1);
		}
		*/
		for(int i=highestPossibleScore, j=0; i >= 0; i--){
			if(scoresAndFreq.containsKey(i)){
				int frequency = scoresAndFreq.get(i);
				while(frequency > 0){
					sortedScores[j] = i;
					j++;
					frequency--;
				}
			}
		}
		return sortedScores;
	}

}
