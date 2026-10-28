package org.howard.edu.lsp.assignment5;

import java.util.TreeSet;

/**
 * Mathematical set of integers
 */
public class IntegerSet {
    private final TreeSet<Integer> elements = new TreeSet<>();

    /**
     * Empties the set
     */
    public void clear() {
        elements.clear();
    }

    /**
     * Get the length of the set
     * @return the number of elements in the set
     */
    public int length() {
        return elements.size();
    }

    /**
     * Checks if two integer sets are equal
     * @param b Integer set to compare to
     * @return boolean value of equality
     */
    public boolean equals(IntegerSet b) {
        return elements.equals(b.elements);
    }

    /**
     * Checks whether a specified value is in the set
     * @param value value to be searched for
     * @return boolean value of whether the element is in the set
     */
    public boolean contains(int value) {
        return elements.contains(value);
    }

    /**
     * Finds the largest element in a set
     * @return largest element
     * @throws IllegalStateException thrown when set is empty
     */
    public int largest() throws IllegalStateException {
        if (elements.isEmpty()) {
            throw new IllegalStateException("No elements in set");
        }

        return elements.last();
    }

    /**
     * Finds the smallest element in a set
     * @return smallest element
     * @throws IllegalStateException thrown when set is empty
     */
    public int smallest() throws IllegalStateException {
        if (elements.isEmpty()) {
            throw new IllegalStateException("No elements in set");
        }

        return elements.first();
    }

    /**
     * Adds a new element to the set, does nothing for elements already in the set
     * @param item element to be added to the set
     */
    public void add(int item) {
        elements.add(item);
    }

    /**
     * Removes an element from the set, does nothing if element is not in the set
     * @param item element to be removed from the set
     */
    public void remove(int item) {
            elements.remove(item);
    }

    /**
     * The mathematical union of two sets
     * @param b integer set with which to perform union
     * @return the set representing the union
     */
    public IntegerSet union(IntegerSet b) {
       IntegerSet result = new IntegerSet();
       result.elements.addAll(this.elements);
       result.elements.addAll(b.elements);
       return result;
    }

    /**
     * The mathematical intersection of two sets
     * @param b integer set with which to perform intersection
     * @return the set representing the intersection
     */
    public IntegerSet intersect(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.elements.addAll(this.elements);
        result.elements.retainAll(b.elements);
        return result;
    }

    /**
     * The set difference of two sets
     * @param b integer set with which to perform difference
     * @return the set representing the difference
     */
    public IntegerSet diff(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.elements.addAll(this.elements);
        result.elements.removeAll(b.elements);
        return result;
    }

    /**
     * The elements in a given not in the current set
     * @param b integer set with which to perform 'complement'
     * @return the set representing the 'complement'
     */
    public IntegerSet complement(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.elements.addAll(b.elements);
        result.elements.removeAll(this.elements);
        return result;
    }

    /**
     * Checks whether set is a subset of a given set
     * @param b integer set
     * @return boolean value of whether set is a subset of given set
     */
    public boolean isSubsetOf(IntegerSet b) {
        return b.elements.containsAll(this.elements);
    }

    /**
     * Checks whether set is disjoint from a given set
     * @param b integer set
     * @return boolean value of whether sets are disjoint
     */
    public boolean isDisjoint(IntegerSet b) {
        return this.intersect(b).isEmpty();
    }

    /**
     * The symmetric difference of two sets
     * @param b integer set
     * @return symmetric difference of the sets
     */
    public IntegerSet symmetricDiff(IntegerSet b) {
        return this.union(b).diff(this.intersect(b));
    }

    /**
     * Checks whether set is empty
     * @return boolean value of whether sets are empty
     */
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    /**
     * Returns a string representation of the set
     * @return a string representation of the set
     */
    @Override
    public String toString() {
        return elements.toString();

    }

}
