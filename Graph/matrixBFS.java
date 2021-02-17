import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Find shortest distances from a start node by updating dist[]
            
            Input:
            2   -> q: number of queries
            4 2 -> n, m: number of nodes and edges
            1 2 -> u, v: edge connection
            1 3
            1   -> s: start node
            3 1
            2 3
            2
            
            Output:
            6 6 -1
            -1 6
         */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for(int j = 0; j < q; j++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            // create a graph
            int[][] g = new int[n+1][n+1]; 
            for(int i = 0; i < m; i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                g[u][v] = 1;
                g[v][u] = 1;
            }
            int start = sc.nextInt();
            
            // get the distances from start node
            int[] distances = BFS(start, g, n);
            
            // print the result
            for(int i = 1; i < distances.length; i++){
                if(i == start)  continue;   // skip start node
                int d = distances[i];
                if(d == Integer.MAX_VALUE || d == 0) d = -1;
                System.out.print(d +" ");
            }                
            System.out.println();
        }        
    }
    
    /* BFS to get a shortest distance from start node to each node */
    static int[] BFS(int start, int[][] g, int n){
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(start);
        visited[start] = true;
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int t = q.peek();            
            for(int i = 1; i < g.length; i++){
                if(g[t][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    dist[i] = dist[t]+6;
                }
            }
            q.remove();
        }
        return dist;
    }
}
