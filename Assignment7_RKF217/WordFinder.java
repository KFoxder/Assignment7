import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 * @author kevin_fox
 *
 */
public class WordFinder {


	private int length;
	private HashMap<Integer,Character> nonWilds;

	/**
	 * Constructor for WordFinder class.
	 * 
	 * @param pattern A pattern of *'s and Letters (Example: P**N), cannot be null
	 */
	public WordFinder(String pattern){
		if(pattern!=null){
			this.length = pattern.length();
			this.nonWilds = new HashMap<Integer,Character>(length);

			//Iterate through pattern and only add nonWild characters to hashMap
			for(int i = 0; i<length;i++){
				Character c = pattern.charAt(i);
				if(c!='*'&&Character.isLetter(c)){
					nonWilds.put(i, c);
				}

			}

		}

	}

	/**
	 * This function takes a String and checks if it matches the pattern used to construct the WordFinder class.
	 * 
	 * @param word The word to be checked against the pattern
	 * @return True if the word passed in is a match or false otherwise
	 */
	public boolean checkWord(String word){
		if(nonWilds!=null){
			//Make sure word is the same length before proceeding
			if(word.length()!=this.length){
				return false;
			}else{
				//Iterate through nonWild Characters of our pattern and check if string being checked contains all of them
				for(Entry<Integer,Character> set : nonWilds.entrySet()){

					int index = set.getKey();
					char c = set.getValue();

					char cToCheck = Character.toUpperCase(word.charAt(index));

					if(c != cToCheck){
						return false;
					}


				}
			}
		}



		return true;
	}

}
