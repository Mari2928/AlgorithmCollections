/*
 * 1, 2, 3歩とびで可能な階段のぼり方の数
 * n = 3段 -> 4 ways
 * [1,1,1] [1,2] [2,1] [3]
 */

public static int stepPerms(int n) {
    int[] memo = new int[n+5];
    Arrays.fill(memo, 0);
    memo[1] = 1;
    memo[2] = 2;
    memo[3] = 4;
    return stepPerms(n, memo);
}
public static int stepPerms(int n, int[] memo){
    if(n==0)    return 0;
    if(memo[n]!=0)  return memo[n];      
    memo[n] = stepPerms(n-1, memo) + stepPerms(n-2, memo) + stepPerms(n-3, memo);
    return memo[n];
}
