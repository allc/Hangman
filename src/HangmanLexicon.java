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
	
	private String lexiconFilePath = "wordlist.txt";
		
	private ArrayList<String> words = new ArrayList<String>();

	/**
	 * use specified lexicon file
	 * @param lexiconFilePath lexicon file path
	 */
	public HangmanLexicon(String lexiconFilePath) {
		this.lexiconFilePath = lexiconFilePath;
		getWords();
	}
	
	/**
	 * use default lexicon file
	 */
	public HangmanLexicon() {		
		getWords();
	}

	/**
	 * read words from lexicon file into ArrayList
	 */
	private void getWords() {
		// check if lexicon file exists
		File lexiconFile = new File(lexiconFilePath);
		if (!lexiconFile.exists()) {
			System.out.println("The lexicon file does not exists!");
			System.out.println("Make sure there is a wordlist.txt file in the directory or specify another lexicon file.");
			System.exit(0);
		}
		// get words
		BufferedReader bufferedrReader = null;
		try {
			FileReader fileReader = new FileReader(lexiconFile);
			bufferedrReader = new BufferedReader(fileReader);
			String word;
			while ((word = bufferedrReader.readLine()) != null && !word.equals("")) {
				words.add(word);
			}
			// check if there are words added
			if (words.isEmpty()) {
				System.out.println("The lexicon file does not contain any words!");
				System.exit(0);
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
