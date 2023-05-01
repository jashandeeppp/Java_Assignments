package Assignment02;

import java.util.Stack;

/*
	Stacks are used by compilers to evaluate expressions and generate machine-language code. 
	In this and the next exercise, we investigate how compilers evaluate arithmetic expressions consisting only of constants, operators and parentheses.
	Humans generally write expressions like 3 + 4 and 7 / 9, in which the operator (+ or / here) is written between
	its operands—this is called infix notation. Computers “prefer” postfix notation, 
 	in which the operator is written to the right of its two operands. 
	The preceding infix expressions would appear in postfix notation as 3 4 + and 7 9 /, respectively.
	To evaluate a complex infix expression, a compiler would first convert the expression to postfix notation, 
	then evaluate the postfix version of the expression. 
	Write class InfixToPostfixConverter to convert an ordinary infix arithmetic expression
	(assume a valid expression is entered), with single-digit integers, such as (6 + 2) * 5 - 8 / 4 to a postfix expression. 
	The postfix version of the preceding infix expression is 6 2 + 5 * 8 4 / - .
	
	The algorithm for creating a postfix expression is as follows:
	
	a) Push a left parenthesis '(' on the stack.
	b) Append a right parenthesis ')' to the end of infix.
	c) While the stack is not empty, read infix from left to right and do the following:
	If the current character in infix is a digit, append it to postfix.
	If the current character in infix is a left parenthesis, push it onto the stack.
	If the current character in infix is an operator:
	Pop operators (if there are any) at the top of the stack while they
	           have equal or higher precedence than the current operator, and 
	           append the popped operators to postfix.
	Push the current character in infix onto the stack.
	If the current character in infix is a right parenthesis:
	Pop operators from the top of the stack and append them to postfix until a left parenthesis is at the top of the stack.
	Pop (and discard) the left parenthesis from the stack.
	
	The following arithmetic operations are allowed in an expression:
	
	+ addition
	- subtraction
	* multiplication
	/ division
	^ exponentiation
	% modulus
 */
public class Assignment02 {

	public static void main(String[] args) {

		String[] equation = { "(1+2)*4-3" };
		if (equation.length != 1) {
			System.out.println("Unable to convert to postfix, Please check your expression.");
			System.exit(1);
		}
		try {
			System.out.println("Expression: "+equation[0]);
			processor(equation);
		} catch (Exception e) {
			System.out.println("Incorrect expression: " + equation[0]);
		}
	}

	public static void processor(String[] equation) {
		String expression = insertBlanks(equation[0]);
		String[] elements = expression.split(" ");
		result(elements);
	}
	
	public static void result(String[] elements) {
		Stack<Character> operator = new Stack<>();
		Stack<Character> resultstack = new Stack<>();
		for (String element : elements) {
			if (element.length() == 0)
				continue;
			else if (element.charAt(0) == '+' || element.charAt(0) == '-') {
				while (!operator.isEmpty() && (
						operator.peek() == '+' || operator.peek() == '-'|| 
						operator.peek() == '*' || operator.peek() == '/'|| 
						operator.peek() == '%' || operator.peek() == '^')) {
					resultstack.push(operator.pop());
				}
				operator.push(element.charAt(0));
			} else if (element.charAt(0) == '*' || element.charAt(0) == '/' || element.charAt(0) == '%') {
				while (!operator.isEmpty() && (
						operator.peek() == '*' || operator.peek() == '/'|| 
						operator.peek() == '%' || operator.peek() == '^')) {
					resultstack.push(operator.pop());
				}
				operator.push(element.charAt(0));
			} else if (element.charAt(0) == '^') {
				while (!operator.isEmpty() && (operator.peek() == '^')) {
					resultstack.push(operator.pop());
				}
				operator.push(element.charAt(0));
			} else if (element.charAt(0) == '(') {
				operator.push('(');
			} else if (element.charAt(0) == ')') {
				while (operator.peek() != '(') {
					resultstack.push(operator.pop());
				}
				operator.pop();
			} else {
				resultstack.push(element.charAt(0));
			}
		}

		while (!operator.isEmpty()) {
			char oper = operator.pop();
			resultstack.push(oper);
		}
		
		System.out.println("----- After Conversion into Postfix Expression -----");
		System.out.print("Expression: ");
		for (Character element : resultstack) {
			System.out.print(element + " ");
		}
	}

	public static String insertBlanks(String s) {
		String expression = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')' || 
				s.charAt(i) == '+' || s.charAt(i) == '-' || 
				s.charAt(i) == '*' || s.charAt(i) == '/' || 
				s.charAt(i) == '%' || s.charAt(i) == '^') {
				expression = expression + " " + s.charAt(i) + " ";
			}else {
				expression += s.charAt(i);
			}
		}
		return expression;
	}
}