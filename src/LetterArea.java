import java.awt.Font;
import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GLabel;

public class LetterArea extends GCompound
{
	ArrayList<GLetter> guessDisplay=new ArrayList<GLetter>();
	GLabel displayedWord;
	private static final Font FONT = new Font("Helvetica", Font.BOLD, 30);
	public LetterArea(String guess)
	{
		populateDisplay();
		displayedWord = new GLabel(guess, 300, 300);
		displayedWord.setFont(FONT);
		add(displayedWord);
		System.out.println(guess);
		for(int i=0; i<guessDisplay.size();i++)
			add(guessDisplay.get(i),500+15*i%13+50*i/13,
					i/13*guessDisplay.get(i).getHeight()+50);
		
			
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
