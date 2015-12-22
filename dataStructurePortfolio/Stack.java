/**
 * 
 */
package dataStructurePortfolio;

/**
 * @author Huseen Sufi
 * Implement a stack using an Array with a top pointer
 */
public class Stack {
	//initial variables
	private int maxSize; //variable sized stacks
	private int[] stack; 
	private int top; //pointer to top of stack
	
	//stack constructor
	public Stack(int max) {
		maxSize = max; //make a stack of variable size
		stack = new int[maxSize];
		top = -1;
	}
	
	/**
	 * @param toPush integer to push to stack
	 * adds an item to the top of the stack
	 */
	public void push(int toPush) {
		stack[top] = toPush; //set the new top
		top++; //increment the pointer
	}
	
	/**
	 * pop method which removes from top of stack
	 * @return the removed value
	 */
	public int pop() {
		return stack[top--];
	}
	
	/**
	 * peek method which looks at top of stack without removing
	 * @return the peeked value
	 */
	public int peek() {
		System.out.println("Top of stack is " + stack[top]);
		return stack[top];
	}
	
	/**
	 * boolean method to check if stack is full
	 * @return true if full, false otherwise
	 */
	public boolean isFull() {
		int length = maxSize - 1;
		//if the top of the stack is equal to the length then the stack is full
		if (top == length) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * boolean method to check if stack is empty
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
