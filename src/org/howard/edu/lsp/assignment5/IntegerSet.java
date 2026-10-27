package org.howard.edu.lsp.assignment5;

import java.util.TreeSet;

public class IntegerSet {
    private final TreeSet<Integer> elements = new TreeSet<>();

    public void clear() {
        elements.clear();
    }
    public int length() {
        return elements.size();
    }

    public boolean equals(IntegerSet b) {
        return elements.equals(b.elements);
    }

    public boolean contains(int value) {
        return elements.contains(value);
    }

    public int largest() throws IllegalStateException {
        if (elements.isEmpty()) {
            throw new IllegalStateException("No elements in set");
        }

        return elements.last();
    }

    public int smallest() throws IllegalStateException {
        if (elements.isEmpty()) {
            throw new IllegalStateException("No elements in set");
        }

        return elements.first();
    }

    public void add(int item) {
        elements.add(item);
    }

    public void remove(int item) {
            elements.remove(item);
    }

    public IntegerSet union(IntegerSet b) {
       IntegerSet result = new IntegerSet();
       result.elements.addAll(this.elements);
       result.elements.addAll(b.elements);
       return result;
    }

    public IntegerSet intersect(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.elements.addAll(this.elements);
        result.elements.retainAll(b.elements);
        return result;
    }

    public IntegerSet diff(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.elements.addAll(this.elements);
        result.elements.removeAll(b.elements);
        return result;
    }

    public IntegerSet complement(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.elements.addAll(b.elements);
        result.elements.removeAll(this.elements);
        return result;
    }

    public boolean isSubsetOf(IntegerSet b) {
        return b.elements.containsAll(this.elements);
    }

    public boolean isDisjoint(IntegerSet b) {
        return this.intersect(b).isEmpty();
    }

    public IntegerSet symmetricDiff(IntegerSet b) {
        return this.union(b).diff(this.intersect(b));
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public String toString() {
        return elements.toString();

    }

}
