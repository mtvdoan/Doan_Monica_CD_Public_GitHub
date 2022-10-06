package calculator_part_two;

import java.io.Serializable;
import java.util.ArrayList;

//Java Bean needs to implement a serializable interface
public class Calculator implements Serializable {
	
	
	private ArrayList<Double> operands;
	private ArrayList<String> operations;

	
	//Java Bean needs a Public Zero parameter constructor
	//@param operandone
	//@param operandtwo
	//@param operation

	
	//Since we already have a public zero parameter constructor we can now make an method overload as shown below.
	public Calculator() {
		this.operands = new ArrayList<Double>();
		this.operations = new ArrayList<String>();
	}
	
	//operand: 10.5, 5.2, 10
	
	//operations: +, *, =
	
	
	public void performOperation(String operator) {
		if(operator == "=") {
			performOperation();
		}
		else {
			this.operations.add(operator);
		}
	}
	
	public void performOperation(Double operand) {
		this.operands.add(operand);
	}
	
	public void performOperation() {
	
		for(int i = 0; i < operations.size(); ) {
			double leftOperands = operands.get(i);
			double rightOperands= operands.get(i + 1);

			String operation = operations.get(i);
			
			if( operation == "*" || operation == "/") {
				operands.remove(i);
				operands.remove(i);
				operations.remove(i);
				if(operation == "*") {
					operands.add(i, leftOperands * rightOperands);
				}
				else {
					operands.add(i, leftOperands / rightOperands);
				}
			}
			
			else {
				i++;
			}
		}
		for(int j = 0; j < operations.size(); ) {
			double leftOperands = operands.get(j);
			double rightOperands= operands.get(j + 1);

			String operation = operations.get(j);
			if(operation == "+" || operation == "-") {
				operands.remove(j);
				operands.remove(j);
				operations.remove(j);
				if(operation == "+") {
					operands.add(j, leftOperands + rightOperands);
				}
				else {
					operands.add(j, leftOperands + rightOperands);
				}
			}
			else {
				j++;
			}
		}
	}
	
	public double getResult() {
		return operands.get(0);
	}
}
