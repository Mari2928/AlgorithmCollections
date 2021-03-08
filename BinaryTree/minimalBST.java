import java.util.*;

class Node{
    int data;
    Node left, right;
    Node(int val){this.data = val;}
}

/*
    Create a minimal height of BST: CCI P.242
    sorted listのまん中をrootにしてBST高さを最小にする。
    createMinimalBST() -> O(Nlog(logN))
    insertNode() -> O(NlogN)より速い
*/
public class MinimalBST {	
   
    static Node createMinimalBST(int[] arr) {
        return createMinimalBST(arr, 0, arr.length-1);
    }
    static Node createMinimalBST(int[] arr, int start, int end) {
        if(start > end)	return null;
        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);
        n.left = createMinimalBST(arr, start, mid-1);
        n.right = createMinimalBST(arr, mid+1, end);
        return n;
    }
    
    public static void main(String[] args) {		
        int[] arr = new int[] {1,2,3,4,5,6,7};
        Node n = createMinimalBST(arr);
        System.out.println(n.right.data);
    }
}
