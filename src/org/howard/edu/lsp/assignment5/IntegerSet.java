package org.howard.edu.lsp.assignment5;

import java.util.TreeSet;

public class IntegerSet() {
    private TreeSet<Integer> elements = new TreeSet<Integer>();

    public void clear() {

    }
    public int length() {

    }

    public boolean equals(IntegerSet b) {

    }

    public boolean contains(int value) {

    }

    public int largest() {

    }

    public int smallest() {

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

    }

    public IntegerSet symmetricDiff(IntegerSet b) {

    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }
    @Override
    public String toString() {

    }

}
