package cmps252.hw05.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Conversion{
	
	private static List ops = Arrays.asList("+", "-", "*", "/");
	
	public static int Precedence(String op) {
		 switch (op) { 
	        case "+": 
	        case "-": 
	            return 1; 
	       
	        case "*": 
	        case "/": 
	            return 2;
	            } 
	        return -1; 
	}
	
	public static String InfixToPost(String s) {
		
		String[] splitted = s.split("\\s+");
		String result = new String(""); 
        Stack<String> stack = new Stack<>();
        
		for (int i = 0; i < splitted.length; i++) {
			
			String str = splitted[i];
			
			if (str.equals("(")) {
				stack.push(str);
			}
			
			else if (str.equals(")")) {
				while (!stack.isEmpty()) {
					if (stack.peek().equals("(")) {
                    stack.pop();
					}
					else {
						result = result + " " + stack.pop();
					}
				}
			}
			else if (ops.contains(str)) {
				while(!stack.isEmpty() && (Precedence(str) <= Precedence(stack.peek()))) {
					result = result + " " + stack.pop();
				}
				stack.push(str);
			}
			else {
				result = result + " " + str;
			}
			System.out.println(result);
		}
		
		while (!stack.isEmpty()) {
			if (stack.peek() == "(") {
				return "Invalid Expression";
			}
			result = result + " " + stack.pop();
			}
		return result;
		
	}
	
}
