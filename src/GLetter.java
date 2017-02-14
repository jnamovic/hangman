import java.awt.Color;
import java.awt.Font;

import acm.graphics.*;


public class GLetter extends GCompound
{
	GLabel letter;
	GRect back;
	private static final Font FONT = new Font("Helvetica", Font.BOLD, 20);
	GLine x1,x2,czech1,czech2;
	char passedLet;
	boolean clickedAlready = false;
	public GLetter(String s)
	{
		passedLet=s.charAt(0);
		letter = new GLabel(s);
		letter.setFont(FONT);
		back = new GRect(letter.getWidth(),letter.getHeight());
		add(letter);
		add(back,letter.getX(),letter.getY()-letter.getHeight());
		x1 = new GLine(letter.getX(),letter.getY(),letter.getX()+letter.getWidth(),letter.getY()+letter.getHeight());
		x1.setColor(Color.red);
		x1.setVisible(false);
		x2 = new GLine(letter.getX(),letter.getY(),letter.getX()+letter.getHeight()+letter.getWidth(),letter.getY());
		x2.setColor(Color.red);
		x2.setVisible(false);
		//back.setVisible(false);
		add(x1);
		add(x2);
		czech1 = new GLine(letter.getX(),letter.getY()+letter.getHeight()/2,letter.getX()+letter.getWidth()/2,letter.getY()+letter.getHeight());
		czech1.setColor(Color.green);
		czech1.setVisible(false);
		czech2 = new GLine(letter.getX()+letter.getWidth()/2,letter.getY()+letter.getHeight(),letter.getX()+letter.getWidth(),letter.getY());
		czech2.setColor(Color.green);
		czech2.setVisible(false);
		add(czech1);
		add(czech2);
	}
	public boolean clickedAlready()
	{
		return clickedAlready;
	}
	public void onceGuessed(boolean guessResult)
	{
		clickedAlready=true;
		back.setLocation(-600,-600);
		if(guessResult)
		{
			czech1.setVisible(true);
			czech2.setVisible(true);
		}
		else
		{
			x1.setVisible(true);
			x2.setVisible(true);
		}
	}
	public char getLetter()
	{
	return passedLet;
	}
	}