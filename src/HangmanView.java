import java.util.ArrayList;

import acm.graphics.GCompound;

public class HangmanView extends GCompound {

	HangmanModel model;
	String word;
	Gallows execute;
	LetterArea areaOfLetters;
	private final double wid = 500;
	private final double ht = 650;
	char guessedLetter;
	public HangmanView(HangmanController controller){
		execute = new Gallows(wid, ht);
	}
	
	public void startUp(HangmanModel model, String word){
		this.model=model;
		this.word=word;
		areaOfLetters=new LetterArea(word); 
		execute = new Gallows(wid, ht);
		add (execute);
		add(areaOfLetters);
		
	}
	
	public void guess(String guess, boolean good)
	{
		
	}
	public void winNotification(){
		
	}
	
	public void loseNotification(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
