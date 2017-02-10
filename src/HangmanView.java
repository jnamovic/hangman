import java.util.ArrayList;

public class HangmanView {

	HangmanModel model;
	String word,guessArea="";
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
