/* 
    最長共通部分列の長さを出力
    Input:
    SHINCHAN
    NOHARAAA
    Output: 3 -> NHA
*/

static int lcs(String x, String y) {
    int m = x.length();
    int n = y.length();
    int N = Math.max(m,  n);
    int[][] dp = new int[N+1][N+1];
    int maxl = 0;
    x = " " + x;	// to start from dp[1][1]
    y = " " + y;
    for(int i = 1; i <= m; i++) {
        for(int j = 1; j <= n; j++) {
            if(x.charAt(i) == y.charAt(j)) // 一緒なら１つ手前の段階のlcsにx_iを連結
                dp[i][j] = dp[i-1][j-1] + 1;
            else
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            maxl = Math.max(maxl, dp[i][j]);
        }
    }
    return maxl;
}
