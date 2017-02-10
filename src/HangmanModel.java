import java.util.ArrayList;

public class HangmanModel {

	HangmanView view;  // the view
	private String word="heeevcedeefeaeck";
	private Dictionary dict;
	private int guesses=0;
	private final int MAX_GUESS=5;
	public HangmanModel(HangmanView view){
		this.view=view;
		dict=new Dictionary();	
		setUpGame();
		
	}
	
	public void setUpGame(){
		word=dict.getWord();
		view.startUp(this,word);
		guessMade('e');
	}
	
	public void guessMade(char letter){
			ArrayList<Integer> morgrius=new ArrayList<Integer>();
			for(int i=0;i<word.length();i++){
				if(word.charAt(i)==letter){
					morgrius.add(i);
				}
			}
			if(morgrius.size()==0){
				guesses++;
				view.guess(word, false);
			}
			else{
				String guessword= view.getGuessArea();
				for(int i=0;i<morgrius.size();i++){
					guessword=guessword.substring(0,morgrius.get(0))+letter+guessword.substring(morgrius.get(0)+1,guessword.length());
					System.out.println(guessword);
				}
			}
			
			if (view.getGuessArea().equals(word)) {
				//view.winNotification();
				return;
			}
			
			if (guesses>MAX_GUESS) {
				//view.loseNotification();
				return;
			}
		
	}
	
//	public boolean hasNotLost(){
//		return(guesses<MAX_GUESS);
//	}
//	public boolean hasNotWon(){
//		return(view.getGuessArea().equals(word));
//	}
//	
}


