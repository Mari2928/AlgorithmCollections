/*
    Revers an integer N without converting to String.
    Test cases to be careful: 
        1000000009 -> overflow
        -123 -> what happens?
        100 -> should return 1, not 001
*/

int reverseN(int n) {
  int sign = 1;
  if (n < 0) {
    sign = -1;
    n *= -1;  // …. Integer.MIN_VALUE = 0x80000000;
  }
  int result = 0;
  while (n > 0) {
    int digit = n % 10;
    n /= 10;
    if (Integer.MAX_VALUE / 10 < result ||
        (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < digit)) {
       return -1;
    }
    result = result * 10 + digit;
  }
  return result * sign;
}

