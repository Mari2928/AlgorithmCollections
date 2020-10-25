/*
    Given a color, find the shortest path connecting any two nodes of that color. Each edge has a weight of 1.
    5 -> the number of node
    [1 1 2 3] -> graphFrom
    [2 3 4 5] -> graphTo
    [1 2 3 3 2] -> ids the color id per node
    2 -> val the targeted color id  
    Output: 3
        1/1
      /     \
    2/2     3/3
     |       |
    4/3     5/2
*/

static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
    // only one color is in it and no destination
    int countVal = 0;
    for(int i = 0; i < ids.length; i++){
        if(ids[i] == val)   countVal++;
    }
    if(countVal <= 1)   return -1;
    
    // create a graph and initialize states
    int[][] g = createGraph(graphNodes, graphFrom, graphTo, ids);
    int start = 0;
    boolean[] visited = new boolean[graphNodes];
    int min = Integer.MAX_VALUE;
    
    // BFS starting from every same color
    for(int i = 0; i < graphNodes; i++){
        if(ids[i] == val) { // targeted color is found
            start = i; 
            Arrays.fill(visited, false);
            ArrayList<Integer> path = BFS(g, start, visited, ids, val);                
            int pathLen = path.size();
            if(pathLen-1 < min) min = pathLen-1; // update min
        }            
    }            
    return min;
}

static ArrayList<Integer> BFS(int[][] g, int start, boolean[] visited, long[] ids, int val){
    ArrayList<Integer> path = new ArrayList<>();
    Queue<Integer> q = new ArrayDeque<>();
    q.add(start);
    visited[start] = true;
    while(!q.isEmpty()){
        int t = q.peek();
        path.add(t);
        if(ids[t] == val && t != start) return path;            
        for(int i = 0; i < g.length; i++){
            if(g[t][i]==1 && !visited[i])  {
                q.add(i);
                visited[i] = true;
            }
        }
        q.remove();
    }
    return path;
}

static int[][] createGraph(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids){
    int[][] g = new int[graphNodes][graphNodes];
    for(int i = 0; i < graphFrom.length; i++){
        g[graphFrom[i]-1][graphTo[i]-1] = 1;
        g[graphTo[i]-1][graphFrom[i]-1] = 1;
    }
    return g;        
}
