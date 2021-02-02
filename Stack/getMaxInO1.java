/* 
    Get Max value of the current stack in O(1).
    Input: 1, 6, 3, 4, 5
    st: [(1, 1), (6, 6), (3, 6) (4, 6), (5, 6)]
*/
import java.util.Stack;
import java.util.*;

public class Test2 {

    // let each element have max value in the moment
    class StackElement {
        int value;
        int maxValue;
        StackElement(int v, int maxV){
            this.value = v;
            this.maxValue = maxV;
        }
    }
    Stack<StackElement> st = new Stack<>();	

    void push(int value) {
        int maxValue = (st.isEmpty() || st.peek().maxValue < value) ? value : st.peek().maxValue;
        st.push(new StackElement(value, maxValue));
    }

    void pop() {
        st.pop();
    }

    int getMax() {
        return st.peek().maxValue;
    }

    public static void main(String[] args) {
        Test2 test = new Test2();
        test.push(1);
        test.push(5);
        test.push(3);
        test.push(4);
        test.push(6);
        test.pop();
        System.out.println(test.getMax());
    }	
}
