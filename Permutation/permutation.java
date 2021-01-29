import java.util.*;
    /*
    n個の都市があります。都市1を出発し、全ての都市をちょうど1度ずつ訪問してから都市1に戻るような経路のうち、移動時間の合計がちょうどKになるようなものはいくつありますか？
    4 330 -> N, K
    0 1 10 100 -> distance from city1 to city4 = 100
    1 0 20 200
    10 20 0 300
    100 200 300 0
    Output: 2
    */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        t = new long[n+1][n+1];
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=n; j++) {
                t[i][j] = sc.nextLong();
            }			
        }
        String s = "";
        for(int i = 2; i <=n; i++) {
            s += String.valueOf(i); // create "234"
        }
        count = 0;
        permutation(s, "", k);
        System.out.println(count);
    }	
    static long[][] t;
    static int count;

    /* Calculate distance */
    static long calc(String s) {
        long result = 0L;
        for(int i = 1; i < s.length(); i++) {
            int a = Integer.parseInt(String.valueOf(s.charAt(i-1)));
            int b = Integer.parseInt(String.valueOf(s.charAt(i)));
            result += t[a][b];
        }
        //System.out.println(result);
        return result;
    }


    /* Generate permutation in String */
    static void permutation(String q, String ans, long k) {
        if(q.length() <= 1) {
            String s = "1"+ ans + q + "1"; // "12341"
            if(calc(s) == k)	count++;
        }
        else {
            for(int i =0; i < q.length(); i++) {
                permutation(q.substring(0, i) + q.substring(i + 1),
                        ans + q.charAt(i), k);
            }
        }
    }
}
