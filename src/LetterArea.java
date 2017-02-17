import java.awt.Font;
import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class LetterArea extends GCompound
{
	/**
	 * list of letters, fonts and game
	 */
	ArrayList<GLetter> guessDisplay=new ArrayList<GLetter>();
	GLabel displayedWord;
	HangmanController game;
	private static final Font FONT = new Font("Helvetica", Font.BOLD, 30);
	public LetterArea(String guess)
	{
		populateDisplay();
		displayedWord = new GLabel(guess, 300, 300);
		displayedWord.setFont(FONT);
		add(displayedWord);
		
		for(int i=0; i<guessDisplay.size();i++)
			add(guessDisplay.get(i),500+15*(i%13),
					(i/13)*guessDisplay.get(i).getHeight()+50);
		
			
	}
	/**
	 * This mess makes all the gletters and adds them to an array list
	 */
	private void populateDisplay()
	{
		guessDisplay.add(new GLetter("a"));
		guessDisplay.add(new GLetter("b"));
		guessDisplay.add(new GLetter("c"));
		guessDisplay.add(new GLetter("d"));
		guessDisplay.add(new GLetter("e"));
		guessDisplay.add(new GLetter("f"));
		guessDisplay.add(new GLetter("g"));
		guessDisplay.add(new GLetter("h"));
		guessDisplay.add(new GLetter("i"));
		guessDisplay.add(new GLetter("j"));
		guessDisplay.add(new GLetter("k"));
		guessDisplay.add(new GLetter("l"));
		guessDisplay.add(new GLetter("m"));
		guessDisplay.add(new GLetter("n"));
		guessDisplay.add(new GLetter("o"));
		guessDisplay.add(new GLetter("p"));
		guessDisplay.add(new GLetter("q"));
		guessDisplay.add(new GLetter("r"));
		guessDisplay.add(new GLetter("s"));
		guessDisplay.add(new GLetter("t"));
		guessDisplay.add(new GLetter("u"));
		guessDisplay.add(new GLetter("v"));
		guessDisplay.add(new GLetter("w"));
		guessDisplay.add(new GLetter("x"));
		guessDisplay.add(new GLetter("y"));
		guessDisplay.add(new GLetter("z"));
	}
	/**
	 * Updates the guess word
	 * @param s
	 */
	public void wordUpdate(String s)
	{
		displayedWord.setLabel(s);
		
	}
	/**
	 * Passes the value of the char in a gletter
	 * @param x
	 * @param y
	 * @return
	 */
	public GObject giveChar(double x, double y)
	{
		GObject obj = this.getElementAt(x,y);
		if (!guessDisplay.contains(obj)){
			
			return null;
		}
		if (obj instanceof GLetter) {
			
			if (((GLetter) obj).clickedAlready()){
				//message = "You've already guessed that letter you silly billy";
				return null;
			}
	
		
		}
		
		return obj;}
	
}
