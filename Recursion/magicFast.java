/*
    Find a magic index such that arr[i] = i in a sorted array.
    にぶたんの要領でさがす。
*/

/* 
    重複値があっても動くバージョン　[-10,-5,2,2,2,3,4,7,9,12,13]
*/
static int magicFast(int[] arr, int start, int end){
    if(end < start)	return -1;	// base case

    int midIndex = (start + end) / 2;
    int midValue = arr[midIndex];
    if(midValue == midIndex) return midIndex; // found    			

    // 左から探す
    int leftIndex = Math.min(midValue, midIndex-1);
    int left = magicFast(arr, start, leftIndex); 
    if(left >= 0)	return left;

    // 左にはない。右を探す
    int right = Math.max(midIndex + 1, midValue);
    return magicFast(arr, right, end);	
}

/* 
    重複値なしなら動くシンプル実装バージョン　[-40,-20,-1,1,2,3,5,7,9,12,13]
*/
static int magicFast１(int[] arr, int start, int end){
    if(end < start)	return -1;
    int mid = (start + end) / 2;
    if(arr[mid] == mid) 
        return mid;	// found
    else if(arr[mid] > mid)	// いたちごっこで追いつけないので左だけ探せばいい
        return magicFast(arr, start, mid - 1); 
    return magicFast(arr, mid + 1, end);	// 右を探す
}
