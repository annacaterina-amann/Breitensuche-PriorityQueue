/**
 * Class representing a queue that holds UndirectedGraphNode objects. The queue is implemented based on a
 * doubly linked list. The end of the queue is the tail of the list, i.e., new objects are added at the back.
 * The start of the queue is the head of the list, i.e., objects are removed from the beginning of the list.
 */
public class Queue {


    /**
     * Removes the element at the start of the queue, i.e. removes the head of the linked list.
     * @return object at the start of the queue
     */
    public UndirectedGraphNode get() {
        //TODO
        return null;
    }

    /**
     * Adds a new UndirectedGraphNode to the end of queue by adding it as a new tail element in the linked list.
     * @param new_tail node to be added
     */
    public void put(UndirectedGraphNode new_tail) {
        //TODO
    }


    /**
     * Returns  <code>true</code> if there are no elements stored in the queue, <code>false</code> otherwise.
     * @return <code>true</code> if there are no elements stored in the queue;
     *         <code>false</code> otherwise
     */
    public boolean isEmpty() {
        //TODO
        return true;
    }


    /**
     * Returns a String representation of the queue, by printing the value of the nodes starting from the start (head)
     * of the queue and ending with the end (tail) of the queue. Between each node value there is an right arrow ("->").
     * If the queue is empty, this method returns just "null".
     * @return String representation of the queue
     */
    public String toString() {
        //TODO
        return "";
    }

}
