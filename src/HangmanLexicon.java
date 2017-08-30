import java.util.NoSuchElementException;

/**
 * 
 */

/**
 * @author Allen
 *
 */
public class HangmanLexicon {
	
	private String[] words = {"BUOY", "COMPUTER", "CONNOISSEUR", "DEHYDRATE", "FUZZY", "HUBBUB", "KEYHOLE", "QUAGMIRE", "SLITHER", "ZIRCON"};
	
	/**
	 * returns the number of words in the lexicon
	 * @return number of words in the lexicon
	 */
	public int getWordCount() {
		return words.length;
	}
	
	/**
	 * returns the word at the specified index
	 * @param index
	 * @return the word at the specified index
	 */
	public String getWord(int index) {
		if (index < 0 || index >= words.length) {
			throw new NoSuchElementException("getWord: Illegal index");
		}
		return words[index];
	}
	
}
