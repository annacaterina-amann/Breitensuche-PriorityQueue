/**
 * Class that represents the data structure max-heap. The class uses the array representation of a heap.
 */
public class Heap {

    /*Array that represents the heap*/
    UndirectedGraphNode[] array;

    /*Size of the heap*/
    int size;

    /**
     * Constructor that already calls the method build heap that constructs the heap based on the unordered
     * array passed as a parameter.
     * @param init_array unordered array to be "converted" to a heap
     */
    public Heap(UndirectedGraphNode[] init_array) {
        size = init_array.length;
        array = new UndirectedGraphNode[size];
        array = init_array;
        build_heap(array);
    }


    /**
     * Builds a heap based on an unordered array. Hence, after calling this function the array
     * (aka UndirectedGraphNode[] array;) is fullfilling the max-heap condition.
     */
    public void build_heap(UndirectedGraphNode[] array) {
        //TODO
    	for (int i = size/2 ; i >= 0; i--) {
    		heapify(array, i);
    	}
    }

    /**
     * Heapifies an element in the heap, such that the max-heap condition is satisfied.
     * @param i Index of the element in the array to be heapified.
     */
    public void heapify(UndirectedGraphNode[] array, int i) {
        //TODO
    	int l = left(i);
    	int r = right(i);
    	int index = i;
    	
    	if (l < size && array[l].value > array[i].value) {
    		index = l;
    	} 
    	if (r < size && array[r].value > array[index].value) {
    		index = r;
    	} 
    	if (i != index) {
    		swap(array[i], array[index]);
    		heapify(array, index);
    	}
    	
    }


    private void swap(UndirectedGraphNode ugn1, UndirectedGraphNode ugn2) {
		// TODO Auto-generated method stub
    	int temp = ugn1.value; 
        ugn1.value = ugn2.value; 
        ugn2.value = temp;
	}


	/**
     * Computes the index of the "left child" of the element at index i.
     * @param i index to compute the "left child" for
     * @return index of the "left child"
     */
    public int left(int i) {
        //TODO
       return 2*i+1;
    }

    /**
     * Computes the index of the "right child" of the element at index i.
     * @param i index to compute the "right child" for
     * @return index of the "right child"
     */
    public int right(int i) {
        //TODO
        return 2*i+2;
    }

    /**
     * Computes the index of the "parent" of the element at index i.
     * @param i index to compute the "parent" for
     * @return index of the "parent"
     */
    public int parent(int i) {
        //TODO
        return i/2;
    }

    /**
     * Returns a string representation of the heap by printing the elements in order and separating them with
     * a comma.
     * @return String representation of the heap
     */
    public String toString() {
        String result = "";
        if(size <= 0 || array.length<=0){
            return "null";
        }
        int i = 0;
        while (i < size - 1) {
            result += array[i] + ",";
            i++;
        }
        result += array[size - 1];
        return result;
    }

}
