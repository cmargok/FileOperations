package InstructionslinesAndOperations;


/**
 * this class is for the basic operations
 * @author dykey
 *
 */
public class Operations {

	
	/**
	 * this method add a to b (a sum)
	 * @param a
	 * @param b
	 * @return
	 */
	public double add(double a, double b) {

		return a+b;	
	}	
	
	/**
	 * this method substract a from b
	 * @param a
	 * @param b
	 * @return
	 */
	public double subtract(double a, double b) {			
		
		return a-b;	
	}
	
	/**
	 * this method divide a by b
	 * @param a
	 * @param b
	 * @return
	 */	
	public double divide(double a, double b) {
		
		return a/b;	
	}
	
	/**
	 * this method multiply a by 2
	 * @param a
	 * @param b
	 * @return
	 */	
	public double multiply(double a, double b) {
		
		return a*b;	
	}
	
	/**
	 * this method multiply a, b times
	 * @param a
	 * @param b
	 * @return
	 */
	public double exponent(double a, double b) {
			
		return Math.pow(a, b);	
	}
	
	
}

