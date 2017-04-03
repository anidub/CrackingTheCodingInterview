package Trie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class readFile {

	public static void main(String[] args) {
		String fileName = "C:\\Users\\anish\\Desktop\\Quantcast\\dictionary.txt";
		String output = "C:\\Users\\anish\\Desktop\\Quantcast\\output.txt";

		String line = null;
		ArrayList<String> dictionary = new ArrayList<String>();

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				dictionary.add(line);
			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		
		/*for(String s:dictionary){
			System.out.println(s);
		}*/
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(output, "UTF-8");
			for(String s:dictionary){
				//System.out.println(s);
				writer.println(s);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
