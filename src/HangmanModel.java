import java.util.ArrayList;

public class HangmanModel {

	HangmanView view;  // the view
	String word="heeevcedeefeaeck";
	Dictionary dict;
	int guesses;
	public HangmanModel(HangmanView view){
		this.view=view;
		dict=new Dictionary();	
		System.out.println(guessMade('l'));
		setUpGame();
		
	}
	
	public void setUpGame(){
		word=dict.getWord();
		view.startUp(this,word);
	}
	
	public ArrayList<Integer> guessMade(char letter){
		ArrayList<Integer> morgrius=new ArrayList<Integer>();
		for(int i=0;i<word.length();i++){
			if(word.charAt(i)==letter){
				morgrius.add(i);
			}
		}
		if(morgrius.size()==0){
			guesses++;
			morgrius.add(-1);
		}
		return morgrius;
	}
	
}
