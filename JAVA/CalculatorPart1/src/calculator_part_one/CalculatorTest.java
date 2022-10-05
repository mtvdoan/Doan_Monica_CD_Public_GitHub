package calculator_part_one;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator result = new Calculator();
		
		result.setOperandone(10.5);
		result.setOperation("+");
		result.setOperandtwo(5.2);
		result.performOperation();
		System.out.println(result.getResult());
		
	}

}
