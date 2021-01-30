/*
    満たされる条件の個数は最大でいくつでしょうか？
    4 4 -> n balls, m conditions
    1 2 -> satisfied if balls are on both
    1 3
    2 4
    3 4 -> m_th condition
    3   -> k persons
    1 2 -> put a ball on dish1 or dish2
    1 3
    2 3
    Output: 2   -> condition 1 and 2 are met if person 1,2,3 put a ball on dish 1,3,2
*/
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[m];
    int[] b = new int[m];
    for(int i = 0; i < m; i++) {
        a[i] = sc.nextInt() - 1; //探索用に１引いておく
        b[i] = sc.nextInt() - 1;
    }
    int k = sc.nextInt();
    int[] c = new int[k];
    int[] d = new int[k];
    for(int i = 0; i < k; i++) {
        c[i] = sc.nextInt() - 1;
        d[i] = sc.nextInt() - 1;
    }
    int ans =0;
    // ビット全探索:　k人がそれぞれcかdのボールを選ぶ組合せ
    for(int i = 0; i < Math.pow(2, k); i++) {
        boolean[] dish = new boolean[n];
        int buf = 0;
        for(int j = 0; j < k; j++) {	// for k persons

            // i を j だけ右にビットシフトしたとき、i の右端のビットが立っているか
            if((1 & (i>>j)) == 1) 
                dish[c[j]] = true;
            else	
                dish[d[j]] = true;
        }
        // check if condition is met
        for(int j = 0; j < m; j++)		
            if(dish[a[j]] && dish[b[j]])	buf++;
        ans = Math.max(ans, buf);
    }
    System.out.println(ans);
}	
