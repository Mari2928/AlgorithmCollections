static boolean flag;
/*
 * 授業が完了できるか、隣接リストで判定 
 */
static boolean canComplete2(int[][] arr, int n) {
    ArrayList<Integer>[] g = createGraph2(arr, n);
    boolean[] visited = new boolean[n+1]; 
    for(int i = 1; i <= n; i++) {
        Arrays.fill(visited, false);
        flag = false;
        hasCycle2(g, i, visited);
        if(flag)	return false;
    }
    return true;
}

/*
 * 閉路(cycle)がないか判定: 隣接リスト用
 */
static void hasCycle2(ArrayList<Integer>[] g, int node, boolean[] visited) {
    if(visited[node]) {
        flag = true;
        return;
    }    	
    visited[node] = true;
    for(Integer adjNode : g[node]) 
        hasCycle2(g, adjNode, visited);
}

/*
 * 隣接リストの有向グラフつくる
 */
static ArrayList<Integer>[] createGraph2(int[][] arr, int n){
    ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n+1];
    for(int i = 0; i < n+1; i++) 
        g[i] = new ArrayList<Integer>(); // g[i]使う -> foreachはエラーに
    for(int i = 0; i < arr.length; i++)
        g[arr[i][0]].add(arr[i][1]); //　一方向のみ
    return g;
}    

/*
 * クラスが完了できるか、隣接行列で判定 
 */
static boolean canComplete(int[][] arr, int n) {
    int[][] g = createGraph(arr);

    boolean[] visited = new boolean[n+1]; 

    for(int i = 1; i <= n; i++) {
        Arrays.fill(visited, false);
        flag = false;
        hasCycle(g, i, visited);
        if(flag)	return false;
    }
    return true;
}

/*
 * 閉路(cycle)がないか判定: 隣接行列用
 */
static void hasCycle(int[][] g, int node, boolean[] visited) {
    if(visited[node]) {
        flag = true;
        return;
    }
    visited[node] = true;
    for(int i = 1; i < g.length; i++) 
        if(g[node][i] == 1)	hasCycle(g, i, visited);
}

/*
 * 隣接行列の有向グラフつくる
 */
static int[][] createGraph(int[][] arr){
    int n = arr.length;
    int[][] g = new int[n+1][n+1];
    for(int i = 0; i < n; i++) {
        g[arr[i][0]][arr[i][1]] = 1; //　向きあり
    }
    return g;
}


public static void main(String[] args) {		

    //int[][] arr = new int[][] {{0,1},{0,2},{1,2},{2,3}}; // no cycle
    int[][] arr = new int[][] {{1,2},{2,3},{3,1},{1,4}}; // cycle
    int n = 4;

    //System.out.println(canComplete(arr, n));
    System.out.println(canComplete2(arr, n));
}
