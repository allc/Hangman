import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * 
 */

/**
 * @author Allen
 *
 */
public class HangmanLexicon {
		
	private ArrayList<String> words = new ArrayList<String>();

	/**
	 * get the words from a text file
	 */
	public HangmanLexicon() {
		BufferedReader bufferedrReader = null;
		try {
			FileReader fileReader = new FileReader("wordlist.txt");
			bufferedrReader = new BufferedReader(fileReader);
			String word;
			while ((word = bufferedrReader.readLine()) != null && !word.equals("")) {
				words.add(word);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedrReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * returns the number of words in the lexicon
	 * @return number of words in the lexicon
	 */
	public int getWordCount() {
		return words.size();
	}
	
	/**
	 * returns the word at the specified index
	 * @param index
	 * @return the word at the specified index
	 */
	public String getWord(int index) {
		if (index < 0 || index >= words.size()) {
			throw new NoSuchElementException("getWord: Illegal index");
		}
		return words.get(index);
	}
	
}
