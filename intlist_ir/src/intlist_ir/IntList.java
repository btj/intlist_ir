package intlist_ir;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class stores a sequence of int values.
 */
public class IntList {
	
	/**
	 * @invar | elements != null
	 * 
	 * @representationObject
	 */
	private int[] elements;
	
	public int[] getElements() { return elements.clone(); }
	
	/**
	 * @pre | elements != null
	 * @post | Arrays.equals(getElements(), elements)
	 */
	public IntList(int[] elements) {
		this.elements = elements.clone();
	}
	
	/**
	 * @mutates | this
	 * 
	 * @pre | 0 <= index && index < getElements().length
	 * @post | IntStream.range(0, getElements().length).allMatch(i -> getElements()[i] == (i == index ? value : old(getElements())[i]))
	 */
	public void setElementAt(int index, int value) {
		elements[index] = value;
	}

}
