import java.util.*;
/*
    A[i]を組み合わせて、mが作れるかを判定する再帰
    
    Input:
    5   -> n
    1 5 7 10 21 -> A[i]
    4   -> q
    2 4 17 8    -> m
    
    Output:
    no
    no
    yes
    yes
*/
public class Test2 {

    public static void main(String[] args) {		
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++) A[i] = sc.nextInt();
        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int m = sc.nextInt();
            if(solve(0, m, n, A))	System.out.println("yes");
            else					System.out.println("no");
        }		
    }	

    static boolean solve(int i, int m, int n, int[] A) {
        if(m == 0)	return true;
        if(i >= n)	return false;
        boolean res = solve(i + 1, m, n, A) || solve(i + 1, m - A[i], n, A);
        return res;
    }
}
