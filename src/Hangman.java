import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * https://web.stanford.edu/class/archive/cs/cs106a/cs106a.1124/handouts/200%20Assignment%204.pdf
 * 
 * @author Allen
 *
 */
public class Hangman {
	
	private String word;
	private boolean[] isUnmasked; 
	private int unmaskedCount = 0;
	
	private final int GUESS_ALLOWED = 6;
	
	private HangmanGUI gui;

	public static void main(String[] args) {
		new Hangman();
	}
	
	public Hangman() {
		// initialize data
		initGameData();
		
		// initialize GUI
		gui = new HangmanGUI();
		
		// show welcome prompt
		System.out.println("Welcome to Hangman!");
		
		// scanner
		Scanner scanner = new Scanner(System.in);
		
		int guessCount = 0;
		while (guessCount < GUESS_ALLOWED) {
			System.out.println();
			// masked word
			StringBuilder maskedWordBuilder = new StringBuilder(word.length());
			for (int i = 0; i < word.length(); i++) {
				if (isUnmasked[i]) {
					maskedWordBuilder.append(word.charAt(i));
				} else {
					maskedWordBuilder.append('-');
				}
			}
			System.out.printf("The word now looks like this: %s\n", maskedWordBuilder.toString());
			
			System.out.printf("You have %d guesses left.\n", GUESS_ALLOWED - guessCount);
			
			// input guess
			System.out.print("Your guess: ");
			String guess = scanner.nextLine();
			
			// check with the word
			char guessedChar = guess.toUpperCase().toCharArray()[0];
			String wordUpperCase = word.toUpperCase();
			boolean isCorrect = false;
			for (int i = 0; i < wordUpperCase.length(); i++) {
				if (wordUpperCase.charAt(i) == guessedChar) {
					isUnmasked[i] = true;
					unmaskedCount++;
					isCorrect = true;
				}
			}
			
			if (!isCorrect) {
				guessCount++;
				System.out.printf("There are no no %c's in the word.\n", guessedChar);
				gui.canvas.enablePart();
			} else {
				System.out.println("Your guess is correct.");
				if (unmaskedCount == word.length()) { // complete the word
					break;
				}
			}
		}
		
		// win or not
		if (unmaskedCount < word.length()) { // lost
			System.out.println("You're completely hung.");
			System.out.printf("The word was: %s\n", word);
			System.out.println("You lose.");
		} else { // win
			System.out.printf("You guessed the word: %s\n", word);
			System.out.println("You win.");
		}
		
		scanner.close();
	}
	
	private void initGameData() {
		// get word
		HangmanLexicon hangmanLexicon = new HangmanLexicon();
		Random random = new Random();
		int index = random.nextInt(hangmanLexicon.getWordCount());
		word = hangmanLexicon.getWord(index);
		//System.out.println(word);
		
		// initialize guessed
		isUnmasked = new boolean[word.length()];
		for (int i = 0; i < word.length(); i++) {
			isUnmasked[i] = false;
		}
	}
	
}
