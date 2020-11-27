/*
    Find sum of max-subarray and max-subsequence.
    Input -> [-1,2,3,-4,5,10]
*/
static int[] maxSubarray(int[] arr) {
    int[] result = new int[2];

    // max subarray sum -> [2,3,-4,5,10] = 16
    int maxEndHere = 0;
    int maxSoFar = Integer.MIN_VALUE;
    for(int x : arr){
        maxEndHere = Math.max(x, x + maxEndHere);
        maxSoFar = Math.max(maxSoFar, maxEndHere);
    }
    result[0] = maxSoFar;

    //  max subsequence sum -> [2,3,5,10] = 20
    Arrays.sort(arr);
    int max = 0;
    if(arr[arr.length-1] < 0)   
        max = arr[arr.length-1];
    else            
        for(int x : arr)    if(x > 0) max += x;
    result[1] = max;

    return result;            
}
