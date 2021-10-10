/*
 * BigInteger関連の処理。superDigitを再帰で出力。
 * n = "123", k = 3
 * f(123123123) -> f(1+2+3+1+2+3+1+2+3) -> f(18) -> f(9) -> 9
 */

public static int superDigit(String n, int k) {
    BigInteger digit = BigInteger.valueOf(0);
    for(int i = 0; i < n.length(); i++){
        digit = digit.add(BigInteger.valueOf(Character.getNumericValue(n.charAt(i)))); // たす
    }
    digit = digit.multiply(BigInteger.valueOf(k)); // かける
    return superDigit(digit);
}

public static int superDigit(BigInteger n){
    BigInteger ten = BigInteger.valueOf(10); // BigIntegerにする
    BigInteger zero = BigInteger.valueOf(0);
    if(n.divide(ten) == zero)   return n.intValue(); // わる
    BigInteger newDigit = zero;
    while(n.compareTo(zero)==1){  // ==(n > 0)　比較
        BigInteger digit = n.mod(ten);  //　モジュロ
        n = n.divide(ten);
        newDigit = newDigit.add(digit);
    }
    return superDigit(newDigit);
}
