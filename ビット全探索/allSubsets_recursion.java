import java.util.*;
/*
    再帰バージョン。
    3の倍数を作ることができないなら -1 を、作ることができるなら作るのに必要な最少の消す桁数を出力せよ。
    Input: 6227384
    Output: 1   -> 8を消した622734は3の倍数です。
*/
public class allSubsets_recursion {
	
    static int min;

    public static void main(String[] args) {		
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        int n = digits.length();
        int[] bit = new int[n];
        min = 18;
        makeCombination(0, digits, bit);
        System.out.println(min == n? -1 : min);
    }	
    
    /* 組合せを全列挙 */
    static void makeCombination(int i, String digits, int[] bit) {
        if(i == digits.length())	{
            int sum = 0, count = 0, n = digits.length();
            for(int j = 0; j < n; j++) 
                if(bit[j] == 1) {
                    // do something
                    sum += digits.charAt(j) - '0';
                    count++;
                }
            if(sum % 3 == 0) min = Math.min(min, n - count);
            return;
        }
        makeCombination(i + 1, digits, bit);
        bit[i] = 1;	// choose i
        makeCombination(i + 1, digits, bit);	
        bit[i] = 0;	// not choose i
    }
}
