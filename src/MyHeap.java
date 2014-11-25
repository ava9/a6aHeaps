import java.util.ArrayList;
import java.util.HashMap;

/** An instance is a heap of elements of type T. */
public class MyHeap<T> implements MinHeap<T> {
    
	ArrayList<T> heap;
	HashMap<T, HeapEntry> heapMap;
	HeapEntry entry;
	
    /** Constructor: an empty heap. */
    public MyHeap() { 
    	heap = new ArrayList<T>();
    	heapMap = new HashMap<T, HeapEntry>(); 	
    }

    /** Return a representation of this heap. */
    public @Override String toString(){
        String s = "[";
        //	 * [item1:priority1, item2:priority2, ..., itemN:priorityN]
    	for (int i=0; i < heapMap.size(); i++){
    		if (i == heapMap.size()-1){
    			s = s + heap.get(i) + ":" + heapMap.get(heap.get(i)).priority;
    		}
    		else{
    			s = s + heap.get(i) + ":" + heapMap.get(heap.get(i)).priority + ", ";
    		}
        }
    	s = s + "]";
        return s;
    }

    /** Remove and return the min value in this heap.
     * Precondition: The heap is not empty. */
    public @Override T poll() {
        if(heap.size() == 0){
        	return null;
        }
        T temp1 = heap.get(0);
        heapMap.remove(temp1);
        T temp2 = heap.remove(heap.size() - 1);
        
        if (heap.size() == 0){
        	return temp1;
        }
        heap.set(0, temp2);
        heapMap.get(temp2).index=0;
        bubbleDown(0);
        return temp1;
    }

    /** Add item with priority p to this heap.
     * Throw IllegalArgumentException if an equal item is already in the heap. */
    public @Override void add(T item, double p) throws IllegalArgumentException {
        
    	if(item == null || heapMap.containsKey(item)){
    		throw new IllegalArgumentException();
    	}
    	
    	heap.add(item);
    	heapMap.put(item, new HeapEntry(heap.size()-1, p));
    	
    	bubbleUp(heap.size()-1);
    }

    /** Change the priority of item to p. */
    public @Override void updatePriority(T item, double p) {
        HeapEntry entry = heapMap.get(item);
        double tempPriority = entry.priority;
        entry.priority = p;
        //HeapEntry parent = heapMap.get(heap.get(entry.index));
        if(tempPriority > p){
        	 bubbleUp(entry.index);
        }
        else if (tempPriority < p){
        	 bubbleDown(entry.index);
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
    /** Bubble element k up the tree */
    private void bubbleUp(int k){
    	int p = (k-1)/2;
    	while ((k > 0) && (heapMap.get(heap.get(k)).compareTo(heapMap.get(heap.get(p))) < 0)){
    		swap(heap.get(k), heap.get(p));
    		k = p;
    		p = (k-1)/2;
    	}
    }
    
    /** Bubble the root down to its heap position. */
    private void bubbleDown(int k){
    	int c = 2*k+2;
    	if ((c > heap.size()-1) || (heapMap.get(heap.get(c-1)).compareTo(heapMap.get(heap.get(c))) < 0)){
    		c--;
    	}
    	while ((c < heap.size()) && ((heapMap.get(heap.get(k)).compareTo(heapMap.get(heap.get(c))) > 0))){
    		swap(heap.get(k), heap.get(c));
    		k = c;
    		c = 2*k+2;
    		if ((c > heap.size()-1) || (heapMap.get(heap.get(c-1)).compareTo(heapMap.get(heap.get(c))) < 0)){
        		c--;
        	}
    	}
    }
    
    //Swap two nodes in the heap
    private void swap(T entry1, T entry2) {
    	
  	  if (entry1 == null || entry2 == null){
  		
  		  throw new IllegalArgumentException();
  	  }
  	    
  	  int index1 = heapMap.get(entry1).index;
  	  int index2 = heapMap.get(entry2).index;
  	  
  	 if (index1 < 0 || index1 >= heap.size() || index2 < 0 || index2 >= heap.size()){
  		 throw new IllegalArgumentException();
  	 }
 	   
  	 heapMap.get(entry1).index = index2;
  	 heapMap.get(entry2).index = index1;
  	 
  	 heap.set(index1, entry2);
  	 heap.set(index2, entry1);
    
   }
    
    private class HeapEntry implements Comparable<HeapEntry>{
    	
    	private int index;
    	private double priority;

    	private HeapEntry(int i, double p){
    		this.index = i;
    		this.priority = p;
    	}
    	
    	private int getIndex(){
    		return index;
    	}
    	
    	private double getPriority(){
    		return priority;
    	}
    	
    	@Override
    	public int compareTo(HeapEntry entry){
    		
    		return Double.compare(priority, entry.priority);
    		
    	}
    }
}