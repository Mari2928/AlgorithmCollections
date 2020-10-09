/*
    Create a matrix graph and BFS to find shortest distances from s to each node (6 per edge).
    4 2     -> the number of nodes and edges
    [1 2]
    [1 3]
    1       -> start node
    Output: [6 6 -1] -> 1 to 2, 1 to 3, and 1 to 4
*/

static int[] bfs(int n, int m, int[][] edges, int s) {
    int[][] g = createGraph(n, m, edges);

    // BFS for traversing 
    int[] result = new int[n+1];                 // edge counts
    Arrays.fill(result, -1);
    ArrayList<Integer> path = new ArrayList<>(); // BFS path
    Queue<Integer> q = new ArrayDeque<>();       // visiting list
    boolean[] visited = new boolean[g.length+1]; // visiting status

    q.add(s);
    visited[s] = true;
    
    while(!q.isEmpty()){
        int t = q.peek(); 
        path.add(t);      
        // count the number of edges
        if(t != s) {
            result[t] = countEdges(g, t, path);
        }            
        // get adjacents
        for(int i = 1; i < g.length; i++){
            if(g[t][i] == 1 && !visited[i]){ 
                q.add(i);  
                visited[i] = true;
            }
        }            
        q.remove();            
    }
    return formatResult(n, s, result);
}

/*
    Create a matrix graph.
*/
static int[][] createGraph(int n, int m, int[][] edges){        
    int[][] g = new int[n+1][n+1];
    for(int i =0; i < m; i++){
        int x = edges[i][0];
        int y = edges[i][1];
        g[x][y] = 1;
        g[y][x] = 1;
    }
    return g;
}

/*
    Format the resulted counting list as required.
*/
static int[] formatResult(int n, int start, int[] result){ 
    int[] result2 = new int[n-1];
    int j = 0;
    for(int i = 1; i <= n; i++){
        if(i == start)  continue;   // remove a start node
        result2[j] = result[i];
        j++;
    }
    return result2;
}

/*
    Count edges to find a shortest distance on each destination.
*/
static int countEdges(int[][] g, int t, ArrayList<Integer> path){
    int count = 0;
    int start = path.get(0);

    // start from t and move backward toward start
    while(t != start){
        int current = start;
        int i = 0;
        // if edge is found, increment the count
        while(g[t][current] != 1){ 
            i++;
            current = path.get(i); // start node moves forward
        }
        count += 6;
        t = current;               // t moves backward
    }
    return count;        
}
