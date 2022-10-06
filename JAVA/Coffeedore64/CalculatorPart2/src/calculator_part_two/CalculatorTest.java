package calculator_part_two;

import java.util.ArrayList;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> operands = new ArrayList<Double>();       
		ArrayList<String> operators = new ArrayList<String>();
		
		Calculator calc = new Calculator();
		
		calc.performOperation(3.0);
		calc.performOperation("*");
		calc.performOperation(3.0);		
		calc.performOperation("*");
		calc.performOperation(3.0);
		calc.performOperation("=");
		System.out.println(calc.getResult());
	

	}

}

