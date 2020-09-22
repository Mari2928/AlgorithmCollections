import java.util.*;
/**
* Grouping the nodes given by Lists and return the number of groups.
*/
public class Graph {    

    enum State { Unvisited, Visited; }

    class Graph_{
        public Node[] nodes;
        Graph_(int V){ this.nodes = new Node[V]; }
    }    
    class Node{	
        public String number;   	
        public State state = State.Unvisited;
        public ArrayList<Node> followers = new ArrayList<>();
        Node(String i){ this.number = i;}
    }    

    /*
     * Create a graph and find the number of groups.
     */
    int grouping_(int n, int d, ArrayList<Integer> x, ArrayList<Integer> y) {
        Graph_ g = createGraph(n, d, x, y);
        int count = 0;
        for(int i =1; i <= n; i++) {
            int j = n;
            while(j != i) {
                if(isReachable(g, String.valueOf(i), String.valueOf(j))) {    			
                    count++;
                    if(j == n)	{
                        return count;
                    }
                    else		break;
                }
                j--;
            }
        }    	
        return count; 
    }

    /**
     * See if the node is reachable to the other node using DFS.
     */
    boolean found = false;
    boolean isReachable(Graph_ g, String yourName, String herName) {
        for(Node u : g.nodes)	// reset the states
            u.state = State.Unvisited;    	
        isReachable2(g, yourName, herName);
        return found;
    }    

    void isReachable2(Graph_ g, String yourName, String herName) {   	
        Node root = findNodeInNumber(yourName, g);
        if(root == null)	return;

        // base case of recursion
        if(root.number.equals(herName)) {
            found = true;
            return;
        }    	 
        root.state = State.Visited;    	    	
        for(Node v : root.followers) {
            if(v.state == State.Unvisited) 
                isReachable2(g, v.number, herName);   			
        } 
    }

    /**
     * Helper: Find a node in node number. 
     */
    Node findNodeInNumber(String nodeNumber, Graph_ g) {
        for(Node n : g.nodes)
            if(n.number.equals(nodeNumber))	return n;
        return null;
    }

    /**
     * Run test cases. Assume node# starts from 0.
     * [1,2]
     * [3,4]
     * [4,5] Output: 2 (there are 2 groups)
     */
    void test() {   
        // create a graph
        int V = 5;
        int d = 3;  
        ArrayList<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(3);
        x.add(4);
        ArrayList<Integer> y = new ArrayList<>();
        y.add(2);
        y.add(4);
        y.add(5);    	
        Graph_ g = createTestGraph2(V, d, x, y);
        // find the number of groups
        int count = grouping_( V,  d,  x, y);    	  
        System.out.println("answer: "+ count );   	
    }

    /*
    * Create a graph with List parameters.
    */
    Graph_ createGraph(int n, int d, ArrayList<Integer> x, ArrayList<Integer> y) {    	
        if(n == 0)	return null;
        Graph_ g = new Graph_(n);  
        g.nodes = new Node[n];
        // create nodes inserting values
        for(int i = 0; i < n; i++)
            g.nodes[i] = new Node(String.valueOf(i+1));
        // add followers
        for(int j = 0; j < d; j++) {
            int myId = x.get(j)-1;
            int followerId = y.get(j)-1;
            g.nodes[myId].followers.add(g.nodes[followerId]);
            // undirected graph = 相互フォローの関係
            g.nodes[followerId].followers.add(g.nodes[myId]);
        } 
        return g;
    }

    public static void main(String args[]) {	
        Graph graph = new Graph();
        graph.test();   	

    }
}
