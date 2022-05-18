import java.util.*;

public class Rpn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Stack<Double> stack = new Stack<Double>();
		while (in.hasNextLine()) {
			String token = in.nextLine();
			if (token.equals("*")) {
				Double num = stack.pop();
				Double num2 = stack.pop();
				stack.push(num * num2);
			} else if (token.equals("+")) {
				Double num = stack.pop();
				Double num2 = stack.pop();
				stack.push(num + num2);
			} else if (token.equals("-")) {
				Double num = stack.pop();
				Double num2 = stack.pop();
				stack.push(num - num2);
			} else if (token.equals("/")) {
				Double num = stack.pop();
				Double num2 = stack.pop();
				stack.push(num / num2);
			} else 
				stack.push(Double.parseDouble(token));
		}
		
		System.out.println(stack.pop());
	}

}
