/*
    Find the number of triplets (i,j,k) that are in geometric progression for a given common ratio.
    
    4 2 -> total, common ratio
    [1 2 2 4]
    Output: 2 -> There are 2 triplets (0,1,3) and (0,2,3)
*/

static ArrayList<Long> ratio;
static int result;

static long countTriplets(List<Long> arr, long r) {
    result = 0;
    int n = arr.size();
    ratio = new ArrayList<>();

    //find a base ratio e.g. -> 1,2,4
    ratio.add(1L);
    for(int i = 1; i < n; i++){
        if(ratio.size() == 3) break;
        long val = arr.get(i);
        if(val % r == 0 && val > arr.get(i-1)) ratio.add(val);
    }
    if(ratio.size() < 3) return 0;

    // make combinations of 3 pairs and see the ratio is met
    long[] data = new long[3];        
    makeCombination(arr, data, 0, n-1, 0, 3);

    return result;
}

/*
    Make combinations of tripets.
*/

static void makeCombination(List<Long> arr, long[] data, int start,
                            int end, int index, int tripets){ 
    if (index == tripets) {
        long base = data[0];
        for (int j=0; j < tripets; j++) {
            if(data[j]/base != ratio.get(j)) return; // base ratio is not met
            //System.out.print(data[j] + " "); -> [1,2,2]
        }                 
        result++;
        return; 
    } 
    //  make a next pair
    for (int i=start; i<=end && end-i+1 >= tripets-index; i++){
        data[index] = arr.get(i); 
        makeCombination(arr, data, i+1, end, index+1, tripets); 
    } 
} 
