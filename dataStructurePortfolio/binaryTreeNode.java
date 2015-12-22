
package dataStructurePortfolio;

/**
 * @author Huseen Sufi
 * class for binary tree node with comparable key values
 * Each node has left and right child pointers
 * Includes access methods for Node fields
 */
public class binaryTreeNode {

//initial variables
private String Name;
private binaryTreeNode leftChild;
private binaryTreeNode rightChild;
private Comparable key;

//constructor
@SuppressWarnings("rawtypes")
public binaryTreeNode(Comparable key,String Name, binaryTreeNode leftChild, binaryTreeNode rightChild) {
	this.setKey(key);
	this.setName(Name);
	this.setLeftChild(leftChild);
	this.setRightChild(rightChild);
}

/**
 * @return the name
 */
public String getName() {
	return Name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	Name = name;
}

/**
 * @return the leftChild
 */
public binaryTreeNode getLeftChild() {
	return leftChild;
}

/**
 * @param leftChild the leftChild to set
 */
public void setLeftChild(binaryTreeNode leftChild) {
	this.leftChild = leftChild;
}

/**
 * @return the rightChild
 */
public binaryTreeNode getRightChild() {
	return rightChild;
}

/**
 * @param rightChild the rightChild to set
 */
public void setRightChild(binaryTreeNode rightChild) {
	this.rightChild = rightChild;
}

/**
 * @return the key
 */
public Comparable getKey() {
	return key;
}

/**
 * @param key the key to set
 */
public void setKey(Comparable key) {
	this.key = key;
}

/**
 * @param key
 * @param newNode the new Node to add
 * insert method with recursive call
 */
public void insertNode(binaryTreeNode newNode) {
	int compare = newNode.getKey().compareTo(newNode.getKey());
	if (compare < 0) {
		//add to left child
		if (newNode.getLeftChild() == null) {
			newNode.setLeftChild(newNode);
		//add to left subtree
		} else {
			newNode.getLeftChild().insertNode(newNode); //recursive call
		} //end else
	} else if(compare > 0){
		//add to right child
		if (newNode.getRightChild() == null) {
			newNode.setRightChild(newNode);
		// add to right subtree
		} else {
			newNode.getRightChild().insertNode(newNode); //recursive call
		} //end inner else
	} //end outer else
} //end method


}
