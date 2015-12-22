/**
 * 
 */
package dataStructurePortfolio;

/**
 * @author Huseen Sufi
 *	Node Class with access methods
 *	Each Node has a next and previous Pointer
 *	Includes access methods for Node fields
 */
public class Node {
	
	//Initial  variables
	private Node next;
	private Node prev;
	private String name;
	
	//Constructor
	public Node(String name, Node prev, Node next) {
		this.name = name;
		this.prev = prev;
		this.next = next;
	}
	
	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}
	
	/**
	 * @param the next Node to set
	 * 
	 */
	public void setNext(Node next) {
		this.next = next; //set the current Node's Next to param next
	}
	
	/**
	 * @return the prev
	 */
	public Node getPrev() {
		return prev;
	}
	
	/**
	 * @param the previous node to set
	 */
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	/**
	 * @return the Node's name value
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	
	public void setName(String name) {
		this.name = name;
	}	

}
