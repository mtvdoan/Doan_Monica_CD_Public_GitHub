package calculator_part_one;

import java.io.Serializable;

//Java Bean needs to implement a serializable interface
public class Calculator implements Serializable {
	
	//Note to self. Java Bean requires PRIVATE fields with standard getters & setters
	private double operandone;
	private double operandtwo;
	private String operation;
	private double result;
	
	//Java Bean needs a Public Zero parameter constructor
	public Calculator() {
		
	}
	//@param operandone
	//@param operandtwo
	//@param operation
	

	//Since we already have a public zero parameter constructor we can now make an method overload as shown below.
	public Calculator(double operandone, double operandtwo, String operation) {
		this.operandone = operandone;
		this.operation = operation;
		this.operandtwo = operandtwo;
		
	}
	
	public void performOperation() {
		if(this.operation.equals("+")) {
			this.result = this.operandone + this.operandtwo;
		}
		else if(this.operation.equals("-")) {
			this.result = this.operandone - this.operandtwo;
		}
	}
	

	//Java Bean needs standard setters and getters (below). 1 pair for each instance variables
	/**
	 * @return the operandone
	 */
	public double getOperandone() {
		return operandone;
	}

	/**
	 * @param operandone the operandone to set
	 */
	public void setOperandone(double operandone) {
		this.operandone = operandone;
	}

	/**
	 * @return the operandtwo
	 */
	public double getOperandtwo() {
		return operandtwo;
	}

	/**
	 * @param operandtwo the operandtwo to set
	 */
	public void setOperandtwo(double operandtwo) {
		this.operandtwo = operandtwo;
	}

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * @return the result
	 */
	public double getResult() {
		return result;
	}
}
