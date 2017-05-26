import java.util.*;
import myUtil.*;

public class MyStackTest {

    public static void main(String args[]) {

      MyStack<Integer> talStack = new MyStack<Integer>();
      MyStack<String>  wordStack = new MyStack<String>();
      Scanner keyboard = new Scanner(System.in);

      System.out.println("Testing integers!\n" + 
			 "Enter 5 integers");
      
      for(int i = 1; i <= 5; i++) {
    	  talStack.push(keyboard.nextInt());
      }

      System.out.println("The last four will print in reverse order");
      try {
    	  for(int i = 1; i <= 4; i++) {
    		  System.out.print(talStack.pop() + " ");
    	  }
      }
      catch (Exception e) {
    	  System.out.println("Can't pop!");
      }
      
      System.out.println();

      System.out.println("Enter new integer:");
      talStack.push(keyboard.nextInt());
      
      System.out.println("The last digit you entered will print first");
      try {
    	  for(int i = 1; i <= 3; i++) {
    		  System.out.print(talStack.pop() + " ");
    	  }
      }
      catch (Exception e) {
    	  System.out.println("Can't pop!");
      }
      System.out.println();

      if (talStack.empty())
    	  System.out.println("Stack is empty.");
      else
    	  System.out.println("Stack is not empty.");
      
     System.out.println("Testing strings!\n" +
			 "Enter 5 words");
      
      for(int i = 1; i <= 5; i++) {
    	  wordStack.push(keyboard.next());
      }

      System.out.println("The last 4 words you entered will print in reverse order");
      try {
    	  for(int i = 1; i <= 4; i++) {
    		  System.out.print(wordStack.pop() + " ");
    	  }
      }
      catch (Exception e) {
    	  System.out.println("Can't pop!");
      }
      System.out.println();

      System.out.println("Enter a new word");
      wordStack.push(keyboard.next());
      
      System.out.println("The last word you entered will print first");
      try {
    	  for(int i = 1; i <= 2; i++) {
    		  System.out.print(wordStack.pop() + " ");
    	  }
      }
      catch (Exception e) {
    	  System.out.println("Can't pop!");
      }
      System.out.println();

    
      if (wordStack.empty())
    	  System.out.println("Stack is empty.");
      else
    	  System.out.println("Stack is not empty.");
    }
}
