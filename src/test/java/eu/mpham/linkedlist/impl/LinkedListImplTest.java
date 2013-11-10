package eu.mpham.linkedlist.impl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import eu.mpham.linkedlist.interfaces.LinkedList;

/**
 * Unit test for the linked list implementation
 * 
 * @author Mickael Pham <mickael.pham@gmail.com>
 * 
 */
public class LinkedListImplTest extends TestCase {

	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public LinkedListImplTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(LinkedListImplTest.class);
	}

	/**
	 * Test node insertion to the linked list
	 */
	public void testAddSingleNodeToList() {
		LinkedList ll = new LinkedListImpl();
		assertEquals(0, ll.size());
		String data = "Hello";
		ll.add(data);
		assertEquals(1, ll.size());
		// now retrieve the data
		String retrieved = (String) ll.get(0);
		assertEquals(data, retrieved);
	}
	
	/**
	 * Test multiple node insertions
	 */
	public void testAddMultipleNodes() {
		String data[] = { "Banana", "Apple", "Orange", "Watermelon" };
		LinkedList ll = new LinkedListImpl();
		// add them all to the linked list
		for (String d : data)
			ll.add(d);
		assertEquals(data.length, ll.size());
		for (int i = 0; i < data.length; i++) {
			String retrieved = (String) ll.get(i);
			assertEquals(data[i], retrieved);
		}
	}

}
