/*
    Minimize the number of candies to give. 
    Rule: A student with the higer score gets more candies. If a next student has less than or equal sore gets 1.
    3
    [1 2 2]     Output: 4 -> Optimal distribution is 1, 2, 1
*/

static long candies(int n, int[] arr) {
    long[] candy = new long[n];
    Arrays.fill(candy, 1);
    int N = arr.length;
    
    // move forward giving one more candy if next person has higer score
    for(int i = 0; i < N-1; i++){ 
        if(arr[i] < arr[i+1])   
            candy[i+1] = candy[i]+1;
    }
    
    // move backward modifying if the rule is violated
    for(int i = N-1; i > 0; i--){
        if(arr[i-1] > arr[i] && candy[i-1] <= candy[i])
            candy[i-1] = candy[i]+1;
    }
    long sum = 0;
    for(long c : candy) sum += c;
    return sum;
}
