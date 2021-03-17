/*
   山と谷の交互のシーケンスにソートする -> CCI P.414 
*/

/*
    ソートして奇数インデックスを手前とスワップ。
*/
static void sortValleyPeak(int[] arr) {
    Arrays.sort(arr);
    for(int i =1; i < arr.length; i+=2) {
        swap(arr, i , i-1);
    }
}

/*
    ソートしない方法。奇数インデックスに対して、手前か次が最大値ならスワップ。
*/
static void sortValleyPeak2(int[] arr) {
    for(int i =1; i < arr.length; i+=2) {
        int biggestPos = findBiggestPos(arr, i-1, i, i+1);
        if(biggestPos != i) swap(arr, i, biggestPos);
    }    	
}

static int findBiggestPos(int[] arr, int a,int b,int c) {
    int valC = c >= 0 && c < arr.length? arr[c] : Integer.MIN_VALUE;
    int max = Math.max(arr[a], Math.max(arr[b], valC));
    if(max == arr[a])		return a;
    else if(max == arr[b])	return b;
    return c;
}

static void swap(int[] arr, int i , int prev) {
    int temp = arr[i];
    arr[i] = arr[prev];
    arr[prev] = temp;
}


public static void main(String[] args) {		

    int[] arr = new int[]{5,3,1,2,3};
    sortValleyPeak2(arr);
    for(int val: arr)
        System.out.print(val + " "); // 3 5 1 3 2
}	
