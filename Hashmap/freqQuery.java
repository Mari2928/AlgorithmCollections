/*
    Perform queries -> 1: insert x, 2: delete y, 3: output 1 if frequent number z exists and 0 otherwise.
    [3 4]
    [2 1003]
    [1 16]
    [3 1]
    Output: 0, 1
*/

static List<Integer> freqQuery(List<List<Integer>> queries) {
    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    int N = queries.size();
    int count = 0;

    for(int i = 0; i < N; i++){            
        List<Integer> L = queries.get(i);
        int q = L.get(0);
        int val = L.get(1);
        count = map.containsKey(val)? map.get(val) : 0; // count frequency
        if(q == 1){             
            map.put(val, count+1);                
        }
        else if(q == 2){
            if(count != 0) map.put(val, count-1); 
        }
        else if(q == 3){
            if(map.containsValue(val)) result.add(1);
            else                       result.add(0);
        }
    }
    return result;
}
