import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Dictionary {

	private File file =new File("NauticalPirateterms.txt");
	private String word;
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
	public String getWord(){
		return word;
	}
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
