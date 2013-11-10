package eu.mpham.linkedlist.interfaces;

/**
 * 
 * @author Mickael Pham <mickael.pham@gmail.com>
 * 
 *         This class represents a single linked list that can be instantiated
 *         and provide the common list operation (add, remove, etc.)
 * 
 */
public interface LinkedList {

	/**
	 * Appends the specified element to the end of this list
	 * 
	 * @param e
	 *            element to be appended to this list
	 * @return `true` as specified by the collection framework
	 */
	public boolean add(Object e);

	/**
	 * Inserts the specified element at the specified position in this list
	 * 
	 * @param index
	 *            index at which the specified element is to be inserted
	 * @param e
	 *            element to be inserted
	 * @throws IndexOutOfBoundException
	 *             if the index is out of range (index < 0 || index > size())
	 */
	public void add(int index, Object e) throws IndexOutOfBoundsException;

	/**
	 * Removes all of the elements from this list
	 */
	public void clear();

	/**
	 * Returns `true` if this list contains the specified element
	 * 
	 * @param o
	 *            object to search for
	 * @return `true` if found in this list
	 */
	public boolean contains(Object o);

	/**
	 * Returns the element at the specified position in this list
	 * 
	 * @param index
	 *            index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size())
	 */
	public Object get(int index) throws IndexOutOfBoundsException;

	/**
	 * Removes the element at the specified position in this list
	 * 
	 * @param index
	 *            index of the element to remove
	 * @return the removed element at the specified position
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size())
	 */
	public Object remove(int index) throws IndexOutOfBoundsException;

	/**
	 * Returns the number of elements in this list
	 * 
	 * @return the number of elements in this list
	 */
	public int size();

}
