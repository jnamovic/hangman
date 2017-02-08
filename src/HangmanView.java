import java.util.ArrayList;

public class HangmanView {

	HangmanModel model;
	String word,guessArea;
	Gallows execute;
	private final double wid = 500;
	private final double ht = 650;
	char guessedLetter;
	public HangmanView(HangmanController controller){
		execute = new Gallows(wid, ht);
	}
	
	public void startUp(HangmanModel model, String word){
		this.model=model;
		this.word=word;
	}
	
	public String getGuessArea()
	{
		return guessArea;
	}
	public void guess(ArrayList<Integer> g)
	{
		if(g.get(0)==-1)
		{
			execute.drawNextPart();
		}
		else
		{
			while(g.size()>=1){
				if(g.get(0)==0)//for first letter mess ups
				{
					guessArea = guessedLetter + guessArea.substring(1);
					g.remove(0);
					break;
				}
				if(g.get(0)==)
				guessArea = guessArea.substring(0, g.get(0))+guessedLetter + guessArea.substring(g.get(0));
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
