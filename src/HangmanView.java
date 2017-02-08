
public class HangmanView {

	HangmanModel model;
	String word,guessArea;
	public HangmanView(HangmanController controller ){
		
	}
	
	public void startUp(HangmanModel model, String word){
		this.model=model;
		this.word=word;
	}
	
	public String getGuessArea()
	{
		return guessArea;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
