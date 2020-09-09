
import java.util.*;
import java.io.*;

public class EnCoder
{
	public static void main(String [] args){
		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		String previous;
		String current;
		int counter = 256;
		String line = null;
		String encoded = "";
		String combination = "";
		try{
			FileReader fr = new FileReader("text.txt");
			BufferedReader br = new BufferedReader (fr);
				
			previous = "";
				
			int a;
			while ((a = br.read()) != -1)
			{

				current = String.valueOf((char)a);
				combination = previous + current;
				if(combination.length() == 1){
					previous = combination;
				}
				else if (dictionary.containsKey(combination))
				{
					previous = combination;
				}

				else
				{
					dictionary.put((combination), counter);
					counter++;
					if (previous.length() == 1){
						encoded += " " + (int)(previous.charAt(0));
					}
					else{
						encoded += " " + dictionary.get(previous);
					}
					previous = current;
					
				}
					
				
				
				
			}
			if (previous.length() == 1){
				encoded += " " + (int)(previous.charAt(0));
			}
			else{
				encoded += " " + dictionary.get(previous);
			}
			
			//this code prints the dictionary...you're welcome
			//for (String key : dictionary.keySet()){
				//System.out.println(key + ": " + dictionary.get(key));
			//}

			br.close ();
			fr.close ();
		}
				
		catch ( Exception e ){
			System.out.println ( "Error Occured" );
		}
		try {
			FileWriter fw = new FileWriter(new File("encoded.txt"));
			BufferedWriter buffer = new BufferedWriter(fw);
			buffer.write(encoded);
			buffer.close();
		}
		catch (Exception e) {
			System.out.println("Error Occured in Writing.");
		}
	}
	
		
}