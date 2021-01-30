/*
    すべての人に計画通りにお湯を供給することはできますか？
    4 10    -> n persons, w litters
    1 3 5   -> start time, end time, consume amount
    2 4 4
    3 10 6
    2 4 1
    Output: No  -> it becomes 11 litters between the time 3 and 4
*/

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int w = sc.nextInt();
    long[] cum = new long[200010];  // time <= 2*10^5
    for(int i = 0; i < n; i++) {
        int s = sc.nextInt();
        int t = sc.nextInt();
        int p = sc.nextInt();
        cum[s] += p;
        cum[t] -= p;
    }
    for(int i = 0; i < 200005; i++) {
        cum[i+1] += cum[i];
        if(cum[i] > w) {
            System.out.println("No");
            return;
        }
    }
    System.out.println("Yes");
    return;		
}	
