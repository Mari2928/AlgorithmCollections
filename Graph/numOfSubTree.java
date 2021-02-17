/*
    Find the number of children in every sub trees.
    Input: Graph info
    Output: count[] -> {0,8,2,3,4}
*/

static boolean[] visited;
static int[] count;

static int[] numOfSubTree(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
    int[][] g = createGraph(t_nodes, t_from, t_to);    
    visited = new boolean[t_nodes+1]; 
    count = new int[t_nodes+1];
    dfs(1, g);                                
    return count;
}

/*
    DFS to update the count of children
*/
static void dfs(int start, int[][] g){
    count[start] = 1;
    visited[start] = true;
    for(int i = 1; i < g.length; i++){
        if(g[start][i]==1 && !visited[i]){              
            dfs(i, g);
            count[start] += count[i];   
        }
    }        
}

/*
    Create a undirected matrix graph
*/
static int[][] createGraph(int t_nodes, List<Integer> t_from, List<Integer> t_to){
    int[][] g = new int[t_nodes+1][t_nodes+1];
    for(int i = 0; i < t_from.size(); i++){
        g[t_from.get(i)][t_to.get(i)] = 1;
        g[t_to.get(i)][t_from.get(i)] = 1;
    }
    return g;
}
