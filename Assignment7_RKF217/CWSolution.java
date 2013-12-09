
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 
 * @author kevin_fox
 *
 */
public class CWSolution {
	private DictHolderArrayList d;
	private WordFinder wf;

	/**
	 * CWSolution constructor.
	 * 
	 * @param allWords The List of words to be used as dictionary for testing
	 * 
	 */
	public CWSolution(List<String> allWords)
	{
		//Adds all words to DictHolder if the List of allWords isn't null & is greater than 0
		if(allWords!=null && allWords.size()>0){
			d = new DictHolderArrayList();
			for(String word : allWords){
				d.addWord(word);
			}
		}
	}

	/**
	 * This function returns the maximum number of solutions found given the pattern passed in (Example: P*T would return [PAT, PUT, etc ].
	 * 
	 * @param pattern The pattern to use for the search
	 * @param maxRequired The maximum number solutions required
	 * @return A list of solutions found
	 */
	public List<String> solutions(String pattern, int maxRequired)
	{
		List<String> sols = new ArrayList<String>();

		//If the dictHolder is null, then we don't have a valid CWSolution instance and return a empty List
		if(d==null){
			return sols;
		}

		if(pattern!=null && pattern.length()>1 && maxRequired>=0){
			//Clean pattern first
			pattern = cleanString(pattern);
			//Create  wordFinder instance with clean pattern
			wf = new WordFinder(pattern);

			//Get all possible words based on length of the pattern
			List<String> possibleWords = d.getWordsToSearchThrough(pattern.length());
			//Create iterator for the list of possible words to search pattern agaisnt
			Iterator<String> iter = possibleWords.iterator();

			while(iter.hasNext() && sols.size()<maxRequired){
				String word = iter.next();
				boolean isWordMatch = wf.checkWord(word);

				//If the word is a match against the pattern then we add the word to the
				//solution list to be returned.
				if(isWordMatch){
					sols.add(word);
				}

			}

		}
		return sols;
	}

	/*
	 * cleanString() function takes in a String pattern and removes leading or trailing whitespace
	 * and capitalizes any lower class characters.
	 */
	private String cleanString(String pattern) {
		String patternUpdated = "";
		pattern = pattern.trim();
		for(int i =0;i<pattern.length();i++){
			Character c = pattern.charAt(i);
			if(Character.isLowerCase(c)||Character.isUpperCase(c)){
				c = Character.toUpperCase(c);
				patternUpdated+=c;

			}else if(c=='*'){
				patternUpdated+=c;
			}
		}
		return patternUpdated;
	}


}

