package fileHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class determine if a file exist and if there's any data inside it
 * 
 * @author dykey
 *
 */
public class FileManagement {
	
	private List<String> linesList; 	
	
	/**
	 * Constructor of the class, initialize the ArrayList
	 */
	public FileManagement() {
		
		linesList= new ArrayList<>();
		
	}
	
	/**
	 * get the List of strings named linesList
	 * @return list of strings
	 */
	public List<String> getLines() {
		return linesList;
	}
	
	/**
	 * check if a file exist from the console's input	 * 
	 * @param nameFile
	 * @return true if the file existe and false if not
	 */
	public Boolean checkIfFileExist(String nameFile) {	
		
		InputStream fileStream = setFile(nameFile);
			
	      if(fileStream != null) { 	
	    	  	
	    	    return true;
	      }else {
	    	  System.out.println("File not Exist, verify file's name...");
	    	  return false;	  
	      }	
	}
	
	/**
	 * Check if the file is empty or not
	 * @param nameFile
	 * @return true if the file
	 */
	public boolean checkIfFileIsNotEmpty(String nameFile) {			
		
		InputStream fileStream = setFile(nameFile);	
		
		BufferedReader bufferFile = new BufferedReader(new InputStreamReader(fileStream));
		
		int empty =  (int)bufferFile.lines().count();		
		
		if(empty > 0) {			
			
			linesList= parseLines(nameFile);
			return true;
		}else			
		{ 
			System.out.println("The File is empty, restart the App to try another file");
			return false;
		}
		
	}	
	
	/**
	 * make a list of string from a the lines of the file
	 * @param nameFile
	 * @return list of lines from the file
	 */
	public List<String> parseLines(String nameFile)  {
		
		InputStream fileStream = setFile(nameFile);			
		BufferedReader bufferFile = new BufferedReader(new InputStreamReader(fileStream));
		
		List<String> tempLines = new ArrayList<String>();				
		String line="";
		
			try {
				while((line = bufferFile.readLine()) != null){
					tempLines.add(line);				
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tempLines;
	}
	
	/**
	 * search the relative path of the file mentioned
	 * @param nameFile
	 * @return inputStream with the path where the file is located
	 */
	private InputStream setFile(String nameFile) {		
		 InputStream Stream = getClass().getClassLoader().getResourceAsStream("File/"+nameFile);
		 return Stream;
	}
	
}
