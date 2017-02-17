import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.graphics.GScalable;
import acm.program.Program;

public class HangmanView extends GCompound implements MouseListener, ActionListener {

	HangmanController game;
	HangmanModel model;
	String word,message;
	Gallows execute;
	LetterArea areaOfLetters;
	JLabel feedback,score;
	GImage ship;
	GLetter gobj ;
	JButton button;
	private final double WID = 150;
	private final double HT = 150;
	private final double LETTERX = 350;
	private final double LETTERY = 100;
	private final double SHIP_OFFSET = 75;
	char guessedLetter;
	public HangmanView(HangmanController controller){
		execute = new Gallows(WID, HT);
		game=controller;
		feedback = new JLabel(message);
		score = new JLabel();
		game.add(feedback, Program.NORTH);
		button = new JButton("Concede");
		game.add(button, Program.SOUTH);
		game.addMouseListeners(this);
		game.addActionListeners(this);
		catchResizeEvents();
		ship = new GImage("boat.png");
		ship.scale(.25,.25);
	}
	/**
	 * Sets up game by removing all items on screen and making/re-adding all of them
	 * @param model
	 * @param word
	 * @param win
	 * @param lose
	 */
	public void startUp(HangmanModel model, String word,int win, int lose){
		this.removeAll();
		this.model=model;
		this.word=word;
		feedback.setText("Welcome to Hangman");
		score.setText("Won: " + win + " Lost: " + lose);
		game.add(score, Program.SOUTH);
		areaOfLetters=new LetterArea(word); 
		add (execute,WID*2,HT);
		execute.reset();
		add(areaOfLetters);
		areaOfLetters.displayedWord.setColor(Color.black);
		game.add(this);
		add(ship,0,getHeight()-SHIP_OFFSET);
	}
	/**
	 * Updates the word and hangman upon guess, sets gletter unguessable
	 * @param guess
	 * @param good
	 */
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
	/**
	 * Game is won, allows game to be reset and congratulates player
	 */
	public void winNotification()
	{
		
		message = "Conflagurations, you won!";
		feedback.setText(message);
		button.setText("New Game");
		areaOfLetters.displayedWord.setColor(Color.green);
		
	}
	/**
	 * What is displayed when game is lost
	 * @param word
	 */
	public void loseNotification(String word)
	{
		message = "Hughhhh you lost";
		feedback.setText(message);
		areaOfLetters.wordUpdate(word);
		areaOfLetters.displayedWord.setColor(Color.red);
		button.setText("New Game");
	}
	/**
	 * Returns which character was clicked
	 */
	public void mouseClicked(MouseEvent e) {
		
		GObject obj = areaOfLetters.giveChar(e.getX(),e.getY());
		if(obj==null){
			return;
		}
		gobj = (GLetter) obj;
		model.guessMade(gobj.getLetter());	
		
	}
	/**
	 * Makes a new game, adding a loss if you hadn't finished the game before
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New Game")) {
			model.setUpGame();
		}
		if(e.getActionCommand().equals("Concede")){
			model.addLoss();
			model.setUpGame();
		}
	}
	private double width,height;
	/**
	 * Resizes scalable elements
	 */
	private void catchResizeEvents() {
		width = game.getWidth();
		height = game.getHeight();

		game.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				double scaleX = game.getWidth() / width,  scaleY = game.getHeight() / height;
				for (int i = 0; i < game.getElementCount(); i++) {
					Object obj = game.getElement(i);
					if (obj instanceof GObject) {
						if (obj instanceof GScalable) {
							((GScalable) obj).scale(scaleX, scaleY);
						}
						((GObject) obj).setLocation(((GObject) obj).getX()*scaleX, ((GObject) obj).getY()*scaleY);
					}
				}
				width = game.getWidth(); height = game.getHeight();
			}
		}); 		
	}
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
