package AppTests;

import static org.junit.jupiter.api.Assertions.assertFalse;


import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import fileHandling.*;




/**
 * 
 * set of test for FileManagment class
 * it check is a file existe, if there's any data inside and getting data from file and putting
 * inside a List of strings
 * 
 * @author dykey
 *
 */
public class FileManagmentTest {
	
	
		private FileManagement fileMgt;
		
		/**
		 * Test method for {@link fileHandling.FileManagement#checkIfFileExist(String)}
		 * check if the existe in the folder "File" in the current context
		 * true = file exists
		 * false = file not exist
		 * expected result from the test FALSE
		 */
		@Test
	    public void TestcheckIfFileExist() {
	    	
	    	//Arrange
		  	fileMgt = new FileManagement();   	
	    	
	    	//Act
	    	boolean res = fileMgt.checkIfFileExist("fileNotExist.txt");
	    	
	    	//Assert  	
	    	assertFalse(res, "file not exists");  		    	
	    	
	    }
		
		
		/**
		 * Test method for {@link fileHandling.FileManagement#checkIfFileIsNotEmpty(String)}
		 * check if the file have data inside.
		 * must provide a true file name
		 * expected result from the test FALSE
		 */		
		@Test
	    public void TestcheckIfFileIsNotEmpty() {
	    	
	    	//Arrange
		  	fileMgt = new FileManagement();   		    	
	    	//Act
	    	boolean res = fileMgt.checkIfFileIsNotEmpty("fileempty.txt");
	    	//Assert  	
	    	assertFalse(res, "file is empty");  	    	
	    	
	    }
		
		
		
		/**
		 * Test method for {@link fileHandling.FileManagement#parseLines(String)}
		 * Test to check transform data from file to list of strings
		 * 
		 */
		@Test
		public void TestparseLines() {
			
			//Arrange
			fileMgt = new FileManagement();   		
			List<String> expectedLines = new ArrayList<String>();
			expectedLines.add("add 2");
			expectedLines.add("multiply 3");
			expectedLines.add("apply 10");
			  	
		   	//Act
		   	List<String> resList = fileMgt.parseLines("test.txt");
		   	
		   	//Assert  	
		   	assertLinesMatch(expectedLines, resList);		
			
		}
		
		

}
