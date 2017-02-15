import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.program.Program;

public class HangmanView extends GCompound implements MouseListener, ActionListener {

	HangmanController game;
	HangmanModel model;
	String word,message;
	Gallows execute;
	LetterArea areaOfLetters;
	JLabel feedback;
	GLetter gobj ;
	private final double wid = 150;
	private final double ht = 150;
	char guessedLetter;
	public HangmanView(HangmanController controller){
		execute = new Gallows(wid, ht);
		game=controller;
		message = "Welcome to Hangman";
		feedback = new JLabel(message);
		game.add(feedback, Program.NORTH);
		game.add(new JButton("New Game"), Program.SOUTH);
		game.addMouseListeners(this);
		game.addActionListeners(this);
	}
	
	public void startUp(HangmanModel model, String word){
		game.removeAll();
		this.model=model;
		this.word=word;
		areaOfLetters=new LetterArea(word); 
		execute = new Gallows(wid, ht);
		add (execute,300,150);
		execute.reset();
		
		add(areaOfLetters);
		game.add(this);
		
	}
	
	public void guess(String guess, boolean good)
	{
		if(good){
			areaOfLetters.wordUpdate(guess);
			gobj.onceGuessed(true);
		}
		else{
			execute.drawNextPart();
			gobj.onceGuessed(false);
		}
	}
	public void winNotification()
	{
		
		message = "Conflagurations, you won!";
		feedback.setText(message);
		
	}
	
	public void loseNotification()
	{
		message = "Hughhhh";
		feedback.setText(message);
		
	}
	public void mouseClicked(MouseEvent e) {
		
		GObject obj = areaOfLetters.giveChar(e.getX(),e.getY());
		if(obj==null){
			return;
		}
		gobj = (GLetter) obj;
		model.guessMade(gobj.getLetter());	
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New Game")) {
			model.setUpGame();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
