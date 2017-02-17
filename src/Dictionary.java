import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Dictionary {

	private File file =new File("NauticalPirateterms.txt");
	private String word;
/**
 * Scans a random amount of times pulling a word from the list
 */
	public Dictionary(){
		try
		{
			Scanner scan=new Scanner(file);
			for(int i=0; i<(int)(Math.random()*500000000);i++){
				if(scan.hasNextLine())
					word=scan.nextLine();
				else
					scan=new Scanner(file);
			}
		}	
		catch(FileNotFoundException s){
			System.out.println("help");
		}
		
	}
	/**
	 * Passes the word to other classes
	 * @return
	 */
	public String getWord(){
		return word;
	}
	/**
	 * Returns a new word
	 * @return
	 */
	public String getNewWord(){
		try
		{
			Scanner scan=new Scanner(file);
			for(int i=0; i<(int)(Math.random()*500000000);i++){
				if(scan.hasNextLine())
					word=scan.nextLine();
				else
					scan=new Scanner(file);
			}
		}	
		catch(FileNotFoundException s){
			
		}
		return word;
	}
}
