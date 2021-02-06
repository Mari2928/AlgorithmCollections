import java.util.ArrayDeque;
import java.util.Queue;
import java.util.*;

public class BT {

    static class Node{
        int data;
        Node left, right;
        Node(int data){this.data = data;}
    }

    public static void main(String[] args) {		
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();	// the number of nodes
        Node root = null;
        while(n-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        sc.close();
        int height = height(root);
        System.out.println("height: " + height);
        System.out.println("BFS 5: " + BFS(root, 5).data);	  
        preOrder(root);
    }	

    /* Pre-order traversal */
    static void preOrder(Node root) {
        if(root == null)	return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /* BFS for tree */
    static Node BFS(Node root, int x) {
        Queue<Node> q = new ArrayDeque<>();
        enqueue_if(q, root);
        while(!q.isEmpty()) {
            Node t = q.peek();
            if(t.data == x)	return t;
            q = enqueue_if(q, t.left);
            q = enqueue_if(q, t.right);
            q.remove();
        }
        return null;
    }
    static Queue enqueue_if(Queue q, Node t) {
        if(t != null)	q.add(t);
        return q;
    }

    /* Get height of the binary tree */
    static int height(Node root) {
        if(root == null)	return -1; // depth か height　かで変わる
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    /* Max depth of the tree */
    static int maxDepth(Node root) {
        if(root == null) return 0; 
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /* Insert to BST */
    static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}
