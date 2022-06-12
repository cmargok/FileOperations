package InstructionslinesAndOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * This class get the instruccions from a list of strings
 * @author dykey
 *
 */
public class Instructions {
	
	
	 private List<String> fileStringData;
	 private List<String []> instructionsList = new ArrayList<>();
	 private Operations operations;
	 private boolean applyFound = false;
	 private double result =0;
	 private String explanation ="";
	 
	 /**
	  * Constructor's class
	  * initialize the list of string
	  * the class operatios to get results from it
	  * call the method get instructions
	  * and set the result fom method getOutput;
	  * @param lines
	  */
	public Instructions(List<String> lines) {
		
		fileStringData = lines;	
		operations = new Operations();
		getInstructions();
		result = getOutput();
		
	}
	
	/**
	 * get the result after processing all the instructions
	 * @return double with the result
	 */
	public double getResult() {
		return result;
	}
	
	/**
	 * get a string with the explanation from the instructions
	 * @return string 
	 */
	public String getExplanation() {
		return explanation;
	}
	
	/**
	 * this method get the instructions from the list of the strings
	 * it takes every instruction and puts in array of 2 positions,
	 * the first position is the kind of operation and the second position is the value to operate
	 * at the same time it checks if there is any instructions wrongly written, 
	 * if is wrongly written it stops at findinf instructions
	 * 
	 */
	private void getInstructions() {
		 
	
		for(int i=0; i<fileStringData.size();i++) {
			
			String [] instruction = fileStringData.get(i).split(" ");
			
			if (instruction.length<2) {
				
				System.out.println("data cannot be read, one or more lines are not operations");
				break;
				
			}else if(instruction[0].equals("apply")){
				instructionsList.add(0,instruction);
				applyFound = true;
				
			}else {				
				instructionsList.add(instruction);		
			}
		}
		
	}
	
	
	/**
	 * this method prove if there is an instruccion with the apply operation
	 * if apply operation was found then call method getOutputFromInstructions
	 * to execute the operations
	 * @return double with the value of all instructions
	 */
	private double getOutput() {
		
		if(applyFound ) {			
			return getOutputFromInstructions();			
		}else {			
			return 0;			
		}
	}
	

	/**
	 * this method determine the size of the instructions "how many lines"
	 * if there's only one and if its correct then return the result
	 * if theres more lines , trough a for loop call the method selectOperation
	 * after every instructions it adds the result from each operation to the ouput variable
	 * at the same time fills the explanation string
	 * @return double with the value of all instructions
	 */
	private double getOutputFromInstructions() {	
		
		double output =0;
		int size = instructionsList.size();
		
		explanation = instructionsList.get(0)[0]+" "+instructionsList.get(0)[1];
		
		if( size > 1) {
			
			output= Integer.parseInt(instructionsList.get(0)[1]);
			
			for(int i=1; i<instructionsList.size();i++) {
				
				strucResultModel temp = selectOperation(output, instructionsList.get(i));
				output = temp.value; 
				explanation += " "+temp.symbol+" "+instructionsList.get(i)[1];
				
			}
			return output;
			
		}else if(size == 1) {
			
			return Double.parseDouble(instructionsList.get(0)[1]);		
			
		}else {
			
			return 0;
		}
		
	}
		
	
	/**
	 * this method  uses a switch to determine what kind of operation is in the instruction
	 * calls the operation from Operation class
	 * it uses a class model to be able to get two different values, the type of operation in symbol form and the value
	 * if the operation is not recognized returns an undefiend symbol and value 0
	 * @param actualOutput the general value
	 * @param UniqueInstruction 
	 * @return strucResultModel with the data
	 */
	private strucResultModel selectOperation(double actualOutput, String[] UniqueInstruction) {
		
		double parse = Integer.parseInt(UniqueInstruction[1]);
		strucResultModel result = new strucResultModel (); 
		
		switch (UniqueInstruction[0]) {	
			case "add": 
				result.symbol ="+";
				result.value = operations.add(actualOutput,parse);			
				break;				
				
			case "subtract": 
				result.symbol ="-";
				result.value = operations.subtract(actualOutput, parse);			
				break;	
				
			case "divide": 
				result.symbol ="/";
				result.value = operations.divide(actualOutput, parse) ;
				break;	
				
			case "multiply": 
				result.symbol ="*";
				result.value =  operations.multiply(actualOutput,parse);
				break;	
				
			case "exponent": 
				result.symbol ="^";
				result.value =  operations.exponent(actualOutput,parse);
				break;
				
			default:
				result.symbol ="undefined";
				result.value =  0;
				break;
		}
		
		return result;
		
		
	}
	
}




/**
 * this class is like a struc, only data * 
 * @author dykey
 *
 */
class strucResultModel {
	
	public String symbol="";
	public double value =0;
}


