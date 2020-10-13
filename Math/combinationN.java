/*
    Find the number of combination.
*/

static long combination(long n, int c){        
    return customFact(n, (int)n-c+1)/ customFact(c, 1);
}

static long customFact(long n, int stop){
    long ans = n;
    while(n != stop){
        n--;
        ans= ans * n;            
    }
    return ans;
}
