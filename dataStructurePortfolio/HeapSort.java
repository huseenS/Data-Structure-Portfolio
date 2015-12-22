
package dataStructurePortfolio;

/**
 * @author Huseen Sufi
 * Implements Heap data Structure using an Array
 * Includes Sort method, fixHeap method, access methods
 */
public class HeapSort {

	//initial variables
	private int length;
	private int rightChildIndex;
	/**
	 * @param length
	 * @param rightChildIndex
	 */
	public HeapSort(int length, int rightChildIndex) {
		this.length = length;
		this.rightChildIndex = rightChildIndex;
	}

	
	/**
	 * @param a
	 * Sorts the array using HeapSort
	 * calls fixHeap to build the heap  then sorts
	 */
	private void sort(int[] a) {
		//build the heap from the initial array
		length = a.length -1;
		for (int i = (length - 1)/2; i >= 0; i--) { //start with the rightmost Node
			fixHeap(a,i,length);
		}
		//sort using selection Sort algorithm as array when heaped is backwards. Keeps sorted and unsorted in original array
		while (length > 0) {
			swap(a, 0, length); //swap the largest item(root) with the lowest item(smallest child)
			length--; //decrement so unsorted heap is smaller and smaller per iteration
			fixHeap(a,0,length); //fix the subtrees
		}
	}
	
	/**
	 * @param a array to fix
	 * @param rootIndex
	 * @param lastIndex
	 * Fixes the tree so it obeys heap property where all parent nodes are at least as large as children
	 * works by fixing lower part of tree and working up to root
	 * fix the lowest subtree then fix the other subtree on same level. go up one level and repeat
	 */
	private  void fixHeap(int[] a, int rootIndex, int lastIndex) {
		int rootValue = a[rootIndex]; //value at root position
		int index = rootIndex; //current index
		boolean more = true; //boolean flag 
		while (more) {
			int childIndex = getLeftChildIndex(index); //set the largest as left Child
			
			//if there are more child nodes
			if (childIndex <= lastIndex) {
				//set right child
				rightChildIndex = getRightChildIndex(index);
				/*if the right child is smaller than the last node, and the value of that child is larger than left
				* then use the right
				*/
				if (rightChildIndex <= lastIndex && a[rightChildIndex] > a[childIndex]) {
					childIndex = rightChildIndex; //set right child as larger child
				}
				// if the child is larger than parent then promote the child to pos of parent
				if (a[childIndex] > rootValue) {
					a[index] = a[childIndex];
					index = childIndex; //set the current index
				} else {
					more = false; //root is larger than both children
				}
			} else {
				more = false; //no child
			}
		}
		a[index] = rootValue; //store the value in empty slot
	}
	
	/**
	 * @param index
	 * @return left child
	 */
	private int getLeftChildIndex(int index) {
		return 2 * index +1;
	}
	/**
	 * @param index
	 * @return right child
	 */
	private int getRightChildIndex(int index) {
		return 2 * index +2;
	}
	
	/**
	 * @param a array to sort
	 * @param i
	 * @param j
	 * swap values using temp variable
	 */
	private void swap(int[] a , int i, int j ) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

}
