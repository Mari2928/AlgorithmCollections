import java.util.*;

class Node{
    int data;
    Node left, right;
    Node(int val){this.data = val;}
}

/*
    各レベルごとのLinkedListを作る: CCI P.243
    両バージョン同じ　Time -> O(N)    Space -> both require returning O(N) data
*/

public class LinkedListsOfDepths {
    /*
        DFSバージョン。pre-order traversalでレベルを増やす。
    */
    static ArrayList<LinkedList<Node>> createLevelLL(Node root){
        ArrayList<LinkedList<Node>> lists = new ArrayList<>();
        createLevelLL(root, lists, 0);
        return lists;
    }
    static void createLevelLL(Node root, ArrayList<LinkedList<Node>> lists, int level) {
        if(root == null)	return;

        LinkedList<Node> list = null;
        if(lists.size() == level) { // at first, lists==0 && level==0 so create a LL
            list = new LinkedList<>();
            lists.add(list);
        }
        else	list = lists.get(level); // otherwise retrieve a LL at the level   	

        // pre-order traversal
        list.add(root);
        createLevelLL(root.left, lists, level+1);
        createLevelLL(root.right, lists, level+1);
    }
    
    /*
        BFSバージョン
    */
    static ArrayList<LinkedList<Node>> createLevelLL2(Node n){
        ArrayList<LinkedList<Node>> lists = new ArrayList<>();
        LinkedList<Node> list = new LinkedList<>();
        if(n != null)	list.add(n);

        while(list.size() > 0) {
            lists.add(list);	// add previous level
            LinkedList<Node> parents = list; // go to next level
            list = new LinkedList<Node>();

            // visit children
            for(Node parent : parents) {
                if(parent.left != null)	
                    list.add(parent.left);
                if(parent.right != null)	
                    list.add(parent.right);
            }
        }
        return lists;
    }
    
    // test
    public static void main(String[] args) {		

        int[] arr = new int[] {1,2,3,4,5,6,7};
        Node root = createMinimalBST(arr);

        ArrayList<LinkedList<Node>> lists = createLevelLL2(root);

        for(Node v : lists.get(2))
            System.out.print(v.data + " ");	// 1 3 5 7 
    }
}
