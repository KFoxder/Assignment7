import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author kevin_fox
 *
 */
public class DictHolderLinkedList {

	private LinkedList<String> word2,word3,word4,word5,
							  word6,word7,word8,word9,word10,
							  word11,word12,word13plus;

	/**
	 * Constructor for the DictHolder class that holds the words to be tested against.
	 */
	public DictHolderLinkedList(){
		/*
		 * Creates bins for the length of the words to decrease search time
		 */
		this.word2 = new LinkedList<String>();
		this.word3 = new LinkedList<String>();
		this.word4 = new LinkedList<String>();
		this.word5 = new LinkedList<String>();
		this.word6 = new LinkedList<String>();
		this.word7 = new LinkedList<String>();
		this.word8 = new LinkedList<String>();
		this.word9 = new LinkedList<String>();
		this.word10 = new LinkedList<String>();
		this.word11= new LinkedList<String>();
		this.word12 = new LinkedList<String>();
		this.word13plus = new LinkedList<String>();

	}

	/**
	 * Takes a word and adds it to the respective bin depending upon the length of the word added.
	 * 
	 * @param word Word to be added to the DictHolder array that cannot be null
	 */
	public void addWord(String word){
		if(word!=null&&word.length()>1){
			int wordLen = word.length();
			switch(wordLen){
			case 2:
				word2.add(word);
				break;
			case 3:
				word3.add(word);
				break;
			case 4:
				word4.add(word);
				break;
			case 5:
				word5.add(word);
				break;
			case 6:
				word6.add(word);
				break;
			case 7:
				word7.add(word);
				break;
			case 8:
				word8.add(word);
				break;
			case 9:
				word9.add(word);
				break;
			case 10:
				word10.add(word);
				break;
			case 11:
				word11.add(word);
				break;
			case 12:
				word12.add(word);
				break;
			default:
				word13plus.add(word);
				break;
			}
		}

	}

	/**
	 * Returns the ArrayList of words depending upon the length parameter passed in.
	 * @param len The length of the words requested, must be greater than 0
	 * @return A list of words of length @{len} or null if @{len} is less than or equal to 0
	 */
	public LinkedList<String> getWordsToSearchThrough(int len){
		if(len>1){
			switch(len){
			case 2:
				return this.word2;
			case 3:
				return this.word3;
			case 4:
				return this.word4;
			case 5:
				return this.word5;
			case 6:
				return this.word6;
			case 7:
				return this.word7;
			case 8:
				return this.word8;
			case 9:
				return this.word9;
			case 10:
				return this.word10;
			case 11:
				return this.word11;
			case 12:
				return this.word12;
			default:
				return this.word13plus;


			}
		}
		return null;
	}

	

}
