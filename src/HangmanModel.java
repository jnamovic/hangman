import java.util.ArrayList;
import java.util.Scanner;

public class HangmanModel {
	final private Scanner scan=new Scanner(System.in);
			
	HangmanView view;  // the view
	private String word,guessWord;
	String weirdchars="'-_!.{}:"; 
	boolean test=true;
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
			guessWord+="?";
			else
				guessWord+=word.charAt(i);
		}
		view.startUp(this,guessWord);
		
	}
	
	public void guessMade(char letter){
			ArrayList<Integer> letterloc=new ArrayList<Integer>();
			
			for(int i=0;i<word.length();i++){
				if(word.toLowerCase().charAt(i)==(letter+"").toLowerCase().charAt(0)){
					letterloc.add(i);
				}
			}
			if(letterloc.size()==0){
				guesses++;
				view.guess(guessWord, false);
				
			}
			else{
				for(int i=0;i<letterloc.size();i++){
					if(letterloc.get(i)==0){
						letter=(letter+"").toUpperCase().charAt(0);
					}else{
						letter=(letter+"").toLowerCase().charAt(0);
					}
					guessWord=guessWord.substring(0,letterloc.get(i))+letter+guessWord.substring(letterloc.get(i)+1,guessWord.length());
					
				}
				view.guess(guessWord, true);
			}
			
			if (guessWord.equals(word)) {
				view.winNotification();
				return;
			}
			
			if (guesses>MAX_GUESS) {
				view.loseNotification();
				return;
			}
		
	}
	

}


