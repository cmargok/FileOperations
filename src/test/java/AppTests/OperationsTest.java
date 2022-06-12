/**
 * 
 */
package AppTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import InstructionslinesAndOperations.Operations;

/**
 * @author dykey
 *
 */
class OperationsTest {

	Operations op ;
	
	/**
	 * Test method for {@link InstructionslinesAndOperations.Operations#add(double, double)}.
	 */
	@Test
	void testAdd() {
		
		//Arrange
		op = new Operations();
		//Act
		double res = op.add(10, 20);
		//Assert
		assertEquals(30, res);
		
	}

	/**
	 * Test method for {@link InstructionslinesAndOperations.Operations#substract(double, double)}.
	 */
	@Test
	void testSubstract() {
		
		//Arrange
		op = new Operations();
		//Act
		double res = op.subtract(20, 10);
		//Assert
		assertEquals(10, res);
	}

	/**
	 * Test method for {@link InstructionslinesAndOperations.Operations#divide(double, double)}.
	 */
	@Test
	void testDivide() {
		
		//Arrange
		op = new Operations();
		//Act
		double res = op.divide(45, 9);
		//Assert
		assertEquals(5, res);
	}

	/**
	 * Test method for {@link InstructionslinesAndOperations.Operations#multiply(double, double)}.
	 */
	@Test
	void testMultiply() {
		
		//Arrange
		op = new Operations();
		//Act
		double res = op.multiply(8, 7);
		//Assert
		assertEquals(56, res);	
	}

	/**
	 * Test method for {@link InstructionslinesAndOperations.Operations#exponent(double, double)}.
	 */
	@Test
	void testExponent() {
		
		//Arrange
		op = new Operations();
		//Act
		double res = op.exponent(5, 5);
		//Assert
		assertEquals(3125, res);	
	}

}
