/**
 * 
 */
package dataStructurePortfolio;

/**
 * @author Huseen Sufi
 * Implements a circular queue using an Array with head and tail pointers
 * Integer implementation but queue can be changed later to hold anything
 */
public class Queue {
	//initial variables
	private int maxSize;
	private int head;
	private int tail;
	private int qSize;
	private int[] queue;
	
	//queue constructor 
	public Queue(int size) {
	maxSize = size;
	head = 0;
	tail = 0;
	qSize = 0;
	queue = new int[maxSize];
	}
	
	/**
	 * @param toRemove
	 * inserts an item in the queue
	 */
	public void insert(int toRemove ) {
		//check if queue isn't full first
		if (!isFull()) {
			qSize++; //increment size
			tail = (tail + 1)%qSize; //increment tail pointer
			System.out.println(toRemove + " was removed ");
		} else {
			System.out.println("Error queue is full");
		}
	}
	
	/**
	 * delete from queue method
	 */
	public void delete() {
		//check if queue isn't empty first
		if (!isEmpty()) {
			qSize--; //decrement size
			head = (head+1)%maxSize; //increment head pointer
			System.out.println(queue[head] + " was removed"); //return the new head value
		} else {
			System.out.println("\nError queue is empty");
		}
	}
	
	/**
	 * @return the head of the queue
	 */
	public int peek() {
		System.out.println("First Element is " + queue[head]);
		return queue[head];
	}
	
	/**
	 * boolean method to check if queue is full
	 * @return true if full, false otherwise
	 */
	public boolean isFull() {
		if (qSize == maxSize) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		if (qSize == 0 ) {
			return true;
		} else {
			return false;
		}
	}
}
