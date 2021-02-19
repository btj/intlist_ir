package intlist_ir.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import intlist_ir.IntList;

class IntListTest {

	@Test
	void test() {
		int[] elems = {1, 5, 9};
		IntList myIntList = new IntList(elems);
		assertArrayEquals(new int[] {1, 5, 9}, myIntList.getElements());

		assertArrayEquals(new int[] {1, 5, 9}, elems);

		myIntList.setElementAt(0, 10);
		assertArrayEquals(new int[] {10, 5, 9}, myIntList.getElements());
		
		assertArrayEquals(new int[] {1, 5, 9}, elems);

	}

}
