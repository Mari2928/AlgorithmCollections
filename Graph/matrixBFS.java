import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Shortest path from a start node.
            
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
            int[][] g = new int[n+1][n+1]; // create a graph
            for(int i = 0; i < m; i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                g[u][v] = 1;
                g[v][u] = 1;
            }
            int s = sc.nextInt();
            ArrayList<Integer> distances = shortestDistFromS(s, n, g);
            for(Integer val : distances)
                System.out.print(val +" ");
            System.out.println();
        }        
    }
    /* Get a list of shortest distances from start to each node */
    static ArrayList<Integer> shortestDistFromS(int start, int n, int[][] g){
        ArrayList<Integer> distances = new ArrayList<>();
        for(int goal = 1; goal <= n; goal++){
            if(goal != start)
                distances.add(BFS(start, goal, g, n));  
        }    
        return distances;    
    }
    
    /* BFS to get a shortest distance from start to goal */
    static int BFS(int start, int goal, int[][] g, int n){
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(start);
        visited[start] = true;
        dist[start] = 0;
        while(!q.isEmpty()){
            int t = q.peek();            
            if(t == goal && t != start) 
                return dist[goal];
            for(int i = 1; i < g.length; i++){
                if(g[t][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    dist[i] = dist[t]+6;
                }
            }
            q.remove();
        }
        return -1;
    }
}
