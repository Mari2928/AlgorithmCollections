import java.util.Stack;
import java.util.*;

/*
    temp stackのみでstackをソート: CCI P237　図参照
*/
public class sortStack {

    static void sort(Stack<Integer> s) {
        Stack<Integer> s2 = new Stack<>();	// 降順sort用
        
        // sort s
        while(!s.isEmpty()) {
            int temp = s.pop();     // 対象の値を
            while(!s2.isEmpty() && s2.peek() > temp) { 
                s.push(s2.pop());   // 適切な所までpopして
            }
            s2.push(temp);          // いれる
        }
        
        // sを昇順にする
        while(!s2.isEmpty())
            s.push(s2.pop());
    }

    public static void main(String[] args) {		
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(7);
        s.push(3);
        s.push(1);
        sort(s);
        for(Integer val : s)
            System.out.print(val + " ");
    }	
}
