import java.util.ArrayList;
import java.util.HashMap;

/** An instance is a heap of elements of type T. */
public class MyHeap<T> implements MinHeap<T> {
    
    /** Constructor: an empty heap. */
    public MyHeap() { }

    /** Return a representation of this heap. */
    public @Override String toString(){
        //TODO  
        return "";
    }

    /** Remove and return the min value in this heap.
     * Precondition: The heap is not empty. */
    public @Override T poll() {
        //TODO 
        return null;
    }

    /** Add item with priority p to this heap.
     * Throw IllegalArgumentException if an equal item is already in the heap. */
    public @Override void add(T item, double p) throws IllegalArgumentException {
        //TODO 
    }

    /** Change the priority of item to p. */
    public @Override void updatePriority(T item, double p) {
        //TODO
    }

    /** Return the size of this heap. */
    public @Override int size() {
        //TODO
        return 0;
    }

    /** Return true iff the heap is empty. */
    public @Override boolean isEmpty() {
        //TODO
        return false;
    }
}