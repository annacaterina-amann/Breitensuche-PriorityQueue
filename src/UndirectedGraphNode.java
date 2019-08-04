/**
 * Class representing an undirected graph node
 */
public class UndirectedGraphNode {

    /*Value of the node*/
    int value;

    /*Array containing the neighboring nodes.
    * These are already sorted in such a way, that in the breadth first search
    * these can be added in the same order to the queue as they appear in this array*/
    UndirectedGraphNode[] neighbors;

    /**
     * Returns a String representation of the node.
     *
     * @return String representation of the node
     */
    public String toString() {
        return String.valueOf(value);
    }

}
