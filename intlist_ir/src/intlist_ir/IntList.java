package intlist_ir;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class stores a sequence of int values.
 */
public class IntList {
	
	private static class Node {
		/**
		 * @invar | previous != null
		 * @invar | next != null
		 * @invar | previous.next == this
		 * @invar | next.previous == this
		 * 
		 * @peerObject
		 */
		private Node previous;
		private int value;
		/**
		 * @peerObject
		 */
		private Node next;
		
		private int getLengthTo(Node other) {
			if (this == other)
				return 0;
			else
				return 1 + next.getLengthTo(other);
		}
	}
	
	/**
	 * @invar | sentinel != null
	 * 
	 * @representationObject
	 */
	private Node sentinel;
	
	public int[] getElements() {
		int[] result = new int[sentinel.next.getLengthTo(sentinel)];
		Node node = sentinel.next;
		for (int i = 0; i < result.length; i++) {
			result[i] = node.value;
			node = node.next;
		}
		return result;
	}
	
	/**
	 * @pre | elements != null
	 * @post | Arrays.equals(getElements(), elements)
	 */
	public IntList(int[] elements) {
		sentinel = new Node();
		sentinel.next = sentinel;
		sentinel.previous = sentinel;
		
		for (int element : elements)
			add(element);
	}
	
	/**
	 * @mutates | this
	 * 
	 * @post | getElements().length == old(getElements()).length + 1
	 * @post | Arrays.equals(getElements(), 0, old(getElements()).length, old(getElements()), 0, old(getElements()).length)
	 * @post | getElements()[old(getElements()).length] == value
	 */
	public void add(int value) {
		Node newNode = new Node();
		newNode.value = value;
		newNode.next = sentinel;
		newNode.previous = sentinel.previous;
		sentinel.previous = newNode;
		newNode.previous.next = newNode;
	}
	
	/**
	 * @mutates | this
	 * 
	 * @pre | 0 <= index && index < getElements().length
	 * @post | IntStream.range(0, getElements().length).allMatch(i -> getElements()[i] == (i == index ? value : old(getElements())[i]))
	 */
	public void setElementAt(int index, int value) {
		Node node = sentinel.next;
		while (0 < index) {
			node = node.next;
			index--;
		}
		node.value = value;
	}

}
