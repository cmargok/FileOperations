package main;

import java.util.List;
import java.util.Scanner;

import InstructionslinesAndOperations.Instructions;
import fileHandling.FileManagement;

/**
 * this class is like an orchestator,receives data, sends it to fileManagment class,
 * the result sends it to instructions class, and then print the result and explanation
 * @author dykey
 *
 */
public class startApp {

	
	 private FileManagement fileMgt = new FileManagement();
	 private List<String> fileStringData;
	 private String nameFile;
	 private Scanner scanner ;
	 
	 
	 /**
	  * Constructor's class
	  * it initializes the direccions , automacally call the functions to prove if the file existe, and if its empty
	  * send to Instrucctions class the list of instrucctions in a list of strings
	  * get the result and explanation from the instrucctions class 
	  */
	 public startApp() {
		 Directions directions = new Directions();
		 directions.initConfigurationDirections();	
		 
		 checkFileExistence();
		 setInstructionsToList();		
		 Instructions startOperations = new Instructions(fileStringData);
		 
		 double result = startOperations.getResult();
		 String explanation = startOperations.getExplanation();
		 printOutput(result, explanation);
		 
	 }
	 /**
	  * this method print into console the result and the explanation
	  * @param result
	  * @param explanation
	  */
	 private void printOutput(double result, String explanation) {
		 
		 System.out.println("Output "+ result);
		 System.out.println("Explanation "+ explanation);
	 }
	 	
	 /**
	  * call checkDataExistence() and if returns true, 
	  * got the insctrutions from FileManagement object as a list
	  * if returns false, app ends	  * 	 
	 */
	 private void setInstructionsToList() {
		 
		 if(checkDataExistence()) {
			 
			 fileStringData = fileMgt.getLines();	
			 printInputFromFile();			 
		 }else {
			 System.out.println("no data");
		 }
		 
	 }
	 
	 /**
	  * check if there data inside the file
	  * @return true if file has data, (not empty)
	  */
	 private boolean checkDataExistence() {
		 
		return fileMgt.checkIfFileIsNotEmpty(nameFile);
	 }
	
	 /*
	  * Check if the file exist
	  * if not exist close the app, user has 3 attemps to enter the rigth name
	  */
	 private void checkFileExistence() {		
		 int attempts =1;		 
		 do {			 
			 nameFile = invokeFile();	
			 
			 if(fileMgt.checkIfFileExist(nameFile)) { attempts = 5; }
			 else { attempts++; }	
			 
		 }while(attempts <=3);
		 
		 scanner.close();
		 
		 if(attempts == 4) {
			 System.out.println("Off\nRestart the App to get new Attempts");
			 System.exit(-1);;
		 }
	 }
	 
	 /**
	  * this method uses an scanner to get the data from the user and the it adds .txt 
	  * @return the name of the file with .txt extension concatenated
	  */
	 private String invokeFile() {
		 
		 	scanner = new Scanner(System.in);		 	
			System.out.println("\nType the file's name without .txt extension");
			String name = scanner.nextLine();
			System.out.println("");
			return name+".txt";			
	 }
	 
	 /**
	  * print to console the instructions from the file
	  */
	 private void printInputFromFile() {
		     System.out.println("Input from file");
		 for(int i =0; i<fileStringData.size();i++) {
			 System.out.println("                 "+fileStringData.get(i));
		 }
	 }
	
}
