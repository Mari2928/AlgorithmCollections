import java.util.*;

/* 配列によるスタックの実装 */

public class arrayStack {

    static int top;
    static int[] S;

    static void initialize() {
        top = 0;
    }

    static boolean isEmpty() {
        return top == 0;
    }

    static boolean isFull() {
        return top >= S.length - 1;
    }

    static void push(int x) {
        if(isFull()) 
            throw new IllegalArgumentException("Error: Over flow");
        top++;
        S[top] = x;
    }

    static int pop() {
        if(isEmpty()) 
            throw new IllegalArgumentException("Error: Under flow");			
        top--;
        return S[top+1];
    }	

    /*
     * 逆ポーランド記法で与えられた数式の計算結果
     * Input:
     * 7
     * 1 2 + 3 4 - *
     * Output: -3   
     */
    public static void main(String[] args) {
        int a, b;
        top = 0;
        S = new int[1000];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0;
        while(i < n) {
            String s = sc.next();
            if(s.equals("+")) {
                a = pop();
                b = pop();
                push(a + b);
                System.out.println("push a+b: "+ a+" "+b);
            }
            else if(s.equals("-")) {
                b = pop();
                a = pop();
                push(a - b);
                System.out.println("push a-b: " + (a-b));
            }
            else if(s.equals("*")) {
                a = pop();
                b = pop();
                push(a * b);
                System.out.println("push a*b: " + (a*b));
            }
            else {
                push(Integer.parseInt(s));
                System.out.println("push s: " + Integer.parseInt(s));
            }	
            i++;
        }
        System.out.println(pop());
    }	
}
