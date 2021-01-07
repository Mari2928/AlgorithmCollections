/*
    Atcoder E: https://atcoder.jp/contests/abc187/tasks/abc187_e
    Execute que and update value on each vertex
    
    Input:
    5 -> graph
    1 2
    2 3
    2 4
    4 5
    4 -> ques
    1 1 1   -> T[i][0] T[1] val=1 : start from T[1][0] == 1, DFS avoiding 2, and add 1 on each vertex
    1 4 10
    2 1 100
    2 2 1000
    
    Output:
    11
    110
    1110
    110
    100
*/

public static void main(String[] args) {		

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] T = new int[N-1][2];
    for(int i = 0; i < N-1; i++) {
        T[i][0] = sc.nextInt();			
        T[i][1] = sc.nextInt();
    }
    int N2 = sc.nextInt();
    int[][] Q = new int[N2][3];
    for(int i = 0; i < N2; i++) {
        Q[i][0] = sc.nextInt();			
        Q[i][1] = sc.nextInt();
        Q[i][2] = sc.nextInt();
    }
    sc.close();		
    printResult(T, Q, N, N2);
}	

static int[] C;

static void printResult(int[][] T, int[][] Q, int N, int N2) {
    C = new int[N+1];
    int[] edge;		
    int[][] g = createGraph(N, N-1, T);
    for(int i = 0; i < N2; i++) {	
        int start = -1;
        int kinshi = -1;
        edge = findEdge(T, Q[i][1]);
        if(Q[i][0] == 1) {				
            start = edge[0];
            kinshi = edge[1];
        }
        else if(Q[i][0] == 2) {							
            start = edge[1];
            kinshi = edge[0];
        }	
        executeQ(g, N, start, kinshi, Q[i][2]);
    }
    for(int i = 1; i < N+1; i++)
        System.out.println(C[i]);
}

static void DFS(int root, int[][] g, boolean[] visited, int val){
    visited[root] = true;
    C[root] += val;
    for(int i = 0; i < g.length; i++){
        if(g[root][i] == 1 && visited[i] == false){ // if there is an edge and unvisited
            DFS(i, g, visited, val);
        }
    }
}

static void executeQ(int[][] g, int N, int start, int kinshi, int val) {
    boolean[] visited = new boolean[N+1];
    visited[kinshi] = true;
    DFS(start, g, visited, val);
}

static int[] findEdge(int[][] T, int i) {
    return T[i-1];
}

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
