import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GPoint;

public class HangmanView extends GCompound {

	HangmanController game;
	HangmanModel model;
	String word;
	Gallows execute;
	GLabel feedback;
	LetterArea areaOfLetters;
	private final double wid = 500;
	private final double ht = 650;
	char guessedLetter;
	public HangmanView(HangmanController controller){
		execute = new Gallows(wid, ht);
		game=controller;
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
	public void mouseClicked(MouseEvent e) {
		GObject obj = game.getElementAt(new GPoint(e.getPoint()));
		if (obj == null) return;
		if (obj instanceof GLetter) {
			GLetter gobj = (GLetter) obj;
			//model.((gobj).getLetter());	
		}
	}

	

}
