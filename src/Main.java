import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    /**
     * String Builder to collect the results for printing at the end
     */
    public static StringBuilder result=new StringBuilder();

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Error: Please specify an input file");
            System.exit(-1);
        }

        IOHandler ioHandler=new IOHandler();
        String input = ioHandler.readInput(args[0]);
        System.out.println("Input File: " + args[0]);

        String input_parsed[] = input.split("----");

        //create undirected graph based on input
        UndirectedGraph graph = new UndirectedGraph(input_parsed[0]);

        //parse remainder of input
        String [] specific_input = input_parsed[1].split("\\r?\\n");

        switch(specific_input[0]){
            case "queue":
                handleQueue(graph,specific_input);
                break;
            case "bfs":
                handleBFS(graph);
                break;
            case "heap":
                handleHeap(graph,specific_input);
                break;
            case "priority":
                handlePriorityQueue(graph,specific_input);
                break;

        }

        System.out.println(result.toString());
        ioHandler.printResultToOutputFile(result.toString(),args[0]);

    }

    /**
     * Handles all requests that are to be performed by the queue.
     * @param graph Undirected Graph that contains the nodes stored in the queue
     * @param commands String array of commands that are to be performed on the queue e.g. get.
     */
    public static void handleQueue(UndirectedGraph graph, String [] commands){
        graph.queue=new Queue();
        //each line of the input is parsed via regular expressions
        for(int i=1; i< commands.length;i++){
            if(commands[i].contains("get")){
                UndirectedGraphNode node_value=graph.queue.get();
                result.append(commands[i]).append(": ").append(node_value.value);
                result.append(" [").append(graph.queue.toString()).append("]\n");
            }
            else if(commands[i].contains("isEmpty")){
                result.append(commands[i]).append(": ").append(graph.queue.isEmpty()).append("\n");
            }
            else{
                //put
                String value=parseInputBetweenParentheses(commands[i]);
                graph.queue.put(graph.findSpecificNodeByValue(Integer.valueOf(value)));
                result.append(commands[i]).append(": [").append(graph.queue.toString()).append("]\n");
            }
        }
    }

    /**
     * Handles all breadth-first traversal requests that are performed on the graph.
     * @param graph undirected graph on which the traversal is to be performed.
     */
    public static void handleBFS(UndirectedGraph graph){
        //create new array to store the nodes in order they are traversed in bfs
        UndirectedGraphNode[] nodes_in_order = new UndirectedGraphNode[graph.nodes.length];
        nodes_in_order = graph.bfs();

        //create output
        result.append("bfs: ");
        for(int i=0;i< nodes_in_order.length;i++){
            result.append(nodes_in_order[i]);
            if(i+1<nodes_in_order.length){
                result.append(",");
            }
        }
    }


    /**
     * Handles all requests that are to be performed by the heap.
     * @param graph Undirected Graph that contains the nodes stored in the queue
     * @param input String array of nodes in order that they are initially written into the heap.
     */
    public static void handleHeap(UndirectedGraph graph, String [] input){
        UndirectedGraphNode[] array = parseHeapInput(graph, input);

        //build heap
        Heap heap = new Heap(array);

        //create output
        result.append("heap:: ").append(heap.toString());
    }

    /**
     * Handles all requests that are to be performed by the priority queue.
     * @param graph Undirected Graph that contains the nodes stored in the queue
     * @param input String array of commands that are to be performed on the queue e.g. max.
     */
    public static void handlePriorityQueue(UndirectedGraph graph, String [] input){
        UndirectedGraphNode[] array = parseHeapInput(graph, input);

        //build heap
        Heap heap = new Heap(array);
        PriorityQueue p_queue = new PriorityQueue(heap);
        result.append("initial priority queue:: ").append(p_queue.toString()).append("\n");
        //each line of the input is parsed via regular expressions
        for(int i=2; i< input.length;i++){
            if(input[i].contains("extract_max")){
                p_queue.extract_max();
                result.append(input[i]).append(":: ").append(p_queue.toString()).append("\n");
            }
            else if(input[i].contains("max")){
                UndirectedGraphNode maximum= p_queue.max();
                result.append(input[i]).append(":: ").append(maximum.toString()).append("\n");
            }
            else{
                //insert
                String value=parseInputBetweenParentheses(input[i]);
                //create a new node for the element to be inserted
                UndirectedGraphNode new_node = new UndirectedGraphNode();
                new_node.value=Integer.valueOf(value);
                p_queue.insert(new_node);
                result.append(input[i]).append(":: ").append(p_queue.toString()).append("\n");
            }
        }
    }

    /**
     * Parses the heap input, i.e., the order of nodes that are to be stored within the array that is supplied
     * as the initial array to build the heap.
     * @param graph Undirected Graph that contains the nodes stored in the heap
     * @param input Nodes values separated by comma
     * @return
     */
    public static UndirectedGraphNode[] parseHeapInput(UndirectedGraph graph, String [] input){
        String [] nodes = input[1].split(",");
        UndirectedGraphNode[] array = new UndirectedGraphNode[nodes.length];
        //each command contains 1 node in order to be added to the array that is added to the heap
        for(int i=0; i< nodes.length;i++){
            UndirectedGraphNode node = graph.findSpecificNodeByValue(Integer.valueOf(nodes[i]));
            array[i]=node;
        }
        return array;
    }

    /**
     * Extracts the information stored between parentheses.
     * @param input String containing the to be extracted portion.
     * @return String containing the String that has previously been between parentheses.
     */
    public static String parseInputBetweenParentheses(String input){
        String value="";
        Pattern value_str = Pattern.compile("\\((.*?)\\)");
        Matcher value_str_matcher = value_str.matcher(input);
        while(value_str_matcher.find()) {
            value=value_str_matcher.group(1);
        }
        return value;
    }


}
