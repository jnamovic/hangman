import java.util.ArrayList;

public class HangmanModel {

	HangmanView view;  // the view
	private String word="he-ck",guessArea="";
	String weirdchars="'-_!.{}:"; 
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
		for(int i=0;i<word.length();i++){
			if((weirdchars.indexOf(""+word.charAt(i))<0))
			guessArea+="?";
			else
				guessArea+=word.charAt(i);
		}
		view.startUp(this,guessArea);
		guessMade('e');
	}
	
	public void guessMade(char letter){
			ArrayList<Integer> letterloc=new ArrayList<Integer>();
			String guessword= view.getGuessArea();
			for(int i=0;i<word.length();i++){
				if(word.charAt(i)==letter){
					letterloc.add(i);
				}
			}
			if(letterloc.size()==0){
				guesses++;
				view.guess(guessword, false);
				System.out.println("nop");
				
			}
			else{
				for(int i=0;i<letterloc.size();i++){
					guessword=guessword.substring(0,letterloc.get(i))+letter+guessword.substring(letterloc.get(i)+1,guessword.length());
					System.out.println(guessword);
				}
				view.guess(guessword, true);
			}
			
			if (view.getGuessArea().equals(word)) {
				view.winNotification();
				return;
			}
			
			if (guesses>MAX_GUESS) {
				view.loseNotification();
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


