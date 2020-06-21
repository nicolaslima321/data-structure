import java.util.Stack;
import java.util.*;

public class StackExpression {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>();
		
		int numberLeft = 0, numberRight = 0, coupled = 0;
		
		String expression = scan.nextLine();
		
		char[] truncatedExpression = expression.toCharArray();
		
		for(int i = 0; i < truncatedExpression.length; i++) {
			// Se não for numérico, faço as verificações de caracteres de parenteses
			if (Character.isLetter(truncatedExpression[i])) {
				if(truncatedExpression[i] == '(')
					numberLeft++;
				else if(truncatedExpression[i] == ')')
					numberRight++;
				if(numberLeft == numberRight)
					coupled++;
			}
			stack.push(truncatedExpression[i]);			
		}
		
		if(coupled != ((numberRight + numberLeft)/2))
			throw new Exception("Condições violadas para criação da expressão");
		else
		   while(!stack.empty())
			   System.out.println("Retirando da pilha: " + stack.pop());
	}

}
