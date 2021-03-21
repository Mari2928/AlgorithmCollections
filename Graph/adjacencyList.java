/*
    Find the minimum cost to make libraries accessible to all the citizens.
    Input: n = 3, c_lib = 2, c_road = 1, cities = [[1, 2], [3, 1], [2, 3]]
    Output: 4
*/

static boolean[] visited;
static long road;

static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities){
    ArrayList<Integer>[] g = createGraph(n, cities);
    long ans = 0L;
    visited = new boolean[n+1];
    for(Integer i = 1; i <= n; i++){
        if(!visited[i]){
            road = 0L;
            DFS(i, g);
            // take cheaper one: lib for each city | a lib and roads
            ans += Math.min(c_lib * (road+1), c_lib + (road*c_road));
        }
    }          
    return ans; 
}

/*
    隣接リストのDFS
*/
static void DFS(Integer root, ArrayList<Integer>[] g){
    visited[root] = true;
    
    // recur each unvisited adjacent node
    for(int i = 0; i < g[root].size(); i++){
        Integer node = g[root].get(i);
        if(!visited[node]) {
            road++;
            DFS(node, g);
        }
    }
}

/*
隣接リストのBFS: rootから各ノードまでの最短距離をdistに保存
*/
static int[] BFS(ArrayList<Integer>[] g, int root, int n) {
    Queue<Integer> q = new ArrayDeque<>();
    boolean[] visited = new boolean[n+1];
    int[] dist = new int[n+1];

    q.add(root);
    visited[root] = true;
    dist[root] = 0;

    while(!q.isEmpty()) {
        int t = q.peek();
        for(Integer adjNode: g[t]) { // tの隣接ノードをキューに追加
            if(!visited[adjNode]) {
                q.add(adjNode);
                visited[adjNode] = true;
                dist[adjNode] += dist[t] + 1;
            }   				
        }
        q.remove(t);
    }
    return dist;
}

/* 
    Create adjacency list (無向グラフ)
*/
static ArrayList<Integer>[] createGraph(int n, int[][] cities){
    // initialize array and each ArrayList
    ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n+1];
    for(int i = 0; i <= n; i++)
        g[i] = new ArrayList<Integer>();
    
    // add adjacent nodes 
    for(int i = 0; i < cities.length; i++){
        g[cities[i][0]].add(cities[i][1]);
        g[cities[i][1]].add(cities[i][0]);
    }
    return g;
}
