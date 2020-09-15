/*
 * Find an unvisited node.
 */
public static int findUnvisited(boolean[] visited) {
    int node = -1;
    for(int i = 0; i < visited.length; i++) {			
        if(!visited[i]) {
            node = i;
        }
    }
    return node;
}

/*
 * Q2: Return the number of water sources.
 */
static ArrayList<Integer> waterSources = new ArrayList<>();

static int numOfWaterSources(int[][] arr, boolean[] visited) {
    int count = 0;
    while(findUnvisited(visited) != -1) {
        waterSources.clear();
        int start = findUnvisited(visited);			
        DFSFlood(start, visited, arr);
        if(waterSources.size() > 1) {count++;}
    }
    return count;
}

/*
 * Q2: DFS to find water sources.
 */
public static void DFSFlood(int start, boolean[] visited, int[][] matrix) {
    waterSources.add(start);
    //System.out.print(start+ " ");
    visited[start] = true;
    for(int i = 0; i < matrix.length; i++) {
        if(matrix[start][i] == 1 && (!visited[i])) {
            DFSFlood(i, visited, matrix);
        }
    }
}
