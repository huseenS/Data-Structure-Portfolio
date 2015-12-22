/**
 * 
 */
package dataStructurePortfolio;

/**
 * @author Huseen Sufi
 * Implements a Binary Search Tree
 * Includes insert, delete, search, listAll methods
 */
public class BinarySearchTree {
	//initial variables
	private binaryTreeNode root;
	
	//constructor
	public BinarySearchTree() {
		root = null;
	}
	/**
	 * @param key
	 * public insert method. calls the private insert method
	 */
	public void insert(Comparable key) {
		binaryTreeNode newNode = new binaryTreeNode(key, null, null, null);
		//insert if empty
		if (root == null) {
			root = newNode;
			System.out.println("set " + newNode.getKey() + " as new root node");
			//call private insert
		} else {
			root.insertNode(newNode);
			System.out.println("Inserted " + newNode.getKey());
		} //end else
	} //end method
	

	/**
	 * delete method with recursive calls
	 * Follows the right subtrees going to the left child and deletes the node
	 */
	public void deleteNode(Comparable key) {
		//find node to be removed
		binaryTreeNode tobeRemoved = root;
		binaryTreeNode parent = null;
		boolean found = false; //boolean flag
		while (!found && tobeRemoved != null) {
			int compare = tobeRemoved.getKey().compareTo(key);
			if (compare == 0) {
				found = true; //found node to remove
			} else {
				//check parent
				parent = tobeRemoved;
				//left child
				if (compare > 0) {
					tobeRemoved = tobeRemoved.getLeftChild();
				//right child
				} else {
					tobeRemoved = tobeRemoved.getRightChild();
				} //end inner else
			} //end outer else
		} //end while
		if (!found) {
			return;
		} //end if
		//use one of the child nodes
		if (tobeRemoved.getLeftChild() == null || tobeRemoved.getRightChild() == null) {
			binaryTreeNode newChild;
			if (tobeRemoved.getLeftChild() == null) {
				newChild = tobeRemoved.getLeftChild();
			} else {
				newChild = tobeRemoved.getRightChild();
			} //end else
			//found in root
			if (parent == null) {
				root = newChild;
			} else if (parent.getLeftChild() == tobeRemoved) {
				parent.setLeftChild(newChild);
			} else {
				parent.setRightChild(newChild);
			} //end else
			System.out.println("removed " + key);
			return;
		} //end outer if
		
		//find smallest element in right subtree
		binaryTreeNode smallestParent = tobeRemoved;
		binaryTreeNode smallest = tobeRemoved.getRightChild();
		while (smallest.getLeftChild()!=null) {
			smallestParent = smallest;
			//keep picking left child
			smallest = smallest.getLeftChild();
		} //end while
		
		//move over data, remove child link
		tobeRemoved.setKey(smallest.getKey());
		if (smallestParent == tobeRemoved) {
			smallestParent.setRightChild(smallest.getRightChild());
		} else {
			smallestParent.setLeftChild(smallest.getRightChild());
		} //end else
	} //end method
	
	/**
	 * @param key to compare
	 * @return true if found, false otherwise
	 */
	public boolean search(Comparable key) {
		binaryTreeNode toSearch = root; //reference to root
		//keep searching while not found
		while (toSearch!= null) {
			int compare = toSearch.getKey().compareTo(key);
			if (compare == 0) {
				System.out.println(key + " found in tree");
				return true; //key values are the same
				//shift search left
			} else if (compare > 0) {
				toSearch = toSearch.getLeftChild();
				//shift  search right
			} else {
				toSearch = toSearch.getRightChild();
			} //end else
		} //end while
		System.out.println(key + " Not found in tree");
		return false;
	} //end method
	
	/**
	 * Prints the tree by calling the recursive private listNodes method
	 */
	public void listAll() {
		binaryTreeNode ref = root;
		listAllNodes(ref);
	}
	
	/**
	 * @param parent root of subtree
	 * prints the nodes in sorted order via inOrder sort
	 * Prints left subtree, then parent, then left subtree
	 */
	private static void listAllNodes(binaryTreeNode parent) {
		if (parent == null) {
			return;
		}
		listAllNodes(parent.getLeftChild()); //traverse left 
		System.out.println("key " + parent.getKey()); //get parent data
		listAllNodes(parent.getRightChild()); //traverse right
	}
}
