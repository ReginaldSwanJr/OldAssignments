
import java.util.EmptyStackException;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Bracket {
	static boolean pmissing = false;
	static boolean cmissing = false;
	static boolean smissing = false;
	
	static int x = 0;
	static int y = 1;
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		FileReader fRead = new FileReader("txt/HelloWorld.java");
		BufferedReader buffer = new BufferedReader(fRead);
		
		
		
		String firstline = buffer.readLine();
		
		while(firstline != null){
			char[] ch = firstline.toCharArray();
			bracket(ch);
			firstline = buffer.readLine(); // read next line
			y++;
		}
		

		// Parentheses
		if(stack1.isEmpty() && pmissing == false)
			System.out.println("All parentheses accounted for");
		if(stack1.isEmpty() && pmissing == true)
			System.out.println(" Opening Parentheses missing");
		if(!stack1.isEmpty())
			System.out.println("Closing Parentheses missing");
		
		//Curly Braces
		if(stack2.isEmpty() && cmissing == false)
			System.out.println("All Curly Braces accounted for");
		if(stack2.isEmpty() && cmissing == true)
			System.out.println(" Opening Curly Braces missing");
		if(!stack2.isEmpty())
			System.out.println("Closing Curly Braces missing");
		
		//Square brackets
		if(stack3.isEmpty() && smissing == false)
			System.out.println("All Square Brackets accounted for");
		if(stack3.isEmpty() && smissing == true)
			System.out.println(" Opening Square Brackets missing");
		if(!stack3.isEmpty())
			System.out.println("Closing Square Brackets missing");
		
	}
	
	
	static Stack<Character> stack1 = new Stack<Character>();
	static Stack<Character> stack2 = new Stack<Character>();
	static Stack<Character> stack3 = new Stack<Character>();
	//static Stack<Character> stack4 = new Stack<Character>();
	
	public static void bracket(char[] c) throws EmptyStackException{
		try{
			x = 0;
		for(char letter : c){
			x++;
			// Parentheses
			if(letter == '('){
				stack1.push(letter);}
			else if(letter == ')'){
				if(stack1.isEmpty()){
					pmissing = true;
					System.out.println("Error at line " + y + " column " + x);
					break;
				}
				else
					stack1.pop();
			}	
			
			//Curly Braces
			if(letter == '{'){
				stack2.push(letter);}
			else if(letter == '}'){
				if(stack2.isEmpty()){
					cmissing = true;
					System.out.println("Error at line " + y + " column " + x);
					break;
				}
				else
					stack2.pop();
			}
			

			//Square Brackets
			if(letter == '['){
				stack3.push(letter);}
			else if(letter == ']'){
				if(stack3.isEmpty()){
					smissing = true;
					System.out.println("Error at line " + y + " column " + x);
					break;
				}
				else
					stack3.pop();
			}
			
			}
		}catch(EmptyStackException e){System.out.print(".");}
	}
	
}

