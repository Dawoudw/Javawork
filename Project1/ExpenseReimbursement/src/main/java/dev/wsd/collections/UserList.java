package dev.wsd.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UserList<E> implements Iterable<E> {

	// Size of list
	private int size = 0;

	// Default capacity of list is 10
	private static final int DEFAULT_CAPACITY = 10;

	// This array will store all elements added to list
	public Object elements[];

	// Default constructor
	public UserList() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	// Add method
	public void add(E e) {
		if (size == elements.length) {
			ensureCapacity();
		}
		elements[size++] = e;
	}

	// Get method
	@SuppressWarnings("unchecked")
	public E get(int i) {
		if (i >= size || i < 0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		}
		return (E) elements[i];
	}

	// Remove method
	@SuppressWarnings("unchecked")
	public E remove(int i) {
		if (i >= size || i < 0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		}
		Object item = elements[i];
		int numElts = elements.length - (i + 1);
		System.arraycopy(elements, i + 1, elements, i, numElts);
		size--;
		return (E) item;
	}

	// Get Size of list
	public int size() {
		return size;
	}

	// Print method
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; i < size; i++) {
			sb.append(elements[i].toString());
			if (i < size - 1) {
				sb.append(",");
			}
		}
		sb.append(']');
		return sb.toString();
	}

	private void ensureCapacity() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}

	class ArrayIterator implements Iterator<E> {
		int current = 0; // the current element we are looking at

		// return whether or not there are more elements in the array that
		// have not been iterated over.
		public boolean hasNext() {
			if (current < elements.length-1) {
				return true;
			} else {
				return false;
			}
		}

		// return the next element of the iteration and move the current
		// index to the element after that.

		@SuppressWarnings("unchecked")
		public E next() {

			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return (E) elements[current++];
		}

	}

	// Return the value at a given index
//	public E get1(int index) {
	// return (E) elements[index];
	// }

	// Set the value at a given index
	// public void set(int index, E value) {
	//// elements[index] = value;

	// }

	// Return the length of the array
	// public int length() {
	// return elements.length;
//	}

	// Return an iterator over the elements in the array. This is generally not
	// called directly, but is called by Java when used in a "simple" for loop.

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		try {
			return new ArrayIterator();
		}

		finally {

		}

	}

}