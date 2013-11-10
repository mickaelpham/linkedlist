package eu.mpham.linkedlist.impl.data;

/**
 * A node is represented by a data (stored in an object) and a reference to
 * another node, so it can be used by the linked list implementation.
 * 
 * @author Mickael Pham <mickael.pham@gmail.com>
 * 
 */
public class Node {

	private Node next;

	private Object data;

	public Node(Object data) {
		this.next = null;
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
