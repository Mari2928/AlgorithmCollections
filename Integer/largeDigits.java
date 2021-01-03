/*
 * Print a larger digit sum.
 * Input: 123 234
 * Output: 9
 */
static int largeDigits(int a, int b) {
    return Math.max(intSum(a), intSum(b));		
}

static int intSum(int n) {
    int result = 0;
    while(n > 0) {
        int digit = n % 10;
        n /= 10;
        result += digit;
    }
    return result;
}
