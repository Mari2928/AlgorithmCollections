/*
    Swap nodes on k_th level and print nodes by in-order traversal.
    [2 3] 
    [-1 -1]
    [-1 -1]     
    queries [1 1] -> level: 1*1, 2*1, 3*1...
    Output:
    [3 1 2] 
    [2 1 3]
*/

static ArrayList<Integer> bag = new ArrayList<>();

static int[][] swapNodes(int[][] indexes, int[] queries) {
    int[][] result = new int[queries.length][indexes.length];
    inOrder(1, indexes);
    int nodeN = bag.size();

    for(int i = 0; i < queries.length; i++){
        bag.clear();
        int d = queries[i];
        indexes = swap(indexes, d, nodeN);
        inOrder(1, indexes);
        for(int j = 0; j < bag.size(); j++){
            result[i][j] = bag.get(j);
        }            
    }
    return  result; 
}

/*
    Swap all nodes on k_th level.
*/
static int[][] swap(int[][] indexes, int k, int nodeN){
    int i = 1;
    int level = (int)(Math.log(nodeN+1) / Math.log(2));

    ArrayList<Integer> treeArr = BFS(indexes);

    while((i*k) <= level+1){
        int height = i * k;                       
        int startIdx = (int)Math.pow(2, height-1) - 1;
        int toVisitN = (int)((Math.pow(2, height)-1)
                     - startIdx); 

        if (startIdx >= indexes.length)   break; 
        // swap                        
        for(int j = startIdx; j < startIdx+toVisitN; j++){
            int val = treeArr.get(j);
            if(val == -1)   continue;
            int temp = indexes[val-1][0];                
            indexes[val-1][0] = indexes[val-1][1];
            indexes[val-1][1] = temp;
        }           
        i++;
    }      
    return indexes;
}

/*
    BF traversal to represent a current tree in 1D array.
*/
static ArrayList<Integer> BFS(int[][] indexes) {
    ArrayList<Integer> bag = new ArrayList<>();
    Queue<Integer> q = new ArrayDeque<Integer>();
    q.add(1);
    while(!q.isEmpty()) {
        int t = q.peek();
        bag.add(t);
        if(t == -1) {
            q.remove();
            continue;
        }
        q.add(indexes[t-1][0]);
        q.add(indexes[t-1][1]);
        q.remove();
    }
    return bag;
}    

/*
    Traverse in-order the final tree after swapped.
*/
static void inOrder(int root, int[][] indexes){
    if(root == -1)  return;
    inOrder(indexes[root-1][0], indexes);
    bag.add(root);
    inOrder(indexes[root-1][1], indexes);
}
