package eu.mpham.linkedlist.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.mpham.linkedlist.interfaces.LinkedList;

/**
 * Unit test for the linked list implementation
 * 
 * @author Mickael Pham <mickael.pham@gmail.com>
 * 
 */
public class LinkedListImplTest {

	/**
	 * Test node insertion to the linked list
	 */
	@Test
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
	@Test
	public void testAddMultipleNodes() {
		String[] data = { "Banana", "Apple", "Orange", "Watermelon" };
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
	
	/**
	 * Confirm that an exception is thrown when retrieving negative index
	 */
	@Test (expected=IndexOutOfBoundsException.class)
	public void testNegativeIndexShouldThrowException() {
		LinkedList ll = new LinkedListImpl();
		ll.get(-1);
	}
	
	/**
	 *  Test inserting a new element at the beginning
	 */
	@Test
	public void testInsertingNewRootElement() {
		String[] data = { "Banana", "Apple", "Orange", "Watermelon" };
		LinkedList ll = new LinkedListImpl();
		// add them all to the linked list
		for (String d : data)
			ll.add(d);
		// add a new element at the beginning
		String element = "Coconut";
		ll.add(0, element);
		assertEquals(element, (String) ll.get(0));
		// test that the other elements are there too
		assertEquals(data.length + 1, ll.size());
		int i = 1;
		for (String d : data)
			assertEquals(d, ll.get(i++));
	}
	
	/**
	 *  Test inserting a new element in the middle
	 */
	@Test
	public void testInsertingNewElement() {
		String[] data = { "Banana", "Apple", "Orange", "Watermelon" };
		LinkedList ll = new LinkedListImpl();
		// add them all to the linked list
		for (String d : data)
			ll.add(d);
		// add a new element at the beginning
		String element = "Coconut";
		ll.add(2, element);
		assertEquals(element, (String) ll.get(2));
		String[] modifiedData = { "Banana", "Apple", element, "Orange", "Watermelon" };
		// test that all the element are there
		assertEquals(modifiedData.length, ll.size());
		int i = 0;
		for (String d : modifiedData)
			assertEquals(d, ll.get(i++));
	}
	
	/**
	 * Test clear method
	 */
	@Test
	public void testClearLinkedList() {
		String[] data = { "Banana", "Apple", "Orange", "Watermelon" };
		LinkedList ll = new LinkedListImpl();
		// add them all to the linked list
		for (String d : data)
			ll.add(d);
		assertEquals(data.length, ll.size());
		ll.clear();
		assertEquals(0, ll.size());
		String element = "Coconut";
		ll.add(element);
		assertEquals(1, ll.size());
		assertEquals(element, ll.get(0));
	}
	
	/**
	 * Try removing the root element
	 */
	@Test
	public void testRemoveRootElement() {
		String[] data = { "Banana", "Apple", "Orange", "Watermelon" };
		LinkedList ll = new LinkedListImpl();
		// add them all to the linked list
		for (String d : data)
			ll.add(d);
		assertEquals(data.length, ll.size());
		// try removing the root element
		ll.remove(0);
		assertEquals(data.length - 1, ll.size());
		// make sure the new root element is correct
		assertEquals(data[1], ll.get(0));
	}
	
	/**
	 * Try removing an element in the middle
	 */
	@Test
	public void testRemoveMiddleElement() {
		String[] data = { "Banana", "Apple", "Orange", "Watermelon" };
		LinkedList ll = new LinkedListImpl();
		// add them all to the linked list
		for (String d : data)
			ll.add(d);
		assertEquals(data.length, ll.size());
		// try removing the 2nd element
		String removed = (String) ll.remove(1);
		assertEquals(data.length - 1, ll.size());
		// make sure the removed one is correct
		assertEquals(data[1], removed);
		String[] modifiedData = { "Banana", "Orange", "Watermelon" };
		int i = 0;
		for (String d : modifiedData)
			assertEquals(d, ll.get(i++));
	}
	
	/**
	 * Test if the list contains an element
	 */
	@Test
	public void testContainsElement() {
		String[] data = { "Banana", "Apple", "Orange", "Watermelon" };
		LinkedList ll = new LinkedListImpl();
		// add them all to the linked list
		for (String d : data)
			ll.add(d);
		assertEquals(data.length, ll.size());
		assertFalse(ll.contains("Coconut"));
		assertTrue(ll.contains("Watermelon"));
	}

}
