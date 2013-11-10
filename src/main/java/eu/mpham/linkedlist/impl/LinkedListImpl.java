package eu.mpham.linkedlist.impl;

import eu.mpham.linkedlist.impl.data.Node;
import eu.mpham.linkedlist.interfaces.LinkedList;

/**
 * The linked list implementation in Java
 * 
 * @author Mickael Pham <mickael.pham@gmail.com>
 * 
 */
public class LinkedListImpl implements LinkedList {

	private int size;

	private Node root;

	public LinkedListImpl() {
		this.size = 0;
	}

	@Override
	public boolean add(Object e) {
		// If it's the first object we are inserting in our list
		if (size == 0) {
			root = new Node(e);
		} else {
			Node current = findLast(root);
			current.setNext(new Node(e));
		}
		size++;
		return true;
	}

	@Override
	public void add(int index, Object e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Recursively returns the last node in the current list
	 * 
	 * @param current
	 *            actual node we are on
	 * @return last node on this list
	 */
	private Node findLast(Node current) {
		if (current.getNext() != null) {
			return findLast(current.getNext());
		} else {
			return current;
		}
	}

}
