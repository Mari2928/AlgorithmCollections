import java.util.Stack;
import java.util.*;

/* 
NodeWithMin バージョン: 全ての値におけるminをキープする 
*/
class NodeWithMin{
    int min;
    int data;
    NodeWithMin(int x, int min){
        data = x;
        this.min = min;
    }
}
public class stackMin {

    static Stack<NodeWithMin> s = new Stack<>();

    static void push(int val) {
        int min = Math.min(min(), val); 
        NodeWithMin node = new NodeWithMin(val, min);
        s.push(node);		
    }

    static int min() {
        if(s.isEmpty())	return Integer.MAX_VALUE;
        return s.peek().min;
    }
}

/*
minをいくつかだけキープするバージョン
*/
public class stackMin {

    static Stack<Integer> s = new Stack<>();
    static Stack<Integer> sMin = new Stack<>();	// keep some mins

    static void push(int val) {
        if(val <= min())	sMin.push(val);
        s.push(val);	
    }

    static int min() {
        if(sMin.isEmpty())	return Integer.MAX_VALUE;
        return sMin.peek();
    }

    static int pop() {
        int val = s.pop();
        if(val == min())	sMin.pop();
        return val;
    }

    public static void main(String[] args) {		    	
        push(5);
        push(6);
        push(3);
        push(7);
        pop();
        pop();
        System.out.println(min());    // 5	         
    }	
}
