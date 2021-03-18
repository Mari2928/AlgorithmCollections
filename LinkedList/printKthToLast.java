/*
 *  ラストからK番目を再帰で出力: CCI P.209
 */
static int printKthToLast(LinkedListNode head, int k) {
    if(head == null)	return 0;
    int index = printKthToLast(head.next, k) + 1;
    if(index == k) 
        System.out.println(n.data);
    return index;  	
}

/*
 *  Arrayを線形リストに入れる
 */
static LinkedListNode createLL(int N, int[] arr) {
    LinkedListNode n = new LinkedListNode(arr[0]);
    LinkedListNode head = n;
    for(int i = 1; i < N; i++) {
        n.next = new LinkedListNode(arr[i]);
        n = n.next;
    }
    return head;
}

class LinkedListNode{
	int data;
	LinkedListNode next;
	LinkedListNode(int x){ data = x;}
}

public static void main(String[] args) {		

    int[] arr = new int[] {5,5,3,1};    	
    LinkedListNode head = createLL(arr.length, arr);
    printKthToLast(head, 3);
    
}	
