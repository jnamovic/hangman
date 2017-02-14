import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.program.Program;

public class HangmanView extends GCompound {

	HangmanController game;
	HangmanModel model;
	String word,message;
	Gallows execute;
	LetterArea areaOfLetters;
	JLabel feedback;
	private final double wid = 500;
	private final double ht = 650;
	char guessedLetter;
	public HangmanView(HangmanController controller){
		execute = new Gallows(wid, ht);
		game=controller;
	}
	
	public void startUp(HangmanModel model, String word){
		JLabel feedback = new JLabel(message);
		this.model=model;
		this.word=word;
		areaOfLetters=new LetterArea(word); 
		execute = new Gallows(wid, ht);
		add (execute);
		execute.reset();
		message = "Welcome to Hangman";
		add(areaOfLetters);
		game.add(feedback, Program.NORTH);
		
	}
	
	public void guess(String guess, boolean good)
	{
		if(good)
			areaOfLetters.wordUpdate(guess);
		else
			execute.drawNextPart();
	}
	public void winNotification()
	{
		message = "Conflagurations, you won!";
	}
	
	public void loseNotification()
	{
		message = "Hughhhh";
	}
	public void mouseClicked(MouseEvent e) {
		GObject obj = game.getElementAt(new GPoint(e.getPoint()));
		if (obj == null) return;
		if (obj instanceof GLetter) {
			System.out.println("i was clicked");
			if (((GLetter) obj).clickedAlready()){
				message = "You've already guessed that letter you silly billy";
				return;
			}
			GLetter gobj = (GLetter) obj;
			model.guessMade(gobj.getLetter());	
		}
	}

	

}
