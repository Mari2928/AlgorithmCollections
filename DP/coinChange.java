/*
    How many ways of coin change summing up to n?
    n = 4 
    [1 2 3]
    Output: 4 -> {1,1,1,1},{1,1,2},{2,2},{1,3}
*/

static long getWays(int n, List<Long> L) {
    Long[] dp = new Long[n+1];
    
    // count for the smallest change -> [1,1,1,1,1]
    for(int i = 0; i <= n; i++){ 
        dp[i] = i % L.get(0) == 0? 1L : 0L;
    }    

    // update for the bigger changes -> [1,1,2,3,4]
    for(int i = 1; i < L.size(); i++){
        long coin = L.get(i);
        int coin2 = (int)coin;
        for(int j = coin2; j <= n; j++){             	
            dp[j] += dp[j - coin2];
        }
    }
    return dp[n];
}
