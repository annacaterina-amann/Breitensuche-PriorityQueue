/**
 * Class representing an undirected graph.
 */
public class UndirectedGraph {

    /*Array containing all nodes*/
    public UndirectedGraphNode[] nodes;

    /*Queue necessary for implementing an iterative breadth-first search*/
    public Queue queue;


    /**
     * Constructor calling all necessary methods to create the undirected graph based on the String input
     *
     * @param input String containing an adjazenzlist representation of the graph
     */
    public UndirectedGraph(String input) {
        parseInput(input);
    }

    /**
     * Parses the input and generates the array list containing all nodes
     *
     * @param input String containing an adjazenzlist representation of the graph
     */
    private void parseInput(String input) {
        String[] lines = input.split("\\r?\\n");

        //First parse n, which is the number of nodes
        String[] string_containing_n = lines[0].split("=");
        int n = Integer.valueOf(string_containing_n[1]);
        nodes = new UndirectedGraphNode[n];

        // after that every line contains one node's adjazenzlist
        // first create all nodes
        for (int i = 1; i < lines.length; i++) {
            UndirectedGraphNode node = new UndirectedGraphNode();
            String[] node_val_and_rest = lines[i].split(":");
            node.value = Integer.valueOf(node_val_and_rest[0]);
            nodes[i - 1] = node;
        }

        // then process the adjazenzlist
        for (int i = 1; i < lines.length; i++) {
            UndirectedGraphNode node = nodes[i - 1];
            String[] node_val_and_rest = lines[i].split(":");
            processAdjazenzList(node_val_and_rest[1], node);
        }
    }

    /**
     * Processes each adjazenzlist input line and creates the neighbors array of each node
     *
     * @param line String representation of the adjazenzlist
     * @param node node for which the adjazenzlist is supplied
     */
    private void processAdjazenzList(String line, UndirectedGraphNode node) {
        String[] neighboring_nodes = line.split(",");
        node.neighbors = new UndirectedGraphNode[neighboring_nodes.length];
        for (int i = 0; i < neighboring_nodes.length; i++) {
            String node_val = neighboring_nodes[i];
            UndirectedGraphNode neighbor = findSpecificNodeByValue(Integer.valueOf(node_val));
            if (neighbor != null) {
                node.neighbors[i] = neighbor;
            }
        }
    }

    /**
     * Returns the UndirectedGraphNode object in the node array based on the value
     *
     * @param val value of the node to be returned
     * @return UndirectedGraphNode with the specified value
     */
    public UndirectedGraphNode findSpecificNodeByValue(int val) {
        for (UndirectedGraphNode ugn : nodes) {
            if (ugn.value == val) {
                return ugn;
            }
        }
        return null;
    }

    /**
     * Traverses the undirected graph in an iterative breadth-first search manner using a queue. The
     * procedure always starts at the node at position 0 in the array containing all nodes (aka  UndirectedGraphNode []
     * nodes) and successively processes the node's neighbors.
     *
     * @return Array containing the nodes in order of traversal.
     */
    public UndirectedGraphNode[] bfs() {
       //TODO
        return null;
    }

}


