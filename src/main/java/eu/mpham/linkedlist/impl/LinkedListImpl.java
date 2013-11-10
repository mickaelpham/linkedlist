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
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();

		if (index == 0) {
			// edge case: adding as the first element
			Node next = root;
			root = new Node(e);
			root.setNext(next);
			
		} else {
			// insert the new node in between
			Node previous = findAt(index - 1);
			Node n = new Node(e);
			n.setNext(previous.getNext());
			previous.setNext(n);
		}
		this.size++;
	}

	@Override
	public void clear() {
		this.size = 0;
		// assuming the JVM and GC will take care of all the remaining nodes
		// since they are not referenced anymore, this should be enough
		this.root = null;

	}

	@Override
	public boolean contains(Object o) {
		if (root == null)
			return false;
		else if (root.getNext() == null)
			return (o.equals(root.getData()));
		else {
			Node current = root;
			while (current != null) {
				if (o.equals(current.getData()))
					return true;
				current = current.getNext();
			}
			return false;
		}
	}

	@Override
	public Object get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		return findAt(index).getData();
	}

	@Override
	public Object remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		Node removed;
		if (index == 0) {
			removed = root;
			root = removed.getNext();
		} else {
			Node previous = findAt(index - 1);
			removed = previous.getNext();
			previous.setNext(removed.getNext());
		}
		size--;
		return removed.getData();
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

	/**
	 * Find the node at the given index position
	 * 
	 * @param index
	 *            Node position to return
	 * @return the node at the given index position
	 */
	private Node findAt(int index) {
		Node current = root;
		for (int i = 0; i < index; i++)
			current = current.getNext();
		return current;
	}

}
