import java.util.ArrayList;
import java.util.HashMap;

/** An instance is a heap of elements of type T. */
public class MyHeap<T> implements MinHeap<T> {
    
	ArrayList<HeapEntry> heap;
	HashMap<MyHeap<T>, HeapEntry> heapMap;
	
    /** Constructor: an empty heap. */
    public MyHeap() { 
    	heap = new ArrayList<HeapEntry>();
    	heapMap = new HashMap<MyHeap<T>, HeapEntry>();
    }

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
        HeapEntry entry = (HeapEntry) item;
        
        if(entry.priority < p){
        	throw new IllegalArgumentException();
        }
        
        entry.priority = p;
        
        HeapEntry parent = heap.get(getParent(entry.index));
        
        if(parent.compareTo(entry) > 0){
        	 swap(parent, entry);
        }
        
       
    }

    /** Return the size of this heap. */
    public @Override int size() {
        
    	return heap.size();
    }

    /** Return true iff the heap is empty. */
    public @Override boolean isEmpty() {
        
    	return heap.size() == 0;
    }
    
    //Return parent index of a node in the heap
    private int getParent(int index) {
		if (index < 0 || index >= heap.size()){
			throw new IllegalArgumentException();
		}
			
		return (index - 1) / 2;
	}
    
    //Swap two nodes in the heap
    private void swap(HeapEntry entry1, HeapEntry entry2) {
    	
  	  if (entry1 == null && entry2 == null){
  		
  		  throw new IllegalArgumentException();
  	  }
  	    
  	  int index1 = entry1.index;
  	  int index2 = entry2.index;
  	  
  	 if (index1 < 0 || index1 > heap.size() || index2 < 0 || index2 > heap.size()){
  		 throw new IllegalArgumentException();
  	 }
 	   
  	 entry1.index = index2;
  	 entry2.index = index1;
  	 
  	 heap.set(entry1.index, entry2);
  	 heap.set(entry2.index, entry1);
    
   }
    
    public static class HeapEntry implements Comparable<HeapEntry>{
    	
    	public int index;
    	public double priority;
    	
    	public HeapEntry(int i, double p){
    		this.index = i;
    		this.priority = p;
    	}
    	
    	@Override
    	public int compareTo(HeapEntry entry){
    		
    		return Double.compare(priority, entry.priority);
    		
    	}
    }
}