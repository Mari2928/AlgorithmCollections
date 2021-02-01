/*
    3の倍数を作ることができないなら -1 を、作ることができるなら作るのに必要な最少の消す桁数を出力せよ。
    Input: 6227384
    Output: 1   -> 8を消した622734は3の倍数です。
*/

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String digits = sc.nextLine();
    int n = digits.length();
    int min = 18;
    // n-digitsの部分集合の全探索 -> {6,2,2,7,3,8,4}
    // https://qiita.com/drken/items/7c6ff2aa4d8fce1c9361#6-bit-%E5%85%A8%E6%8E%A2%E7%B4%A2
    for(int bit = 0; bit < (1<<n); bit++) {
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if((bit & (1<<i)) > 0) {    // i が bit に入るかどうか
                sum += digits.charAt(i) - '0'; // 6+2+2+7+3+4 = 3の倍数(622734に変換不要)
                cnt++;
            }
        }
        if(sum % 3 == 0) min = Math.min(min, n - cnt);
    }
    System.out.println(min == n? -1 : min);
}	
