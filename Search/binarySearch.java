/*
 * ソート済みの配列をにぶたんで再帰検索 
 */
static int binarySearch(int[] arr, int val, int start, int end) {
    if(start > end)	return -1;
    int mid = (start + end) / 2;
    if(arr[mid] > val)	
        return binarySearch(arr, val, start, mid-1);
    else if(arr[mid] < val)
        return binarySearch(arr, val, mid+1, end);    
    return mid;
}

/*
 * ソート済みの配列をにぶたんでループ検索 
 */
static int binarySearch(int[] arr, int val) {
    int mid;
    int start = 0;
    int end = arr.length -1;
    while(start <= end) {
        mid = (start + end) / 2;
        if(arr[mid] > val)	end = mid - 1;
        else if(arr[mid] < val)	start = mid + 1;
        else	return mid;
    }
    return -1;
}

public static void main(String[] args) {	
    
    int[] arr = new int[] {1,2,3,4,5};
    System.out.println(binarySearch(arr, 5, 0, 4));  // 4
    
}
