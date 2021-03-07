import java.util.Stack;
import java.util.*;

/*
    実際の皿積みをmimicしたstack。Capacityに達したら次のstackに重ねる。
*/
public class stackOfPlates {

    int capacity;
    stackOfPlates(int cap){
        capacity = cap;
    }

    ArrayList<Stack<Integer>> stacks = new ArrayList<>();

    void push(int val) {
        Stack<Integer> last = getLastStack();
        if(last != null && !isFull(last))	
            last.push(val);
        
        // stackが何もないか、capacityに達している
        else {
            Stack<Integer> s = new Stack<>();
            s.push(val);
            stacks.add(s);
        }
    }

    int pop() {
        Stack<Integer> last = getLastStack();
        if(last == null)	throw new EmptyStackException();			
        int val = last.pop();
        if(last.size() == 0)	stacks.remove(last); //　そのstackの全皿とった
        return val;
    }

    boolean isFull(Stack<Integer> s) {
        if(s.size() == capacity)	return true;
        return false;
    }

    Stack<Integer> getLastStack() {
        if(stacks.size() == 0)	return null;
        return stacks.get(stacks.size()-1);
    }

    public static void main(String[] args) {		

        stackOfPlates test = new stackOfPlates(3);
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);    	  
        System.out.println(test.pop());
        System.out.println(test.pop());

        for(Stack<Integer> s : test.stacks) {
            for(Integer x : s)
                System.out.print(x + " "); 
            System.out.println();
        } 
    }	
}
