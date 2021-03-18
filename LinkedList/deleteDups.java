class LinkedListNode{
	int data;
	LinkedListNode next;
}

/*
 *  線形リストから重複値を消す: 時間はO(N)だけどバッファーにHashSet使う
 */
static void deleteDupls(LinkedListNode n) {
    HashSet<Integer> set = new HashSet<>();
    LinkedListNode prev = null;
    while(n != null) {
        if(set.contains(n.data)) {
            prev.next = n.next;
        } else {    		
            prev = n;
            set.add(n.data);
        }
        n = n.next;
    }
} 

/*
 * バッファーなしバージョン: 時間はO(N^2)だけど空間はO(1)
 */
static void deleteDupls2(LinkedListNode head) {
    LinkedListNode current = head;

    while(current != null) {	// １つのcurrentノードに対して
        LinkedListNode runner = current;

        while(runner.next != null) {	// 毎回runner走らせる
            if(runner.next.data == current.data) {
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
            }    			
        }   		
        current = current.next;
    }
}
