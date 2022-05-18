import java.util.Scanner;
import java.util.Stack;

public class SimpleScanning {
	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static Double rpn(Stack<String> inputStack) {
		Stack<Double> stack = new Stack<Double>();
		while (!inputStack.isEmpty()) {
			String token = inputStack.pop();
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

		return stack.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		boolean hasError = false;
		Stack<Token> tokenStack = new Stack<Token>();
		while (in.hasNextLine() && hasError == false) {
			String input = in.nextLine();
			if (input.equals("*")) {
				Token token = new Token(TokenType.STAR, input);
				tokenStack.push(token);
			} else if (input.equals("/")) {
				Token token = new Token(TokenType.SLASH, input);
				tokenStack.push(token);
			} else if (input.equals("+")) {
				Token token = new Token(TokenType.PLUS, input);
				tokenStack.push(token);
			} else if (input.equals("-")) {
				Token token = new Token(TokenType.MINUS, input);
				tokenStack.push(token);
			} else if (isNumeric(input)) {
				Token token = new Token(TokenType.NUM, input);
				tokenStack.push(token);
			} else {
				System.out.println("Error: Unexpected character: " + input);
				hasError = true;
			}

		}

		Stack<String> rpnStack = new Stack<String>();
		if (!hasError)
			while (!tokenStack.empty()) {
				System.out.println(tokenStack.peek());
				rpnStack.push(tokenStack.pop().lexeme);

			}
		System.out.println();
		System.out.println("Resultado: " + rpn(rpnStack));
	}

}
