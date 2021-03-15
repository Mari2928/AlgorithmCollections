/*
    Factorial 再帰版
*/

static int factorial(int n){
    if(n == 0)  return 1;
    return n * factorial(n - 1);
}

/*
    Factorial BigInteger版
*/
static void extraLongFactorials(int n) {
    System.out.println(fact(n));
    return;
}

static BigInteger fact(int n){
    BigInteger ans = BigInteger.ONE;
    for(int i = 1; i <= n; i++){
        ans = ans.multiply(BigInteger.valueOf(i));
    }       
    return ans;
}
