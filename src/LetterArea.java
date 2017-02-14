import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GLabel;

public class LetterArea extends GCompound
{
	ArrayList<GLetter> guessDisplay;
	GLabel displayedWord;
	public LetterArea(String guess)
	{
		populateDisplay();
		displayedWord = new GLabel(guess);
		add(displayedWord);
		for(int i=0; i<guessDisplay.size();i++)
			add(guessDisplay.get(i),displayedWord.getX()+guessDisplay.get(i).getWidth()*i%13,
					guessDisplay.get(i).getHeight()*i/13+displayedWord.getY()+displayedWord.getHeight());
		
			
	}
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
	public void wordUpdate(String s)
	{
		displayedWord.setLabel(s);
	}
}
