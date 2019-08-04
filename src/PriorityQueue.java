/**
 * Class representing a priority queue based on a max-heap. Elements stored in the queue are UndirectedGraphNode
 * objects. The value of the UndirectedGraphNode determines it position in the priority queue.
 */

public class PriorityQueue {

    /*Max-heap*/
    Heap heap;

    /**
     * Constructor creating a priority queue object based on the heap
     * @param heap
     */
    public PriorityQueue(Heap heap) {
        this.heap = heap;
    }

    /**
     * Returns the maximum of the priority queue.
     * @return node with the maximum value
     */
    public UndirectedGraphNode max() {
		//TODO
    	UndirectedGraphNode[] max = new UndirectedGraphNode[heap.size];
        return max[0];
    }

    /**
     * Extracts/removes the element with the maximum value of the queue.
     */
    public void extract_max() {
       //TODO
    	UndirectedGraphNode[] array = new UndirectedGraphNode[heap.size];
    	swap(array[1], array[heap.size]);
    	heap.size -= 1;
    	heap.heapify(array, 1);
    }

    /**
     * Adds a new node to the priority queue by adding it at the correct "spot" in the priority queue.
     * @param newnode Node to be added to the queue
     */
    public void insert(UndirectedGraphNode newnode) {
        //TODO
    	UndirectedGraphNode[] array = new UndirectedGraphNode[heap.size];
    	heap.size += 1;
    	array[heap.size - 1] = newnode;
    	int i = heap.size;
    	
    	while(i > 1 && array[i].value > array[heap.parent(i)].value) {
    		swap(array[i], array[heap.parent(i)]);
    		i = heap.parent(i);
    	}
    }

    private void swap(UndirectedGraphNode ugn1, UndirectedGraphNode ugn2) {
		// TODO Auto-generated method stub
    	int temp = ugn1.value; 
        ugn1.value = ugn2.value; 
        ugn2.value = temp;
	}

    /**
     * Returns a String representation of the priority queue
     * @return String representation of the priority queue
     */
    public String toString() {
        return heap.toString();
    }
}
