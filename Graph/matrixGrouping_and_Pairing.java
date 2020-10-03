/*
    Grouping nodes and compute the number of combination of a pair of 2.
    5 3 -> number of nodes, number of edges
    [0 1]
    [2 3]
    [0 4]   
    Output: 6 -> [0,2],[0,3][1,2],[1,3],[4,2],[4,3]
*/

static boolean[] visited;
static ArrayList<Integer> path = new ArrayList<>();

static long journeyToMoon(int n, int[][] astronaut){

    ArrayList<ArrayList<Integer>> all = new ArrayList<>();
    visited = new boolean[n];
    int countN = 0;
    
    // create a matrix graph
    int[][] g = new int[n][n];
    for(int i =0; i < astronaut.length; i++){
        int x = astronaut[i][0];
        int y = astronaut[i][1];
        g[x][y] = 1;
        g[y][x] = 1;
    }
    
    // DFS for grouping
    for(int i =0; i < n; i++){
        if(!visited[i]){
            path.clear();
            DFS(i, g);                
            countN += path.size();
            all.add((ArrayList<Integer>)path.clone());
        }
    }
    
    // count the number of pairs
    long count = 0;
    for(int j = 0; j < all.size(); j++){
        ArrayList<Integer> each = all.get(j);
        for(int i = j+1; i < all.size(); i++){
            ArrayList<Integer> each2 = all.get(i);
            count += each.size() * each2.size();
        }
    }       
    return count; 
}

static void DFS(int root, int[][] g){
    path.add(root);
    visited[root] = true;
    for(int i = 0; i <g.length; i++){
        if(g[root][i] == 1 && visited[i] == false){
            DFS(i, g);
        }
    }
}
